package com.example.projekt1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        LoginFragment loginFragment = new LoginFragment(this);
//        loginFragment.setArguments(getIntent().getExtras());
        transaction.add(R.id.container, loginFragment);
//        transaction.addToBackStack(null);
        transaction.commit();


    }
}
