package com.example.admin.gridrecycle.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.gridrecycle.R;
import com.example.admin.gridrecycle.customAdapter;



    public class Fragment_pemain extends Fragment {
        private static final String TAG = "RecyclerViewFragment";
        private static final String KEY_LAYOUT_MANAGER = "layoutManager";
        private static final int SPAN_COUNT = 2;
        private static final int DATASET_COUNT = 60; // menampilkan data sebanyak value

        private enum LayoutManagerType {
            GRID_LAYOUT_MANAGER,
            LINEAR_LAYOUT_MANAGER
        }

        protected LayoutManagerType mCurrentLayoutManagerType;

        protected RecyclerView mRecyclerView;
        protected customAdapter mAdapter;
        protected RecyclerView.LayoutManager mLayoutManager;
        protected String[] mDataset, mDataset2;
        protected int[] mDataset3;

        int [] icon = {R.drawable.Totti, R.drawable.cantona,R.drawable.derossi};
        String [] judul = {"Franchesco totti","Eric Cantona","Daniele De rossi"};
        String [] deskripsi = {"Totti merupakan legenda dar AS Roma","Eric cantona adalah mantan kapten manchester united","De rossi merupakan penerus dari francesco Totti"};

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Initialize dataset, this data would usually come from a local content provider or
            // remote server.
            initDataset();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.Fragmentpemain, container, false);
            rootView.setTag(TAG);

            // BEGIN_INCLUDE(initializeRecyclerView)
            mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyler);

            // LinearLayoutManager is used here, this will layout the elements in a similar fashion
            // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
            // elements are laid out.
            mLayoutManager = new LinearLayoutManager(getActivity());

            mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

            if (savedInstanceState != null) {
                // Restore saved layout manager type.
                mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                        .getSerializable(KEY_LAYOUT_MANAGER);
            }
            setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

            mAdapter = new customAdapter(mDataset,mDataset2,mDataset3);
            // Set CustomAdapter as the adapter for RecyclerView.
            mRecyclerView.setAdapter(mAdapter);
            return rootView;
        }

        public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
            int scrollPosition = 0;

            // If a layout manager has already been set, get current scroll position.
            if (mRecyclerView.getLayoutManager() != null) {
                scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                        .findFirstCompletelyVisibleItemPosition();
            }

            switch (layoutManagerType) {
                case GRID_LAYOUT_MANAGER:
                    mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                    mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                    break;
                case LINEAR_LAYOUT_MANAGER:
                    mLayoutManager = new LinearLayoutManager(getActivity());
                    mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                    break;
                default:
                    mLayoutManager = new LinearLayoutManager(getActivity());
                    mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
            }

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.scrollToPosition(scrollPosition);
        }

        @Override
        public void onSaveInstanceState(Bundle savedInstanceState) {
            // Save currently selected layout manager.
            savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
            super.onSaveInstanceState(savedInstanceState);
        }
        private void initDataset() {
            mDataset = new String[judul.length];
            mDataset2 = new String[deskripsi.length];
            mDataset3 = new int[icon.length];
            for (int i = 0; i < judul.length; i++) {
                mDataset[i] = judul[i];
                mDataset2[i] = deskripsi[i];
                mDataset3[i] = icon[i];
            }
        }
    }



