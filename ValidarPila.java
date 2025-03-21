import javax.swing.JOptionPane;
import java.util.Stack;

public class ValidarPila {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de elementos en la pila:"));
        Stack<Integer> pila = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el elemento " + (i + 1) + ":"));
            pila.push(num);
        }

        Stack<Double> pilaProcesada = procesarPila(pila);

        StringBuilder resultado = new StringBuilder("Elementos procesados con su raíz cuadrada:\n");
        while (!pilaProcesada.isEmpty()) {
            resultado.append(pilaProcesada.pop()).append("\n");
        }

        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    public static Stack<Double> procesarPila(Stack<Integer> pila) {
        Stack<Double> nuevaPila = new Stack<>();
        Stack<Integer> auxiliar = new Stack<>();

        while (!pila.isEmpty()) {
            int num = pila.pop();
            if (num < 0) {
                num = 0;
            } else if (num >= 8 && num <= 20) {
                num = 50;
            } else if (num > 60 && num < 62) {
                num = 100;
            }
            auxiliar.push(num);
        }

        while (!auxiliar.isEmpty()) {
            nuevaPila.push(Math.sqrt(auxiliar.pop()));
        }

        return nuevaPila;
    }
}
