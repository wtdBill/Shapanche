package com.example.administrator.shapanche.http;

/**
 * Created by ypp on 2017/10/16.
 */

public class Huanjing {
    @com.google.gson.annotations.SerializedName("pm2.5")
    private int _$Pm2545; // FIXME check this code
    private int co2;
    private int LightIntensity;
    private int humidity;
    private int temperature;

    public int get_$Pm2545() {
        return _$Pm2545;
    }

    public void set_$Pm2545(int _$Pm2545) {
        this._$Pm2545 = _$Pm2545;
    }

    public int getCo2() {
        return co2;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }

    public int getLightIntensity() {
        return LightIntensity;
    }

    public void setLightIntensity(int LightIntensity) {
        this.LightIntensity = LightIntensity;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
