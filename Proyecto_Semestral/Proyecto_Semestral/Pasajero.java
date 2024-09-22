package Proyecto_Semestral;

public class Pasajero{
    protected String NomContacto;
    protected String FonoContacto; 
    protected String Rut;
    public Pasajero(){
    }
    public Pasajero(String NomContacto, String FonoContacto, String Rut){
        this.NomContacto = NomContacto;
        this.FonoContacto = FonoContacto;
        this.Rut = Rut;
    }

    public String getNomContacto(){
        return NomContacto;
    }
    public void setNomContacto(String NomContacto){
        this.NomContacto = NomContacto;
    }
    public String getFonoContacto(){
        return FonoContacto;
    }
    public void setFonoContacto(String FonoContacto){
        this.FonoContacto = FonoContacto;
    }
    public String getRut(){
        return Rut;
    }
    public void setRut(String Rut){
        this.Rut = Rut;
    }
}
