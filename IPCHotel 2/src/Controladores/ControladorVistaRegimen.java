/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import MaquinaDeEstados.Especificacion;
import MaquinaDeEstados.Main;
import Vistas.Especificacion.VistaRegimen;

/**
 *
 * @author Sergio
 */
public class ControladorVistaRegimen {
    private Especificacion miModelo;
    private VistaRegimen miVista;
    private static String regimen;

    
    public ControladorVistaRegimen(VistaRegimen miVista) {
        miModelo = Main.getMaquinaDeEstadosEspecificacion();
    }
    
    public void pasaConfirmacion() {
                
        miModelo.confirmarReserva();
    }
    
     public void retroceder() {
        miModelo.atras();
    }

}
