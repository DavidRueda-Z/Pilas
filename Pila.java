import java.util.Scanner;
import java.util.Stack;

public class Pila{

    public void pila(){
        Scanner sc = new Scanner(System.in);
        //Para crear una pila uso el metodo Stack
        //Integer es como se declara una pila de tipo entero

        Stack<Integer> pilas = new Stack<>();
        Utils u = new Utils();

        pilas = u.LlenarPila();
        u.MostrarPila(pilas);
        pilas = u.EliminarDato(pilas);
    
    }
}