/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimerParcial.DuracionDePrueba;

import static PrimerParcial.DuracionDePrueba.MetodoDuracionPrueba.*;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class Principal {
    public static void main(String[] args) throws IOException {
        String[] nombre, duracion;
        String[][] horas = new String[tamArch()][2];
        int[][] horaEntero;
        
        nombre = new String[tamArch()];
        duracion = new String[tamArch()];
        
        
        leerArch(nombre, horas);
        horaEntero = horaEntero(horas);
                
        duracionDeParcial(duracion, horaEntero);
        
        prueba(horaEntero);
        
        tablaDeTiempos(horaEntero, nombre, duracion);
        
    }
    
    public static void prueba(int[][] hora){
        for(int i = 0; i < hora.length; i++){
            for(int j = 0; j < hora[0].length; j++){
                System.out.print(hora[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
