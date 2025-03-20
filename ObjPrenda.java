public class ObjPrenda {
    
    private String Marca;
    private String Referencia;
    private double Precio;
    private int Cantidad;


    public ObjPrenda() {
    }


    public ObjPrenda(String marca, String referencia, double precio, int cantidad) {
        this.Marca = marca;
        this.Referencia = referencia;
        this.Precio = precio;
        this.Cantidad = cantidad;
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


    public double getPrecio() {
        return Precio;
    }


    public void setPrecio(double precio) {
        Precio = precio;
    }


    public int getCantidad() {
        return Cantidad;
    }


    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    
    
}
