

package com.example.temperatura;

import java.io.Serializable;

public class Localizacao implements Serializable {

    private int id;
    private Double latitude;
    private Double longitude;

    public Localizacao(int id, Double lat, Double lon){
    this(lat,lon);
    setId(id);
    }

    public Localizacao(Double lat, Double lon){
        setLatitude(lat);
        setLongitude(lon);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Lat: " + latitude + ", Long: " + longitude;
    }
}
