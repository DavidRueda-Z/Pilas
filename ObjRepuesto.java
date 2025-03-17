public class ObjRepuesto {

    private String Marca;
    private String Referencia;
    private int Cantidad;
    private double Precio;

    public ObjRepuesto() {
        //Constructor vacio
    }

    //Constructor 
    public ObjRepuesto(String marca, String referencia, int cantidad, double precio) {
        this.Marca = marca;
        this.Referencia = referencia;
        this.Cantidad = cantidad;
        this.Precio = precio;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String referencia) {
        Referencia = referencia;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    
    


    //Getters y Setters


    
}
