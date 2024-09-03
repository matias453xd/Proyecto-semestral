package Proyecto_Semestral;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int respuesta = 0, cont = 0;
        String[] nombres = new String[400];
        Cliente[][] pasajeros = new Cliente[20][20];
        while(respuesta != 8){
            System.out.println("MENU");
            System.out.println("1)Crear cliente, 2)Crear bus, 3)Crear viaje, 4)Vender pasajes, 5)Lista de pasajeros, 6)Lista de ventas, 7)Lista de viajes, 8)Salir");
            respuesta = input.nextInt();
            Cliente cliente1 = new Cliente();
            switch (respuesta) {
                case 1:
                    cliente1 = CrearCliente(input, cliente1, nombres, cont);
                    System.out.println("Registrado nuevo cliente "+cliente1.getnombre());
                    LlenarMatriz(pasajeros, cliente1);
                    cont++;
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
    public static Cliente CrearCliente(Scanner input, Object cliente, String[] nombre, int contador){
        String Nombre = "", email = "",apellido_pateno ="",apellido_materno="";
        int telefono = 0, tratamiento = 0;
        System.out.print("Nombre: ");
        Nombre = input.next();
        System.out.print("Numero: ");
        telefono = input.nextInt();
        System.out.print("Apellido materno: ");
        apellido_materno = input.next();
        System.out.print("Apellido paterno: ");
        apellido_pateno = input.next();
        System.out.println("Tratamiento= Señor[1] o Señora[2]: ");
        tratamiento = input.nextInt();
        System.out.print("Email: ");
        email = input.next();
        System.out.println();
        System.out.println("Perfil creado");
        System.out.println();
        Cliente cliente1 = new Cliente(telefono, email, tratamiento, Nombre, apellido_pateno, apellido_materno);
        nombre[contador] = Nombre;
        return cliente1;
    }
    public static void LlenarMatriz(Object[][] matriz, Object cliente){
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                if(matriz[i][j] == null){
                    matriz[i][j] = cliente;
                    return;
                }
            }
        }
    }
    public static void MostrarPasajeros(Object[][] matriz, String[] nombre){
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                System.out.println(nombre[i]+" ");
            }
        }
    }
}
