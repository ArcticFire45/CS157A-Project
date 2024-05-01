package com.example.springboot;

public class Items {
    private Integer item_id;
    private String item_name;
    private String item_desc;
    private Float multiplier;
	private String image_url;

    public Integer getItem_id() {
        return item_id;
    }
    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }
    public String getItem_name() {
        return item_name;
    }
    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
    public String getItem_desc() {
        return item_desc;
    }
    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }
    public Float getMultiplier() {
        return multiplier;
    }
    public void setMultiplier(Float multiplier) {
        this.multiplier = multiplier;
    }
    public String getImage_url() {
        return image_url;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    public Items(Integer item_id, String item_name, String item_desc, Float multiplier, String image_url) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_desc = item_desc;
        this.multiplier = multiplier;
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "Items [item_id=" + item_id + ", item_name=" + item_name + ", item_desc=" + item_desc + ", multiplier="
                + multiplier + ", image_url=" + image_url + "]";
    }
}
