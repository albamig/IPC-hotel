/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import MaquinaDeEstados.Confirmacion;
import MaquinaDeEstados.Main;
import Vistas.Confirmacion.VistaDatosPersonales;

/**
 *
 * @author Sergio
 */
public class ControladorVistaDatosPersonales {
    
    private VistaDatosPersonales miVista;
    private Confirmacion miModelo;
    public ControladorVistaDatosPersonales(VistaDatosPersonales vista) {
        miVista = vista;
        miModelo = Main.getMaquinaDeEstadosConfirmacion();
        
    }
    
        
    public void atras() {
        miModelo.atras();
    }
    
    public void informacionFinal() {
        if(compruebaCampos()) {
            miVista.errorCampos();
        }else{if(!compruebaEMail()){
             miVista.errorEmail();
            }else{
                miModelo.confirmarFinal();
            }
        }
        
    }
    
    public boolean compruebaCampos() {
        if(miVista.compruebaCampos()) {
            return true;
        }
        return false;
    }
    
    public void volverAElegir() {
        Main.retroceder();
    }
    
    public boolean compruebaEMail() {
        String email, emailConfirmacion;
        email = miVista.getEmail();
        emailConfirmacion = miVista.getEmailConfirmacion();
        if(!email.equals(emailConfirmacion)){
            return false;
            
        }
        return true;
        
    }
}
