// Universidad de Pamplona
// Ingeniería de sistemas - Matemáticas discretas
// Facilitador: MSc. Luis Armando Portilla Granados
// Propiedades de Funciones_TC definidas de A en B

package funciones_tc;

import java.util.Scanner;

public class Funciones_TC {
    static Scanner teclado = new Scanner (System.in);

    public static void main(String[] args) {
        
        int w[][] = new int[3][3];
        w[0][0] = 0;
        w[0][1] = 0;
        w[0][2] = 1;
        w[1][0] = 1;
        w[1][1] = 0;
        w[1][2] = 0;
        w[2][0] = 0;
        w[2][1] = 1;
        w[2][2] = 0;
        /*String v1[], v2[];
        int n1, n2, op;
        System.out.println("***** CARGAR CONJUNTOS *****");
        System.out.println("Digite número de elementos del conjunto A");
        n1 = teclado.nextInt();
        v1 = new String [n1];
        v1 = cargarConjunto(n1);
        System.out.println("Digite número de elementos del conjunto B");
        n2 = teclado.nextInt();
        v2 = new String [n2];
        
        v2 = cargarConjunto(n2);
        w = new int [n1][n2];
        
        do{
            System.out.println("***** CARGAR RELACIÓN (MATRIZ)¨*****");
            w = cargarMatriz(v1,v2);

            System.out.println("***** DEFINICIÓN DE LA RELACIÓN *****");
            mostrarConjunto(v1,"A");
            mostrarConjunto(v2,"B");
            
            mostrarRelacion(w,v1,v2);
            mostrarMatriz(w,v1,v2);
            
            System.out.println("Relación Inversa...");
            mostrarRelacion(inversa(w),v2,v1);
            System.out.println("Matriz Inversa...");
            mostrarMatriz(inversa(w),v2,v1);
            if (validarfuncion(w)){
                System.out.println("***** TIPO DE FUNCIÓN *****");
                System.out.println("Inyectiva \t\t\t\t\t=\t"+inyectiva(w));
                System.out.println("Sobreyectiva \t\t\t\t\t=\t"+sobreyectiva(w));
                System.out.println("Biyectiva1: utilizando inyectiva y sobre \t=\t"+biyectiva1(w));
                System.out.println("Biyectiva2: comprobando inyectiva y sobre \t=\t"+biyectiva2(w));
                System.out.println("Biyectiva3: calculando la inversa \t\t=\t"+biyectiva3(w));
            } else {
                System.out.println("LA RELACIÓN INGRESADA NO ES FUNCIÓN");
            }
            System.out.println("\nDesea evaluar otra función? [1]SI [0]NO");
            op = teclado.nextInt();
        }while(op==1);*/
    }
    static public String[] cargarConjunto(int ne){
        String [] x = new String [ne];
        for (int i=0; i<ne; i++){
            System.out.print("Digite elemento v"+"["+i+"] = ");
            x[i] = teclado.next();
        }
        System.out.println("");
        return x;
    }
    static public int[][] cargarMatriz (String a[], String b[]){
        int [][] x = new int [a.length][b.length];
        for (int i=0; i<a.length; i++){
            for (int j=0; j<b.length; j++){
                System.out.print("Digite elemento m"+"["+i+","+j+"] = "+"("+a[i]+","+b[j]+") = ");
                x[i][j] = teclado.nextInt();
            }
        }
        System.out.println("");
        return x;
    }
    static public void mostrarConjunto(String w[], String nom){
        System.out.print(nom + " = {");
        for (int i=0; i<(w.length-1); i++){
            System.out.print(w[i]+",");
        }
        System.out.print(w[(w.length-1)]+"}");
        System.out.println("");
    }
    static public void mostrarRelacion(int x[][], String a[], String b[]){
        System.out.print("R = {");
        for (int i =0; i<a.length; i++){
            for (int j=0; j<b.length; j++){
                if (x[i][j]!=0){    
                    System.out.print("("+a[i]+","+b[j]+")");
                }
            }
        }
        System.out.print("}");
        System.out.println("");
    } 
    static public void mostrarMatriz (int x[][], String a[], String b[]){
        System.out.print("Matriz = ");
        System.out.println("\t");
        for (int k=0; k<b.length; k++){
            System.out.print("\t"+b[k]+"\t");
        }
        System.out.println("");
        for (int i =0; i<a.length; i++){
            System.out.print(a[i]);
            for (int j=0; j<b.length; j++){
                System.out.print("\t"+x[i][j]+"\t");
            }
            System.out.println("");
        }
        System.out.println("");
    }
// ========================== tipos de función =============================
    // se puede validar si es o no función y de forma independiete al tipo
    // sólo se va a utilizar para la biyectiva con la inversa
    public static boolean validarfuncion(int m[][])
    {
        boolean b=true;
        int cont=0;
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                if(m[i][j]==1){
                    cont++;
                }
            }
            if(cont!=1){
                b=false;
            }
            cont=0;
        }
        return b;
    }
    public static boolean inyectiva(int m[][])
    {
         boolean b=true;
         int cont=0;
        for(int col=0;col<m.length;col++){
            for(int fila=0;fila<m[0].length;fila++){
                if(m[col][fila]==1){
                    cont++;
                }
            }
            if(cont!=1){
                b=false;
            }
            cont=0;
        }
        return b;
    }
    public static boolean sobreyectiva(int m[][])
    {
        boolean b=true;
         int cont=0;
         for(int i=0;i<m.length;i++){
             for(int j=0;j<m[0].length;j++){
                 if(m[j][i]==1){
                    cont++;
                }
             }
             if(cont!=1){
                b=false;
            }
            cont=0;
         }
         return b;
    }
    // opción 1 de biyectiva: utilizando los métodos inyectiva y sobreyectiva
    public static boolean biyectiva1(int m[][])
    {
        boolean p,q;
        p=inyectiva(m);
        q=sobreyectiva(m);
        return p&&q;
    }    
    // opción 2 de biyectiva: verificar que cumpla ser inyectiva y sobre
    public static boolean biyectiva2(int m[][])
    {
       int cont=0;
        for(int columna=0;columna<m[0].length;columna++){
            for(int fila=0;fila<m.length;fila++){
                if(m[fila][columna]==1){
                    cont++;
                }
            }
            if(cont>1 || cont!=1){
                return false;
            }
            cont=0;
        }
        return true;
    }
    // opción 3 de biyectiva: hallar la relación inversa de la función y verificar que también es función
    public static boolean biyectiva3(int m[][]){
        return validarfuncion(inversa(m));
    }
    public static int[][] inversa (int m[][]){
        int aux[][] = new int [m[0].length][m.length];
        for(int i=0;i<m.length;i++) 
        {
            for(int j=0;j<m[0].length;j++)
            {
                aux[j][i]=m[i][j];
            }
        }
        return aux;
    }
}
