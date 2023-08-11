/* UNIVERSIDAD DE PAMPLONA - Ingniería de Sistemas
 * Estructuras Computacionales discretas
 * Facilitador: MSc. Luis Armando Portilla Granados
 * Práctica 2: Proposiciones lógicas
 */
package practica2_operadoreslogicos;
import java.util.Scanner;
public class Main_practica2_operadoreslogicos {
    public static void main(String[] args) {
        avance3();
    }
    //avance 1 - OPCION a: validar que no esté en la diagonal y por fuera del rango abierto 10 y 20
    public static void avance1a (){
        Scanner teclado = new Scanner (System.in);
        int tm;
        int matriz[][];
        
        System.out.println("Tamaño de la matriz cuadrada...");
        tm = teclado.nextInt();
        matriz = new int [tm][tm];
        
        int x;
        boolean p,q;
        
        for (int i=0; i<matriz.length; i++){ //filas
            for (int j=0; j<matriz[0].length; j++){ //columnas para matrices no cuadradas 
                System.out.print("Elemento ["+i + "," + j +"]" + " = ");
                x = teclado.nextInt();
        
                p = i==j; // en la diagonal
                q = (x <= 10) || (x >= 20); // opcional: q = (x > 10) && (x < 20);
                
                if (!p && q){ // opccional: if (!p && !q)){
                    matriz[i][j] = x;
                } else {
                    System.out.println("Dato no válido");
                    matriz[i][j] = -1;
                }
            }
        }
        imprimeMatriz(matriz);
    }
    //avance 1 - OPCION 2: validar que no esté en la diagonal y por fuera del rango abierto 10 y 20
    public static void avance1b (){
        Scanner teclado = new Scanner (System.in);
        int tm;
        int matriz[][];
        
        System.out.println("Tamaño de la matriz cuadrada...");
        tm = teclado.nextInt();
        matriz = new int [tm][tm];
        
        int x;
        boolean p,q,r;
        
        for (int i=0; i<matriz.length; i++){ //filas
            for (int j=0; j<matriz[0].length; j++){ //columnas para matrices no cuadradas 
                System.out.print("Elemento ["+i + "," + j +"]" + " = ");
                x = teclado.nextInt();
        
                p = i==j; // en la diagonal
                q = x <= 10; // opcional: q = x > 10;
                r = x >= 20; // opcional: q = x < 20;
                
                if (!p && (q || r)){ // opccional: if (!p && (!q && !r)){
                    matriz[i][j] = x;
                } else {
                    System.out.println("Dato no válido");
                    matriz[i][j] = -1;
                }
            }
        }
        imprimeMatriz(matriz);
    }
    // avance 2 - no admita repetidos, del rango 10 y 20, ni en la diagonal
    public static void avance2 (){
        Scanner teclado = new Scanner (System.in);
        int tm;
        int matriz[][];
        
        System.out.println("Tamaño de la matriz cuadrada...");
        tm = teclado.nextInt();
        matriz = new int [tm][tm];
        
        int x;
        boolean p,q,r;
        
        for (int i=0; i<matriz.length; i++){ //filas
            for (int j=0; j<matriz[0].length; j++){ //columnas para matrices no cuadradas 
                System.out.print("Elemento ["+i + "," + j +"]" + " = ");
                x = teclado.nextInt();
        
                p = repetido(matriz,x); // esta repetido
                q = i==j; // en la diagonal
                r = (x <= 10) || (x >= 20); // opcional: q = x < 20;
                
                if (!p && !q && r){
                    matriz[i][j] = x;
                } else {
                    System.out.println("Dato no válido");
                    matriz[i][j] = -1;
                }
            }
        }
        imprimeMatriz(matriz);
    }
    // avance 3 - no admita repetidos, del rango 10 y 20, ni en la diagonal,
    //sobre la diagonal sólo amite pares y por debajo impares
    public static void avance3 (){
        Scanner teclado = new Scanner (System.in);
        int tm;
        int matriz[][];
        
        System.out.println("Tamaño de la matriz cuadrada...");
        tm = teclado.nextInt();
        matriz = new int [tm][tm];
        
        int x;
        boolean p,q,r,s,t;
        
        for (int i=0; i<matriz.length; i++){ //filas
            for (int j=0; j<matriz[0].length; j++){ //columnas para matrices no cuadradas 
                System.out.print("Elemento ["+i + "," + j +"]" + " = ");
                x = teclado.nextInt();
        
                p = repetido(matriz,x); // esta repetido
                q = i==j; // en la diagonal
                r = (x <= 10) || (x >= 20);
                s = i<j;
                t = x%2==0;
                
                if (!p && !q && r && ((s && t)||(!s && !t))){
                    matriz[i][j] = x;
                } else {
                    System.out.println("Dato no válido");
                    matriz[i][j] = -1;
                }
            }
        }
        imprimeMatriz(matriz);
    }
    //busca si en la matriz ya está un elemento de entrada
    static public boolean repetido (int m[][], int dato){
        for (int i=0; i<m.length; i++){
            for (int j=0; j<m[0].length; j++){ //for (int j=0; j<x.length; j++)
                if (m[i][j] == dato){
                    return true;
                }
            }
        }
        return false;
    }
    //imprime la matriz en consola
    public static void imprimeMatriz(int m[][]){
        for (int i=0; i<m.length; i++){
            for (int j=0; j<m[0].length; j++){
                System.out.print(m[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }
}
