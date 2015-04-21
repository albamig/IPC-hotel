
package Controladores;

import MaquinaDeEstados.Especificacion;
import MaquinaDeEstados.Main;
import Vistas.Especificacion.VistaFechas;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Sergio
 */
public class ControladorFechasyTipoHabitacion {
    private Especificacion miModelo;
    private VistaFechas miVistaFechas;
    private String fechaEntrada, fechaSalida;
    private  String tipoHabitacion;
    
    public ControladorFechasyTipoHabitacion(VistaFechas miVista) {
        miModelo = Main.getMaquinaDeEstadosEspecificacion();
        miVistaFechas = miVista;
    }
    public void habitacion() {
        if(compruebaFechas() && validaEntradaSalida()) {
        miModelo.seleccionarHabitacion();
        }

        
    }
    public boolean validaEntradaSalida() {
        int mesEntrada = miVistaFechas.getMesIndiceEntrada();
        int diaEntrada = miVistaFechas.getDiaEntrada();
        int mesSalida = miVistaFechas.getMesSalidaIndice();
        int diaSalida = miVistaFechas.getDiaSalida();
        int anioEntrada = miVistaFechas.getAnioEntrada();
        int anioSalida = miVistaFechas.getAnioSalida();
        
        if (anioEntrada > anioSalida) {
            miVistaFechas.errorFechaSalida();
            return false;
        }else {
            if (anioEntrada < anioSalida) {
                return true;
            } else {
                // ==
                if(mesEntrada > mesSalida){
                    miVistaFechas.errorFechaSalida();
                    return false;
                }else {
                    if (mesEntrada < mesSalida) {
                        return true;
                    } else {
                        // ==
                        if (diaEntrada > diaSalida){
                            miVistaFechas.errorFechaSalida();
                            return false;
                        }
                    }
                }
            }       
        }
        return true;
    }
    public void tipoElegido() {
        tipoHabitacion = miVistaFechas.getTipoH();
        
    }
    
    public boolean compruebaFechas() {
        Calendar diaDeHoy = new GregorianCalendar();
        int mesEntrada = miVistaFechas.getMesIndiceEntrada();
        int diaEntrada = miVistaFechas.getDiaEntrada();
        int mesSalida = miVistaFechas.getMesSalidaIndice();
        int diaSalida = miVistaFechas.getDiaSalida();
        int anioEntrada = miVistaFechas.getAnioEntrada();
        int anioSalida = miVistaFechas.getAnioSalida();
        
        if(diaDeHoy.get(Calendar.YEAR) < anioEntrada){
            return true;
        }else{
            if(diaDeHoy.get(Calendar.YEAR) > anioEntrada){
                miVistaFechas.errorFechaHoy();
                return false;
            }else {
                if(diaDeHoy.get(Calendar.MONTH) < mesEntrada){
                    return true;
                }else if(diaDeHoy.get(Calendar.MONTH) > mesEntrada){
                    miVistaFechas.errorFechaHoy();
                    return false;
                }else{
                    if(diaDeHoy.DAY_OF_WEEK < diaEntrada){
                        return true;
                    }else if(diaDeHoy.DAY_OF_WEEK > diaEntrada){
                        miVistaFechas.errorFechaHoy();
                        return false;
                    }
                }
            }
        }
        return true;
            
        

        
    }
    
    public void revisaFechasValidasEntrada() {
        String mes = miVistaFechas.getMesStringEntrada();

        if (tieneTreintaYUnDias(mes)) {
            miVistaFechas.cambiaModeloSpinnerDiasEntrada(new SpinnerNumberModel(miVistaFechas.getDiaEntrada(), 1, 31, 1));
        } else if (tieneTreintaDias(mes)) {
            if (miVistaFechas.getDiaEntrada() == 31) {
                miVistaFechas.setDiasEntrada(30);
            }
            miVistaFechas.cambiaModeloSpinnerDiasEntrada(new SpinnerNumberModel(miVistaFechas.getDiaEntrada(), 1, 30, 1));
        } else if (esFebrero(mes) && anioBisiestoEntrada()) {
            if (miVistaFechas.getDiaEntrada() > 29) {
                miVistaFechas.setDiasEntrada(29);
            }
            miVistaFechas.cambiaModeloSpinnerDiasEntrada(new SpinnerNumberModel(miVistaFechas.getDiaEntrada(), 1, 29, 1));
        } else {
            if (miVistaFechas.getDiaEntrada() > 28) {
                miVistaFechas.setDiasEntrada(28);
            }
            miVistaFechas.cambiaModeloSpinnerDiasEntrada(new SpinnerNumberModel(miVistaFechas.getDiaEntrada(), 1, 28, 1));
            
        }
        fechaEntrada = miVistaFechas.getFechaEntrada();
        
        
        
    }
     public void revisaFechasValidasSalida() {
        String mes = miVistaFechas.getMesSalidaString();

        if (tieneTreintaYUnDias(mes)) {
            miVistaFechas.cambiaModeloSpinnerDiasSalida(new SpinnerNumberModel(miVistaFechas.getDiaSalida(), 1, 31, 1));
        } else if (tieneTreintaDias(mes)) {
            if (miVistaFechas.getDiaSalida() == 31) {
                miVistaFechas.setDiasSalida(30);
            }
            miVistaFechas.cambiaModeloSpinnerDiasSalida(new SpinnerNumberModel(miVistaFechas.getDiaSalida(), 1, 30, 1));
        } else if (esFebrero(mes) && anioBisiestoSalida()) {
            if (miVistaFechas.getDiaSalida() > 29) {
                miVistaFechas.setDiasSalida(29);
            }
            miVistaFechas.cambiaModeloSpinnerDiasSalida(new SpinnerNumberModel(miVistaFechas.getDiaSalida(), 1, 29, 1));
        } else {
            if (miVistaFechas.getDiaSalida() > 28) {
                miVistaFechas.setDiasSalida(28);
            }
            miVistaFechas.cambiaModeloSpinnerDiasSalida(new SpinnerNumberModel(miVistaFechas.getDiaSalida(), 1, 28, 1));
        }
        fechaSalida = miVistaFechas.getFechaSalida();
    }
    
    public boolean tieneTreintaYUnDias(String mes) {
        return mes.equals("Enero") || mes.equals("Marzo") || mes.equals("Mayo")
                || mes.equals("Julio") || mes.equals("Agosto") || mes.equals("Octubre")
                || mes.equals("Diciembre");
    }

    public boolean tieneTreintaDias(String mes) {
        return mes.equals("Abril") || mes.equals("Junio") || mes.equals("Septiembre")
                || mes.equals("Noviembre");
    }

    public boolean esFebrero(String mes) {
        return mes.equals("Febrero");
    }

    public boolean anioBisiestoEntrada() {
        return (miVistaFechas.getAnioEntrada() % 4 == 0) && ((miVistaFechas.getAnioEntrada() % 100 != 0)
                || miVistaFechas.getAnioEntrada() % 400 == 0);
    }
    
      public boolean anioBisiestoSalida() {
        return (miVistaFechas.getAnioSalida() % 4 == 0) && ((miVistaFechas.getAnioSalida() % 100 != 0)
                || miVistaFechas.getAnioSalida() % 400 == 0);
    }
     
      public String getFechaEntrada() {
          return fechaEntrada;
      }
      public String getFechaSalida() {
          return fechaSalida;
      }
      public String getTipoHabitacion() {
          return tipoHabitacion;
      }
}
