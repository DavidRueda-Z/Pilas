import javax.swing.JOptionPane;
import java.util.Stack;

public class MatrizPila {
    public static void main(String[] args) {
        int filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas:"));
        int columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas:"));
        int[][] matriz = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = Integer.parseInt(
                        JOptionPane.showInputDialog("Ingrese el elemento en la posición [" + i + "][" + j + "]:"));
            }
        }

        Stack<Double> pilaFilas = sumaFilas(matriz);
        Stack<Double> pilaColumnas = sumaColumnas(matriz);
        Stack<Integer> pilaMultiplicacion = multiplicarMatrices(matriz, matriz); // Multiplicación de la misma matriz
                                                                                 // por simplicidad

        mostrarResultados(pilaFilas, "Promedio de las filas:");
        mostrarResultados(pilaColumnas, "Raíz cuadrada de la suma de las columnas:");
        mostrarResultados(pilaMultiplicacion, "Matriz multiplicada almacenada en pila:");
    }

    public static Stack<Double> sumaFilas(int[][] matriz) {
        Stack<Double> pila = new Stack<>();
        for (int[] fila : matriz) {
            int suma = 0;
            for (int num : fila) {
                suma += num;
            }
            pila.push((double) suma / fila.length);
        }
        return pila;
    }

    public static Stack<Double> sumaColumnas(int[][] matriz) {
        Stack<Double> pila = new Stack<>();
        int columnas = matriz[0].length;
        for (int j = 0; j < columnas; j++) {
            int suma = 0;
            for (int[] fila : matriz) {
                suma += fila[j];
            }
            pila.push(Math.sqrt(suma));
        }
        return pila;
    }

    public static Stack<Integer> multiplicarMatrices(int[][] a, int[][] b) {
        int filas = a.length;
        int columnas = b[0].length;
        int[][] resultado = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int suma = 0;
                for (int k = 0; k < a[0].length; k++) {
                    suma += a[i][k] * b[k][j];
                }
                resultado[i][j] = suma;
            }
        }

        Stack<Integer> pila = new Stack<>();
        for (int[] fila : resultado) {
            for (int num : fila) {
                pila.push(num);
            }
        }
        return pila;
    }

    public static void mostrarResultados(Stack<?> pila, String mensaje) {
        StringBuilder resultado = new StringBuilder(mensaje + "\n");
        while (!pila.isEmpty()) {
            resultado.append(pila.pop()).append("\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}