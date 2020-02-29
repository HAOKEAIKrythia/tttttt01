package com.jiker.keju;


public class Taxi {
    private int distance;
    private int waitingTime;
    private int taxiPrice;
    private double distancePrice = 0;

    public void parameter(int distance, int waitingT) {
        this.distance = distance;
        this.waitingTime = waitingT;
    }

    public double getDistancePrice() {
        if (distance <= 2) {
            distancePrice = 6;
        } else if (distance <= 8) {
            distancePrice = 6 + (distance - 2) * 0.8;
        } else {
            distancePrice = 10.8 + (distance - 8) * 1.2;
        }
        return distancePrice;
    }

    public String getPrice() {
        if (waitingTime == 0) {
            taxiPrice = (int) Math.round(getDistancePrice());
        } else {
            taxiPrice = (int) Math.round(getDistancePrice() + waitingTime * 0.25);
        }
        return "收费" + taxiPrice + "元" + "\n";
    }
}

