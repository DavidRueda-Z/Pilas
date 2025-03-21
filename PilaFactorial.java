import javax.swing.JOptionPane;
import java.util.Stack;
import java.util.Random;

public class PilaFactorial {
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la pila:"));
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            pila.push(factorial(random.nextInt(10) + 1));
        }

        ordenarPilaDescendente(pila);

        StringBuilder pilaOrdenada = new StringBuilder("Pila ordenada descendente:\n");
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

    public static int factorial(int n) {
        int resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static void ordenarPilaDescendente(Stack<Integer> pila) {
        Stack<Integer> aux = new Stack<>();
        while (!pila.isEmpty()) {
            int temp = pila.pop();
            while (!aux.isEmpty() && aux.peek() < temp) {
                pila.push(aux.pop());
            }
            aux.push(temp);
        }
        while (!aux.isEmpty()) {
            pila.push(aux.pop());
        }
    }
}
