/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimerParcial;
import java.io.*;
import java.util.*;

/**
 *
 * @author Usuario
 */

//Que determine y retorne la mayor de las tres dimensiones del paquete las
//cuales se pasaran como parámetros al método, este método será privado.

public class Despacho {
    
    public static void main(String[] args) throws IOException {
        
        String[] nombre = new String[tamArch()];
        double[][] dato = new double[tamArch()][4];
        
        leoArch(nombre, dato);
        mostrar(nombre, dato);
        
        estadoCostoDeEnvio(nombre,dato);
        
    }
    
    public static int tamArch()  throws IOException{
        File f = new File("D:/Despacho/Despacho.txt");
        int tam = 0;
        Scanner leo = new Scanner(f);
        String reg = "";
        while(leo.hasNext()){
            reg = leo.nextLine();
            tam++;
        }
        return tam;
    }
    
    public static void leoArch(String[] nombre, double[][] dato) throws IOException {
        Scanner leer = new Scanner(new File("C:/Users/Usuario/Documents/NetBeansProjects/ProgamacionIII/src/Despacho.txt"));
        int fila = 0;
        while(leer.hasNext()){
            nombre[fila] = leer.next();
            for(int col = 0; col < dato[0].length ;col++){
                dato[fila][col] = leer.nextDouble();
            }
            fila++;
        }
    }
    
    public static void mostrar(String[] nombre, double[][] dato) throws IOException{
        for(int i = 0; i < nombre.length; i++){
            System.out.printf("%-12s ", nombre[i]);
            for(int j = 0; j < dato[0].length; j++){
                System.out.printf("%05.2f ", dato[i][j]);
            }
            System.out.println("\n");
        }
    }
    
    private static double mayorDimension(double n1, double n2, double n3){
        double mayor;
            mayor = Math.max(Math.max(n1, n2), n3);
        return mayor;
    }
    
    private static double perimetro(double a,double l, double an){
        double perimetro, mayorD = mayorDimension(a, l, an);
        perimetro = 2 * (a + l + an - mayorD);
        return perimetro;
    }
    
    private static double costoDeEnvio(double peso){
        double costo = 0;
        if(peso >= 0.1 && peso <= 3.50){
            costo = 156;
        }else if(peso >= 3.51 && peso <= 6.50){
            costo = 240;
        }else if(peso >= 6.51 && peso <= 18.0){
            costo = 492;
        }
            
        return costo;
        
    }
    
    public static void estadoCostoDeEnvio(String[] nombre, double[][] dato){
        String estado = "";
        int j;
        double a, l, an, peso, mayorDim, perim, vcosto;
        boolean pesoAprobado = true;
        System.out.printf("%-12s %-16s %-7s \n", "Cliente", "estado", "costo");
        for(int i = 0; i < nombre.length; i++){
            System.out.printf("%-12s ", nombre[i]);
            peso = dato[i][0];
            a = dato[i][1];
            l = dato[i][2];
            an = dato[i][3];
            mayorDim = mayorDimension(a, l, an);
            perim = perimetro(a, l, an);
            
            pesoAprobado = peso <= 18;
            
            if(pesoAprobado){
                if(a < 1 && l < 1 && an < 1 && (perim + mayorDim <= 2)){
                    estado = "aprobado";
                    vcosto = costoDeEnvio(peso);
                }else if(a < 1 && l < 1 && an < 1 && ((mayorDim + perim) < 3)){
                    vcosto = costoDeEnvio(peso) + costoDeEnvio(peso) * (1.0/10);
                    estado = "extraordinario";
                }else{
                    vcosto = 0;
                    estado = "desaprobado";
                }
            } else {
                vcosto = 0;
                estado = "desaprobado";
            }
            
            System.out.printf("%-16s %07.2f \n", estado, vcosto);
        }
            
        
    }
    
    
    
}
