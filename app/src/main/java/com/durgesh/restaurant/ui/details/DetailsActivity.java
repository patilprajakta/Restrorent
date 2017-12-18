package com.durgesh.restaurant.ui.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import com.durgesh.restaurant.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Snehal Tembare on 1/9/17.

 */

public class DetailsActivity extends AppCompatActivity {
    @BindView(R.id.image)
    protected ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        Picasso.with(this).load("https://lh3.googleusercontent.com/p/AF1QipOJ3aOYFPnTZa-w9moQeI6_9pQj1H27jHmBlbFj=s1600-w1280").into(imageView);
    }
}
