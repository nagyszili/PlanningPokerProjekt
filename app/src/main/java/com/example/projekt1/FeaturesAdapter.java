package com.example.projekt1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FeaturesAdapter extends RecyclerView.Adapter<FeaturesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Feature> features;
    private String groupId;
    private FirebaseDatabase database;
    private DatabaseReference group;
    private DatabaseReference dbFeatures;
    private DatabaseReference activeFeature;
    private FragmentManager fragmentManager;
    private Feature aFeature;

    public FeaturesAdapter() {
    }

    public FeaturesAdapter(Context context, ArrayList<Feature> features, String groupId,FragmentManager fragmentManager) {
        this.context = context;
        this.features = features;
        this.groupId = groupId;
        database = FirebaseDatabase.getInstance();
        group = database.getReference("groups/" + groupId);
        dbFeatures = group.child("features");
        activeFeature = group.child("activeFeature");
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public FeaturesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.feature_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final FeaturesAdapter.ViewHolder holder, final int position) {
        holder.textView.setText(features.get(position).getName());
//        Toast.makeText(context, features.get(position).getName(), Toast.LENGTH_SHORT).show();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putString("groupId", groupId);

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                ListVoteFragment listVoteFragment = new ListVoteFragment(context);
                listVoteFragment.setArguments(bundle);

                transaction.replace(R.id.container, listVoteFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        holder.aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (isChecked) {
                    features.get(position).setActive(true);
                    group.child("activeFeature").setValue(features.get(position));

                } else {

                    group.child("activeFeature").setValue(null);
                    features.get(position).setActive(false);

                }
            }
        });

        if (features.get(position).isActive()) {
            holder.aSwitch.setChecked(true);
        } else {
            holder.aSwitch.setChecked(false);
        }




    }

    @Override
    public int getItemCount() {
        return features.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout constraintLayout;
        private TextView textView;
        private Switch aSwitch;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.parentLayout);
            textView = itemView.findViewById(R.id.featureText);
            aSwitch = itemView.findViewById(R.id.active);
        }
    }
}


