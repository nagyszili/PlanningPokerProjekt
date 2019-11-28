package com.example.projekt1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListVoteFragment extends Fragment {

    private Context context;
    private RecyclerView recyclerView;
    private VoteAdapter adapter;
    private ArrayList<User> votedUsers = new ArrayList<>();
    private DatabaseReference group;
    private DatabaseReference dbFeatures;
    private DatabaseReference activeFeature;


    public ListVoteFragment() {
    }

    public ListVoteFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View view = inflater.inflate(R.layout.list_vote_fragment_layout, container, false);


        Bundle args = getArguments();
//        String groupName =  args != null ? args.getString("groupName") : null;
        final String groupId =  args != null ? args.getString("groupId") : null;

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        group = database.getReference("groups/"+groupId);
        dbFeatures = group.child("features");
        activeFeature = group.child("activeFeature");

        activeFeature.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists())
                {
                   for(DataSnapshot data : dataSnapshot.child("usersVoted").getChildren())
                   {
                       User user = data.getValue(User.class);
                       votedUsers.add(user);
                       Toast.makeText(context, user != null ? user.getName() : null, Toast.LENGTH_SHORT).show();

                   }

                   if (!votedUsers.isEmpty())
                   {
                       Toast.makeText(context, "votedUsers is not Empty!", Toast.LENGTH_SHORT).show();
                       recyclerView = view.findViewById(R.id.listVotes);
                       adapter = new VoteAdapter(context,votedUsers);
                       recyclerView.setLayoutManager(new LinearLayoutManager(context));
                       recyclerView.setAdapter(adapter);
                   } else {
                       Toast.makeText(context, "votedUsers is Empty!", Toast.LENGTH_SHORT).show();

                   }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        return view;
    }



}
