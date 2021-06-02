package com.test.ecommerce.model;

public class AssociatedProduct {
    public int id;
    public String name;
    public String short_description;
    public String description;
    public String SKU;
    public String regular_price;
    public String final_price;
    public String currency_code;
    public int remaining_quantity;
    public int is_featured;
    public String new_from_date;
    public String new_to_date;
    public String brand_name;
    public String boutique_name;
    public String image;
    public String delivery_time;
    public String delivery_time_text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getRegular_price() {
        return regular_price;
    }

    public void setRegular_price(String regular_price) {
        this.regular_price = regular_price;
    }

    public String getFinal_price() {
        return final_price;
    }

    public void setFinal_price(String final_price) {
        this.final_price = final_price;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public int getRemaining_quantity() {
        return remaining_quantity;
    }

    public void setRemaining_quantity(int remaining_quantity) {
        this.remaining_quantity = remaining_quantity;
    }

    public int getIs_featured() {
        return is_featured;
    }

    public void setIs_featured(int is_featured) {
        this.is_featured = is_featured;
    }

    public String getNew_from_date() {
        return new_from_date;
    }

    public void setNew_from_date(String new_from_date) {
        this.new_from_date = new_from_date;
    }

    public String getNew_to_date() {
        return new_to_date;
    }

    public void setNew_to_date(String new_to_date) {
        this.new_to_date = new_to_date;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getBoutique_name() {
        return boutique_name;
    }

    public void setBoutique_name(String boutique_name) {
        this.boutique_name = boutique_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
    }

    public String getDelivery_time_text() {
        return delivery_time_text;
    }

    public void setDelivery_time_text(String delivery_time_text) {
        this.delivery_time_text = delivery_time_text;
    }
}
