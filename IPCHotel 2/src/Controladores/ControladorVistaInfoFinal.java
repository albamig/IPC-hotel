/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import MaquinaDeEstados.Confirmacion;
import MaquinaDeEstados.Main;
import Vistas.Confirmacion.VistaInformacionFinal;

/**
 *
 * @author Sergio
 */
public class ControladorVistaInfoFinal {
    
    private Confirmacion miModelo;
    private VistaInformacionFinal miVista;
    public ControladorVistaInfoFinal(VistaInformacionFinal vista) {
        miModelo = Main.getMaquinaDeEstadosConfirmacion();
        miVista = vista;
        
    }
    
            
    public void atras() {
        miModelo.atras();
    }
    
        public void confirmar() {
        Main.terminar();
    }
}
