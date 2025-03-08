import java.util.Scanner;
import java.util.Stack;

import javax.swing.JOptionPane;

public class MetodosVehiculo {
    
    Scanner sc = new Scanner(System.in);

    public void LlenarPila()
    {
        Stack<ObjVehiculo> pila = new Stack<>();
        boolean Bandera = true;
        String opt = "";
        while (Bandera) {
            ObjVehiculo obj = new ObjVehiculo();

            obj.setMarca(JOptionPane.showInputDialog("Ingrese la marca del vehiculo: "));
            obj.setColor(JOptionPane.showInputDialog("Ingrese el color del vehiculo: "));
            obj.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio: ")));

            pila.push(obj); 
            
            opt = JOptionPane.showInputDialog("Desea ingresar mas registros? (SI/NO)");
            if(opt.equalsIgnoreCase("NO"))
            {
                Bandera = false;
            }
        }
        MostrarPila(pila);
        pila = Eliminar(pila);
        
    }

    public static void MostrarPila(Stack<ObjVehiculo> pila)
    {   
        //for each
        for (ObjVehiculo item : pila) {
            System.out.println("Marca: " + item.getMarca());
            System.out.println("Color: " + item.getColor());
            System.out.println("Precio: " + item.getPrecio());  
            System.out.println("");     
        }
    }

    public Stack<ObjVehiculo> Eliminar(Stack<ObjVehiculo> pila)
    {   

        boolean eliminado = false;
        String dato = "";
        dato = JOptionPane.showInputDialog("Ingrese el dato que desea eliminar: ");

        for (ObjVehiculo item : pila) {
            if(item.getMarca().equalsIgnoreCase(dato))
            {
                pila.pop();
                eliminado = true;
            }
            
        }
        if(eliminado)
        {
            dato = "Registro elimnado con exito";
        }
        else
        {
            dato = "Registro no encontrado";
        }
        return pila;
    }
}
