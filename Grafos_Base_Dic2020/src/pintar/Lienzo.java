/*  UNIVERSIDAD DE PAMPLONA
    Ingeniería de Sistemas - Matemáticas discretas: Grafos
    Wilmer Rodríguez S
    Diciembre 19 2020
        # Se creó una clase que simula un lienzo para ser pintado
        # Se creó el método paint, para actualizar todo el grafo conjuntamente
        # Se cambió los colores de nodos y arista y fuente usadas
 */
package pintar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;


/**
 * Crea un lienzo en el cual se puede pintar y actualizar el grafo Diciembre 19
 * 2020
 *
 * @author WILMER RODRIGUEZ S
 */
public class Lienzo extends JPanel {

    private Nodo[] nodos;
    private Arista aristas[];
    private boolean camino;
    private Arista[] aris;
    private BufferedImage backgroundImage;

    /**
     * Crea un objeto de tipo JPanel para simular lienzo
     *
     * @param t Numero de nodos que soporta el vector
     */
    public Lienzo(int t) {

        nodos = new Nodo[t];
        aristas = new Arista[t * 2];
    }

    /**
     * permite el cambio de la imagen de fondo
     *
     * @param backgroundImage
     */
    public void setBackground(BufferedImage backgroundImage) {
        this.backgroundImage = backgroundImage;
        repaint();
    }

    /**
     * pinta la imagen de fondo en el Jpanel
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

    }

    /**
     * Pinta los gráficos del panel. Donde se pinta el grafo
     *
     * @param grphcs
     */
    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);

        Graphics2D graphics = (Graphics2D) grphcs;

        // Renderiza los gráficos para mejorar la calidad de los dibujos
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja las aristas
        for (Arista arista : aristas) {
            if (arista != null) {
                pintarArista(graphics, arista.getN1(), arista.getN2());
            }
        }

        // Dibuja los nodos
        for (Nodo nodo : nodos) {
            if (nodo != null) {
                pintarNodo(graphics, nodo);
            }
        }
    }

    /**
     * Permite pintar los nodos
     *
     * @param g
     * @param n1 Nodo 2 de la arista
     */
    private void pintarNodo(Graphics g, Nodo n1) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setColor(n1.getColorNodo());
        //La esquina superior izquierda esta en (x,y), y se especifica la anchura (width) y la altura (height)
        //Si la anchura y la altura son iguales, se dibuja la circunferencia.
        graphics.fillOval(n1.getX() - n1.getD() / 2, n1.getY() - n1.getD() / 2, n1.getD(), n1.getD()); // relleno del círculo

        graphics.setColor(Color.red);
        graphics.setFont(new java.awt.Font("Segoe UI", 0, 15));
        //Dibuja la string str, empieza en el punto (x,y). x define la posición de la izquierda de la String. y define la altura para la línea base 
        graphics.drawString(n1.getNombre(), n1.getX() - n1.getD() / 2, n1.getY() - n1.getD() / 2); // *** nombre del vértice

    }

    /**
     * Permite pintar las aristas de un grafo
     *
     * @param g
     * @param n1 Nodo 1 de la arista
     * @param n2 Nodo 2 de la arista
     */
    private void pintarArista(Graphics g, Nodo n1, Nodo n2) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        // dar color de la linea
        Arista arista = new Arista(n1, n2);
        graphics.setColor(Color.BLACK);
        // dar grosor de la linea
        graphics.setStroke(new BasicStroke((int) (Ventana.ANCHO * 0.002)));
        // Pintar la linea
        graphics.drawLine(n1.getX(), n1.getY(), n2.getX(), n2.getY());
        graphics.setColor(Color.white);
        graphics.setStroke(new BasicStroke((int) (Ventana.ANCHO * 0.008)));
        graphics.drawString(String.format("%.2f", arista.getDistancia()), n1.getX() + ((n2.getX() - n1.getX()) / 2), n1.getY() + ((n2.getY() - n1.getY()) / 2));
        if (camino == true) {
            for (Arista a : aris) {
                n1 = a.getN1();
                n2 = a.getN2();
                graphics.setColor(Color.BLUE);
                graphics.setStroke(new BasicStroke((int) (Ventana.ANCHO * 0.004)));
                graphics.drawLine(n1.getX(), n1.getY(), n2.getX(), n2.getY());
                
            }
        }
    }

    /**
     * Permite actualizar los nodos que serán pintados
     *
     * @param nodos
     */
    public void setNodos(Nodo[] nodos) {
        this.nodos = nodos;
    }

    /**
     * Permite actualizar las aristas que serán pintadas
     *
     * @param aristas
     */
    public void setAristas(Arista[] aristas) {
        this.aristas = aristas;
    }

    public void activarCamino(Arista[] aris) {
        //Para pintar el camino
        this.camino = true;
        this.aris = aris;
    }

    public void desactivarCamino() {//Para no pintar el camino luego de borrarlo
        this.camino = false;
    }

}
