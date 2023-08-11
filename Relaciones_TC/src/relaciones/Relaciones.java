// Universidad de Pamplona - Actualización: Abril 2 de 2020
// Ingeniería de sistemas - Matemáticas discretas
// Facilitador: MSc. Luis Armando Portilla Granados
// Propiedades de Relaciones AXA

package relaciones;

import java.util.Scanner;

public class Relaciones {
    static Scanner teclado = new Scanner (System.in);

    public static void main(String[] args) {
        int m[][];
        String v[];
        int n, op;
        
        System.out.println("Digite número de elementos del conjunto A");
        n = teclado.nextInt();
        v = new String [n];
        m = new int [n][n];
        System.out.println("***** CARGAR CONJUNTO¨*****");
        v = cargarConjunto(n);
        
        do{
            System.out.println("***** CARGAR RELACIÓN (MATRIZ)¨*****");
            m = cargarMatriz(v,n);

            System.out.println("***** DEFINICIÓN DE LA RELACIÓN *****");
            mostrarConjunto(v,n);
            mostrarRelacion(m,v,n);
            mostrarMatriz(m,v,n,"m");
            
            System.out.println("***** TIPO DE RELACIÓN *****");
            // Llamado a 6 métodos, uno para cada tipo de relación
            System.out.println("Reflexiva1: recorre toda la matriz \t=\t"+reflexiva1(m));
            System.out.println("Reflexiva2: Con las variantes \t=\t"+reflexiva2(m));
            System.out.println("Simétrica1: recorre toda la matriz \t=\t"+simetrica1(m));
            System.out.println("Simétrica2: Con las viarintes \t=\t"+simetrica2(m));
            System.out.println("Antisimétrica1: recorre toda la matriz \t=\t"+antisimetrica1(m));
            System.out.println("Antisimétrica2: Con las variantes \t=\t"+antisimetrica2(m));
            System.out.println("Transitiva1: recorre la matriz op1 o op2 \t=\t"+transitiva1_op1_recorrematriz(m));
            System.out.println("Transitiva2: multiplicación de matrices \t=\t"+transitiva2_multiplicamatrices(m));
            mostrarMatriz(m,v,n,"m");
            mostrarMatriz(multiplicacionmatrices(m),v,n,"mXm");
            System.out.println("Equivalencia \t=\t"+equivalencia(m));
            System.out.println("Orden parcial \t=\t"+ordenparcial(m));
            System.out.println("\nDesea evaluar otra relación? [1]SI [0]NO");
            op = teclado.nextInt();
        }while(op==1);
    }
// ======================= entradas y salidas ==================================
    static public String[] cargarConjunto(int ne){
        String [] x = new String [ne];
        for (int i=0; i<ne; i++){
            System.out.print("Digite elemento v"+"["+i+"] = ");
            x[i] = teclado.next();
        }
        System.out.println("");
        return x;
    }
    static public int[][] cargarMatriz (String w[],int ne){
        int [][] x = new int [ne][ne];
        for (int i=0; i<ne; i++){
            for (int j=0; j<ne; j++){
                System.out.print("Digite elemento m"+"["+i+","+j+"] = "
                        +"("+w[i]+","+w[j]+") = ");
                x[i][j] = teclado.nextInt();
            }
        }
        System.out.println("");
        return x;
    }
    static public void mostrarConjunto(String w[], int ne){
        System.out.print("A = {");
        for (int i=0; i<(ne-1); i++){
            System.out.print(w[i]+",");
        }
        System.out.print(w[(ne-1)]+"}");
        System.out.println("");
    }
    static public void mostrarRelacion(int x[][], String w[], int ne){
        System.out.print("R = {");
        for (int i =0; i<ne; i++){
            for (int j=0; j<ne; j++){
                if (x[i][j]!=0){    
                    System.out.print("("+w[i]+","+w[j]+")");
                }
            }
        }
        System.out.print("}");
        System.out.println("");
    } 
    static public void mostrarMatriz (int x[][], String w[], int ne, String nom){
        System.out.print("Matriz "+nom);
        System.out.println("\t");
        for (int k=0; k<ne; k++){
            System.out.print("\t"+w[k]+"\t");
        }
        System.out.println("");
        for (int i =0; i<ne; i++){
            System.out.print(w[i]);
            for (int j=0; j<ne; j++){
                System.out.print("\t"+x[i][j]+"\t");
            }
            System.out.println("");
        }
        System.out.println("");
    }
// ======================== tipos de relación  =================================
    // reflexiva recorriendo toda la matriz
    public static boolean reflexiva1(int m[][]){
        boolean b=true;
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                if(i==j && m[i][j]!=1){
                    b=false;
                }
            }
        }
        return b;
    }
    // reflexiva con las variantes
    public static boolean reflexiva2(int m[][]){
        boolean b=true;
        for(int i=0; i<m.length;i++){
            if(m[i][i]!=1){
                b=false;
            }
        }
        return b;
    }
    // simétrica recorriendo toda la matriz
    public static boolean simetrica1(int m[][]){
        boolean b=true;
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                if(m[i][j]==1 && m[j][i]!=1){
                    b=false;
                }
            }
        }
        return b;
    }
    // simétrica con las variantes
    public static boolean simetrica2(int m[][]){
        
        return true;
    }
    // antisimétrica recorriendo toda la matriz
    public static boolean antisimetrica1(int m[][]){
        return true;
    }
    // antisimétrica con las variantes
    public static boolean antisimetrica2(int m[][]){
        return true;
    }
    // transitivas
    //PARA ESTUDIAR opción 1
    public static boolean transitiva1_op1_recorrematriz (int m[][]){
       boolean b=true;
        for(int i=0;i<m.length;i++)
        {
            for(int j=0;j<m[0].length;j++)
            {
               if(m[i][j]==1)
               {
                   for(int k=0;k<m[0].length;k++)  // recorre la fila j
                   {
                        if(m[j][k]==1)
                        {
                            if(m[i][k]!=1)
                            {
                                b=false;
                            }
                        }
                   }
               }
            }
        }
        return b;
    }
    //PARA ESTUDIAR opción 2
    public static boolean transitiva1_op2_recorrematriz(int m[][]){
        boolean b=true;
        for (int i=0; i<m.length; i++){
            for (int j=0; j<m[0].length; j++){
                if ((i!=j)&(m[i][j]== 1)){
                    for (int k=0; k<m.length; k++){
                        if ((j!=k)&(m[j][k]==1)&(m[i][k]!=1)){
                            b= false;
                        }
                    }
                }
            }
        }
        return b;
    }
    // escriba el método para sumas booleanas.
    public static int[][] multiplicacionmatrices(int m[][])
    {
        int[][] aux=new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++)  // recorre filas de la matriz 1 (m que luego aux)
        {
            for (int j = 0; j < m[0].length; j++)  // recorre columnas de matriz 2 (aux)
            {
                for (int k = 0; k <m[0].length; k++ )  // recorre las columnas de la matriz 1 (m)
                {
                    aux[i][j] += m[i][k]*m[k][j]; // suma booleana pendiente..
                } 
                if(aux[i][j]>1)  // machete para llenar con solo unos la matriz resultante
                {
                    aux[i][j]=1;
                }
            }
        }
        return (aux);
    }
    // transitica OPCIÓN 2 por multiplicación de matrices
    public static boolean transitiva2_multiplicamatrices (int m[][]){
        return true;
    }
    public static boolean equivalencia (int m[][]){
        boolean p,q,r;
        p = reflexiva1(m);
        q = simetrica1 (m);
        r = transitiva2_multiplicamatrices(m);
        if (p&q&r){
            return true;
        } else{
            return false;
        }
    }
    public static boolean ordenparcial (int m[][]){
        boolean p,q,r;
        p = reflexiva1(m);
        q = antisimetrica1(m);
        r = transitiva2_multiplicamatrices(m);
        if (p&q&r){
            return true;
        } else{
            return false;
        }
    }
}
