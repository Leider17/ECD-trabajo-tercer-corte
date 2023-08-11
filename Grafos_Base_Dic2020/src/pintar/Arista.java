/* UNIVERSIDAD DE PAMPLONA
    Ingeniería de Sistemas - Matemáticas discretas: Grafos
    M.Sc. Luis Armando Portilla Granados
    Abril 24 de 2018

    *** ACTUALIZADO *** 
    Wilmer Rodríguez S
    Diciembre 19 2020
        # Se eliminó el método de pintar aristas independientemente
 */
package pintar;

/**
 *
 * @author Mariana
 */
public class Arista {

    private Nodo n1, n2;
    private String nombreA;
    private double distancia;

    public Arista(Nodo n1, Nodo n2) {
        this.n1 = n1;
        this.n2 = n2;
        this.nombreA = n1.getNombre() + n2.getNombre();
        this.distancia=calcularDistancia();
    }
    
    /**
     * @return the n1
     */
    public Nodo getN1() {
        return n1;
    }

    /**
     * @return the n2
     */
    public Nodo getN2() {
        return n2;
    }

    /**
     * @return the nombreA
     */
    public String getNombreA() {
        return nombreA;
    }
    public double getDistancia(){
       return  this.distancia;
    }
    public double calcularDistancia(){
        this.distancia=(Math.sqrt(Math.pow(n2.getX()-n1.getX(), 2)+ Math.pow(n2.getY()-n1.getY(), 2)))*2;
        return distancia;
    }
}
