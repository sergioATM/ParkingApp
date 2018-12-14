/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingapp;


/**
 *
 * @author Sergio
 */
public class Usuario extends Parking {

    public String nombre;
    public String matricula;
    public String telefono;

    public Usuario() {

    }

    public Usuario(String nombre, String matricula, String telefono) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.telefono = telefono;

    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", matricula=" + matricula + ",telefono=" + telefono + '}';
    }

}
