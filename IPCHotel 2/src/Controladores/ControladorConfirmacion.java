
package Controladores;

import MaquinaDeEstados.Confirmacion;
import MaquinaDeEstados.Especificacion;
import MaquinaDeEstados.Main;

/**
 *
 * @author Sergio
 */
public class ControladorConfirmacion {
    
    private Confirmacion miModelo;
    
    public ControladorConfirmacion() {
        
        miModelo = Main.getMaquinaDeEstadosConfirmacion();
        
    }
    
    public void atras() {
        miModelo.atras();
    }
    
    public void informacionFinal() {
        miModelo.confirmarFinal();
    }
    
    public void confirmar() {
        Main.terminar();
    }
    
    public void volverAElegir() {
        Main.retroceder();
    }
    
    public void compruebaEMail() {
        
    }
}
