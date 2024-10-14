import java.util.Scanner;

public class OrdenamientoApp {
    private MetodosOrdenamiento metodosOrdenamiento = new MetodosOrdenamiento();
    private int[] arreglo = null;

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Ingresar arreglo");
            System.out.println("2. Ordenar arreglo");
            System.out.println("0. Salir");
            int opcion = obtenerOpcion(scanner);

            switch (opcion) {
                case 1:
                    arreglo = ingresarArreglo(scanner);
                    break;
                case 2:
                    if (arreglo == null) {
                        System.out.println("Primero debe ingresar un arreglo.");
                    } else {
                        ordenarArreglo(scanner);
                    }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private int obtenerOpcion(Scanner scanner) {
        int opcion = -1;
        while (true) {
            System.out.print("Seleccione una opción: ");
            String entrada = scanner.nextLine();
            try {
                opcion = Integer.parseInt(entrada);
                if (opcion < 0) {
                    System.out.println("Error: Debe ingresar un número positivo. Intente de nuevo.");
                } else {
                    break; // Salir del bucle si la entrada es válida
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido. Intente de nuevo.");
            }
        }
        return opcion;
    }

    private int[] ingresarArreglo(Scanner scanner) {
        System.out.print("Ingrese el tamaño del arreglo: ");
        int tamano = obtenerValor(scanner); // Usamos obtenerValor para obtener directamente el tamaño.

        if (tamano <= 0) {
            System.out.println("El tamaño del arreglo debe ser mayor a 0.");
            return null;
        }

        int[] arreglo = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            System.out.print("Ingrese el valor para la posición " + (i + 1) + ": ");
            arreglo[i] = obtenerValor(scanner); // Directamente se pide el valor sin mensajes adicionales.
        }

        System.out.println("Arreglo ingresado:");
        MetodosOrdenamiento.imprimirArreglo(arreglo);
        return arreglo;
    }

    private int obtenerValor(Scanner scanner) {
        int valor = 0;
        while (true) {
            String entrada = scanner.nextLine(); // Se elimina el mensaje de "Ingrese un número".
            try {
                valor = Integer.parseInt(entrada);
                break; // Salir del bucle si la entrada es válida
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido. Intente de nuevo.");
            }
        }
        return valor;
    }

    private void ordenarArreglo(Scanner scanner) {
        System.out.println("Seleccione el método de ordenamiento:");
        System.out.println("1. Burbuja");
        System.out.println("2. Selección");
        System.out.println("3. Inserción");
        System.out.println("4. Burbuja con ajuste");
        int opcion = obtenerOpcion(scanner);

        System.out.println("Seleccione ascendente o descendente:");
        System.out.println("1. Ascendente");
        System.out.println("2. Descendente");
        boolean ascendente = (scanner.nextInt() == 1);
        scanner.nextLine(); // Limpiar el buffer

        System.out.println("¿Desea ver los pasos de la ordenación?");
        System.out.println("1. Sí");
        System.out.println("2. No");
        boolean verPasos = (scanner.nextInt() == 1);
        scanner.nextLine(); // Limpiar el buffer

        int[] arregloOrdenado;
        switch (opcion) {
            case 1:
                arregloOrdenado = metodosOrdenamiento.burbuja(arreglo, ascendente, verPasos);
                break;
            case 2:
                arregloOrdenado = metodosOrdenamiento.seleccion(arreglo, ascendente, verPasos);
                break;
            case 3:
                arregloOrdenado = metodosOrdenamiento.insercion(arreglo, ascendente, verPasos);
                break;
            case 4:
                arregloOrdenado = metodosOrdenamiento.burbujaConAjuste(arreglo, ascendente, verPasos);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        System.out.println("Arreglo ordenado:");
        MetodosOrdenamiento.imprimirArreglo(arregloOrdenado);
    }
}
