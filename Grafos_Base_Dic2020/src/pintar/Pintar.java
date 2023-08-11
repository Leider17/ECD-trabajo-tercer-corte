/*  UNIVERSIDAD DE PAMPLONA
    Ingeniería de Sistemas - Matemáticas discretas: Grafos
    M.Sc. Luis Armando Portilla Granados
    Abril 24 de 2018

    * Actualizado * 
    Wilmer Rodríguez S
    Diciembre 19 2020
 */
package pintar;

import javax.swing.JLayeredPane;
import pintar.Ventana;
import sun.net.www.content.image.png;

public class Pintar {

    private static Ventana view;

    public Pintar() {
        view = new Ventana();
 
 
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /*
        * Ejecuta la ventana principal de la aplicacion
         */
        java.awt.EventQueue.invokeLater(() -> {
            new Pintar();
            
            
            view.setVisible(true);
            /*
            Nodo nodoA=new Nodo(2,3,1);
            Nodo nodoB=new Nodo(4,3,2);
            Nodo nodoC=new Nodo(4,2,3);
            Nodo nodoD=new Nodo(5,3,4);
            Nodo nodoE=new Nodo(5,2,5);
            Nodo nodoF=new Nodo(6,3,6);
            nodoA.agregarArista(new Arista(nodoA,nodoB));
            nodoA.agregarArista(new Arista(nodoA,nodoC));
            nodoB.agregarArista(new Arista(nodoB,nodoD));
            nodoC.agregarArista(new Arista(nodoC,nodoE));
            nodoD.agregarArista(new Arista(nodoD,nodoF));
            nodoE.agregarArista(new Arista(nodoE,nodoF));
            
            dijkstra.mostrarRuta(nodoA, nodoF);*/
        });
  

    }
}
