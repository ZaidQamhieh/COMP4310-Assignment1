package com.example.mobileassignment1;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.example.mobileassignment1.Data.GPU;
import com.example.mobileassignment1.Data.Market;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static Market market;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        market = new Market();
        listView = findViewById(R.id.gpusList);
        setup();
    }
    private void setup(){
        listView.setAdapter(market.getAdapter(this,market.getListedGPUs()));
        EditText searchBar = findViewById(R.id.searchBar);
        Button searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(v-> search(String.valueOf(searchBar.getText())));
        listView.setOnItemClickListener((parent, view, position, id) -> {
            GPU gpu = (GPU) parent.getItemAtPosition(position);
            Intent intent = new Intent(this, detailedGPU_Activity.class);
            intent.putExtra("gpu", gpu);
            startActivity(intent);
        });
    }
    private void search(String searched){
        if(searched.isEmpty()){
            listView.setAdapter(market.getAdapter(this,market.getListedGPUs()));
            return;
        }
        ArrayList<GPU> searchGPU = market.searchGPU(searched);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, searchGPU));
    }
    @Override
    protected void onResume() {
        super.onResume();
        listView.setAdapter(market.getAdapter(this, market.getListedGPUs()));
    }
}