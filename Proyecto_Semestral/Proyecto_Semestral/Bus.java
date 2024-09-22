package Proyecto_Semestral;

public class Bus {
    protected String patente;
    protected String marca;
    protected String modelo;
    protected int NumeroAsientos;
    protected String Salida;
    protected int Valor;
    protected String[][] asientos;
    protected int filas;
    protected int columnas;
    public Bus() {
    }
    public Bus(String patente, String marca, String modelo, int NumeroAsientos, int filas, int columnas){
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.NumeroAsientos = NumeroAsientos;
        this.filas = filas;
        this.columnas = columnas;
        this.asientos = new String[filas][columnas];
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
    public int getFilas(){
        return filas;
    }
    public int getColumnas(){
        return columnas;
    }
    public void LlenarMatriz(int filas, int columnas){
        int numero = 1;
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                this.asientos[i][j] = String.valueOf(numero);
                numero++;
            }
        }
    }
    public void mostrarMatriz(int filas, int columnas) {
        for (int i = 0; i < filas; i++) {
            System.out.print("|");
            for (int j = 0; j < columnas; j++) {
                System.out.print(this.asientos[i][j] + "|");
                if(j % 2 != 0){
                    System.out.print(" |");
                }
            }
            System.out.println();
        }
    }
    public void setMatriz(String asiento, int filas, int columnas){
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                if(this.asientos[i][j].equals(asiento)){
                    this.asientos[i][j] = "*";
                }
            }
        }
        System.out.println("El asiento esta ocupado");
    }
}
