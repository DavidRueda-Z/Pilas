import javax.swing.JOptionPane;
import java.util.Stack;
import java.util.Random;

public class PilaFibonacci {
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la pila:"));
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            pila.push(fibonacci(random.nextInt(10) + 1));
        }

        ordenarPila(pila);

        StringBuilder pilaOrdenada = new StringBuilder("Pila ordenada:\n");
        for (int num : pila) {
            pilaOrdenada.append(num).append("\n");
        }

        JOptionPane.showMessageDialog(null, pilaOrdenada.toString());

        int buscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número que desea eliminar:"));
        pila.removeElement(buscar);

        StringBuilder pilaDespues = new StringBuilder("Pila después de eliminar el número:\n");
        for (int num : pila) {
            pilaDespues.append(num).append("\n");
        }

        JOptionPane.showMessageDialog(null, pilaDespues.toString());
    }

    public static int fibonacci(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        int a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void ordenarPila(Stack<Integer> pila) {
        Stack<Integer> aux = new Stack<>();
        while (!pila.isEmpty()) {
            int temp = pila.pop();
            while (!aux.isEmpty() && aux.peek() > temp) {
                pila.push(aux.pop());
            }
            aux.push(temp);
        }
        while (!aux.isEmpty()) {
            pila.push(aux.pop());
        }
    }
}