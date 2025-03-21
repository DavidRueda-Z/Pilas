import javax.swing.JOptionPane;
import java.util.Stack;

public class InvertirCadena {
    public static void main(String[] args) {
        String cadena = JOptionPane.showInputDialog("Ingrese una cadena de caracteres:");

        String cadenaInvertida = invertir(cadena);
        int cantidadCaracteres = cadena.length();

        JOptionPane.showMessageDialog(null,
                "Cadena invertida: " + cadenaInvertida + "\nCantidad de caracteres: " + cantidadCaracteres);
    }

    public static String invertir(String cadena) {
        Stack<Character> pila = new Stack<>();
        for (char c : cadena.toCharArray()) {
            pila.push(c);
        }

        StringBuilder invertida = new StringBuilder();
        while (!pila.isEmpty()) {
            invertida.append(pila.pop());
        }

        return invertida.toString();
    }
}