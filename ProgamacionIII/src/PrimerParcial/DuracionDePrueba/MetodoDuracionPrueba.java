/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimerParcial.DuracionDePrueba;

import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;

/**
 *
 * @author Usuario
 */
public class MetodoDuracionPrueba {

    public static void main(String[] args) throws IOException {
        String[] nombre = new String[tamArch()];
        String[][] hora = new String[tamArch()][2];

        System.out.println(tamArch());
        System.out.println("");
        leerArch(nombre, hora);

        System.out.println(hora[0][0]);

    }

    public static int tamArch() throws IOException {

        Scanner leer = new Scanner(new File("D:/Alumnos/Alumnos.txt"));
        int i = 0;
        String control = "";
        while (leer.hasNext()) {
            leer.nextLine();
            i++;
        }
        return i;
    } //metodo 1

    public static void leerArch(String[] nombre, String[][] hora) throws IOException {
        Scanner archivo = new Scanner(new File("D:/Alumnos/Alumnos.txt"));
        int i = 0;
        while (archivo.hasNext()) {
            nombre[i] = archivo.next();
            for (int j = 0; j < 2; j++) {
                hora[i][j] = archivo.next();
            }
            i++;
        }
    } //metodo2

    public static int[][] horaEntero(String[][] hora) {

        int[][] horaEntera = new int[hora.length][hora[0].length * 2];
        int i, j;
        for (i = 0; i < horaEntera.length; i++) {
            for (j = 0; j < horaEntera[0].length; j = j + 2) {

                horaEntera[i][j] = horaEnteraAux(hora[i][j / 2], 1);
                horaEntera[i][j + 1] = horaEnteraAux(hora[i][j / 2], 2);
            }

        }

        return horaEntera;
    }

    private static int horaEnteraAux(String hora, int horaMin) {
        //horaMin puede ser un valor entre 1 o 2
        //1 es para hora, 2 es para min
        String acum = "";
        int hm = 0;
        int i = 0;
        boolean condicion = true;
        if (horaMin == 1) {
            while (condicion) {
                if (hora.charAt(i) != ':') {
                    acum += hora.charAt(i);
                    
                }else{
                
                condicion = false;
                }
                i++;
            }
        } else {

            while (condicion && i < hora.length()) {
                if (hora.charAt(i) == ':') {
                    acum = hora.substring(i + 1);
                    condicion = false;
                }
                i++;
            }
        }

        hm = parseInt(acum);

        return hm;
    }

    public static void duracionDeParcial(String[] tiempoTotal, int[][] horaMin) {
        int minEntrada = 0, minSalida = 0, minTotal;
        for (int i = 0; i < horaMin.length; i++) {
            for (int j = 0; j < horaMin[0].length; j = j + 2) {
                if (j == 0) {
                    minEntrada = (horaMin[i][j] * 60) + horaMin[i][j + 1];
                } else if (j == 2) {
                    minSalida = horaMin[i][j] * 60 + horaMin[i][j + 1];
                }

            }
            
            minTotal = minSalida - minEntrada;
            
            if (minSalida == 0) {
                tiempoTotal[i] = "No entro";
            } else {
                tiempoTotal[i] = duracionDeParcialAux(minTotal);
            }
        }

    } 
    
    private static String duracionDeParcialAux(int minutos) {
        String hhmm = "";
        int horas, min;

        horas = minutos / 60;
        min = minutos % 60;

        if (min < 10) {
            hhmm = "0" + horas + ":" + "0" + min ;
        } else{
            hhmm = "0" + horas + ":" + min;
        }
        return hhmm;

    }
    
    public static void tablaDeTiempos(int[][] horaMin, String[] nombre, String[] tiempoTotal){
        System.out.println("Nombres         hi mi hs ms Duracion");
        for(int i = 0; i < horaMin.length; i++){
            System.out.printf("%-16s ", nombre[i]);
            for(int j = 0; j < horaMin[0].length; j++){
                System.out.printf("%2d ", horaMin[i][j]);
            }
            System.out.println(tiempoTotal[i]);
        }
    }

   

}
