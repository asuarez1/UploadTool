package com.kpcm.beans;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class GSIN {

    @CsvBindByPosition(position = 0)
    private String number;
    @CsvBindByPosition(position = 1)
    private String status;
    @CsvBindByPosition(position = 2)
    private String productName;
    @CsvBindByPosition(position = 3)
    private String description;
    @CsvBindByPosition(position = 4)
    private String mainBrand;
    @CsvBindByPosition(position = 5)
    private String subBrand;
    @CsvBindByPosition(position = 6)
    private String productLink;
    @CsvBindByPosition(position = 7)
    private String mpn;
    @CsvBindByPosition(position = 8)
    private String sku;
    @CsvBindByPosition(position = 9)
    private String updated;

    public String getNumber() {
        return number;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
