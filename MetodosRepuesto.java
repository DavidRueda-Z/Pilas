import java.util.Scanner;
import java.util.Stack;

import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.JOptionPane;

public class MetodosRepuesto {

    private Stack<ObjRepuesto> pila = new Stack<>();
    Scanner sc = new Scanner(System.in);

    public void LlenarStock() {
        
        boolean bandera = true;
        while (bandera) {

            String referencia = JOptionPane.showInputDialog("Ingrese la Referencia del repuesto: ");
            String marca = JOptionPane.showInputDialog("Ingrese la Marca del repuesto: ");
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del repuesto: "));
            double precio =Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del repuesto: "));

            boolean existe= false;
            for (ObjRepuesto item : pila) {
                if(item.getReferencia().equalsIgnoreCase(referencia) && item.getMarca().equalsIgnoreCase(marca) && item.getPrecio() == precio)
                {
                    item.setCantidad(item.getCantidad() + cantidad);
                    JOptionPane.showMessageDialog(null, "Cantidad actualizada");
                    existe = true;
                    break;
                }
            }

            if(!existe)
            {
                ObjRepuesto obj = new ObjRepuesto(referencia, marca, cantidad, precio);
                pila.push(obj);
                JOptionPane.showMessageDialog(null, "Nuevo registro agregado con exito");
            }
            

            String opt = JOptionPane.showInputDialog("¿Desea ingresar mas registros? SI/NO");
            if (opt.equalsIgnoreCase("NO")) {
                bandera = false;
            }
        }
        Mostrar();

    }

    public void Mostrar() {
        if (pila.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El inventario está vacío");
            return;
        }

        for (ObjRepuesto item : pila) {
            System.out.println("Referencia: " + item.getReferencia());
            System.out.println("Marca : " + item.getMarca());
            System.out.println("Cantidad: " + item.getCantidad());
            System.out.println("Precio: " + item.getPrecio());
            System.out.println("--------------");
        }
    }

    public void Buscar() {
        String ref = JOptionPane.showInputDialog("Ingrese la referencia que desea buscar: ");
        for (ObjRepuesto item : pila) {
            if (item.getReferencia().equalsIgnoreCase(ref)) {
                JOptionPane.showMessageDialog(null, "Repuesto encontrado\n" +
                        "Marca: " + item.getMarca() + "\nCantidad: " + item.getCantidad() +
                        "\nPrecio: " + item.getPrecio());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Repuesto no encontrado");
    }

    public void Modificar() {
        String ref = JOptionPane.showInputDialog("Ingrese la referencia que desea modificar");
        for (ObjRepuesto item : pila) {
            if (item.getReferencia().equalsIgnoreCase(ref)) {
                boolean continuar = true;
                while (continuar) {
                    int opcion = Integer.parseInt(JOptionPane.showInputDialog("¿Que campo desea modificar?\n" +
                            "1. Referencia\n" +
                            "2. Marca \n" +
                            "3. Cantidad \n" +
                            "4. Precio \n" +
                            "5. Salir"));

                    switch (opcion) {
                        case 1:
                            item.setReferencia(JOptionPane.showInputDialog("Nueva referencia: "));
                            break;
                        case 2:
                            item.setMarca(JOptionPane.showInputDialog("Nueva Marca: "));
                            break;
                        case 3:
                            item.setCantidad(Integer.parseInt(JOptionPane.showInputDialog("Nueva Cantidad: ")));
                            break;
                        case 4:
                            item.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Nuevo Precio: ")));
                            break;
                        case 5:
                            continuar = false;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no valida");
                    }
                }
                JOptionPane.showMessageDialog(null, "Repuesto modificado con éxito");
            }
        }
        JOptionPane.showMessageDialog(null, "Repuesto no encontrado");
    }

    public void Eliminar() {
        String ref = JOptionPane.showInputDialog("Ingrese la referencia del repuesto a eliminar: ");
        boolean eliminado = pila.removeIf(item -> item.getReferencia().equalsIgnoreCase(ref));

        if (eliminado) {
            JOptionPane.showMessageDialog(null, "Repuesto eliminado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Repuesto no encontrado.");
        }
    }

    public void Menu() {
        int opc = 0;
        boolean valido;
        do {
            do {
                try {
                    opc = Integer.parseInt(JOptionPane.showInputDialog("INVENTARIO\n" +
                            "1. Ingresar registros\n" +
                            "2. Buscar Registro\n" +
                            "3. Modificar Registro\n" +
                            "4. Eliminar Registro\n" +
                            "5. Mostrar Inventario\n" +
                            "6. Salir"));
                    valido = (opc >= 1 && opc <= 6);
                    if (!valido) {
                        JOptionPane.showMessageDialog(null, "Opción no válida, intente de nuevo.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida, ingrese un número válido.");
                    valido = false;
                }
            } while (!valido);

            switch (opc) {
                case 1:
                    LlenarStock();
                    break;
                case 2:
                    Buscar();
                    break;
                case 3:
                    Modificar();
                    break;
                case 4:
                    Eliminar();
                    break;
                case 5:
                    Mostrar();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Hasta luego");
                    break;
            }
        } while (opc != 6);
    }
}
