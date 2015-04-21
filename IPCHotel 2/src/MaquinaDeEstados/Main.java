
package MaquinaDeEstados;

//import static javafx.application.Platform.exit;

/**
 *
 * @author Sergio Delgado & Alberto Amigo
 * 
 */
public class Main {
    private static Confirmacion maquinaDeEstadosConfirmacion;
    private static  Especificacion maquinaDeEstadosEspecificacion;
    private static int habitacionReservada;
    /**
     * 
     * @param args recibe el numero de la habitacion que estara ocupada
     * y por lo tanto no aparecera en la interfaz.
     */
    public static void main(String[] args) {
        System.out.println(args[0]);
        if(Integer.parseInt(args[0]) == 0 || Integer.parseInt(args[0]) < 0) {
            habitacionReservada = -1;
    }
        else {habitacionReservada = Integer.parseInt(args[0]);}
        
        maquinaDeEstadosEspecificacion = new Especificacion(habitacionReservada);
        
    }
    
    public static  Confirmacion getMaquinaDeEstadosConfirmacion() {
        return maquinaDeEstadosConfirmacion;
    }
    
    public static  Especificacion getMaquinaDeEstadosEspecificacion() {
        return maquinaDeEstadosEspecificacion;
    }
    
    public static void confirmarReserva() {
        maquinaDeEstadosEspecificacion.cierra();
        maquinaDeEstadosConfirmacion = new Confirmacion();
    }
    
    public static void retroceder() {
        maquinaDeEstadosConfirmacion.cierra();
        maquinaDeEstadosEspecificacion.atras();
    }
    
    public static void terminar () {
        System.exit(0);
    }
    
}
