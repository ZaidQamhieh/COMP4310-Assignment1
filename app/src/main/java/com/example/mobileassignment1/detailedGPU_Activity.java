package com.example.mobileassignment1;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mobileassignment1.Data.GPU;

public class detailedGPU_Activity extends AppCompatActivity {
    private GPU gpu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detailed_gpu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        gpu = (GPU) getIntent().getSerializableExtra("gpu");
        detailedGPU();
        Button buyButton = findViewById(R.id.buyButton);
        buyButton.setOnClickListener(v-> buyGPU());
    }
    private void buyGPU(){
        MainActivity.market.buyGPU(gpu);
        finish();
    }
    private void detailedGPU(){
        TextView companyName = findViewById(R.id.companyName);
        TextView model = findViewById(R.id.model);
        TextView architecture = findViewById(R.id.architecture);
        TextView memoryType = findViewById(R.id.memoryType);
        TextView vramCapacity = findViewById(R.id.vramCapacity);
        TextView clockSpeed = findViewById(R.id.clockSpeed);
        TextView maxDisplays = findViewById(R.id.maxDisplays);
        TextView releaseDate = findViewById(R.id.releaseDate);
        TextView msrpPrice = findViewById(R.id.msrpPrice);

        companyName.setText(companyName.getText() + " " + gpu.getCompanyName());
        model.setText(model.getText() + " " + gpu.getModel());
        architecture.setText(architecture.getText() + " " + gpu.getArchitecture());
        memoryType.setText(memoryType.getText() + " " + gpu.getMemoryType());
        vramCapacity.setText(vramCapacity.getText() + " " + gpu.getVramCapacity() + " GB");
        clockSpeed.setText(clockSpeed.getText() + " " + gpu.getClockSpeed() + " GHz");
        maxDisplays.setText(maxDisplays.getText() + " " + gpu.getMaxDisplays());
        releaseDate.setText(releaseDate.getText() + " " + gpu.getReleaseDate());
        msrpPrice.setText(msrpPrice.getText() + " $" + gpu.getMsrpPrice());
    }
}