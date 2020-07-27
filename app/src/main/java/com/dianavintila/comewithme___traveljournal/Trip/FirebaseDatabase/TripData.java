package com.dianavintila.comewithme___traveljournal.Trip.FirebaseDatabase;

public class TripData {

    String id;

    String name;
    String destination;
    String type;

    int price;
    float rating;

    String startDate;
    String endDate;
    String imageURL;

    public TripData() {}

    public TripData(String name, String destination, String type, int price, float rating, String startDate, String endDate) {
        this.name = name;
        this.destination = destination;
        this.type = type;
        this.price = price;
        this.rating = rating;
        this.startDate = startDate;
        this.endDate = endDate;

    }


    public TripData(String id, String name, String destination, String type, int price, float rating, String startDate, String endDate, String imageURL) {
        this.id = id;
        this.name = name;
        this.destination = destination;
        this.type = type;
        this.price = price;
        this.rating = rating;
        this.startDate = startDate;
        this.endDate = endDate;
        this.imageURL = imageURL;
    }

    public TripData(String name, String destination, String type, int price, float rating, String startDate, String endDate, String imageURL) {
        this.name = name;
        this.destination = destination;
        this.type = type;
        this.price = price;
        this.rating = rating;
        this.startDate = startDate;
        this.endDate = endDate;
        this.imageURL = imageURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String photoURL) {
        this.imageURL = imageURL;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }




    @Override
    public String toString() {
        return "Trip{" +
                "id= '" + id + '\'' +
                ", name= '" + name + '\'' +
                ", destination= '" + destination + '\'' +
                ", type= '" + type + '\'' +
                ", price= '" + price +
                ", rating= '" + rating +
                ", startDate= '" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", imageURL= '" + imageURL + '\'' +
                '}';
    }
}

