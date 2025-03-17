import java.util.Scanner;
import java.util.Stack;

import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.JOptionPane;

public class MetodosRepuesto {  

    Scanner sc = new Scanner(System.in);

    public void LlenarStock()
    {
        //Creo pila
        Stack<ObjRepuesto> pila = new Stack<>();
        boolean bandera = true;
        String opt = "";

        while (bandera) {
            ObjRepuesto obj = new ObjRepuesto();

            obj.setReferencia(JOptionPane.showInputDialog("Ingrese la Referencia del repuesto: "));
            obj.setMarca(JOptionPane.showInputDialog("Ingrese la Marca del repuesto: "));
            obj.setCantidad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del repuesto: ")));
            obj.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del repuesto: ")));

            pila.push(obj);

            opt = JOptionPane.showInputDialog("¿Desea ingresar mas registros? SI/NO");
            if(opt.equalsIgnoreCase("NO"))
            {
                bandera = false;
            }
        }
        MostrarStock(pila);
        
    }

    public static void MostrarStock(Stack <ObjRepuesto> pila)
        {
            for (ObjRepuesto item : pila) {
                System.out.println("Referencia: " + item.getReferencia());
                System.out.println("Marca : " + item.getMarca());
                System.out.println("Cantidad: " + item.getCantidad());
                System.out.println("Precio: " + item.getPrecio());
                System.out.println("--------------");
                
            }
        }

        public void Menu()
        {   
            String Men = "";
            int opc = Integer.parseInt(JOptionPane.showInputDialog("INVENTARIO\n" + 
                                    "1. Ingresar registros\n" +
                                    "2. Buscar Registro\n" + 
                                    "3. Modificar Registro\n" + 
                                    "4. Eliminar Registro\n" + 
                                    "5. Salir"));
        while(opc != 1 && opc != 2 && opc != 3 && opc != 4 && opc != 5)
        {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Dato Erroneo, intentelo de nuevo: "));
        }
        }

        public Stack<ObjRepuesto> Acciones(Stack<ObjRepuesto> pila, int opc)
        {
            String dato = "";

            if(opc == 1)
            {
             LlenarStock();   
            }else if(opc == 2)
            {
                dato = JOptionPane.showInputDialog("Buscar dato referncia: ");

            }else if(opc == 3)
            {
                dato = JOptionPane.showInputDialog("Que referencia desea modificar: ");
            }else if(opc == 4)
            {
                dato = JOptionPane.showInputDialog("Que referencia desea eliminar:");
            }else
            {
                JOptionPane.showInputDialog("Hasta luego");
            }


            for (ObjRepuesto item : pila) {
                if(item.getReferencia().equalsIgnoreCase(dato))
                {
                    if(opc == 2)
                    {   
                        int x = Integer.parseInt(JOptionPane.showInputDialog("¿Que campo desea modificar?"+ 
                            "1. Referencia\n" + 
                            "2. Marca\n" + 
                            "3. Cantidad \n" + 
                            "4. Precio \n"));
                        while( x!=1 && x!=2 && x!=3 && x!=4)
                        {
                            x = Integer.parseInt(JOptionPane.showInputDialog("Digite un valor correcto"));
                        }
                            
                    }
                }
                
            }
            return pila;
        }
}
