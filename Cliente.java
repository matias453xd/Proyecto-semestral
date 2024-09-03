package Proyecto_Semestral;

public class Cliente extends Nombre {
    protected int telefono;
    protected String email;
    protected String rut;
    protected String pasaporte;
    public Cliente(int telefono, String email,int tratamiento, String nombre, String apellido_paterno, String apellido_materno, String rut){
        this.telefono = telefono;
        this.email = email;
        this.tratamiento = tratamiento;
        this.nombre = nombre;
        this.apellido_materno = apellido_materno;
        this.apellido_paterno = apellido_paterno;
        this.rut = rut;
    }
    public Cliente(){

    }
    protected void LlenarInformacion(int tratamiento, String nombre, String apellido_materno, String aplellido_paterno, int telefono, String email){
        this.tratamiento = tratamiento;
        this.nombre = nombre;
        this.apellido_materno = apellido_materno;
        this.apellido_paterno = apellido_paterno;
        this.telefono = telefono;
        this.email = email;
    }
    public String getRut(){
        return rut;
    }
    public void setRut(String rut){
        this.rut = rut;
    }
}
