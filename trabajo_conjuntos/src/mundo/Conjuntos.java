/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Usuario
 */
public class Conjuntos {
    Stack<Character> pila=new Stack<Character> ();
    public Conjuntos() {
    }

    public String replaceAll(String x) {
        String result = replaceBasic(x);

        return result;
    }

    public String identificarA(String S){
    String aux="";
    int inicio=0;
        for(int i=0;i<S.length();i++){
            
            if(S.charAt(i)=='Δ' && S.charAt(i-1)==')'){
            }
            if(S.charAt(i)=='Δ' && S.charAt(i-1)!=')'){
            }
        }
        
        return "";
    }

    public String replaceBasic(String x) {
        Character aux;
        String newX = "";
        for (int i = 0; i < x.length() - 1; i++) {
            aux = x.charAt(i);
            if (aux == '∪') {
                newX += "∨";
                continue;
            }
            if (aux == '∩') {
                newX += "∧";
                continue;
            }
            if (aux == '/') {
                newX += "∧¬";
                continue;
            }
            if (x.charAt(i + 1) == 'C') {
                newX += "(¬" + aux + ")";
            } else if (aux != 'C') {
                newX += aux;
            }
        }
        return newX;
    }

    public String pasarString(ArrayList<Character> a) {
        String rta = "";
        for (int i = 0; i < a.size(); i++) {
            rta += a.get(i);
        }
        return rta;
    }

    public String difSimetrica(String a, String b) {
        return "(" + a + "∨" + b + ")∧¬(" + a + "∧" + b + ")";
    }
}
