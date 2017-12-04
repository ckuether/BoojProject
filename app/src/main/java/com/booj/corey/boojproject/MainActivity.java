package com.booj.corey.boojproject;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RealtorListFragment.OnRealtorSelectedListener {

    public ArrayList<Realtor> mRealtors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.realtor_frag);

        if(findViewById(R.id.fragment_container) != null){

            if(savedInstanceState != null){
                return;
            }

            RealtorListFragment realtorListFragment = new RealtorListFragment();

            realtorListFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, realtorListFragment).commit();
        }
    }


    public void onRealtorSelected(int position){

        RealtorItemFragment realtorItemFrag = (RealtorItemFragment) getSupportFragmentManager().findFragmentById(R.id.realtor_view);

        //Checks if is Tablet view or Phone view
        if(realtorItemFrag != null){
            realtorItemFrag.updateRealtor(position);
        }else{
            RealtorItemFragment realtorItemFragment = new RealtorItemFragment();
            Bundle args = new Bundle();
            args.putInt(RealtorItemFragment.REALTOR_POS, position);
            realtorItemFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, realtorItemFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }

}

