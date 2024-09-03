package Proyecto_Semestral;

public class Pasaporte extends IdPersona {
    protected String numero;
    protected String nacionalidad;

    public Pasaporte(int rut, String pasaporte){
        this.pasaporte = pasaporte;
        this.rut = rut;
    }
    @SuppressWarnings("unlikely-arg-type")
    @Override
    protected boolean EsIgual() {
        if(pasaporte.equals(rut)){
            return false;
        } else {
            return true;
        }
    }
    
}
