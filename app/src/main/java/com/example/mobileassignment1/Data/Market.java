package com.example.mobileassignment1.Data;

import java.io.Serializable;
import java.util.ArrayList;
import android.content.Context;
import android.widget.ArrayAdapter;

public class Market implements Serializable {
    private ArrayList<GPU> listedGPUs;

    public Market(){
        listedGPUs = new ArrayList<>();
        listGPU("RTX 4090", "NVIDIA", "Ada Lovelace", "GDDR6X", 2.52, 24, 4, 2022, 1599.99);
        listGPU("RTX 4080", "NVIDIA", "Ada Lovelace", "GDDR6X", 2.51, 16, 4, 2022, 1199.99);
        listGPU("RTX 4070 Ti", "NVIDIA", "Ada Lovelace", "GDDR6X", 2.61, 12, 4, 2023, 799.99);
        listGPU("RTX 4070", "NVIDIA", "Ada Lovelace", "GDDR6X", 2.58, 12, 4, 2023, 599.99);
        listGPU("RTX 3080", "NVIDIA", "Ampere", "GDDR6X", 1.71, 10, 3, 2020, 699.99);
        listGPU("RX 7900 XTX", "AMD", "RDNA 3", "GDDR6", 2.50, 24, 4, 2022, 999.99);
        listGPU("RX 7900 XT", "AMD", "RDNA 3", "GDDR6", 2.39, 20, 4, 2022, 849.99);
        listGPU("RX 7800 XT", "AMD", "RDNA 3", "GDDR6", 2.43, 16, 4, 2023, 499.99);
        listGPU("RX 7600", "AMD", "RDNA 3", "GDDR6", 2.655, 8, 4, 2023, 269.99);
        listGPU("RX 6800 XT", "AMD", "RDNA 2", "GDDR6", 2.25, 16, 4, 2020, 649.99);
        listGPU("Arc A770", "Intel", "Alchemist", "GDDR6", 2.10, 16, 4, 2022, 349.99);
        listGPU("Arc A750", "Intel", "Alchemist", "GDDR6", 2.05, 8, 4, 2022, 289.99);
        listGPU("Arc A580", "Intel", "Alchemist", "GDDR6", 1.70, 8, 4, 2023, 179.99);
        listGPU("RTX 4060", "NVIDIA", "Ada Lovelace", "GDDR6", 2.46, 8, 4, 2023, 299.99);
        listGPU("RX 7700 XT", "AMD", "RDNA 3", "GDDR6", 2.54, 12, 4, 2023, 449.99);
    }

    private void listGPU(String model, String companyName, String architecture, String memoryType,
                        double clockSpeed, int vramCapacity, int maxDisplays, int releaseDate, double msrpPrice) {
        GPU gpu = new GPU(model, companyName, architecture, memoryType, clockSpeed, vramCapacity, maxDisplays, releaseDate, msrpPrice);
        listedGPUs.add(gpu);
    }

    public ArrayList<GPU> searchGPU(String searchedGPU) {
        ArrayList<GPU> results = new ArrayList<>();
        for (GPU gpu : listedGPUs) {
            if (gpu.toString().toLowerCase().contains(searchedGPU.toLowerCase()))
                results.add(gpu);
        }
        return results;
    }

    public ArrayAdapter<GPU> getAdapter(Context context, ArrayList<GPU> gpuList) {
        ArrayAdapter<GPU> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, gpuList);
        return adapter;
    }
    public void buyGPU(GPU boughtGPU){
        listedGPUs.remove(boughtGPU);
    }

    public ArrayList<GPU> getListedGPUs() {
        return listedGPUs;
    }
}