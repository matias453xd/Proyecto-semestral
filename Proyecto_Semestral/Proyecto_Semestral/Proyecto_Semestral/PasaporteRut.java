package Proyecto_Semestral;

public class PasaporteRut extends IdPersona {
    protected String rut;
    protected String pasaporte;

    public PasaporteRut(String rut, String pasaporte){
        this.rut = rut;
        this.pasaporte = pasaporte;
    }
    public PasaporteRut(){
    }

    public String getRut(){
        return rut;
    }
    public void setRut(String rut){
        this.rut = rut;
    }
    public String getPasaporte(){
        return pasaporte;
    }
    public void setPasaporte(String pasaporte){
        this.pasaporte = pasaporte;
    }

}
