package com.company;
import static java.lang.Thread.sleep;

public class WeatherBaseStation implements Runnable {
    private double temperature;
    private double humidity;

    public WeatherBaseStation() {

    }

    public void generateWeather(){
        this.temperature = Math.random()*212;
        this.humidity = Math.random()*100;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @Override
    public void run() {
        while(true){
            generateWeather();
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
