
package MaquinaDeEstados;

import Vistas.Confirmacion.VistaDatosPersonales;
import Vistas.Confirmacion.VistaInformacionFinal;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Sergio
 */
public class Confirmacion {
    private JFrame estadoActual;
    private JFrame estadoAnterior;
    
    public Confirmacion() {
        java.awt.EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        estadoActual = new VistaDatosPersonales();
                        estadoActual.setVisible(true);
                    }
                });
    }
    
    public void confirmarFinal() {
        estadoAnterior = estadoActual;
        estadoActual.setVisible(false);
        java.awt.EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        estadoActual = new VistaInformacionFinal();
                        estadoActual.setVisible(true);
                    }
                });
    }
    
    public void cierra() {
        estadoActual.dispose();
    }
    
    public void atras() {
        estadoActual.dispose();
        estadoAnterior.setVisible(true);
        estadoActual = estadoAnterior;
    }
}
