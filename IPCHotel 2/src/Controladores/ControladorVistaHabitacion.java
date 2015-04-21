/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import MaquinaDeEstados.Especificacion;
import MaquinaDeEstados.Main;
import Vistas.Especificacion.VistaHabitacion;

/**
 *
 * @author Sergio
 */
public class ControladorVistaHabitacion {
    
    private Especificacion miModelo;
    private VistaHabitacion miVista;
    

    
    public ControladorVistaHabitacion(VistaHabitacion miVista) {
        miModelo = Main.getMaquinaDeEstadosEspecificacion();
        miVista = miVista;
    }
    
    public void regimen() {

        miModelo.seleccionarRegimen();
    }
    
    public void retroceder() {
        miModelo.atras();
    }
    
    
}
