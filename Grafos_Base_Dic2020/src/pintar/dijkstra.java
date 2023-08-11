/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pintar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author leide
 */
public class dijkstra {
     public static void calcularRutaMasCorta(Nodo nodoInicial) {
        nodoInicial.distancia = 0;
        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>((n1, n2) -> Double.compare(n1.distancia, n2.distancia));
        colaPrioridad.add(nodoInicial);

        while (!colaPrioridad.isEmpty()) {
            Nodo nodoActual = colaPrioridad.poll();

            for (Arista arista : nodoActual.obtenerAristas()) {
                Nodo nodoDestino = arista.getN2();
                double distanciaTotal = nodoActual.distancia + arista.getDistancia();

                if (distanciaTotal < nodoDestino.distancia) {
                    colaPrioridad.remove(nodoDestino);
                    nodoDestino.distancia = distanciaTotal;
                    nodoDestino.previo= nodoActual;
                    colaPrioridad.add(nodoDestino);
                }
            }
        }
    }

    public static List<Nodo> obtenerCaminoMasCorto(Nodo nodoDestino) {
        List<Nodo> camino = new ArrayList<>();
        for (Nodo nodo = nodoDestino; nodo != null; nodo = nodo.previo) {
            camino.add(nodo);
        }
        Collections.reverse(camino);
        return camino;
    }
    public static void mostrarRuta(Nodo inicial,Nodo destino ){
        calcularRutaMasCorta(inicial);
        List<Nodo> camino = obtenerCaminoMasCorto(destino);
         
        for (Nodo nodo : camino) {
            System.out.print(nodo.getNombre() + " ");
        }
        System.out.println("\nDistancia total: " + destino.distancia);
    }
 
 
}
