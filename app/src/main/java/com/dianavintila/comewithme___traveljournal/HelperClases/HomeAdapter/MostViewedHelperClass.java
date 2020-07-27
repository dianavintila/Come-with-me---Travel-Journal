package com.dianavintila.comewithme___traveljournal.HelperClases.HomeAdapter;

public class MostViewedHelperClass {
    int image;
    String title,desc;

    public MostViewedHelperClass(int image, String title,String desc) {
        this.image = image;
        this.title = title;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return desc;
    }

}
