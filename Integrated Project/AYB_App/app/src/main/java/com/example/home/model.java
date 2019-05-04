package com.example.home;

public class model {
    private String ImageLink , Name , Price ;

    public model(String imageLink, String name,String price) {
        ImageLink = imageLink;
        Name = name;
        Price = price;
    }

    public String getImageLink() {
        return ImageLink;
    }

    public String getName() {
        return Name;
    }

    public String getPrice() {
        return Price;
    }
}
