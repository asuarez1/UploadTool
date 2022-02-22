package com.kpcm.beans;

import com.opencsv.bean.CsvBindByName;

public class ProductInfo {

    @CsvBindByName(column = "SKU")
    private String sku;

    @CsvBindByName(column = "Item Name")
    private String productName;

    @CsvBindByName(column = "Image URL")
    private String imageURL;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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
