package org.example.sq.part1.SmartHomeController.model.lightning;

import org.example.sq.part1.SmartHomeController.services.ScheduleTimerControl;

public class LightEntity {
    private final long id;
    private final String name;
    private final String brand;
    private final LightType lightType;
    private final LightLocation lightLocation;
    private boolean open;
    private Colors colors;
    private double brightness;
    private String wifiConnection;
    private ScheduleTimerControl timer;

    private LightEntity(Builder builder) {
        this.brand = builder.brand;
        this.lightType = builder.lightType;
        this.lightLocation = builder.lightLocation;
        this.wifiConnection = builder.wifiConnection;
        this.id = builder.id;
        this.name = builder.name;
        this.open = builder.open;
        this.colors = builder.colors;
        this.brightness = builder.brightness;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private long id;
        private String name;
        private String brand;
        private LightType lightType;
        private LightLocation lightLocation;

        private boolean open = false;
        private Colors colors = Colors.WHITE;
        private double brightness = 100;
        private String wifiConnection = "";
        private ScheduleTimerControl timer;

        private Builder() {}

        public Builder brightness(double brightness){
            if(brightness<0 || brightness>100)
                throw new IllegalArgumentException("Brightness must be between 0 and 100");
            this.brightness=brightness;
            return this;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder lightType(LightType lightType) {
            this.lightType = lightType;
            return this;
        }

        public Builder lightLocation(LightLocation loc) {
            this.lightLocation = loc;
            return this;
        }

        public Builder open(boolean open) {
            this.open = open;
            return this;
        }

        public Builder colors(Colors colors) {
            this.colors = colors;
            return this;
        }

        public Builder wifiConnection(String wifiConnection) {
            this.wifiConnection = wifiConnection;
            return this;
        }

        public LightEntity build(){
            if (brand == null || name == null || lightType == null || lightLocation == null)
                throw new IllegalStateException("Some required fields are missing");

            return new LightEntity(this);
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Colors getColors() {
        return colors;
    }

    public double getBrightness() {
        return brightness;
    }

    public LightLocation getLightLocation() {
        return lightLocation;
    }

    public LightType getLightType() {
        return lightType;
    }

    public ScheduleTimerControl getTimer() {
        return timer;
    }

    public String getBrand() {
        return brand;
    }

    public String getWifiConnection() {
        return wifiConnection;
    }

    public boolean getOpen(){
        return this.open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setBrightness(double brightness) {
        this.brightness = brightness;
    }

    public void setColors(Colors colors) {
        this.colors = colors;
    }

    public void connectWifi(String wifiConnection){
        this.wifiConnection=wifiConnection;
    }

    public void disconnectWifi(){
        this.wifiConnection="";
    }

    public String checkWifiConnection(){
        if(wifiConnection.isBlank()){
            return "Not Connected";
        }
        return wifiConnection;
    }

    public void setTimer(ScheduleTimerControl timer){
        this.timer=timer;
    }
}
