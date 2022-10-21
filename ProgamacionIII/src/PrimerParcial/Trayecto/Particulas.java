/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimerParcial.Trayecto;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Particulas {

    public static int tamArch() throws IOException {
        Scanner leer = new Scanner(new File("D:/Particula/Coordenada.txt"));
        int tam = 0;
        while (leer.hasNextLine()) {
            tam++;
            leer.nextLine();
        }
        return tam;
    }

    public static void leerArch(String[] particula, Double[][] coordenada) throws IOException {
        Scanner leer = new Scanner(new File("D:/Particula/Coordenada.txt"));
        int i = 0;
        while (leer.hasNextLine()) {
            particula[i] = leer.next();
            for (int j = 0; j < coordenada[0].length; j++) {
                coordenada[i][j] = leer.nextDouble();
            }
            i++;
        }
    }

    public static void coorCartesianas(Double[][] polar, Double[][] cartesiana) {
        int j = 0;
        double rad;
        for (int i = 0; i < polar.length; i++) {
            
            rad = (polar[i][j + 1] * Math.PI) / 180;
            cartesiana[i][j] = polar[i][j] * Math.cos(rad);
            cartesiana[i][j + 1] = polar[i][j] * Math.sin(rad);

        }
    }
    
    public static void mostrar(String[] part, Double[][] polar, Double[][] cartesiana){
        System.out.printf("%12s %4s", "Polares", "Cartesiana\n");
        System.out.printf("%-7s %4s %6s %5s %5s", "Particula", "r", "Ángulo", "X", "Y\n");
        int j = 0;
        for(int i = 0; i < part.length; i++){
            System.out.printf("%-7s", part[i]);
            System.out.printf("%4f", polar[i][j]);
            System.out.printf("%6f", polar[i][j + 1]);
            System.out.printf("%5f", cartesiana[i][j]);
            System.out.printf("%5f", cartesiana[i][j + 1]);
            
            System.out.println("");
        }
        
    }

}
