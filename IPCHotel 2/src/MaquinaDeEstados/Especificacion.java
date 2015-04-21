/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MaquinaDeEstados;

import Controladores.ControladorFechasyTipoHabitacion;
import Vistas.Especificacion.VistaFechas;
import Vistas.Especificacion.VistaHabitacion;
import Vistas.Especificacion.VistaRegimen;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Sergio
 */
public class Especificacion {
    
    private JFrame estadoActual;
    private ArrayList<JFrame> estadosAnteriores = new ArrayList<JFrame>();
    private ControladorFechasyTipoHabitacion controladorParaDatos;
    private int habitacionReservada;
    
    public Especificacion(int habitacionReservada) {
        this.habitacionReservada = habitacionReservada;
        java.awt.EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        VistaFechas vistaActual = new VistaFechas();
                        estadoActual = vistaActual;
                        estadoActual.setVisible(true);
                        controladorParaDatos = vistaActual.getControlador();
                        
                    }
                });
        
    }
    
    public void seleccionarHabitacion() {
        estadoActual.setVisible(false);
        estadosAnteriores.add(estadoActual);
        estadoActual.dispose();
        java.awt.EventQueue.invokeLater(
            new Runnable() {
                public void run() {
                    estadoActual = new VistaHabitacion(habitacionReservada);
                    estadoActual.setVisible(true);
                }
            });    
    }
    
    public void seleccionarRegimen() {
        estadoActual.setVisible(false);
        estadosAnteriores.add(estadoActual);
        estadoActual.dispose();
        java.awt.EventQueue.invokeLater(
            new Runnable() {
                public void run() {
                    estadoActual = new VistaRegimen();
                    estadoActual.setVisible(true);
                }
            });
        
    }
    
    private void recuperaVentana() {
        estadoActual = estadosAnteriores.get(estadosAnteriores.size()-1);
        estadoActual.setVisible(true);
        estadosAnteriores.remove(estadosAnteriores.size()-1);
            
    }
    public void confirmarReserva() {
        estadosAnteriores.add(estadoActual);
        Main.confirmarReserva();
    }
    
    public void atras() {
        estadoActual.dispose();
        recuperaVentana();
        
    }
    
    public void cierra() {
        estadoActual.dispose();
    }
    

    public ControladorFechasyTipoHabitacion getControladorDatos() {
        return controladorParaDatos;
    }
}
