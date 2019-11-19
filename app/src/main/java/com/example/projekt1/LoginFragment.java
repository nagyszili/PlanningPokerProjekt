package com.example.projekt1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

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
        String groupName = this.groupNameEditText.getText().toString();
        String groupId = this.groupIdEditText.getText().toString();

        if (!groupName.isEmpty() && !groupId.isEmpty()) {

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference("groups");

            Map<String, Group> groups = new HashMap<>();
            groups.put(groupId, new Group(groupId,groupName));
            ref.setValue(groups);


            startQuestionsFragment(groupName, groupId);
        }


    }
}
