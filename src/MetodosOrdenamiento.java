
public class MetodosOrdenamiento {
    public int[] burbuja(int[] arreglo, boolean ascendente, boolean verPasos) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Mostrar comparación
                if (verPasos) {
                    System.out.println("Comparando " + arreglo[j] + " y " + arreglo[j + 1]);
                }

                if ((ascendente && arreglo[j] > arreglo[j + 1]) || (!ascendente && arreglo[j] < arreglo[j + 1])) {
                    // Intercambio
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;

                    if (verPasos) {
                        System.out.println("Intercambiando " + arreglo[j + 1] + " y " + arreglo[j]);
                        imprimirArreglo(arreglo);
                    }
                }
            }
        }
        return arreglo;
    }

    public int[] seleccion(int[] arreglo, boolean ascendente, boolean verPasos) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinMax = i;
            for (int j = i + 1; j < n; j++) {
                // Mostrar comparación
                if (verPasos) {
                    System.out.println("Comparando " + arreglo[j] + " y " + arreglo[indiceMinMax]);
                }

                if ((ascendente && arreglo[j] < arreglo[indiceMinMax])
                        || (!ascendente && arreglo[j] > arreglo[indiceMinMax])) {
                    indiceMinMax = j;
                }
            }
            // Intercambio
            int temp = arreglo[indiceMinMax];
            arreglo[indiceMinMax] = arreglo[i];
            arreglo[i] = temp;

            if (verPasos) {
                System.out.println("Intercambiando " + temp + " y " + arreglo[i]);
                imprimirArreglo(arreglo);
            }
        }
        return arreglo;
    }

    public int[] insercion(int[] arreglo, boolean ascendente, boolean verPasos) {
        int n = arreglo.length;
        for (int i = 1; i < n; i++) {
            int key = arreglo[i];
            int j = i - 1;

            if (verPasos) {
                System.out.println("Insertando " + key);
            }

            while (j >= 0 && ((ascendente && arreglo[j] > key) || (!ascendente && arreglo[j] < key))) {
                // Mostrar comparación
                if (verPasos) {
                    System.out.println("Comparando " + arreglo[j] + " y " + key);
                }

                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = key;

            if (verPasos) {
                imprimirArreglo(arreglo);
            }
        }
        return arreglo;
    }

    public int[] burbujaConAjuste(int[] arreglo, boolean ascendente, boolean verPasos) {
        int n = arreglo.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                // Mostrar comparación
                if (verPasos) {
                    System.out.println("Comparando " + arreglo[i] + " y " + arreglo[i + 1]);
                }

                if ((ascendente && arreglo[i] > arreglo[i + 1]) || (!ascendente && arreglo[i] < arreglo[i + 1])) {
                    // Intercambio
                    int temp = arreglo[i];
                    arreglo[i] = arreglo[i + 1];
                    arreglo[i + 1] = temp;

                    swapped = true;
                    if (verPasos) {
                        System.out.println("Intercambiando " + arreglo[i + 1] + " y " + arreglo[i]);
                        imprimirArreglo(arreglo);
                    }
                }
            }
            n--; // Cada pasada finaliza el último elemento
        } while (swapped);
        return arreglo;
    }

    public static void imprimirArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
