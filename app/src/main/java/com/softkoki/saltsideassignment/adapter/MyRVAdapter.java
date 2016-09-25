package com.softkoki.saltsideassignment.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.softkoki.saltsideassignment.DetailsActivity;
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
        holder.tv_desc.setText(image.getDescription());
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

        ImageView imageView, iv_readmore;
        TextView tv_title, tv_desc;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.image);
            tv_title = (TextView)itemView.findViewById(R.id.tv_title);
            tv_desc = (TextView)itemView.findViewById(R.id.tv_desc);
            iv_readmore = (ImageView) itemView.findViewById(R.id.iv_readmore);

            iv_readmore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetailsActivity.class);
                    MyImage image = images.get(getAdapterPosition());
                    intent.putExtra("mytitle", image.getTitle());
                    intent.putExtra("mydesc", image.getDescription());
                    intent.putExtra("myimage", image.getImage());
                    context.startActivity(intent);
                }
            });

        }
    }
}