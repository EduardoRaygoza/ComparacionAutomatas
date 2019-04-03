package main;

import util.Automata;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import util.FuncionTransicion;
import util.ParOrdenado;

public class Main {
    private Automata a1, a2;
    private String msg, estadoInicial;
    private ArrayList<String> estados, alfabeto, estadosFinales;
    private ArrayList<FuncionTransicion> transiciones;
    private ArrayList<ParOrdenado> listaPares;
    private ParOrdenado par;
    
    public Main(){
        //Se recolecta la informacion del automata
        estados = getEstados(1);
        alfabeto = getAlfabeto(1);
        estadosFinales = getEstadosFinales(1);
        estadoInicial = getEstadoIncial(1);
        transiciones = getFuncionesTransicion();
        
        //Se crea un automata con la informacion recolectada
        a1 = new Automata(estados, alfabeto, estadoInicial, estadosFinales, transiciones);
        
        //Se verifica que el automata cumpla con las condiciones basicas
        //El estado inicial tiene que ser parte del conjunto de estados
        //Los estados finales tienen que ser parte del conjunto de estados
        if(!a1.verificarAutomata()){
            msg = "El automata ingresado no es valido porque no cumple con las condiciones basicas";
            JOptionPane.showMessageDialog(null, msg);
            System.exit(0);
        }
        
        //Se repite el proceso para el segundo automata
        estados = getEstados(2);
        alfabeto = getAlfabeto(2);
        estadosFinales = getEstadosFinales(2);
        estadoInicial = getEstadoIncial(2);
        transiciones = getFuncionesTransicion();
        a2 = new Automata(estados, alfabeto, estadoInicial, estadosFinales, transiciones);
        if(!a2.verificarAutomata()){
            msg = "El automata ingresado no es valido porque no cumple con las condiciones basicas";
            JOptionPane.showMessageDialog(null, msg);
            System.exit(0);
        }
        
        //Se verifica que los alfabetos de los automatas sean iguales
        if(!a1.compararAlfabeto(alfabeto)){
            msg = "Los alfabetos no son iguales, no es posible que representen el mismo lenguaje";
            JOptionPane.showMessageDialog(null, msg);
            System.exit(0);
        }
        
        listaPares = new ArrayList<>();
        listaPares.add(new ParOrdenado(a1.getEstadoInicial(), a2.getEstadoInicial()));
        
        
    }
    
    public ArrayList<String> getEstados(int i){
        ArrayList<String> lista = new ArrayList<>();
        String ph;
        String[] arr;
        msg = "Ingresa el conjunto de estados para el automata "+i+"\n"
                + "(los estados deben de ir separados por un espacio unicamente)";
        ph = JOptionPane.showInputDialog(msg);
        arr = ph.split(" ");
        for (int j = 0; j < arr.length; j++) {
            if(!arr[j].equals(""))
                lista.add(arr[j]);
        }
        return lista;
    }
    
    public ArrayList<String> getAlfabeto(int i){
        ArrayList<String> lista = new ArrayList<>();
        String ph;
        String[] arr;
        msg = "Ingresa el alfabeto para el automata "+i+"\n"
                + "(los simbolos deben de ir separados por un espacio unicamente)";
        ph = JOptionPane.showInputDialog(msg);
        arr = ph.split(" ");
        for (int j = 0; j < arr.length; j++) {
            if(!arr[j].equals(""))
                lista.add(arr[j]);
        }
        return lista;
    }
    
    public ArrayList<String> getEstadosFinales(int i){
        ArrayList<String> lista = new ArrayList<>();
        String ph;
        String[] arr;
        msg = "Ingresa el conjunto de estados finales para el automata "+i+"\n"
                + "(los estados deben de ir separados por un espacio unicamente)";
        ph = JOptionPane.showInputDialog(msg);
        arr = ph.split(" ");
        for (int j = 0; j < arr.length; j++) {
            if(!arr[j].equals(""))
                lista.add(arr[j]);
        }
        return lista;
    }
    
    public String getEstadoIncial(int i){
        String ph;
        msg = "Ingresa el estado inicial para el automata "+i+"\n"
                + "(Solo se acepta un solo estado)";
        return JOptionPane.showInputDialog(msg).trim();
    }
    
    public ArrayList<FuncionTransicion> getFuncionesTransicion(){
        ArrayList<FuncionTransicion> lista = new ArrayList<>();
        String ph;
        for (int i = 0; i < estados.size(); i++) {
            for (int j = 0; j < alfabeto.size(); j++) {
                msg = "Ingresa el estado destino de la operacion:\n"
                        + estados.get(i) + " X " + alfabeto.get(j) + " -> ?\n"
                        + "(El estado debe existir en el conjunto de estados)";
                do{
                    ph = JOptionPane.showInputDialog(msg).trim();
                }while(!estados.contains(ph));
                lista.add(new FuncionTransicion(estados.get(i), alfabeto.get(j), ph));
            }
        }
        return lista;
    }
    
    public static void main(String[] args) {
        new Main();
    }
}
