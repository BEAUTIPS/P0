package com.laioffer.beautips.Models;

import java.util.Objects;

public class Closet {
    String itemId;
    String bodyShape;
    String occasion;
    String dressCode;
    String topSize;
    String bottomSize;
    String price;
    String url;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getBodyShape() {
        return bodyShape;
    }

    public void setBodyShape(String bodyShape) {
        this.bodyShape = bodyShape;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public String getDressCode() {
        return dressCode;
    }

    public void setDressCode(String dressCode) {
        this.dressCode = dressCode;
    }

    public String getTopSize() {
        return topSize;
    }

    public void setTopSize(String topSize) {
        this.topSize = topSize;
    }

    public String getBottomSize() {
        return bottomSize;
    }

    public void setBottomSize(String bottomSize) {
        this.bottomSize = bottomSize;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Closet closet = (Closet) object;
        return itemId.equals(closet.itemId) &&
                bodyShape.equals(closet.bodyShape) &&
                occasion.equals(closet.occasion) &&
                dressCode.equals(closet.dressCode) &&
                topSize.equals(closet.topSize) &&
                bottomSize.equals(closet.bottomSize) &&
                java.util.Objects.equals(price, closet.price) &&
                java.util.Objects.equals(url, closet.url);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), itemId, bodyShape, occasion, dressCode, topSize, bottomSize, price, url);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Closet{" +
                "itemId='" + itemId + '\'' +
                ", bodyShape='" + bodyShape + '\'' +
                ", occasion='" + occasion + '\'' +
                ", dressCode='" + dressCode + '\'' +
                ", topSize='" + topSize + '\'' +
                ", bottomSize='" + bottomSize + '\'' +
                ", price='" + price + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}