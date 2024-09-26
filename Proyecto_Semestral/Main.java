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
        Pasaje[] pasaje = new Pasaje[10];
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
                    Venta venta3 = VenderPasajes(input, viajes, buses, pasajeros, venta, patente, pasaje);
                    if(venta3 != null){
                       System.out.println("Venta realizada exitosamente");
                       MostrarVentas(venta, pasaje, viajes);
                    } else {
                        System.out.println("La venta no se ha podido realizar");
                    }
                    break;
                case 5:
                    if(pasaje != null){
                        System.out.println("Lista de pasajeros: ");
                        MostrarPasajeros(pasaje);
                    } else {
                        System.out.println("No hay pasajeros");
                    }  
                    break;
                case 6:
                    if(venta != null){
                        System.out.println("...:::: Listado de ventas ::::...");
                        ListaVentas(venta);
                    } else {
                        System.out.println("No existe ninguna venta");
                    }
                    break;
                case 7:
                    if(viajes != null){
                        System.out.println("...:::: Listado de viajes ::::...");
                        ListaViajes(viajes);
                    } else {
                        System.out.println("No hay viajes disponibles");
                    }
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
        System.out.println("Rut[1] o Pasaporte[2]: ");
        int cont = input.nextInt();
        while(cont != 1 && cont != 2){
            System.out.println("Elija entrre 1 o 2");
            cont = input.nextInt();
        }
        String pasaporte = "";
        String rut = "";
        if(cont == 1){
            System.out.print("RUT: ");
            rut = input.next();
            pasaporte = null;
        } else if(cont == 2){
            System.out.print("Pasaporte: ");
            pasaporte = input.next();
            rut = null;
        }
        System.out.println("Perfil creado");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != null && matriz[i][j].getRut().equals(rut)) {
                    return null;
                }
            }
        }

        Cliente cliente1 = new Cliente(telefono, email, tratamiento, nombre, apellidoPaterno, apellidoMaterno, rut, pasaporte);
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

    public static void MostrarPasajeros(Pasaje[] pasajero) {
        System.out.println("Asiento    |    Rut/Pas   |   Pasajero    |    Contacto    |    Telefono contacto");
        for(int i = 0; i < pasajero.length; i++){
            if(pasajero[i] == null){
                continue;
            }
            pasajero[i].MostrarAsientos();
            System.out.print("|   ");
            System.out.print(pasajero[i].obtenerRut()+"|    |");
            System.out.print(pasajero[i].obtenerNombre()+"|    |");
            System.out.print(pasajero[i].obtenerFono()+"|");
            System.out.println();
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
        System.out.print("Asientos de ancho: ");
        int ancho = input.nextInt();
        System.out.print("Asientos de largo: ");
        int largo = input.nextInt();
        Bus bus1 = new Bus(patentes, marca, modelo, asientos, largo, ancho);
        bus1.LlenarMatriz(largo,ancho);
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
        Bus buseleccionado = null;
        for (int j = 0; j < patente.length; j++) {
            if (buses[j] != null && buses[j].getpatente().equals(patentes)) {
                buseleccionado = buses[j];
                System.out.println("Bus disponible");
                if(buses[j].getNumeroAsientos() <= 0){
                    System.out.println("No hay asientos");
                    return null;
                }
                if(buseleccionado == null){
                    System.out.println("El bus no esta disponible");
                    return null;
                }
                System.out.println("El numero de asientos disponibles son: "+buses[j].getNumeroAsientos());
                Viaje viaje3 = new Viaje(fecha, hora, precio, buseleccionado); 
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
    public static Venta VenderPasajes(Scanner input, Viaje[] viajes1, Bus[] buses1, Cliente[][] pasajeros1, Venta[] ventaa, String[] patente, Pasaje[] pasaje){
        // Datos para la venta
        System.out.print("Id Documento: ");
        int documento = input.nextInt();
        System.out.println("Tipo de documento: [1] Boleta [2] Factura: ");
        int eleccion = input.nextInt();
        if(eleccion > 2 || eleccion < 1){
            while(eleccion > 2 || eleccion < 1){
                System.out.println("Elija 1 o 2: ");
                eleccion = input.nextInt();
            }
        }
        System.out.print("Fecha de venta[dd/mm/yyyy]: ");
        String fecha = input.next();
        System.out.print("Ingrese su nombre: ");
        String nombree = input.next();
        System.out.print("Pasajes a comprar: ");
        int boletos = input.nextInt();
        Venta venta2 = new Venta(documento,fecha,nombree);

        // Guardar los clientes en un atributo tipo Cliente[] en un objeto tipo Venta
        // pasajeros1 guardaba los clientes y ahora tambien van a estar en venta2
        venta2.LlenarClientes(pasajeros1);
        System.out.println("Clientes");
        Cliente ClienteSeleccionado = null;
        ClienteSeleccionado = venta2.MostrarClientes(input);
        if(ClienteSeleccionado == null){
            System.out.println("No se pudo seleccionar un cliente");
            return null;
        }
        
        for(int i = 0; i < ventaa.length; i++){
            if(ventaa[i] != null && ventaa[i].getIDdocumento()== documento){
                System.out.println("El numero de documento ya existe");
                return null;
            }
        }
        for(int j = 0; j < ventaa.length; j++){
            if(ventaa[j] == null){//El error debe esta aca
                
                System.out.println("Cantidad de pasajes: "+boletos);
                System.out.println("Fecha de viaje: "+fecha);
                System.out.println("Listado de horarios disponibles");
                // Elegir viaje
                System.out.println("  Bus      Salida       Valor       Asientos");
                for(int t = 0; t < viajes1.length; t++){
                        System.out.print(t+" |");
                        if(viajes1[t] == null && buses1[t] == null){
                            continue;
                        }
                        System.out.print(viajes1[t].obtenerPatenteBus()+"|     |");
                        System.out.print(viajes1[t].getHora()+"|       |$");
                        System.out.print(viajes1[t].getPrecio()+"|        |");
                        System.out.println(viajes1[t].obtenerNumeroAsientos()+"|  ");
                        System.out.println();
                }
                System.out.println("Elija un viaje en [0/"+viajes1.length+"]");
                int elegir = input.nextInt();
                if(elegir == -1){
                    return null;
                }
                if(viajes1[elegir] == null){
                    while(viajes1[elegir] == null){
                        System.out.println("El viaje no existe, elija otro indicando el numero numero,...-1 para salir");
                        elegir = input.nextInt();
                        if(elegir == -1){
                            return null;
                        }
                    }
                }
                // Verificar que hay asientos disponibles
                if(viajes1[elegir].obtenerNumeroAsientos()>= boletos){
                    viajes1[elegir].cambiarNumeroAsientosBus(viajes1[elegir].obtenerNumeroAsientos() - boletos);
                } else {
                    System.out.println("No hay suficientes asientos ");
                    return null;
                }
                // Guardar cantidad boletos y eleccion
                // entre boleta o factura
                venta2.setCantidadBoletos(boletos);
                venta2.setTipoBoleta(eleccion);
                // Calcular el monto final
                venta2.setMonto(viajes1[elegir].getPrecio()*boletos);
                // Guardar rut/Pasaporte
                venta2.cambiarRut(ClienteSeleccionado.getRut());
                venta2.cambiarPasaporte(ClienteSeleccionado.getPasaporte());
                // Guardar venta
                ventaa[j] = venta2;
                // Rellenar datos de pasajeros
                System.out.print("FonoContacto: ");
                String Foncontacto = input.next();
                System.out.print("NombreContacto: ");
                String NomContacto = input.next();
                Pasajero pasajero1 = new Pasajero(NomContacto,Foncontacto,ClienteSeleccionado.getRut());
                Pasaje NuevoPasajero = new Pasaje(ClienteSeleccionado.getTelefono(),viajes1[elegir],pasajero1,venta2, boletos);

                // Elegir asientos
                System.out.println("Asientos disponibles para el viaje seleccionado: ");

                // 

                viajes1[elegir].MostrarMatrices(viajes1[elegir].obtenerFilas(),viajes1[elegir].obtenerColumnas());
                for(int d = 0; d < boletos; d++){
                    System.out.println("Elija un asiento indicando su numero: ");
                    String num = input.next();
                    int numeroEntero = Integer.parseInt(num);
                    if(numeroEntero > viajes1[elegir].obtenerTotalAsientos() || numeroEntero < 0){
                        while(numeroEntero > viajes1[elegir].obtenerTotalAsientos() || numeroEntero < 0){
                            System.out.println("Elija un asiento valido: ");
                            num = input.next();
                            numeroEntero = Integer.parseInt(num);
                            
                        }
                    }
                    
                    viajes1[elegir].CambiarMatriz(num, viajes1[elegir].obtenerFilas(), viajes1[elegir].obtenerColumnas());
                    NuevoPasajero.LlenarAsientos(num);
                    viajes1[elegir].MostrarMatrices(viajes1[elegir].obtenerFilas(),viajes1[elegir].obtenerColumnas());
                }

                // 

                // Guardar pasajeros
                for(int h = 0; h < pasaje.length; h++){
                    if(pasaje[h] == null){
                        pasaje[h] = NuevoPasajero;
                        break;
                    }
                }
                //Tengo para usar:
                //Clienteseleccionado, el cliente seleccionado
                //buses1[elegir],viajes1[elegir], el bus y el viaje seleccionado
                //venta2, la ultima venta guardada
                //ventaa[], guarda todas las ventas realizadas
                //boletos y eleccion entre boleta o factura
                //Tengo que crear el pasaje a medida que se asignan los asientos
                venta2.MostrarDatos(ClienteSeleccionado);
                return venta2;
            } else {
                System.out.println("No hay asientos disponibles");
                continue;
            }
        }



        return venta2;
    }
    public static void MostrarVentas(Venta[] ventaa, Pasaje[] pasaje, Viaje[] viaje){
        int NumAleatorio = 0;
        System.out.println(":::Imprimiendo los pasajes");
        for(int i = 0; i < ventaa.length; i++){
            if(ventaa[i] == null || pasaje[i] == null || viaje[i] == null){
                continue;
            }
            NumAleatorio = (int)(Math.random() * 900000) + 100000;
            System.out.println("-----PASAJE-----");
            System.out.println("Numero de pasaje: "+NumAleatorio);
            System.out.println("Fecha de viaje: "+viaje[i].getFecha());
            System.out.println("Hora de viaje: "+viaje[i].getHora());
            System.out.println("Patente del bus: "+viaje[i].obtenerPatenteBus());
            System.out.println("Asiento/s: ");
            pasaje[i].MostrarAsientos();
            System.out.println();
            System.out.println("Rut/Pasaporte: "+pasaje[i].obtenerRut());
            System.out.println("Nombre Pasajero: "+pasaje[i].obtenerNombre());
            System.out.println("-----------------");
            NumAleatorio = 0;
        }
    } 
    public static void ListaVentas(Venta[] ventas){
        System.out.println("| ID Documento  | Tipos Docu  | Fecha    | Rut/Pasaporte   | Cliente      | Cant Boletos | Total Venta |");
        System.out.print("| ");
        for(int i = 0 ; i < ventas.length; i++){
            if(ventas[i] == null){
                continue;
            }
            System.out.print(ventas[i].getIDdocumento()+ " |   | ");
            if(ventas[i].getTipoBoleta() == 1){
                System.out.print("Boleta | ");
            } else {
                System.out.print("Factura | ");
            }
            System.out.print(ventas[i].getFechaDeVenta()+" | ");
            if(ventas[i].obtenerRut() == null){
                System.out.print(ventas[i].obtenerPasaporte()+" | ");
            } else {
                System.out.print(ventas[i].obtenerRut()+" | ");
            }
            System.out.print(ventas[i].getnombre()+" | ");
            System.out.print(ventas[i].getCantidadBoletos()+" | ");
            System.out.print(ventas[i].getMonto()+" | ");
            System.out.println();
        }
    }
    public static void ListaViajes(Viaje[] viajes){
        System.out.println("Fecha | Hora | Precio | A.Disponibles | Patente");
        for(int i = 0; i < viajes.length; i++){
            if(viajes[i] == null){
                continue;
            }
            System.out.print(" | ");
            System.out.print(viajes[i].getFecha()+" | ");
            System.out.print(viajes[i].getHora()+" | ");
            System.out.print(viajes[i].getPrecio()+" | ");
            System.out.print(viajes[i].obtenerNumeroAsientos()+" | ");
            System.out.print(viajes[i].obtenerPatenteBus()+" |");
            System.out.println();
        }
    }
}

