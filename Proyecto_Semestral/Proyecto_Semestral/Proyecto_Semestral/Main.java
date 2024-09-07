package Proyecto_Semestral;
import java.util.Scanner;

import Proyecto_Semestral.Viajes.Viaje;
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int respuesta = 0, cont = 0;
        String[] nombres = new String[24];
        Cliente[][] pasajeros = new Cliente[6][4];
        String[] patente = new String[10];
        Bus[] buses = new Bus[10];
        Viaje[] viajes = new Viaje[10];
        while(respuesta != 8){
            System.out.println("MENU");
            System.out.println("1)Crear cliente, 2)Crear bus, 3)Crear viaje, 4)Vender pasajes, 5)Lista de pasajeros, 6)Lista de ventas, 7)Lista de viajes, 8)Salir");
            respuesta = input.nextInt();
            if(respuesta > 8 || respuesta < 1){
                while(respuesta > 8 || respuesta < 1){
                    System.out.println("Numero no valido, ingresar nuevamente: ");
                    respuesta = input.nextInt();
                }
            }

            switch (respuesta) {
                case 1:
                    Cliente cliente1 = CrearCliente(input, nombres, cont, pasajeros);
                    if (cliente1 != null) {
                        System.out.println("Registrado nuevo cliente " + cliente1.getnombre());
                        LlenarMatriz(pasajeros, cliente1);
                        cont++;
                    } else {
                        System.out.println("El RUT ya existe. No se creó un nuevo cliente.");
                    }
                    break;
                case 2:
                    Bus bus2 = CrearBus(input, patente);
                    if(bus2 != null){
                        System.out.println("Registrado nuevo bus");
                        LlenarBus(buses, bus2);
                        System.out.println(bus2.getpatente());
                    } else {
                        System.out.println("No se a podido guardar");
                    }
                    break;
                case 3:
                    Viaje viaje1 = CrearViaje(input, patente);
                    if(viaje1 != null){
                       AgendarViaje(viaje1,viajes);
                       System.out.println("Viaje guardado exitosamente");
                       System.out.println("A las "+viaje1.getHora()+" hrs");
                    } else {
                        System.out.println("El bus no esta disponible o no existe");
                    }
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Lista de pasajeros: ");
                    MostrarPasajeros(pasajeros, nombres);
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println("Saliendo....");
                    break;
            }
        }
    }

    public static Cliente CrearCliente(Scanner input, String[] nombres, int contador, Cliente[][] matriz) {
        System.out.print("Nombre: ");
        String nombre = input.next();
        System.out.print("Número: ");
        int telefono = input.nextInt();
        System.out.print("RUT: ");
        String rut = input.next();
        System.out.print("Apellido materno: ");
        String apellidoMaterno = input.next();
        System.out.print("Apellido paterno: ");
        String apellidoPaterno = input.next();
        System.out.println("Tratamiento= Señor[1] o Señora[2]: ");
        int tratamiento = input.nextInt();

        while (tratamiento != 1 && tratamiento != 2) {
            System.out.println("1 o 2");
            tratamiento = input.nextInt();
        }

        System.out.print("Email: ");
        String email = input.next();
        System.out.println("Perfil creado");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != null && matriz[i][j].getRut().equals(rut)) {
                    return null;
                }
            }
        }

        Cliente cliente1 = new Cliente(telefono, email, tratamiento, nombre, apellidoPaterno, apellidoMaterno, rut);
        nombres[contador] = nombre;
        return cliente1;
    }

    public static void LlenarMatriz(Cliente[][] matriz, Cliente cliente) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == null) {
                    matriz[i][j] = cliente;
                    return;
                }
            }
        }
    }

    public static void MostrarPasajeros(Cliente[][] matriz, String[] nombres) {
        for (int j = 0; j < matriz.length; j++) {
            if (nombres[j] != null) {
                System.out.println(nombres[j] + " ");
            }
        }
    }
    
    public static Bus CrearBus(Scanner input, String[] patente){
        System.out.print("Patente: ");
        String patentes = input.next();
        System.out.print("Marca: ");
        String marca = input.next();
        System.out.print("Modelo: ");
        String modelo = input.next();
        System.out.print("Numero de asientos: ");
        int asientos = input.nextInt();
        
        Bus bus1 = new Bus(patentes, marca, modelo, asientos);
        for(int i = 0; i < patente.length; i++){
            if(patente[i] != null && patente[i].equals(patentes)){
                System.out.println("La patente ya existe");
                return null;
            } 
        }
        for(int j = 0; j < patente.length; j++){
            if(patente[j] == null){
                patente[j] = patentes;
                break;
            }
        }
        
        return bus1;
    }
    public static void LlenarBus(Bus[] buses, Bus bus){
        for (int i = 0; i < buses.length; i++) {
            if (buses[i] == null) {
                buses[i] = bus;
                return;
            }
        }
    }
    public static Viaje CrearViaje(Scanner input, String[] patente){
        System.out.print("Fecha[dd/mm/yyyy]: ");
        String fecha = input.next();
        System.out.print("Hora[hh/mm]: ");
        String hora = input.next();
        System.out.print("Precio: ");
        int precio = input.nextInt();
        System.out.println("Patentes de los buses disponibles: ");
        for(int i = 0; i < patente.length; i++){
            if(patente[i] != null){
                System.out.println(patente[i]);
            }
        }
        System.out.println("Elija una patente: ");
        String patentes = input.next();
        for (int j = 0; j < patente.length; j++) {
            if (patente[j].equals(patentes)) {
                System.out.println("Bus disponible");
                Viaje viaje3 = new Viaje(fecha, hora, precio); 
                patente[j] = null; 
                return viaje3;
            }
        }
        System.out.println("El bus no estaba disponible o no existe");
        return null;
        
    }
    public static void AgendarViaje(Viaje viaje2, Viaje[] agenda){
        for(int i = 0; i < agenda.length; i++){
            if(agenda[i] == null){
                agenda[i] = viaje2;
                return;
            }
        }
    }
}

