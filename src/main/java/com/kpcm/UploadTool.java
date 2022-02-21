package com.kpcm;

import com.kpcm.beans.Products;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class UploadTool {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello World");

        List<Products> beans = new CsvToBeanBuilder(new FileReader("test.csv"))
                .withType(Products.class).build().parse();

        for(Products p : beans) {
            System.out.println(p);
        }

    }
}
