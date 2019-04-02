package com.example.admin.gridrecycle.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.gridrecycle.R;
import com.example.admin.gridrecycle.gridadapter;

public class fragmentexplore extends Fragment {

RecyclerView mrecyclerview;
RecyclerView.LayoutManager mlayoutManager;
RecyclerView.Adapter madapter;
    public fragmentexplore() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        mrecyclerview = (RecyclerView)view.findViewById(R.id.recyler);
        mrecyclerview.setHasFixedSize(true);

        mlayoutManager = new GridLayoutManager(getActivity(),2);
        mrecyclerview.setLayoutManager(mlayoutManager);
        madapter = new gridadapter();
        mrecyclerview.setAdapter(madapter);
    return view;
    }

}
