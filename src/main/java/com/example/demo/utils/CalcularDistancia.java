package com.example.demo.utils;

public class CalcularDistancia {

    private static double grausParaRadianos(double graus){
        return graus * (Math.PI / 180);
    }

    public  static double distanciaEmKMEntreCoordenadas(Coordenadas coordenadasSolicitante, Coordenadas coordenadasEntregador){

        final int RADIUS = 6371;

        double latitudeCoordenadasSolicitante = coordenadasSolicitante.getLatitude();
        double longitudeCoordenadasSolicitante = coordenadasSolicitante.getLongitude();

        double latitudeCoordenadasEntregador = coordenadasEntregador.getLatitude();
        double longitudeCoordenadasEntregador = coordenadasEntregador.getLongitude();

        double deltaLatitude = grausParaRadianos(latitudeCoordenadasEntregador - latitudeCoordenadasSolicitante);
        double deltaLongitude= grausParaRadianos(longitudeCoordenadasEntregador - longitudeCoordenadasSolicitante);

        double arco = Math.sin(deltaLatitude / 2) * Math.sin(deltaLatitude / 2)+
                Math.cos(grausParaRadianos(latitudeCoordenadasSolicitante))*
                        Math.cos(grausParaRadianos(latitudeCoordenadasEntregador))*
                        Math.sin(deltaLongitude/ 2) *
                        Math.sin(deltaLongitude/ 2);

        double centro = 2 * Math.atan2(Math.sqrt(arco), Math.sqrt(1 - arco));

        double distancia = RADIUS * centro;
        return distancia;

    }


}
