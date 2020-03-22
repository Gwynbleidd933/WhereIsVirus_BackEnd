package acn.poc.wiv.beans;

import java.io.Serializable;

public class GeoLocation implements Serializable {

    private double latitude;
    private double longitude;

    public GeoLocation() {}

    public GeoLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude(){
        return latitude;
    }
    public void setLatitude(double lat){
        latitude = lat;
    }

    public double getLongitude(){
        return longitude;
    }
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }
}
