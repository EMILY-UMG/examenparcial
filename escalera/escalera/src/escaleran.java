import java.util.Scanner;

public class escaleran {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el número de niveles: ");

        // Validar que sea un entero mayor o igual a 1
        if (!sc.hasNextInt()) {
            System.out.println("Error: Debe ingresar un número entero positivo.");
            return;
        }
        int n = sc.nextInt();

        if (n < 1) {
            System.out.println("Error: El número de niveles debe ser mayor o igual a 1.");
            return;
        }

        // Imprimir parte ascendente
        imprimirAscendente(n);

        // Imprimir parte descendente (recursiva como extra)
        imprimirDescendenteRecursivo(n - 1);

        sc.close();
    }

    // Procedimiento para imprimir escalera ascendente
    public static void imprimirAscendente(int niveles) {
        for (int i = 1; i <= niveles; i++) {
            imprimirLinea(i); // usando versión con números
        }
    }

    // Procedimiento para imprimir escalera descendente (recursivo)
    public static void imprimirDescendenteRecursivo(int nivel) {
        if (nivel < 1) {
            return; // caso base
        }
        imprimirLinea(nivel);
        imprimirDescendenteRecursivo(nivel - 1);
    }

    // Metodo sobrecargado
    public static void imprimirLinea(int nivel) {
        for (int i = 1; i <= nivel; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
