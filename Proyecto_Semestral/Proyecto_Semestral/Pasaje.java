package Proyecto_Semestral;

import Proyecto_Semestral.Viajes.Viaje;

public class Pasaje {
    protected long Numero;
    protected String[] Asiento;
    protected Viaje viaje;
    protected Pasajero pasajero;
    protected Venta venta;
    public Pasaje(){
    }
    public Pasaje(long Numero, Viaje viaje, Pasajero pasajero, Venta venta, int boletos){
        this.Numero = Numero;
        this.viaje = viaje;
        this.pasajero = pasajero;
        this.venta = venta;
        this.Asiento = new String[boletos];
    }

    public long getNumero(){
        return Numero;
    }
    public String[] getAsiento(){
        return Asiento;
    }
    public void LlenarAsientos(String num){
        for (int i = 0; i < Asiento.length; i++) {
            if (Asiento[i] == null) {
                Asiento[i] = num;      
                break;                 
            }
        }
    }
    public void MostrarAsientos(){
        System.out.print("[ ");
        for(int i = 0; i < Asiento.length; i++){
            if(Asiento[i] == null){
                continue;
            } else {
                System.out.print(Asiento[i]+", ");
            }
        }
        System.out.print("]");
    }
    public Viaje getViaje(){
        return viaje;
    }
    public Pasajero getPasajero(){
        return pasajero;
    }
    public String obtenerNombre(){
        return pasajero.NomContacto;
    }
    public String obtenerFono(){
        return pasajero.FonoContacto;
    }
    public Venta getVenta(){
        return venta;
    }
    public String obtenerRut(){
        return pasajero.getRut();
    }
}
