package Proyecto_Semestral.Viajes;

public class Viaje {
    protected String Fecha;
    protected String Hora;
    protected int Precio;
    public Viaje(){
    }
    public Viaje(String Fecha, String Hora, int Precio){
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.Precio = Precio;
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
}

