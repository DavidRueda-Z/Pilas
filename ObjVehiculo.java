

public class ObjVehiculo {
    
    private String Marca;
    private String Color;
    private double Precio;

    public ObjVehiculo() {
        //Constructor vacio
    }

    public ObjVehiculo(String marca, String color, double precio) {
        
        Marca = marca;
        Color = color;
        Precio = precio;
        
        //Al tener las variables con diferente nombre (inicial en mayuscula), no hay necesidad de por el this.marca

    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }
}
