package com.booj.corey.boojproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class RealtorListFragment extends Fragment {

    private static final String REALTOR_URL = "https://www.denverrealestate.com/rest.php/mobile/realtor/list?app_key=f7177163c833dff4b38fc8d2872f1ec6";

    OnRealtorSelectedListener mCallback;

    public interface OnRealtorSelectedListener {
        void onRealtorSelected(int position);
    }

    private RecyclerView mRealtorListRV;
    private RealtorRVAdapter mRealtorRVAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_realtor_list, container, false);

        return view;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        try{
            mCallback = (OnRealtorSelectedListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        ArrayList<Realtor> realtors = ((MainActivity)getActivity()).mRealtors;
        if(realtors == null || realtors.size() == 0)
            getRealtors();
        else setupRecyclerView(realtors);
    }



    public void getRealtors(){
        HttpUtils.get(REALTOR_URL, null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] header, JSONArray array){
                ArrayList<Realtor> realtors = ((MainActivity)getActivity()).mRealtors;
                for(int i = 0; i < array.length(); i++){
                    Realtor realtor = new Realtor(array.optJSONObject(i));
                    realtors.add(realtor);
                }
                setupRecyclerView(realtors);

                //If tablet init realtor selected
                boolean isTablet = getResources().getBoolean(R.bool.isTablet);
                if(realtors.size() > 0 && isTablet){
                    mCallback.onRealtorSelected(0);
                }
            }
        });
    }

    public void setupRecyclerView(ArrayList<Realtor> realtors){
        mRealtorListRV = getView().findViewById(R.id.realtorListRV);
        mRealtorListRV.setLayoutManager(new LinearLayoutManager(getContext()));
        mRealtorRVAdapter = new RealtorRVAdapter(getContext(), realtors, RealtorListFragment.this);
        mRealtorListRV.setAdapter(mRealtorRVAdapter);
    }
}
