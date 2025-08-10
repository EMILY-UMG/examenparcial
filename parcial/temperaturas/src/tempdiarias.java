
import java.util.Scanner;

public class tempdiarias {
    static double[] temp = new double[7];
    static boolean datosIngresados = false;
    static String[] diasS = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n     MENU OPCIONES       ");
            System.out.println("1. Ingresar temperaturas");
            System.out.println("2. Mostrar todas las temperaturas");
            System.out.println("3. Mostrar la temperatura mas alta");
            System.out.println("4. Mostrar suma total de temperaturas");
            System.out.println("5. SALIR");
            System.out.print("Seleccione una opcion a trabajar: ");

            if(scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        ingresarTemp(scanner);
                        break;
                    case 2:
                        if (datosIngresados) {
                            mostrarTemp();
                        } else {
                            System.out.println("Primero debe ingresar las temperaturas");
                        }
                        break;
                    case 3:
                        if (datosIngresados) {
                            double max = obtenerMax(temp);
                            int indiceDia = obtenerIndiceMax(temp);
                            mostrarMax(max, diasS[indiceDia]);
                        } else {
                            System.out.println("Primero debe ingresar las temperaturas");
                        }
                        break;
                    case 4:
                        if (datosIngresados) {
                            double suma = sumarTemperatura(temp, 0);
                            System.out.println("Suma total de temperaturas: " + suma + "°C");
                        } else {
                            System.out.println("Primero debe ingresar las temperaturas");
                        }
                        break;
                    case 5:
                        System.out.println("Saliendo del programa....");
                        break;
                    default:
                        System.out.println("Opción inválida, intente de nuevo.");
                }
            } else {
                System.out.println("Por favor ingrese un número válido.");
                scanner.next(); // limpiar entrada inválida
            }
        } while (opcion != 5);

        scanner.close();
    }

    public static void ingresarTemp(Scanner scanner) {
        for (int i = 0; i < temp.length; i++) {
            System.out.print("Ingresar temperatura maxima del " + diasS[i] + ": ");
            while(!scanner.hasNextDouble()) {
                System.out.println("Por favor ingrese un número válido para la temperatura.");
                scanner.next(); // limpiar entrada inválida
            }
            temp[i] = scanner.nextDouble();
        }
        datosIngresados = true;
        System.out.println("Temperaturas ingresadas correctamente.");
    }

    public static void mostrarTemp() {
        System.out.println("\nTemperaturas Registradas:");
        for (int i = 0; i < temp.length; i++) {
            System.out.println(diasS[i] + ": " + temp[i] + "°C");
        }
    }

    public static double obtenerMax(double[] arreglo) {
        double max = arreglo[0];
        for (double t : arreglo) {
            if (t > max) {
                max = t;
            }
        }
        return max;
    }

    public static int obtenerIndiceMax(double[] arreglo) {
        int indice = 0;
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] > arreglo[indice]) {
                indice = i;
            }
        }
        return indice;
    }

    public static void mostrarMax(double temp, String dia) {
        System.out.println("Temperatura Maxima: " + temp + "°C (" + dia + ")");
    }

    public static double sumarTemperatura(double[] arreglo, int indice) {
        if (indice == arreglo.length) {
            return 0;
        }
        return arreglo[indice] + sumarTemperatura(arreglo, indice + 1);
    }
}
