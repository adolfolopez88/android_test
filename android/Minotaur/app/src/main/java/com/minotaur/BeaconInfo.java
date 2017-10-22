package com.minotaur;

import android.annotation.SuppressLint;
import android.hardware.camera2.params.StreamConfigurationMap;

import org.altbeacon.beacon.Identifier;

/**
 * Created by et on 8/10/17.
 */

class BeaconInfo {
    private Identifier beaconId;
    private Identifier namespaceId;
    private long ttl = 2000;
    private double distance = 0.0;
    private double x = 10.0;
    private double y  = 10.0;
    private String description = "Top left corner of K17";

    public BeaconInfo(Identifier namespaceId, Identifier beaconId) {
        this.beaconId = beaconId;
        this.namespaceId = namespaceId;
    }

    public Identifier getBeaconId() {
        return beaconId;
    }

    public Identifier getNamespaceId() {
        return namespaceId;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + this.namespaceId.toString().hashCode();
        result = prime * result + this.beaconId.toString().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object otherObject) {
        // check for reference equality.
        if (this == otherObject) {
            return true;
        }
        if (otherObject instanceof BeaconInfo) {
            BeaconInfo that = (BeaconInfo) otherObject;
            return (this.beaconId.compareTo(that.getBeaconId()) == 0 && this.namespaceId.compareTo(that.getNamespaceId()) == 0);
        }
        return false;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }

    @SuppressLint("DefaultLocale")
    public String getDistance() {
        if (this.distance < 1) {
            return String.format("%f centimeters", this.distance*100);
        } else {
            return String.format("%f meters", this.distance);
        }
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

