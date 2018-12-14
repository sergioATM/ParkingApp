/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingapp;

import java.util.Scanner;

/**
 *
 * @author Sergio
 */
public class ParkingApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Parking p = new Parking();

        // Mostrar el menu
        int opcion = 0;
        do {
            System.out.println("####### Parking App #######");
            System.out.println("[1] Dar de alta un usuario");
            System.out.println("[2] Dar de baja un usuario");
            System.out.println("[3] Registrar entrada de un coche");
            System.out.println("[4] Resgitrar salida y cobrar importe");
            System.out.println("[0] Salir");
            System.out.print("Opcion: ");
            try {
				opcion = teclado.nextInt();
			} catch (Exception e) {
				System.out.println("Introduzca una opcion correcta");
				e.printStackTrace();
			}

            switch (opcion) {
                case 0:
                    System.out.println("Saliendo...");
                    break;
                case 1:
                    System.out.println("### Añadir usuario ParkingApp ###");
                    teclado.nextLine();

                    System.out.print("Introduzca su nombre: ");
                    String nombre = teclado.nextLine();
                    System.out.print("Introduzca su matricula: ");
                    String matricula = teclado.nextLine();
                    System.out.print("Introduzca su telefono: ");
                    String telefono = teclado.nextLine();

                    p.anadirUsuario(nombre, matricula, telefono);

                    break;
                case 2:
                    System.out.println("### Dar de baja usuario ###");
                    System.out.print("Introduzca su matricula para dar de baja: ");
                    teclado.nextLine();
                    String eliminarByMatricula = teclado.nextLine();

                    p.eliminaUsuario(eliminarByMatricula);

                    System.out.println(p.getUsuario());

                    break;
                case 3:
                    System.out.println("Registrar entrada");
                    System.out.print("Introduzca su matricula para registrar entrada: ");
                    teclado.nextLine();
                    String registrarByMatricula = teclado.nextLine();
                    p.entrada(registrarByMatricula);

                    break;
                case 4:
                    System.out.println("Registrar salida y efectuar pago");

                    System.out.println("Introduzca su matricula para salir");
                    teclado.nextLine();
                    String salidaByMatricula = teclado.nextLine();
                    p.salida(salidaByMatricula);

                    System.out.println("Gracias por utilizar nuestro parking");
                    System.out.println("");
                    System.out.println("####################################");
                    System.out.println("");
                    break;
            }

        } while (opcion != 0);

    }

}
