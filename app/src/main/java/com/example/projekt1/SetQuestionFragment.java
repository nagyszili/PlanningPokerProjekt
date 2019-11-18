package com.example.projekt1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SetQuestionFragment extends Fragment {

    private Context context;

    public SetQuestionFragment() {
    }

    public SetQuestionFragment(Context context) {
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
