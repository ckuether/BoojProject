package com.booj.corey.boojproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RealtorItemFragment extends Fragment {

    final static String REALTOR_POS = "REALTOR_POSITION";

    private View view;
    private ImageView realtorPhoto;
    private TextView realtorName;
    private TextView realtorTitle;
    private TextView realtorOffice;
    private TextView realtorPhone;

    private ArrayList<Realtor> realtors;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_realtor_item, container, false);

        initViews();

        return view;
    }

    @Override
    public void onStart(){
        super.onStart();

        realtors = ((MainActivity)getActivity()).mRealtors;

        Bundle args = getArguments();
        if(args == null && realtors.size() > 0){
            updateRealtor(0);
        }else if(args != null){
            updateRealtor(args.getInt(REALTOR_POS));
        }
    }

    public void initViews(){
        realtorPhoto = view.findViewById(R.id.realtor_item_photo);
        realtorName = view.findViewById(R.id.realtor_item_name);
        realtorTitle = view.findViewById(R.id.realtor_item_title);
        realtorOffice = view.findViewById(R.id.realtor_item_office);
        realtorPhone = view.findViewById(R.id.realtor_item_phone);
    }

    public void updateRealtor(int position){
        Realtor realtor = realtors.get(position);

        Picasso.with(getContext()).load(realtor.getPhoto() + "/width/600")
                .into(realtorPhoto);
        realtorName.setText(realtor.getFirstName() + " " + realtor.getLastName());
        realtorTitle.setText(realtor.getTitle());
        realtorOffice.setText("Office: " + realtor.getOffice());
        realtorPhone.setText("Phone: " + realtor.getPhoneNumber());
    }

}
