package com.softkoki.saltsideassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

public class DetailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView tv_title, tv_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imageView = (ImageView)findViewById(R.id.iv_image);
        tv_desc = (TextView)findViewById(R.id.tv_desc);
        tv_title = (TextView)findViewById(R.id.tv_title);


        tv_title.setText(getIntent().getStringExtra("mytitle") + "");
        tv_desc.setText(getIntent().getStringExtra("mydesc") + "");

        Ion.with(imageView)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .load(getIntent().getStringExtra("myimage"));
    }
}
