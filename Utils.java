import java.util.Scanner;
import java.util.Stack;

public class Utils {

    Scanner sc = new Scanner(System.in);

    public Stack<Integer> LlenarPila()
    {   
        
        Stack<Integer> pila = new Stack<>();
        boolean Bandera = true;
        int opt = 0;
        while(Bandera)
        {   
            //Validar
            System.out.println("Ingrese el registro: ");
            while(!sc.hasNextInt()){
            System.out.println("Dato Erroneo, intentelo de nuevo: ");
            sc.next();
            //El push es la manera en que ingreso un dato a la pila
            }
            pila.push(sc.nextInt());

            System.out.println("Desea ingresar mas registros: 1.Si \n 2.No");
            while(!sc.hasNextInt()){
            System.out.println("Dato Erroneo, intentelo de nuevo: ");
            }
            opt = sc.nextInt();

            while(opt == 1 || opt == 2 )
            {
                System.out.println("Numero erroneo, ingrese una opcion valida: ");
                opt = sc.nextInt();
            }
            if(opt == 2)
            {
                Bandera = false;
            }
        }
        return pila;
    }

    public void MostrarPila(Stack<Integer> pila)
    {   
        //Como simplemente son datos individuales y no objetuales, solo es mostrar la pila
        System.out.println(pila);
    }

    public Stack<Integer> EliminarDato(Stack<Integer> pila)
    {
        Stack<Integer> Aux = new Stack<>();
        int numero = 0;

        System.out.println("Ingrese el numero que desea eliminar: ");
        numero = sc.nextInt();

        while(!pila.isEmpty())
        {
            if(pila.peek() == numero)
            {   
                //.peek busca el ultimo registro que hay en la pila
                pila.pop();
                //.pop, elimina el registro
            }
            else
            {   //push es para insertar
                Aux.push(pila.pop());
            }
        }
        System.out.println(pila);
        System.out.println(Aux.reversed());
        //El reverse como su nombre lo indica en ingles, reserva el orden en el que esta la pila
        return pila;
    }
}
