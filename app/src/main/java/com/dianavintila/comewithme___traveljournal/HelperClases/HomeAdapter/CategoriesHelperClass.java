package com.dianavintila.comewithme___traveljournal.HelperClases.HomeAdapter;

import android.graphics.drawable.Drawable;

public class CategoriesHelperClass {
    int image;
    String title;
    Drawable drawable;

    public CategoriesHelperClass(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }


}
