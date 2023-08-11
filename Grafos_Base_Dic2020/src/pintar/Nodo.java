/*  UNIVERSIDAD DE PAMPLONA
    Ingeniería de Sistemas - Matemáticas discretas: Grafos
    M.Sc. Luis Armando Portilla Granados
    Abril 24 de 2018

    *** ACTUALIZADO *** 
    Wilmer Rodríguez S
    Diciembre 19 2020
        # Se eliminó el método de pintar nodos independientemente
        # Se agregó una variable de ColorNodo para manejar los cambios del nodo cuando se está sobre él
        # Se agregó la posibilidad de actualizar la posición de un nodo
 */
package pintar;

import java.awt.Color;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mariana
 */
public class Nodo {

    private int x;
    private int y; 
    private String nombre;
    private List<Arista> aristas;
    public double distancia = Double.POSITIVE_INFINITY;
    static final int d = (int) (Ventana.ALTO * 0.0105); // 20 px aproximadamente --- 0.01851
    private Color colorNodo;
    public Nodo previo;

    public Nodo(int x, int y, int i) {
        this.x = x;
        this.y = y;
        this.aristas=new ArrayList<>();
        this.nombre = Integer.toString(i);//Character.toString((char) (65 + i));//+" "+ Integer.toString(x) + "," + Integer.toString(y);
        colorNodo = Ventana.COLOR_NODO;
        this.previo=null;
    }

    /**
     * Permite actulizar la posición del nodo luego de ser movido en la interfaz
     *
     * @param punto
     */
    public void actualizarPosicion(Point punto) {
        this.x = punto.x;
        this.y = punto.y;
    }
    
    public void agregarArista(Arista arista){
        aristas.add(arista);
    }
    public List<Arista> obtenerAristas(){
       return aristas; 
    }
    /**
     * @return Posición x del nodo
     */
    public int getX() {
        return x;
    }

    /**
     * @return Posición y del nodo
     */
    public int getY() {
        return y;
    }

    /**
     * @return Nombre del nodo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return Radio del circulo que representa el nodo
     */
    public int getD() {
        return d;
    }

    /**
     *
     * @return Color del nodo en ese instante
     */
    public Color getColorNodo() {
        return colorNodo;
    }

    /**
     * Resetea el nodo al color por defecto
     */
    public void colorDefecto() {
        this.colorNodo = Ventana.COLOR_NODO;
    }

    /**
     * Cambia de color al nodo, para cuendo se está sobre el nodo el la interfaz
     * gráfica
     */
    public void colorSobreNodo() {
        this.colorNodo = Ventana.COLOR_SOBRE_NODO;
    }
    

}
