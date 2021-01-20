package com.company;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        WeatherBaseStation station = new WeatherBaseStation();
        WeatherBaseStation station2 = new WeatherBaseStation();

        WeatherAppScreen app1 = new WeatherAppScreen(station);
        WeatherAppScreen app2 = new WeatherAppScreen(station);

        Thread t1 = new Thread(station);
        Thread t2 = new Thread(station2);
        Thread t3 = new Thread(app1);
        Thread t4 = new Thread(app2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        app2.setBaseStation(station2);

        System.out.println();
        System.out.println("================================================================================================================");
        System.out.println();
    }
}
