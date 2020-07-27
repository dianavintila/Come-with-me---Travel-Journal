package com.dianavintila.comewithme___traveljournal.HelperClases.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dianavintila.comewithme___traveljournal.R;
import com.dianavintila.comewithme___traveljournal.Trip.Search;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder>  {
    ArrayList<SearchHelperClass> searchLocations;

    public SearchAdapter(ArrayList<SearchHelperClass> searchLocations) {
        this.searchLocations = searchLocations;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_card, parent, false);
        SearchViewHolder searchViewHolder = new SearchViewHolder(view);
        return searchViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        SearchHelperClass searchHelperClass=searchLocations.get(position);

        holder.image.setImageResource(searchHelperClass.getImage());
        holder.title.setText(searchHelperClass.getTitle());
        holder.dest.setText(searchHelperClass.getDestination());
        holder.type.setText(searchHelperClass.getType());
        holder.price.setText(searchHelperClass.getPrice());
        holder.rating.setText(searchHelperClass.getRating());

    }


    @Override
    public int getItemCount() {
        return searchLocations.size();
    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title,dest,type,rating,price;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.s_image);
            title = itemView.findViewById(R.id.s_title);
            dest = itemView.findViewById(R.id.s_dest);
            type=itemView.findViewById(R.id.s_type);
            price=itemView.findViewById(R.id.s_price);
            rating=itemView.findViewById(R.id.s_rating);


        }
    }
}
