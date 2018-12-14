/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingapp;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Sergio
 */
public class Parking {

    private int cont;//Variable contador
    //Declaro listas 
    private Map<String, Usuario> usuario;
    private Map<String, Registro> registro;

    //Se crea objeto tipo Registro
    Registro r = new Registro();

    //constructor 
    public Parking() {
        this.usuario = new HashMap<>();
        this.registro = new HashMap<>();
    }

    //Metodo añadirUsuario
    public void anadirUsuario(String nombre, String matricula, String telefono) {
        Usuario u = new Usuario(nombre, matricula, telefono);
        usuario.put(u.getMatricula(), u);
        if (u != null) {
            System.out.println("Bienvenido " + u.getNombre() + ". Usuario dado de alta.");
            System.out.println(usuario);
        } else {
            System.out.println("Login incorrecto. Vuelva a intenarlo.");
        }
    }

    //Metodo para eliminar usuario por matricula
    public void eliminaUsuario(String eliminarByMatricula) {
        if (usuario.containsKey(eliminarByMatricula)) {
            usuario.remove(eliminarByMatricula);
            System.out.println("Usuario eliminado con exito");
        } else {
            System.out.println("No hay usuarios con esa matricula");
        }
    }

    //Metodo para registrar entrada de vehiculo
    public void entrada(String registrarByMatricula) {

        if (cont < 101) {
            if (usuario.containsKey(registrarByMatricula)) {
                //usuario.remove(registrarByMatricula);//elimina entrada de la lista por matricula
                System.out.println("Usuario entrando en garaje");

                r.setFechaEntrada(LocalDateTime.now());
                registro.put(registrarByMatricula, r);
                cont++;

                System.out.println(usuario);
                System.out.println(registro);
                System.out.println("Plazas ocupadas " + cont);
            } else {
                System.out.println("Usuario no registrado en el sistema."
                        + " Por favor registrese");
            }

        } else {
            System.out.println("Capacidad maxima del parking alcanzada. "
                    + "No pueden entrar mas coches");

        }
    }
    //Metodo para registrar salida de vehiculo y imprimir importe a pagar
    public void salida(String salidaByMatricula) {

        if (registro.containsKey(salidaByMatricula)) {
            System.out.print("Usuario con matricula " + salidaByMatricula + " saliendo del parking");
            r.getFechaEntrada();
            r.setFechaSalida(LocalDateTime.now());
            registro.put(salidaByMatricula, r);
            System.out.println("");
        } else {
            System.out.println("Usuario no reconocido. Intentelo de nuevo");
        }
        //Calcula diferencia de dias entre dos fechas
        Period periodo = Period.between(r.getFechaEntrada().toLocalDate(), r.getFechaSalida().toLocalDate());
        int diferenciaDias = periodo.getDays();
        //Calcula diferencia de segundos entre dos fechas
        Duration duracion = Duration.between(r.getFechaEntrada(), r.getFechaSalida());
        long diferenciaSegundos = duracion.getSeconds();

        if (diferenciaSegundos < 86400) {
            if (diferenciaSegundos == 0 || diferenciaSegundos <= 1200) {//Entre 0 y 20 minutos
                System.out.println("Importe a pagar: 1€");
            } else if (diferenciaSegundos == 1201 || diferenciaSegundos <= 3600) {//Entre 21 minutos y 1 hora
                System.out.println("Importe a pagar: 1,5€");
            } else if (diferenciaSegundos == 3601 || diferenciaSegundos <= 86399) {//Entre 1 hora y 24 horas
                System.out.println("Importe a pagar: 1  " + (diferenciaSegundos * 1.5) + " € por hora ");
            }

        } else {
            if (diferenciaDias >= 1) {//un dia o mas
                System.out.println("Importe a pagar: " + (diferenciaDias * 15) + " € por dia");
            }
        }
        registro.remove(salidaByMatricula);//elimina entrada de la lista por matricula
        cont--;
    }

    //contador
    public Parking(int cont) {
        if (cont < 0) {
            this.cont = 0;
        } else {
            this.cont = cont;
        }
    }

    //getter
    public int getCont() {
        return cont;
    }

    //setter
    public void setCont(int cont) {
        if (cont < 0) {
            this.cont = 0;
        } else {
            this.cont = cont;
        }
    }

    public Map<String, Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(Map<String, Usuario> usuario) {
        this.usuario = usuario;
    }

    public Map<String, Registro> getRegistro() {
        return registro;
    }

    public void setRegistro(Map<String, Registro> registro) {
        this.registro = registro;
    }

    //método incrementar contador 
    public void incrementar() {
        cont++;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.cont;
        hash = 59 * hash + Objects.hashCode(this.usuario);
        hash = 59 * hash + Objects.hashCode(this.registro);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Parking other = (Parking) obj;
        if (this.cont != other.cont) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.registro, other.registro)) {
            return false;
        }
        return true;
    }

}
