package com.punkmkt.rallymaya.models;

/**
 * Created by germanpunk on 27/02/15.
 */
public class Coordenada {
    private Double Latitud;
    private Double Longitud;
    private String Ciudad;
public Coordenada(Double latitud, Double longitud, String ciudad){
    this.Latitud = latitud;
    this.Longitud = longitud;
    this.Ciudad = ciudad;
}
    public Double getLatitud() {
        return Latitud;
    }

    public void setLatitud(Double latitud) {
        Latitud = latitud;
    }

    public Double getLongitud() {
        return Longitud;
    }

    public void setLongitud(Double longitud) {
        Longitud = longitud;
    }


    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }
}
