package com.example.mobileassignment1.Data;

import java.io.Serializable;

public class GPU implements Serializable {
    private String companyName;
    private String model;
    private String architecture;
    private String memoryType;

    private int vramCapacity;
    private double clockSpeed;
    private int maxDisplays;
    private int releaseDate;
    private double msrpPrice;
    public GPU(String model, String companyName, String architecture, String memoryType, double clockSpeed,
               int vramCapacity, int maxDisplays, int releaseDate, double msrpPrice) {
        this.model = model;
        this.companyName = companyName;
        this.architecture = architecture;
        this.memoryType = memoryType;
        this.clockSpeed = clockSpeed;
        this.vramCapacity = vramCapacity;
        this.maxDisplays = maxDisplays;
        this.releaseDate = releaseDate;
        this.msrpPrice = msrpPrice;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public int getVramCapacity() {
        return vramCapacity;
    }

    public void setVramCapacity(int vramCapacity) {
        this.vramCapacity = vramCapacity;
    }

    public double getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(double clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getMaxDisplays() {
        return maxDisplays;
    }

    public void setMaxDisplays(int maxDisplays) {
        this.maxDisplays = maxDisplays;
    }

    public double getMsrpPrice() {
        return msrpPrice;
    }

    public void setMsrpPrice(double msrpPrice) {
        this.msrpPrice = msrpPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof GPU)) return false;
        GPU other = (GPU) obj;
        return model.equals(other.model) && companyName.equals(other.companyName);
    }
    @Override
    public String toString() {
        return companyName +": "+ model;
    }
}
