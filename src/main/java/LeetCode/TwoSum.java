package LeetCode;

import java.util.*;

public class TwoSum {
    static int[] findIndeces(int[] nums, int target) {
        int diff, index2, index3;
        for (int index1 = 0; index1 < nums.length; index1++) {
            diff = target - nums[index1];
            index2 = lastIndexOf(nums, diff);
            if (index2 != -1 && index2 != index1) {
                return new int[]{index1, index2};
            }
        }
        return new int[]{0, 0};
    }

    private static int lastIndexOf(int[] nums, int value) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == value) return i;
        }
        return -1;
    }

    // Este método encuentra todas las parejas de números en un arreglo de entrada
    // que al sumadas dan como resultado un objetivo dado.
    // *numeros: Arreglo de entrada
    // *objetivo: Número resultado de la suma entre pares
    // Retorna una lista con todos los pares encontrados
    // Este método tiene las siguientes Big O:
    // O(n): Tiempo (Única iteración a lo largo del arreglo)
    // O(n): Espacio (Estructura de datos adicional)
    // Siendo n el tamaño del arreglo "numeros"
    public static List<List<Integer>> sumaObjetivo(int[] numeros, int objetivo) {
        List<List<Integer>> res = new ArrayList<>();
        // Usa una estructura de datos adicional para saber si el complemento entre
        // el número actual y el objetivo ya ha sido mapeado
        Map<Integer, Integer> mapa = new HashMap<>();
        // Itera a lo largo del arreglo de números actualizando el HashMap
        // y añadiendo pares que se encuentren a la solución
        for (int i = 0; i < numeros.length; i++) {
            int diferencia = objetivo - numeros[i];
            // Si contiene la diferencia, una solución ha sido encontrada
            if (mapa.containsKey(diferencia)) {
                List<Integer> par = new ArrayList<>(
                        Arrays.asList(
                                numeros[mapa.get(diferencia)],
                                numeros[i]
                        ));
                // Sólo incluye valores únicos
                if (!(res.contains(par) ||
                        res.contains(new ArrayList<>(Arrays.asList(par.get(1), par.get(0))))))
                    res.add(par);
            }
            mapa.put(numeros[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 5, -10, 16, 4, 2};
        int target = 6;
        List<List<Integer>> sol = sumaObjetivo(nums, target);
        System.out.println(sol.toString());
    }
}
