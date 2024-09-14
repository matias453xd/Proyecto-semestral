package Proyecto_Semestral;

public class Venta extends PasaporteRut {
    protected int IDdocumento;
    protected String FechaDeVenta;
    protected String nombree;
    public Venta(String rut, String pasaporte, int IDdocumento, String FechaDeVenta,String nombree) {
        super(rut, pasaporte);
        this.rut = rut;
        this.pasaporte = pasaporte;
        this.IDdocumento = IDdocumento; 
        this.FechaDeVenta = FechaDeVenta;
        this.nombree = nombree;
    }
    public Venta(){ 
    }

    public int getIDdocumento(){
        return IDdocumento;
    }
    public void setIDdocumento(int IDdocumento){
        this.IDdocumento = IDdocumento;
    }
    public String getFechaDeVenta(){
        return FechaDeVenta;
    }
    public void setFechaDeVenta(String FechaDeVenta){
        this.FechaDeVenta = FechaDeVenta;
    }
    public String getNombre(){
        return nombree;
    }
    public void setNombre(String nombree){
        this.nombree = nombree;
    }
    
}
