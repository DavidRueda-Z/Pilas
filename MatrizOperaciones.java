import javax.swing.JOptionPane;
import java.util.Stack;

public class MatrizOperaciones {

    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la matriz (n x n):"));
        int[][] matriz = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = Integer.parseInt(
                        JOptionPane.showInputDialog("Ingrese el elemento en la posición (" + i + ", " + j + "):"));
            }
        }

        String menu = "Seleccione una opción:\n" +
                "1: Suma de las filas usando Pila\n" +
                "2: Factorial de la dimensión de la matriz\n" +
                "3: Suma de las columnas usando Pila\n" +
                "4: Números ordenados de mayor a menor usando Pila";
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

        switch (opcion) {
            case 1:
                JOptionPane.showMessageDialog(null, "Suma de las filas:\n" + sumaFilasPila(matriz, n));
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Factorial de " + n + " es: " + factorial(n));
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Suma de las columnas:\n" + sumaColumnasPila(matriz, n));
                break;
            case 4:
                JOptionPane.showMessageDialog(null,
                        "Números ordenados de mayor a menor:\n" + ordenarNumerosPila(matriz, n));
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida.");
        }
    }

    public static String sumaFilasPila(int[][] matriz, int n) {
        Stack<Integer> pila = new Stack<>();
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int suma = 0;
            for (int j = 0; j < n; j++) {
                suma += matriz[i][j];
            }
            pila.push(suma);
        }
        while (!pila.isEmpty()) {
            resultado.append(pila.pop()).append("\n");
        }
        return resultado.toString();
    }

    public static int factorial(int n) {
        int resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static String sumaColumnasPila(int[][] matriz, int n) {
        Stack<Integer> pila = new Stack<>();
        StringBuilder resultado = new StringBuilder();
        for (int j = 0; j < n; j++) {
            int suma = 0;
            for (int i = 0; i < n; i++) {
                suma += matriz[i][j];
            }
            pila.push(suma);
        }
        while (!pila.isEmpty()) {
            resultado.append(pila.pop()).append("\n");
        }
        return resultado.toString();
    }

    public static String ordenarNumerosPila(int[][] matriz, int n) {
        Stack<Integer> pila = new Stack<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pila.push(matriz[i][j]);
            }
        }
        Stack<Integer> ordenada = new Stack<>();
        while (!pila.isEmpty()) {
            int temp = pila.pop();
            while (!ordenada.isEmpty() && ordenada.peek() < temp) {
                pila.push(ordenada.pop());
            }
            ordenada.push(temp);
        }
        StringBuilder resultado = new StringBuilder();
        while (!ordenada.isEmpty()) {
            resultado.append(ordenada.pop()).append(" ");
        }
        return resultado.toString();
    }
}
