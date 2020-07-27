package com.dianavintila.comewithme___traveljournal.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.dianavintila.comewithme___traveljournal.HelperClases.HomeAdapter.CategoriesAdapter;
import com.dianavintila.comewithme___traveljournal.HelperClases.HomeAdapter.CategoriesHelperClass;
import com.dianavintila.comewithme___traveljournal.HelperClases.HomeAdapter.FeaturedAdapter;
import com.dianavintila.comewithme___traveljournal.HelperClases.HomeAdapter.FeaturedHelperClass;
import com.dianavintila.comewithme___traveljournal.HelperClases.HomeAdapter.MostViewedAdapter;
import com.dianavintila.comewithme___traveljournal.HelperClases.HomeAdapter.MostViewedHelperClass;
import com.dianavintila.comewithme___traveljournal.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    RecyclerView featuredRecycler;
    RecyclerView.Adapter adapter;
    //
    RecyclerView mostViewedRecycler;
    RecyclerView.Adapter adapter1;
    //
    RecyclerView categoriesRecycler;
    RecyclerView.Adapter adapter2;

    ImageView menuIcon;

    // Drawer Hooks
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    LinearLayout contentView;
    static final float END_SCALE = 0.7f;
    // Button
    Button button_trip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //HOOKS
        featuredRecycler = findViewById(R.id.featured_recycler);

        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);

        categoriesRecycler = findViewById(R.id.categories_recycler);

        menuIcon=findViewById(R.id.menu_icon);

        contentView=findViewById(R.id.content);

        //Menu HOOKS
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        navigationDrawer();

        // Recycler view function calls
        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();

        button_trip=findViewById(R.id.button_addtrip);
        button_trip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenAddTrip();
            }
        });
    }

    private void OpenAddTrip() {
        Intent intent=new Intent(this,AddTrip.class);
        startActivity(intent);
    }

    // Navigation Drawer Functions
    private void navigationDrawer() {
        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else  drawerLayout.openDrawer(GravityCompat.START);

            }
        });

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {
        //Add any color or remove it to use the default one!
        // To make it transparent use Color.Transparent in side setScrimColor();
        //drawerLayout.setScrimColor(Color.TRANSPARENT);
                drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimaryDark));
                drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {

                        // Scale the View based on current slide offset
                        final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                        final float offsetScale = 1 - diffScaledOffset;

                        contentView.setScaleX(offsetScale);
                        contentView.setScaleY(offsetScale);

                        // Translate the View, accounting for the scaled width
                        final float xOffset = drawerView.getWidth() * slideOffset;
                        final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                        final float xTranslation = xOffset - xOffsetDiff;
                        contentView.setTranslationX(xTranslation);
                    }
                });


    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerVisible(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_search:
                startActivity(new Intent(getApplicationContext(),Search.class));
                break;
            case R.id.nav_addtrip:
                startActivity(new Intent(getApplicationContext(),AddTrip.class));
                break;
            case R.id.contact:
                startActivity(new Intent(getApplicationContext(),Contact.class));
                break;
            case R.id.aboutus:
                startActivity(new Intent(getApplicationContext(),AboutUs.class));
                break;

            }

       return true;
    }
    


    //Recycler Views Functions

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.mcdonalds_icon, "McDonald's", getString(R.string.mcdonalds_desc)));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.chocolat_icon, "Chocolat", getString(R.string.chocolat_desc)));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.linea_icon, "Linea closer to the moon", getString(R.string.linea_desc)));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);


    }

    private void mostViewedRecycler() {
        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewed = new ArrayList<>();

        mostViewed.add(new MostViewedHelperClass(R.drawable.unirii_image, "Water Symphony Bucharest", "Called Simfonia Apei, the show on May 4 was the first of the 2019 season. "));
        mostViewed.add(new MostViewedHelperClass(R.drawable.carturesti_image, "Carturesti Carusel", "Cărturești Carusel is the prettiest bookshop situated in a restored 19th-century building in the very heart of Bucharest’s Old town."));
        mostViewed.add(new MostViewedHelperClass(R.drawable.linea_icon, "Linea closer to the moon", "An iconic restaurant and rooftop bar, famous for it\'s breathtaking view"));

        adapter1 = new MostViewedAdapter(mostViewed);
        mostViewedRecycler.setAdapter(adapter1);

    }

    private void categoriesRecycler() {
        categoriesRecycler.setHasFixedSize(true);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<CategoriesHelperClass> categories = new ArrayList<>();


        categories.add(new CategoriesHelperClass(R.drawable.hotel, "Hotel"));
        categories.add(new CategoriesHelperClass(R.drawable.restaurant, "Restaurant"));
        categories.add(new CategoriesHelperClass(R.drawable.museum, "Museum"));
        categories.add(new CategoriesHelperClass(R.drawable.parks, "Park"));
        categories.add(new CategoriesHelperClass(R.drawable.shops, "Shop"));
        categories.add(new CategoriesHelperClass(R.drawable.pharmacy, "Pharmacy"));
        adapter2 = new CategoriesAdapter(categories);
        categoriesRecycler.setAdapter(adapter2);



    }


}


