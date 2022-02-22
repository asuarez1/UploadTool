package com.kpcm;

import com.kpcm.beans.Amazon;
import com.kpcm.beans.GSIN;
import com.kpcm.beans.ProductInfo;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UploadTool {
    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        final String ANSI_GREEN = "\u001B[32m";
        FileReader frPi = new FileReader("productinfo.csv");
        FileReader frGsin = new FileReader("gsin.csv");
        List<ProductInfo> productInfo = new CsvToBeanBuilder(frPi).withType(ProductInfo.class)
                .build()
                .parse();

        List<GSIN> gsin = new CsvToBeanBuilder(frGsin).withType(GSIN.class)
                                .withSkipLines(3)
                                .build()
                                .parse();
        List<Amazon> amazon = new ArrayList<>();

        List<Material> materials = initMaterials();
        String name = "";
        for(ProductInfo p : productInfo) {
            for(Material m : materials) {
                //CREATE PARENT
                GSIN nextGSIN = getNextGSIN(gsin);
                amazon.add(new Amazon(
                    "2020" + p.getSku() + m.getSKUmod() + "0",
                    nextGSIN.getNumber(),
                    "EAN",
                    "KPCM Display ltd",
                    p.getProductName() + m.getTextTitle(),
                    p.getProductName() + m.getTextTitle() + ". All signs come with a 5 year warranty.",
                    p.getProductName(),
                    m.getTextBullet2(),
                    "Digitally printed and laminated for extra durability",
                    m.getTextBullet4(),
                    p.getImageURL(),
                    "",
                    "500",
                    "Great Britain",
                    "KPCM Display ltd",
                    "health and safety signs",
                    nextGSIN.getNumber(),
                    "New",
                    "1",
                    "number of unit per package",
                    "",
                    "Size",
                    "Variation"
                ));
                name = p.getProductName() + m.getTextTitle();
                System.out.println(ANSI_GREEN + "GTIN No. " + nextGSIN.getNumber() + " assigned " + name);
                nextGSIN.setProductName(name);

                //CREATE CHILDREN
                int i = 1;
                for(String[] mi : m.materialInfo) {
                    nextGSIN = getNextGSIN(gsin);
                    amazon.add(new Amazon(
                            "2020" + p.getSku() + m.getSKUmod() + i,
                            nextGSIN.getNumber(),
                            "EAN",
                            "KPCM Display ltd",
                            p.getProductName() + m.getTextTitle(),
                            p.getProductName() + m.getTextTitle() + ". All signs come with a 5 year warranty.",
                            p.getProductName(),
                            m.getTextBullet2(),
                            "Digitally printed and laminated for extra durability",
                            m.getTextBullet4(),
                            p.getImageURL(),
                            mi[1],
                            "500",
                            "Great Britain",
                            "KPCM Display ltd",
                            "health and safety signs",
                            nextGSIN.getNumber(),
                            "New",
                            "1",
                            "number of unit per package",
                            "2020" + p.getSku() + m.getSKUmod() + "0",
                            mi[0],
                            "Variation"
                    ));
                    name = p.getProductName() + m.getTextTitle() + " (" + mi[0] + ")";
                    System.out.println("GTIN No. " + nextGSIN.getNumber() + " assigned " + name);
                    nextGSIN.setProductName(name);
                    i++;
                }
            }
            Writer writer = new FileWriter("amazon.csv");
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(amazon);
            writer.close();

            writer = new FileWriter("gsin.csv");
            beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(gsin);
            writer.close();
        }
    }

    private static GSIN getNextGSIN(List<GSIN> gsinList) {
        for(GSIN g : gsinList){
            if(g.getProductName().isEmpty()) return g;
        }

        return null;
    }


    private static List<Material> initMaterials() {
        List<Material> materials = new ArrayList<>();

        // STICKER
        Material sticker = new Material(
                "S",
                " - Self adhesive sticker",
                "Self adhesive sticker",
                "Remove backing film and apply to dry smooth oil free surface");
        sticker.materialInfo.add(new String[]{"100mm x 150mm", "1.49"});
        sticker.materialInfo.add(new String[]{"200mm x 150mm", "1.99"});
        sticker.materialInfo.add(new String[]{"300mm x 200mm", "3.49"});
        sticker.materialInfo.add(new String[]{"400mm x 300mm", "6.49"});
        materials.add(sticker);

        // RIGID
        Material rigid = new Material(
                "R",
                " - 1mm Plastic sign",
                "1mm Plastic sign",
                "Drill and screw in position or use double sided tape to mount onto suitable surface");
        rigid.materialInfo.add(new String[]{"100mm x 150mm", "1.49"});
        rigid.materialInfo.add(new String[]{"200mm x 150mm", "2.19"});
        rigid.materialInfo.add(new String[]{"300mm x 200mm", "3.99"});
        rigid.materialInfo.add(new String[]{"400mm x 300mm", "7.49"});
        rigid.materialInfo.add(new String[]{"600mm x 400mm", "14.29"});
        materials.add(rigid);

        // DIBOND
        Material dibond = new Material(
                "D",
                " - 3mm Aluminium sign",
                "3mm Aluminium sign",
                "10mm Radius rounded corners - no sharp edges");
        dibond.materialInfo.add(new String[]{"200mm x 150mm", "7.89"});
        dibond.materialInfo.add(new String[]{"300mm x 200mm", "9.89"});
        dibond.materialInfo.add(new String[]{"400mm x 300mm", "18.99"});
        dibond.materialInfo.add(new String[]{"600mm x 400mm", "29.99"});
        materials.add(dibond);

        return materials;
    }
}
