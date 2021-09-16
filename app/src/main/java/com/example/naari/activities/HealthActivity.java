package com.example.naari.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.naari.R;
import com.example.naari.adapter.ItemCardViewAdapter;
import com.example.naari.models.Mountain;
import com.example.naari.models.MountainData;
import java.util.ArrayList;

public class HealthActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Mountain> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(MountainData.getListData());
        showRecyclerViewCard();

    }

    private void showRecyclerViewCard() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ItemCardViewAdapter cardViewAdapter = new ItemCardViewAdapter(this);
        cardViewAdapter.setListMountain(list);
        recyclerView.setAdapter(cardViewAdapter);
    }
}
