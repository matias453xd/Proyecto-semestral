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
        Venta[] venta = new Venta[10];
        String[][] asientos = new String[10][4];
        LlenarMatriz(asientos);
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
                    Viaje viaje1 = CrearViaje(input, patente, buses);
                    if(viaje1 != null){
                       AgendarViaje(viaje1,viajes);
                       System.out.println("Viaje guardado exitosamente");
                       System.out.println("A las "+viaje1.getHora()+" hrs");
                    } else {
                        System.out.println("El bus no esta disponible o no existe");
                    }
                    break;
                case 4:
                    Venta venta3 = VenderPasajes(input, viajes, buses, pasajeros, venta, patente, asientos);
                    if(venta3 != null){
                       System.out.println("Venta realizada exitosamente");
                    } else {
                        System.out.println("La venta no se ha podido realizar");
                    }
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
                    input.close();
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
    public static Viaje CrearViaje(Scanner input, String[] patente, Bus[] buses){
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
                if(buses[j].getNumeroAsientos() <= 0){
                    System.out.println("No hay asientos");
                    return null;
                }
                System.out.println("El numero de asientos disponibles son: "+buses[j].getNumeroAsientos());
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
    public static Venta VenderPasajes(Scanner input, Viaje[] viajes1, Bus[] buses1, Cliente[][] pasajeros1, Venta[] ventaa, String[] patente, String[][] asientos){
        System.out.print("Id Documento: ");
        int documento = input.nextInt();
        System.out.println("Tipo de documento: [1] Boleta [2] Factura: ");
        int eleccion = input.nextInt();
        System.out.print("Fecha de venta[dd/mm/yyyy]: ");
        String fecha = input.next();
        System.out.print("Nombre: ");
        String nombree = input.next();
        System.out.print("Pasajes a comprar: ");
        int boletos = input.nextInt();
        System.out.println("Rut[1] o Pasaporte[2]: ");
        int cont = input.nextInt();
        String pasaporte = "";
        String rut = "";
        if(cont == 1){
            System.out.println("Ingrese su rut: ");
            rut = input.next();
            pasaporte = "";
        } else if(cont == 2){
            System.out.println("Ingrese su pasaporte: ");
            pasaporte = input.next();
            rut = "";
        }
        Venta venta2 = new Venta(rut,pasaporte,documento,fecha,nombree);
        for(int i = 0; i < ventaa.length; i++){
            if(ventaa[i] != null && ventaa[i].getIDdocumento()== documento){
                System.out.println("El numero de documento ya existe");
                return null;
            }
        }
        for(int j = 0; j < ventaa.length; j++){
            if(ventaa[j] == null && buses1[j].getNumeroAsientos() > 0){
                ventaa[j] = venta2;
                buses1[j].setNumeroAsientos(buses1[j].getNumeroAsientos() - boletos);
                System.out.println("Cantidad de pasajes: "+boletos);
                System.out.println("Fecha de viaje: "+fecha);
                System.out.println("Listado de horarios disponibles");
                System.out.println("  Bus      Salida       Valor       Asientos");
                for(int t = 0; t < buses1.length; t++){
                    for(int h = 0; h < 1; h++){
                        System.out.print(t+" |");
                        if(buses1[t] == null || viajes1[t] == null){
                            continue;
                        }
                        System.out.print(buses1[t].getpatente()+"|     |");
                        System.out.print(viajes1[t].getHora()+"|       |$");
                        System.out.print(viajes1[t].getPrecio()+"|        |");
                        System.out.print(buses1[t].getNumeroAsientos()+"|    ");
                    }
                    System.out.println();
                }
                System.out.println("Elija un viaje en [1"+viajes1.length+"]");
                int elegir = input.nextInt();
                if(viajes1[elegir] == null){
                    while(viajes1[elegir] == null){
                        System.out.println("El viaje no existe, elija otro indicando el numero numero");
                        elegir = input.nextInt();
                    }
                }
                System.out.println("Asientos disponibles para el viaje seleccionado: ");



                return venta2;

            } else {
                System.out.println("No hay asientos disponibles");
                return null;
            }
        }

        








        return venta2;
    }
    public static void LlenarMatriz(String[][] Asiento){
        int numero = 1;
        for(int i = 0; i < Asiento.length; i++){
            for(int j = 0; j < 4; j++){
                Asiento[i][j] = String.valueOf(numero);
                numero++;
            }
        }
    }
}

