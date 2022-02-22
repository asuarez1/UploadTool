package com.kpcm;

import java.util.ArrayList;
import java.util.List;

public class Material {
    public List<String[]> materialInfo = new ArrayList<>();
    private final String SKUmod;
    private final String textTitle;
    private final String textBullet2;
    private final String textBullet4;

    public Material(String SKUmod, String textTitle, String textBullet2, String textBullet4) {
        this.SKUmod = SKUmod;
        this.textTitle = textTitle;
        this.textBullet2 = textBullet2;
        this.textBullet4 = textBullet4;
    }

    public String getSKUmod() {
        return SKUmod;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public String getTextBullet2() {
        return textBullet2;
    }

    public String getTextBullet4() {
        return textBullet4;
    }
}
