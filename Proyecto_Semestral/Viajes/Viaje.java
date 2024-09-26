package Proyecto_Semestral.Viajes;

import Proyecto_Semestral.Bus;

public class Viaje {
    protected String Fecha;
    protected String Hora;
    protected int Precio;
    protected Bus bus;
    public Viaje(){
    }
    public Viaje(String Fecha, String Hora, int Precio, Bus bus){
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.Precio = Precio;
        this.bus = bus;
    }
    public String getFecha(){
        return Fecha;
    }
    public void setFecha(String Fecha){
        this.Fecha = Fecha;
    }
    public String getHora(){
        return Hora;
    }
    public void setHora(String Hora){
        this.Hora = Hora;
    }
    public int getPrecio(){
        return Precio;
    }
    public void setPrecio(int Precio){
        this.Precio = Precio;
    }
    public String obtenerPatenteBus() {
        return bus.getpatente();
    }
    public Bus getBus(){
        return this.bus;
    }
    public int obtenerNumeroAsientos(){
        return bus.getNumeroAsientos();
    }
    public void cambiarNumeroAsientosBus(int nuevosAsientos) {
        if (bus != null) {
            bus.setNumeroAsientos(nuevosAsientos);
        } else {
            System.out.println("El bus no está asignado a este viaje.");
        }
    }
    public int obtenerTotalAsientos(){
        return bus.TotalAsientos();
    }
    public int obtenerFilas(){
        return bus.getFilas();
    }
    public int obtenerColumnas(){
        return bus.getColumnas();
    }
    public void LlenarAsientos(int filas, int columnas){ 
        if (bus != null) {
            bus.LlenarMatriz(filas, columnas);
        } else {
            System.out.println("El bus no está asignado a este viaje.");
        }
    }
    public void MostrarMatrices(int filas, int columnas){
        if (bus != null) {
            bus.mostrarMatriz(filas, columnas);
        } else {
            System.out.println("El bus no está asignado a este viaje.");
        }
    }
    public void CambiarMatriz(String asiento, int filas, int columnas){
        if (bus != null) {
            bus.setMatriz(asiento, filas, columnas);
        } else {
            System.out.println("El bus no está asignado a este viaje.");
        }
    }
}

