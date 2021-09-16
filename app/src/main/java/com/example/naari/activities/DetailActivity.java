package com.example.naari.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.naari.R;
import com.example.naari.models.Mountain;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOUNTAIN = "extra_mountain";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.img_detail);
        TextView name = findViewById(R.id.tv_name_detail);
        TextView description = findViewById(R.id.tv_desc_detail);

        Mountain mountain = getIntent().getParcelableExtra(EXTRA_MOUNTAIN);

        Glide.with(this).load(mountain.getPhoto()).into(imageView);
        name.setText(mountain.getName());
        description.setText(mountain.getDescription());

    }
}
