package com.kpcm.beans;

import com.opencsv.bean.CsvBindByName;

public class Products {

    @CsvBindByName
    private String SKU;

    @CsvBindByName
    private String productName;

    @CsvBindByName
    private String imageURL;

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
