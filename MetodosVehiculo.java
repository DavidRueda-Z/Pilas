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
        int opc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese \n1: Consultar \n2: Eliminar \n3: Modificar \n4:Salir"));
        while(opc != 1  && opc != 2 && opc !=3 && opc != 4)
        {
            System.out.println("Dato erroneo, digite una opcion correcta");
            opc = sc.nextInt();
        }

        pila = AccionesRegistro(pila, opc);
        MostrarPila(pila);
        
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
        String dato = JOptionPane.showInputDialog("Ingrese el dato que desea eliminar: ");

        for (ObjVehiculo item : pila) {
            if(item.getMarca().equalsIgnoreCase(dato))
            {
                pila.remove(item);
                System.out.println("Registro eliminado");
            } 
        }
        
        return pila;
    }

    public Stack<ObjVehiculo>  AccionesRegistro(Stack<ObjVehiculo> pila, int opc)
    {
        String dato = "";
        if(opc == 1)
            {
                dato = JOptionPane.showInputDialog("Ingrese el dato que desea buscar");
            }else if(opc == 2)
        {
            dato = JOptionPane.showInputDialog("Ingrese el dato que desea eliminar");
        }else if(opc == 3)
            {
                dato = JOptionPane.showInputDialog("Ingrese el dato que desea modificar");
            }
            else
            {
                System.out.println("Hasta luego");
            }
            

            for(ObjVehiculo item: pila)
            {
                if(item.getMarca().equalsIgnoreCase(dato))
                {
                    if(opc==1)
                    {
                        System.out.println("El registro se encuentra y es " +item.getMarca() + " " + item.getPrecio());
                    }
                    else if(opc==2)
                    {
                        pila.remove(item);
                    }
                    else if(opc==3) 
                    {
                        item.setMarca(JOptionPane.showInputDialog("Ingrese la marca"));
                    }
                }
            }
                return pila;
            }
}
