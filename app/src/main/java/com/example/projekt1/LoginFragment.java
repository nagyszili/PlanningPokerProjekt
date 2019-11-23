package com.example.projekt1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class LoginFragment extends Fragment implements View.OnClickListener {

    private Context context;
    private EditText groupNameEditText;
    private EditText groupIdEditText;
    private Button loginBtn;

//    private String groupName;
//    private String groupId;

    public LoginFragment() {
    }

    public LoginFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.login_fragment_layout, container, false);
        groupNameEditText = view.findViewById(R.id.groupName);
        groupIdEditText = view.findViewById(R.id.groupId);
        loginBtn = view.findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(this);


        return view;
    }


    private void startQuestionsFragment(String groupName, String groupId) {
        Bundle bundle = new Bundle();
        bundle.putString("groupName", groupName);
        bundle.putString("groupId", groupId);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        SetFeaturesFragment setFeaturesFragment = new SetFeaturesFragment(context);
        setFeaturesFragment.setArguments(bundle);
        transaction.replace(R.id.container, setFeaturesFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    public void onClick(View view) {
        final String groupName = this.groupNameEditText.getText().toString();
        final String groupId = this.groupIdEditText.getText().toString();

        if (!groupName.isEmpty() && !groupId.isEmpty()) {

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            final DatabaseReference ref = database.getReference("groups");

            final Group group1 = new Group(groupId, groupName);

//            Feature feature1 = new Feature("Login", 1);
//            Feature feature2 = new Feature("Register", 2);
//            Feature feature3 = new Feature("Vote", 3);
//
//            User user1 = new User(1, "Szili1");
//            User user2 = new User(2, "Szili2");
//            User user3 = new User(3, "Szili3");


//            group1.addNewFeature(feature1);
//            group1.addNewFeature(feature2);
//            group1.addNewFeature(feature3);
//            group1.activateFeature(feature1);
//
//            user1.setVotedValue("Coffe Time!");
//            user2.setVotedValue("100");
//            feature1.addVotedUser(user1);
//            feature1.addVotedUser(user2);


            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.child(groupId).exists()) {

                        Toast.makeText(getContext(), "This group existing", Toast.LENGTH_SHORT).show();

                    } else {
                        DatabaseReference childRef = ref.child(groupId);
//                        childRef.setValue(new Group(groupId, groupName));
                        childRef.setValue(group1);

                        Toast.makeText(getContext(), "This group is created", Toast.LENGTH_SHORT).show();

                    }


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


            startQuestionsFragment(groupName, groupId);
        }


    }
}
