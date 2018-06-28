package com.example.koncia.footballapplication.models;

import com.google.gson.annotations.SerializedName;

public class Team {

    private String name;
    private String code;

    @SerializedName("shortName")
    private String shortcut;

    @SerializedName("crestUrl")
    private String logoUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
