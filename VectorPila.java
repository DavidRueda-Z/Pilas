import javax.swing.JOptionPane;
import java.util.Stack;

public class VectorPila {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del vector:"));
        int[] vector = new int[n];

        for (int i = 0; i < n; i++) {
            vector[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el elemento " + (i + 1) + ":"));
        }

        Stack<Integer> pilaFactorial = calcularFactoriales(vector);

        StringBuilder resultado = new StringBuilder("Factoriales de los números en la pila:\n");
        while (!pilaFactorial.isEmpty()) {
            resultado.append(pilaFactorial.pop()).append("\n");
        }

        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    public static Stack<Integer> calcularFactoriales(int[] vector) {
        Stack<Integer> pila = new Stack<>();
        for (int num : vector) {
            pila.push(factorial(num));
        }
        return pila;
    }

    public static int factorial(int num) {
        int resultado = 1;
        for (int i = 2; i <= num; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
