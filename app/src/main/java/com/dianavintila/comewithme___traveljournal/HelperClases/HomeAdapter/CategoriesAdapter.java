package com.dianavintila.comewithme___traveljournal.HelperClases.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dianavintila.comewithme___traveljournal.R;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.AdapterAllCategoriesViewHolder> {
    ArrayList<CategoriesHelperClass> categories;

    public CategoriesAdapter(ArrayList<CategoriesHelperClass> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public AdapterAllCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design, parent, false);
        AdapterAllCategoriesViewHolder allCategoriesViewHolder = new AdapterAllCategoriesViewHolder(view);
        return allCategoriesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAllCategoriesViewHolder holder, int position) {

        CategoriesHelperClass categoriesHelperClass = categories.get(position);

        holder.image.setImageResource(categoriesHelperClass.getImage());
        holder.text.setText(categoriesHelperClass.getTitle());
        //holder.relativeLayout.setBackground(categoriesHelperClass.getGradient());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
    public static class AdapterAllCategoriesViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout relativeLayout;
        ImageView image;
        TextView text;

        public AdapterAllCategoriesViewHolder(@NonNull View itemView) {
            super(itemView);

           // relativeLayout = itemView.findViewById(R.id.background_gradient);
            image = itemView.findViewById(R.id.categories_image);
            text  = itemView.findViewById(R.id.categories_title);
        }
    }

}
