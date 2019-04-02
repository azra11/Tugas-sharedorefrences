package com.example.admin.gridrecycle;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.admin.gridrecycle.fragment.item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ujang Wahyu on 24/01/2017.
 */

public class gridadapter extends RecyclerView.Adapter<gridadapter.ViewHolder> {

    List<item> mItems;

    public gridadapter() {
        super();
        mItems = new ArrayList<item>();
        item nama = new item();
        nama.setName("Eric cantona");
        nama.seticon(R.drawable.cantona);
        mItems.add(nama);

        nama = new item();
        nama.setName("De rossi");
        nama.seticon(R.drawable.derossi);
        mItems.add(nama);

        nama = new item();
        nama.setName("Florenzi");
        nama.seticon(R.drawable.florenzi);
        mItems.add(nama);

        nama = new item();
        nama.setName("Bedner");
        nama.seticon(R.drawable.bednet);
        mItems.add(nama);

        nama = new item();
        nama.setName("Totti");
        nama.seticon(R.drawable.Totti);
        mItems.add(nama);



    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        item nature = mItems.get(i);
        viewHolder.tvspecies.setText(nature.getName());
        viewHolder.imgThumbnail.setImageResource(nature.geticon());
    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {


        public ImageView imgThumbnail;
        public TextView tvspecies;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.thumbnail);
            tvspecies = (TextView)itemView.findViewById(R.id.status);

        }
    }
}
