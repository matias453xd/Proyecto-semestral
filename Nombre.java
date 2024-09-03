package Proyecto_Semestral;

public class Nombre {
    protected int tratamiento;
    protected String nombre;
    protected String apellido_paterno;
    protected String apellido_materno;
    public Nombre(){
    }

    public int getratamiento(){
        return tratamiento;
    }
    public void setratamiento(int tratamiento) {
        this.tratamiento = tratamiento;
    }
    public String getnombre(){
        return nombre;
    }
    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
    public String getapellido_paterno(){
        return apellido_paterno;
    }
    public void setapellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }
    public String getapellido_materno(){
        return apellido_materno;
    }
    public void setapellido_maeterno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }
    

}

