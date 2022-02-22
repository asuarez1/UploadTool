package com.kpcm.beans;

import com.opencsv.bean.CsvBindByPosition;

public class Amazon {
    //sku (mandatory)
    @CsvBindByPosition(position = 0)
    private String sku;
    @CsvBindByPosition(position = 1)
    private String productId;
    @CsvBindByPosition(position = 2)
    private String productIdType;
    @CsvBindByPosition(position = 3)
    private final String brand;
    @CsvBindByPosition(position = 4)
    private final String itemName;
    @CsvBindByPosition(position = 5)
    private final String productDescription;
    @CsvBindByPosition(position = 6)
    private final String bullet1;
    @CsvBindByPosition(position = 7)
    private final String bullet2;
    @CsvBindByPosition(position = 8)
    private final String bullet3;
    @CsvBindByPosition(position = 9)
    private final String bullet4;
    @CsvBindByPosition(position = 10)
    private final String imageUrl;
    @CsvBindByPosition(position = 11)
    private final String price;
    @CsvBindByPosition(position = 12)
    private final String quantity;
    @CsvBindByPosition(position = 13)
    private final String origin;
    @CsvBindByPosition(position = 14)
    private final String manufacturer;
    @CsvBindByPosition(position = 15)
    private final String genericKeywords;
    @CsvBindByPosition(position = 16)
    private final String partNumber;
    @CsvBindByPosition(position = 17)
    private final String condition;
    @CsvBindByPosition(position = 18)
    private final String unitCount;
    @CsvBindByPosition(position = 19)
    private final String unitCountType;
    @CsvBindByPosition(position = 20)
    private final String parentage;
    @CsvBindByPosition(position = 21)
    private final String parentSKU;
    @CsvBindByPosition(position = 22)
    private final String relationshipType;

    public Amazon(String sku, String productId, String productIdType, String brand, String itemName, String productDescription, String bullet1, String bullet2, String bullet3, String bullet4, String imageUrl, String price, String quantity, String origin, String manufacturer, String genericKeywords, String partNumber, String condition, String unitCount, String unitCountType, String parentage, String parentSKU, String relationshipType) {
        this.sku = sku;
        this.productId = productId;
        this.productIdType = productIdType;
        this.brand = brand;
        this.itemName = itemName;
        this.productDescription = productDescription;
        this.bullet1 = bullet1;
        this.bullet2 = bullet2;
        this.bullet3 = bullet3;
        this.bullet4 = bullet4;
        this.imageUrl = imageUrl;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
        this.manufacturer = manufacturer;
        this.genericKeywords = genericKeywords;
        this.partNumber = partNumber;
        this.condition = condition;
        this.unitCount = unitCount;
        this.unitCountType = unitCountType;
        this.parentage = parentage;
        this.parentSKU = parentSKU;
        this.relationshipType = relationshipType;
    }
}
