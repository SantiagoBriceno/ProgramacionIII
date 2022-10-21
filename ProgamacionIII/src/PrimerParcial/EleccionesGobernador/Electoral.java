package PrimerParcial.EleccionesGobernador;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */

public class Electoral {
    
    
    
    public static String[] leoCandidatos(){
        Scanner teclado = new Scanner(System.in);
        String[] candidatos;
        candidatos = new String[5];
        System.out.println("Ingrese el nombre de los 5 candidatos \n");
        
        for(int i = 0; i < 5; i++){
            System.out.println((i + 1) + "° Candidato :");
            candidatos[i] = teclado.nextLine();
        }
            
    return candidatos;
}
    
    public static int[][] crearMatrizVotos(){
        ThreadLocalRandom enteroRandom = ThreadLocalRandom.current();
        int[][] votos = new int[5][4];
        
        for(int i = 0; i < 5 ; i++){
            for(int j = 0; j < 4; j++){
                votos[i][j] = enteroRandom.nextInt(100, 300 + 1);
            }
        }
        
        return votos;
    }
      
    public static void mostrarDatos(String[] candidatos, int[][] votos){
        System.out.println("             A   B   C   D  ");
        
        for(int i = 0; i < 5; i++){
            System.out.printf("%-10s ", candidatos[i]);
            for(int j = 0; j < 4; j++){
                System.out.print(" " + votos[i][j] + "");
            }
            System.out.println("");
            
        }
    }
    
    public static void calculos(String[] candidatos, int[][] votos){
        
        System.out.println("             vot   porc");
        int totalVotosDeCandidato = 0, cantGanador = 0, totalVotos = calculosAuxTotalVotos(votos);
        String candGanador = "";
        double promedioDeCandidato;
        
        for(int i = 0; i < 5; i++){
            System.out.printf("%-10s ", candidatos[i]);
            
            for(int j = 0; j < 4; j++){
                totalVotosDeCandidato += votos[i][j];
                if(j == 3 && (totalVotosDeCandidato > cantGanador)){
                    cantGanador = totalVotosDeCandidato;
                    candGanador = candidatos[i];
                }
            }
            
            System.out.printf("%5s ", totalVotosDeCandidato);
                       
            promedioDeCandidato = ((double) totalVotosDeCandidato / totalVotos ) * 100; 
            
            System.out.printf("%6.2f" , promedioDeCandidato);
            System.out.println("");
            
                        
            totalVotosDeCandidato = 0;
        }
        
        System.out.println("El ganador fue: " + candGanador + " ");
        
    }
    
    public static int calculosAuxTotalVotos(int[][] votos){
        
        int totalVotos = 0;
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 4; j++){
                totalVotos += votos[i][j];
            }
        }
        return totalVotos;
    
    }
    
}



