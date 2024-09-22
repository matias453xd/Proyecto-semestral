package Proyecto_Semestral;

import java.util.Scanner;

public class Venta{
    protected int IDdocumento;
    protected String FechaDeVenta;
    protected String nombree;
    protected Cliente[] clientes;
    protected int Monto;
    protected int TipoBoleta;
    protected int CantidadBoletos;
    protected String Rut;
    protected String Pasaporte;
    public Venta(int IDdocumento, String FechaDeVenta,String nombree) {
        this.IDdocumento = IDdocumento; 
        this.FechaDeVenta = FechaDeVenta;
        this.nombree = nombree;
        this.clientes = new Cliente[10];
    }
    public Venta(){ 
    }
    public String getnombre(){
        return nombree;
    }
    public int getIDdocumento(){
        return IDdocumento;
    }
    public void setIDdocumento(int IDdocumento){
        this.IDdocumento = IDdocumento;
    }
    public String getFechaDeVenta(){
        return FechaDeVenta;
    }
    public void setFechaDeVenta(String FechaDeVenta){
        this.FechaDeVenta = FechaDeVenta;
    }
    public void LlenarClientes(Cliente[][] pasage) {
        int cont = 0;  
    
        for (int i = 0; i < pasage.length; i++) {
            for (int j = 0; j < pasage[i].length; j++) {  
    
                if (cont >= this.clientes.length) {
                    break;
                }
    
                if (pasage[i][j] != null && this.clientes[cont] == null) {
                    this.clientes[cont] = pasage[i][j]; 
                    cont++; 
                }
            }
        }
    }
    public Cliente MostrarClientes(Scanner input){
        for(int i = 0; i < clientes.length; i++){
            if(clientes[i] == null){
                continue;
            }
            System.out.print(i+".- |");
            System.out.print(this.clientes[i].getnombre()+"|    |");
            System.out.print(this.clientes[i].getapellido_paterno()+"|    |");
            System.out.print(this.clientes[i].getapellido_materno()+"|    |");
            System.out.print(this.clientes[i].getRut()+"|    |");
            System.out.print(this.clientes[i].getPasaporte()+"|");
            System.out.println();
        }
        System.out.println("Seleccione su numero de cliente [0,10]");
        int eleccion = input.nextInt();
        if (eleccion > clientes.length || eleccion < 0){
            while(eleccion > clientes.length || eleccion < 0){
                System.out.println("Elija un cliente valido o -1 para salir:");
                eleccion = input.nextInt();
                if(eleccion == -1){
                    return null;
                }
            }
        }
        return this.clientes[eleccion];

    }
    public int getMonto(){
        return Monto;
    }
    public void setMonto(int Mont){
        this.Monto = Mont;
    }
    public int getTipoBoleta(){
        return TipoBoleta;
    }
    public void setTipoBoleta(int boletas){
        this.TipoBoleta = boletas;
    }
    public int getCantidadBoletos(){
        return CantidadBoletos;
    }
    public void setCantidadBoletos(int CantBoletos){
        this.CantidadBoletos = CantBoletos;
    }
    public void MostrarDatos(Cliente clienteseleccionado){
            if(this.TipoBoleta == 1){
                System.out.println("Datos del pasajero: ");
                System.out.println("Rut: "+clienteseleccionado.getRut());
            }
            else if(this.TipoBoleta == 2){
                System.out.println("Datos del pasajero: ");
                System.out.println("Pasaporte: "+clienteseleccionado.getPasaporte());
            }
            System.out.println("Pasaje agreagado exitosamente ");
            System.out.println("Monto total de la venta: $"+this.Monto);
    }
    //Funcion que permita sacar el rut de la lista clientes
    public String obtenerRut(){
        return Rut;
    }
    public void cambiarRut(String Rut){
        this.Rut = Rut;
    }
    public String obtenerPasaporte(){
        return Pasaporte;
    }
    public void cambiarPasaporte(String Pasaporte){
        this.Pasaporte = Pasaporte;
    }
}
