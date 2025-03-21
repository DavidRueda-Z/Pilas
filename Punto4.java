import javax.swing.JOptionPane;
import java.util.Stack;

public class Punto4 {
    public static void main(String[] args) {
        Stack<Character> pila = new Stack<>();
        llenarPila(pila);
        buscarEnPila(pila);
    }

    public static void llenarPila(Stack<Character> pila) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de elementos en la pila:"));
        for (int i = 0; i < n; i++) {
            char elemento = JOptionPane.showInputDialog("Ingrese un carácter para la pila:").charAt(0);
            pila.push(elemento);
        }
    }

    public static void buscarEnPila(Stack<Character> pila) {
        char buscar = JOptionPane.showInputDialog("Ingrese el carácter a buscar en la pila:").charAt(0);

        while (true) {
            Stack<Character> auxiliar = new Stack<>();
            boolean encontrado = false;
            int posicion = 0;
            int contador = 1;

            while (!pila.isEmpty()) {
                char elemento = pila.pop();
                auxiliar.push(elemento);
                if (elemento == buscar) {
                    encontrado = true;
                    posicion = contador;
                    break;
                }
                contador++;
            }

            while (!auxiliar.isEmpty()) {
                pila.push(auxiliar.pop());
            }

            if (encontrado) {
                JOptionPane.showMessageDialog(null,
                        "El carácter '" + buscar + "' fue encontrado en la posición " + posicion);
                break;
            } else if (pila.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La pila está vacía. Se debe llenar nuevamente.");
                llenarPila(pila);
            } else {
                JOptionPane.showMessageDialog(null, "El carácter no fue encontrado. Intente de nuevo.");
            }
        }
    }
}
