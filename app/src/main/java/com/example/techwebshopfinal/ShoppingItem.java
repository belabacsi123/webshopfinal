package com.example.techwebshopfinal;

public class ShoppingItem {
    private String id;
    private String name;
    private String info;
    private String price;
    private float rating;
    private int imageResource;


    public ShoppingItem() {

    }

    public ShoppingItem(String name, String info, String price, float rating, int imageResource) {
        this.name = name;
        this.info = info;
        this.price = price;
        this.rating = rating;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public String getPrice() {
        return price;
    }

    public float getRating() {
        return rating;
    }

    public int getImageResource() {
        return imageResource;
    }


    public String _getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
