package com.example.projekt1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SetFeaturesFragment extends Fragment {

    private Context context;
    private RecyclerView recyclerView;
    private FeaturesAdapter adapter;
    private ArrayList<Feature> features = new ArrayList<>();



    public SetFeaturesFragment() {
    }

    public SetFeaturesFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.set_question_fragment_layout, container, false);

        Bundle args = getArguments();
        String groupName =  args != null ? args.getString("groupName") : null;
        String groupId =  args != null ? args.getString("groupId") : null;



        return view;
    }
}
