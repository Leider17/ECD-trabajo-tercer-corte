/* UNIVERSIDAD DE PAMPLONA - Ingniería de Sistemas
 * Estructuras Computacionales discretas - Repasos
 * Facilitador: MSc. Luis Armando Portilla Granados
 * Práctica 1: Variantes del For
 */
package practica1_variantesfor;

public class Main_practica1_variantesfor {
    
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        variante8 (array);
//        boolean b=es_par(5);
//        System.out.println("Salida par = "+b);
        
    }
    //i=i+paso (actualización de variables: i++ = i=i+1, i+=2 = i=i+2, etc.
    public static void variante1 (int[] array){
        int i;
        System.out.println("Salida stándar");
        for (i=0; i<10; i++){ 
            System.out.print(array[i]);
        }
    }
    public static void variante2 (int[] array){
        System.out.println("Salida stándar, declara la variable de control en el for");
        for (int i=0; i<10; i++){ 
            System.out.print(array[i]);
        }
    }
    public static void variante3 (int[] array){
        //length se usa para obtener la longitud de una cadena Java
        System.out.println("Salida con la función length");
        for (int i=0; i<array.length; i++){ 
            System.out.print(array[i]);
        }
    }
    public static void variante4 (int[] array){
        //Foreach (de la palabra inglesa for each = para cada uno)
        System.out.println("Salida con el método foreach");
        for (int i:array){ 
            System.out.print(array[i]);
        }
    }
    public static void variante5 (int[] array){
        int i=0;
        System.out.println("Salida sin inicio");
        for (; i<array.length; i++){ 
            System.out.print(array[i]);
        }
    }
    public static void variante6 (int[] array){
        System.out.println("Salida sin actualización");
        for (int i=0; i<array.length; ){
            i++;
            System.out.print(array[i]);
        }
    }
    public static void variante7 (int[] array){
        System.out.println("Salida sin condición");
        for (int i=0; ; i++){
            if (i==array.length) {
                break;
            }
            System.out.print(array[i]);
        }
    }
    public static void variante8 (int[] array){
        int i=0;
        System.out.println("Salida con sólo la condición");
        for ( ; i<array.length; ){
            System.out.print(array[i]);
            i++;
        }
    }
    public static void variante9 (int[] array){
        System.out.println("Salida varias variables");
        for (int i=0, j=0; i<array.length; i++, j++){ 
            System.out.print("i"+array[i]+" "+"j"+array[i]+" ");
        }
    }
    public static void variante10 (int[] array){
        int i=0;
        System.out.println("Salida con ciclo infinito");
        for ( ; ; ){
            if (i==array.length){
                break;
            }
            System.out.print(array[i]);
            i++;
        }
    }
    public static void variante11 (int[] array){
        System.out.println("Salida for con múltiples condiciones");
        for (int i=0; (i<array.length) && (array[i]<5); i++){ 
            System.out.print(array[i]);
        }
    }
    
    //=================================================
    public static void variante11a (int[] array){
        System.out.println("Salida for con dos condiciones, pares");
        for (int i=0; i<array.length && array[i]%2==0; i++){ 
            System.out.print(array[i]);
        }
    }
    public static void variante11b (int[] array){
        System.out.println("Salida for con dos condiciones");
        for (int i=0; i<array.length && es_par(array[i]); i++){ 
            System.out.print(array[i]);
        }
    }
    public static boolean es_par (int valor){
            if (valor%2==0){
                return true;
            }
            else {
                  return false;
                 }
    }
    public static void variante11c (){
        System.out.println("Salida for con dos condiciones, pares");
        for (int i=0; i<10 && i%2==0; i++){ 
            System.out.print(i);
        }
    }
    //=================================================
    
    public static void variante11d (int[] array){
        System.out.println("Salida for con dos condiciones, pares");
        for (int i=0; ; i++){
            if (i<array.length && array[i]%2==0) {
                System.out.print(array[i]);
            }
            if (i==array.length){
                break;
            }
        }
    }
    public static void variante11e (int[] array){ //de la variante11d
        boolean p, q, r;
        System.out.println("Salida for con dos condiciones y operadores lógicos");
        for (int i=0; ; i++){
            p = i<array.length;
            q = (array[i]%2)==0;
            if (p && q) {
                System.out.print(array[i]);
            }
            if (i==array.length){
                break;
            }
        }
    }
    public static void variante11OK (int[] array){
        boolean p, q, r;
        System.out.println("Salida for con dos condiciones y operadores lógicos");
        for (int i=0; ; i++){
            p = i==array.length;
            if (p){
                break;
            }
            q = i<array.length;
            r = (array[i]%2)==0;
            if (q && r) {
                System.out.print(array[i]);
            }
        }
    }
}
