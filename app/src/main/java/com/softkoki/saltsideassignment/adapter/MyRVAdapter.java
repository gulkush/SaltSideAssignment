package com.softkoki.saltsideassignment.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;
import com.softkoki.saltsideassignment.R;
import com.softkoki.saltsideassignment.model.MyImage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by gulkush on 9/14/2016.
 */
public class MyRVAdapter extends RecyclerView.Adapter<MyRVAdapter.MyViewHolder> {

    List<MyImage> images;

    public MyRVAdapter(List<MyImage> images){
        this.images = images;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.my_item_layout, parent, false);
        MyViewHolder mvh = new MyViewHolder(view);
        return mvh;
    }



    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final MyImage image = images.get(position);
        holder.tv_title.setText(image.getTitle());
        holder.imageView.setImageBitmap(null);
        Ion.with(holder.imageView)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .load(image.getImage());



    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tv_title;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.image);
            tv_title = (TextView)itemView.findViewById(R.id.tv_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }
    }
}