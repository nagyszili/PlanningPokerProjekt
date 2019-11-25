package com.example.projekt1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Vector;

public class SetFeaturesFragment extends Fragment implements View.OnClickListener {

    private Context context;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
//    private ArrayList<Feature> features = new ArrayList<>();
    private FloatingActionButton fab;
    private DatabaseReference group;
    private DatabaseReference dbFeatures;


    public SetFeaturesFragment() {
    }

    public SetFeaturesFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View view = inflater.inflate(R.layout.set_question_fragment_layout, container, false);
        fab = view.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(this);

        Bundle args = getArguments();
        String groupName =  args != null ? args.getString("groupName") : null;
        final String groupId =  args != null ? args.getString("groupId") : null;

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        group = database.getReference("groups/"+groupId);
        dbFeatures = group.child("features");

        dbFeatures.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Feature> features = new ArrayList<>();

                for (DataSnapshot data : dataSnapshot.getChildren())
                {
                    Feature feature = data.getValue(Feature.class);
                    features.add(feature);

                }


                if (!features.isEmpty()){

                    recyclerView = view.findViewById(R.id.listFeaturesRecyclerView);
                    adapter = new FeaturesAdapter(view.getContext(),features,groupId);
                    recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                    recyclerView.setAdapter(adapter);
                }
//                else {
////                    Toast.makeText(getContext(),"Nincs semmi a featuresben", Toast.LENGTH_SHORT).show();
//                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }


    @Override
    public void onClick(View v) {
        final Feature feature = new Feature();

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Add New Feature");


        View viewInflated = LayoutInflater.from(context).inflate(R.layout.new_feature_input,(ViewGroup) getView(),false);

        final EditText input = viewInflated.findViewById(R.id.input);

        builder.setView(viewInflated);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if (!input.getText().toString().isEmpty())
                {
                    feature.setName(input.getText().toString());
//                    features.add(feature);
                    group.child("features").child(String.valueOf(feature.getId())).setValue(feature);
                }


            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

}
