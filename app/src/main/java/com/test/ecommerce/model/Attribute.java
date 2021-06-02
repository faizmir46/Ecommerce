package com.test.ecommerce.model;

public class Attribute {
    public String option_id;
    public String option_product_id;
    public String value;

    public String getOption_id() {
        return option_id;
    }

    public void setOption_id(String option_id) {
        this.option_id = option_id;
    }

    public String getOption_product_id() {
        return option_product_id;
    }

    public void setOption_product_id(String option_product_id) {
        this.option_product_id = option_product_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
