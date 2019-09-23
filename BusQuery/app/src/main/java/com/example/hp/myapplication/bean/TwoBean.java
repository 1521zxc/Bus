package com.example.hp.myapplication.bean;

public class TwoBean {
    private String distance;
    private String timer;

    public TwoBean(String distance, String timer) {
        this.distance = distance;
        this.timer = timer;
    }

    @Override
    public String toString() {
        return "TwoBean{" +
                "distance='" + distance + '\'' +
                ", timer='" + timer + '\'' +
                '}';
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }
}
