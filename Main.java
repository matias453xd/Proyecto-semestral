package Proyecto_Semestral;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int respuesta = 0, cont = 0;
        String[] nombres = new String[24];
        Cliente[][] pasajeros = new Cliente[6][4];

        while(respuesta != 8){
            System.out.println("MENU");
            System.out.println("1)Crear cliente, 2)Crear bus, 3)Crear viaje, 4)Vender pasajes, 5)Lista de pasajeros, 6)Lista de ventas, 7)Lista de viajes, 8)Salir");
            respuesta = input.nextInt();

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
                    break;
                case 3:
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

        // Verificar si el RUT ya existe en la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != null && matriz[i][j].getRut().equals(rut)) {
                    return null;  // RUT duplicado, no se crea el cliente
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
}

