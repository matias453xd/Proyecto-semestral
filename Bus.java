package Proyecto_Semestral;

public class Bus {
    protected String patente;
    protected String marca;
    protected String modelo;
    protected int NumeroAsientos;
    public Bus() {
    }
    public Bus(String patente, String marca, String modelo, int NumeroAsientos){
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.NumeroAsientos = NumeroAsientos;
    }
    public String getpatente(){
        return patente;
    }
    public void setpatente(String patente){
        this.patente = patente;
    }
    public String getmarca(){
        return marca;
    }
    public void setmarca(String marca){
        this.marca = marca;
    }
    public String getmodelo(){
        return modelo;
    }
    public void setmodelo(String modelo){
        this.modelo = modelo;
    }
    public int getNumeroAsientos(){
        return NumeroAsientos;
    }
    public void setNumeroAsientos(int NumeroAsientos){
        this.NumeroAsientos = NumeroAsientos;
    }
}
