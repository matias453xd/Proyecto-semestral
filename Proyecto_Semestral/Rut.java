package Proyecto_Semestral;

public class Rut extends IdPersona {
    protected int numero;
    protected char dv;
    public Rut(int rut, String pasaporte){
        this.pasaporte = pasaporte;
        this.rut = rut;
    }
    @Override
    protected boolean EsIgual() {
        if(pasaporte.equals(rut)){
            return false;
        } else {
            return true;
        }
    }
    
}
