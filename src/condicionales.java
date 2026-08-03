import java.util.Scanner;

public class condicionales
{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("========================================");
        System.out.println("Estudiante: Angel Estuardo Campos Santay");
        System.out.println("Carné: 9941-25-4809");
        System.out.println("Semana 3 — Condiciones y ciclos");
        System.out.println("========================================");

        do {

            System.out.println("\n========= DESAFÍOS LÓGICOS =========");
            System.out.println("1. Generar una secuencia");
            System.out.println("2. Realizar un conteo regresivo");
            System.out.println("3. Analizar números");
            System.out.println("4. Dibujar una pirámide");
            System.out.println("5. Validar palabra secreta");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    System.out.println("\n--- Generar una secuencia ---");

                    System.out.print("Número inicial: ");
                    int inicio = sc.nextInt();

                    System.out.print("Número final: ");
                    int fin = sc.nextInt();

                    System.out.print("Incremento: ");
                    int incremento = sc.nextInt();

                    if (incremento <= 0) {
                        System.out.println("Error: El incremento debe ser mayor que cero.");
                    } else if (fin <= inicio) {
                        System.out.println("Error: El número final debe ser mayor que el inicial.");
                    } else {
                        System.out.println("Secuencia:");
                        for (int i = inicio; i <= fin; i += incremento) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                    }

                    break;

                case 2:

                    System.out.println("\n--- Conteo regresivo ---");

                    int numero;

                    System.out.print("Ingrese un número entre 10 y 50: ");
                    numero = sc.nextInt();

                    while (numero < 10 || numero > 50) {
                        System.out.println("Número inválido.");
                        System.out.print("Ingrese un número entre 10 y 50: ");
                        numero = sc.nextInt();
                    }

                    while (numero >= 0) {
                        System.out.print(numero + " ");
                        numero--;
                    }

                    System.out.println("\n¡Despegue!");

                    break;

                case 3:

                    System.out.println("\n--- Analizar números ---");

                    int positivos = 0;
                    int negativos = 0;
                    int suma = 0;
                    int ignorados = 0;

                    while (true) {

                        System.out.print("Ingrese un número: ");
                        int n = sc.nextInt();

                        if (n == 0) {
                            break;
                        }

                        if (n > 0) {
                            positivos++;
                        } else {
                            negativos++;
                        }

                        if (n % 5 == 0) {
                            ignorados++;
                            System.out.println("El número " + n + " fue ignorado.");
                            continue;
                        }

                        suma += n;
                    }

                    System.out.println("\nResultado:");
                    System.out.println("Positivos: " + positivos);
                    System.out.println("Negativos: " + negativos);
                    System.out.println("Suma válida: " + suma);
                    System.out.println("Números ignorados: " + ignorados);

                    break;

                case 4:

                    System.out.println("\n--- Dibujar una pirámide ---");

                    System.out.print("Ingrese la altura (3-10): ");
                    int altura = sc.nextInt();

                    if (altura < 3 || altura > 10) {
                        System.out.println("Altura inválida. Debe estar entre 3 y 10.");
                    } else {

                        for (int i = 1; i <= altura; i++) {

                            for (int j = 1; j <= altura - i; j++) {
                                System.out.print(" ");
                            }

                            for (int k = 1; k <= (2 * i) - 1; k++) {
                                System.out.print("*");
                            }

                            System.out.println();
                        }
                    }

                    break;

                case 5:

                    System.out.println("\n--- Validar palabra secreta ---");

                    sc.nextLine();

                    String palabra;

                    do {
                        System.out.print("Ingrese la palabra secreta: ");
                        palabra = sc.nextLine().trim();

                        if (!palabra.equalsIgnoreCase("Guatemala")) {
                            System.out.println("Palabra incorrecta. Intente nuevamente.");
                        }

                    } while (!palabra.equalsIgnoreCase("Guatemala"));

                    System.out.println("Palabra correcta.");

                    break;

                case 6:

                    System.out.println("\nPrograma finalizado correctamente.");
                    break;

                default:

                    System.out.println("\nOpción no válida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 6);

        sc.close();
    }
}