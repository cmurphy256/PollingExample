package com.company;

import static java.lang.Thread.sleep;

public class WeatherAppScreen implements Runnable{

    private WeatherBaseStation baseStation;
    private double currentTemperature;
    private double previousTemperature;

    public WeatherAppScreen(WeatherBaseStation station){
        this.baseStation = station;
    }

    public void setBaseStation(WeatherBaseStation baseStation) {
        this.baseStation = baseStation;
    }

    public WeatherBaseStation getBaseStation(){
        return this.baseStation;
    }

    public void display(){
        System.out.println("--------------------------------------------------------");
        System.out.println("The current temperature is : "+ this.currentTemperature + "\u00B0 F");
        System.out.println("The previous temperature is : "+ this.previousTemperature + "\u00B0 F");
        System.out.println("--------------------------------------------------------");
    }

    @Override
    public void run() {
        while(true){
            this.previousTemperature = this.currentTemperature;
            this.currentTemperature = this.baseStation.getTemperature();
            display();
            try {
                sleep(Math.round(Math.random()*5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
