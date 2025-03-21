import javax.swing.JOptionPane;
import java.util.Stack;

public class PilaNumeros {
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la pila:"));

        for (int i = 0; i < n; i++) {
            pila.push(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el elemento " + (i + 1) + ":")));
        }

        procesarPila(pila);
    }

    public static void procesarPila(Stack<Integer> pila) {
        Stack<Integer> pilaProcesada = new Stack<>();
        int cantidad20_80 = 0;
        int cantidadPositivos = 0;
        int suma80_200 = 0;

        while (!pila.isEmpty()) {
            int num = pila.pop();

            if (num < 0) {
                pilaProcesada.push(num * num * num);
            } else {
                pilaProcesada.push(num);
                cantidadPositivos++;
            }

            if (num >= 20 && num <= 80) {
                cantidad20_80++;
            }

            if (num > 80 && num <= 200) {
                suma80_200 += num;
            }
        }

        StringBuilder resultado = new StringBuilder("Resultados:\n");
        resultado.append("Cantidad de números entre 20 y 80: ").append(cantidad20_80).append("\n");
        resultado.append("Cantidad de números positivos: ").append(cantidadPositivos).append("\n");
        resultado.append("Suma de números entre 80 y 200: ").append(suma80_200).append("\n");

        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}