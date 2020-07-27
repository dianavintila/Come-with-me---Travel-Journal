package com.dianavintila.comewithme___traveljournal.Trip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.dianavintila.comewithme___traveljournal.HelperClases.HomeAdapter.SearchAdapter;
import com.dianavintila.comewithme___traveljournal.HelperClases.HomeAdapter.SearchHelperClass;
import android.os.Bundle;
import android.view.WindowManager;

import com.dianavintila.comewithme___traveljournal.R;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
    RecyclerView searchRecycler;
    RecyclerView.Adapter searchAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_search);
        searchRecycler = findViewById(R.id.search_recycler);
        searchRecycler();
    }


    private void searchRecycler() {
        searchRecycler.setHasFixedSize(true);
        searchRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<SearchHelperClass> search = new ArrayList<>();

        search.add(new SearchHelperClass(R.drawable.hotbaloom, "Hot Baloon", "New Mexico","City Break","5000","4.5"));
        search.add(new SearchHelperClass(R.drawable.santorini, "Cruise", "Santorini","Sea Side","3000","4.8"));

        searchAdapter = new SearchAdapter(search);
        searchRecycler.setAdapter(searchAdapter);

    }
}