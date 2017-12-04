package com.booj.corey.boojproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class RealtorRVAdapter extends Adapter<RealtorRVAdapter.ViewHolder> {

    Context mContext;
    ArrayList<Realtor> mRealtors;
    RealtorListFragment mFragment;

    public RealtorRVAdapter(Context context, ArrayList<Realtor> realtors, RealtorListFragment fragment){
        mContext = context;
        mRealtors = realtors;
        mFragment = fragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.realtor_view_holder, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Realtor realtor = mRealtors.get(position);

        Picasso.with(mContext)
                .load(realtor.getPhoto() + "/width/200")
                .transform(new CropCircleTransformation())
                .into(holder.realtorPhoto);
        holder.realtorName.setText("Name: " + realtor.getFirstName() + " " + realtor.getLastName());
        holder.realtorPhone.setText("Phone: " + realtor.getPhoneNumber());

        holder.realtorContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFragment.mCallback.onRealtorSelected(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRealtors.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public RelativeLayout realtorContainer;
        public ImageView realtorPhoto;
        public TextView realtorName;
        public TextView realtorPhone;

        public ViewHolder(View itemView) {
            super(itemView);
            realtorContainer = itemView.findViewById(R.id.realtor_container);
            realtorPhoto = itemView.findViewById(R.id.realtor_photo);
            realtorName = itemView.findViewById(R.id.realtor_name);
            realtorPhone = itemView.findViewById(R.id.realtor_phone);
        }
    }
}
