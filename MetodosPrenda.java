import java.util.Scanner;
import java.util.Stack;
import javax.swing.JOptionPane;

public class MetodosPrenda {

    // Para no estar enviando atributos de pila a cada metodo, la creo de forma
    // global
    private Stack<ObjPrenda> pila = new Stack<>();
    Scanner sc = new Scanner(System.in);

    public void LlenarPrenda() {
        boolean bandera = true;
        while (bandera) {
            String marca = JOptionPane.showInputDialog("Ingrese la marca de la prenda: ");
            String referencia = JOptionPane.showInputDialog("Ingrese  la referencia: ");
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio: "));
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad: "));

            boolean existe = false;
            for (ObjPrenda item : pila) {
                if (item.getReferencia().equalsIgnoreCase(referencia) && item.getMarca().equalsIgnoreCase(marca)
                        && item.getPrecio() == precio) {
                    item.setCantidad(item.getCantidad() + cantidad);
                    JOptionPane.showMessageDialog(null, "Cantidad actualizada");
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                ObjPrenda obj = new ObjPrenda(marca, referencia, precio, cantidad);
                pila.push(obj);
                JOptionPane.showMessageDialog(null, "Prenda registrada con exito");
            }

            String opt = JOptionPane.showInputDialog(null, "¿Desea registrar más prendas?(SI/NO)");
            if (opt.equalsIgnoreCase("NO")) {
                bandera = false;
            }
        }
    }

    public void Mostrar() {

        if (pila.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ningún registro");
            return;
        }

        for (ObjPrenda item : pila) {
            JOptionPane.showMessageDialog(null,
                    "Marca: " + item.getMarca() +
                            "\nReferencia: " + item.getReferencia() +
                            "\nPrecio: " + item.getPrecio() +
                            "\nCantidad: " + item.getCantidad() +
                            "\n----------------");
        }
    }

    public void Buscar() {
        String ref = JOptionPane.showInputDialog("Ingrese la referencia que desea buscar: ");
        for (ObjPrenda item : pila) {
            if (item.getReferencia().equalsIgnoreCase(ref)) {
                JOptionPane.showMessageDialog(null, "Prenda encontrada\n" +
                        "Marca: " + item.getMarca() + "\nPrecio: " + item.getPrecio() +
                        "\nCantidad" + item.getCantidad());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Prenda no encontrada");
    }

    public void Modificar() {
        String ref = JOptionPane.showInputDialog("Ingrese la referencia que desea modificar: ");
        boolean encontrado = false;

        for (ObjPrenda item : pila) {
            if (item.getReferencia().equalsIgnoreCase(ref)) {
                encontrado = true;
                boolean continuar = true;

                while (continuar) {
                    String opcionStr = JOptionPane.showInputDialog(
                            "¿Qué campo desea modificar?\n" +
                                    "1. Marca\n" +
                                    "2. Referencia\n" +
                                    "3. Precio\n" +
                                    "4. Cantidad\n" +
                                    "5. Salir");

                    // Validar que la entrada sea un número
                    if (opcionStr == null || !opcionStr.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "Entrada inválida. Ingrese un número.");
                        continue;
                    }

                    int opcion = Integer.parseInt(opcionStr);

                    switch (opcion) {
                        case 1:
                            item.setMarca(JOptionPane.showInputDialog("Nueva marca: "));
                            break;
                        case 2:
                            item.setReferencia(JOptionPane.showInputDialog("Nueva referencia: "));
                            break;
                        case 3:
                            String precioStr = JOptionPane.showInputDialog("Nuevo precio: ");
                            if (precioStr.matches("\\d+(\\.\\d+)?")) {
                                item.setPrecio(Double.parseDouble(precioStr));
                            } else {
                                JOptionPane.showMessageDialog(null, "Entrada inválida. Ingrese un número válido.");
                            }
                            break;
                        case 4:
                            String cantidadStr = JOptionPane.showInputDialog("Nueva cantidad: ");
                            if (cantidadStr.matches("\\d+")) {
                                item.setCantidad(Integer.parseInt(cantidadStr));
                            } else {
                                JOptionPane.showMessageDialog(null, "Entrada inválida. Ingrese un número válido.");
                            }
                            break;
                        case 5:
                            continuar = false;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida");
                    }
                }
                JOptionPane.showMessageDialog(null, "Prenda modificada con éxito");
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Prenda no encontrada");
        }
    }

    public void Vender() {
        String ref = JOptionPane.showInputDialog("Ingrese la referencia de la prenda a vender:");
        boolean exis = false;

        for (ObjPrenda item : pila) {
            if (item.getReferencia().equalsIgnoreCase(ref)) {
                int cant = Integer
                        .parseInt(JOptionPane.showInputDialog("¿Cuántas prendas de esta referencia va a vender?"));
                if (cant > 0 && cant <= item.getCantidad()) {
                    item.setCantidad(item.getCantidad() - cant);
                    JOptionPane.showMessageDialog(null, "Venta realizada con éxito");
                } else {
                    JOptionPane.showMessageDialog(null, "Cantidad inválida o insuficiente en inventario");
                }
                exis = true;
                break;
            }
        }

        if (!exis) {
            JOptionPane.showMessageDialog(null, "Prenda no encontrada");
        }
    }

    public void Menu() {
        int opc;

        while (true) {
            try {
                opc = Integer.parseInt(JOptionPane.showInputDialog(
                        "Inventario\n" +
                                "1. Ingresar Prenda\n" +
                                "2. Buscar Prenda\n" +
                                "3. Modificar Prenda\n" +
                                "4. Vender Prenda\n" +
                                "5. Mostrar Inventario\n" +
                                "6. Salir"));

                if (opc < 1 || opc > 6) {
                    JOptionPane.showMessageDialog(null, "Opción no válida, intente de nuevo");
                    continue;
                }

                switch (opc) {
                    case 1:
                        LlenarPrenda();
                        break;
                    case 2:
                        Buscar();
                        break;
                    case 3:
                        Modificar();
                        break;
                    case 4:
                        Vender();
                        break;
                    case 5:
                        Mostrar();
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Hasta luego");
                        return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida, ingrese un número válido");
            }
        }
    }
}
