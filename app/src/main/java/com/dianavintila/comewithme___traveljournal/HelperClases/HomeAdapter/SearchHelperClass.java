package com.dianavintila.comewithme___traveljournal.HelperClases.HomeAdapter;

public class SearchHelperClass {
    int image;
    String title,dest,type,rating,price;

    public SearchHelperClass(int image, String title, String dest, String type,String price, String rating) {
        this.image = image;
        this.title = title;
        this.dest = dest;
        this.type = type;
        this.price = price;
        this.rating = rating;

    }

    public int getImage() {
        return image;
    }
    public String getTitle() {
        return title;
    }
    public String getDestination() {
        return dest;
    }
    public String getType() {return  type;}
    public String getPrice(){return price;}
    public String getRating() {return rating;}

}
