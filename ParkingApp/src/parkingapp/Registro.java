/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingapp;

import java.time.LocalDateTime;

/**
 *
 * @author Sergio
 */
public class Registro {

    public LocalDateTime fechaEntrada;
    public LocalDateTime fechaSalida;

    public Registro() {
    }

    public Registro(LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDateTime fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public String toString() {
        return "Registro{" + "fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + '}';
    }

}
