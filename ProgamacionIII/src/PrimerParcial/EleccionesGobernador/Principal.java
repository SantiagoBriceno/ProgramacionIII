/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimerParcial.EleccionesGobernador;

import static PrimerParcial.EleccionesGobernador.Electoral.calculos;
import static PrimerParcial.EleccionesGobernador.Electoral.crearMatrizVotos;
import static PrimerParcial.EleccionesGobernador.Electoral.leoCandidatos;
import static PrimerParcial.EleccionesGobernador.Electoral.mostrarDatos;

/**
 *
 * @author Usuario
 */
public class Principal {
    
    public static void main(String[] args) {
        
        String[] candidatos = leoCandidatos();
        int[][] votos = crearMatrizVotos();
        System.out.println("Bienvenido al proceso electoral de la gobernación");
        
        System.out.println("Datos de Elecciones: ");
        mostrarDatos(candidatos, votos);
        System.out.println("");
        calculos(candidatos, votos);
        
    }
    
}
