package com.example.projekt1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FeaturesAdapter extends RecyclerView.Adapter<FeaturesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Feature> features;

    public FeaturesAdapter() {
    }

    public FeaturesAdapter(Context context, ArrayList<Feature> features) {
        this.context = context;
        this.features = features;
    }

    @NonNull
    @Override
    public FeaturesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.feature_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturesAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return features.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout constraintLayout;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.parentLayout);
            textView = itemView.findViewById(R.id.featureText);
        }
    }
}


