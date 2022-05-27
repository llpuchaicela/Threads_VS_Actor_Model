package ParallelMatriz;

import ParallelMatriz.matriz;

public class RunParallel {
    public static void main(String[] args)throws InterruptedException {
        int[][] mat1Values = {
                {1, 2},
                {3, 4},
                {5, 6},
        };
        matriz m1 = new matriz(mat1Values);
        int[][] mat2Values = {
                {1, 2, 3},
                {3, 4, 5}
        };
        matriz m2 = new matriz(mat2Values);

        matriz result = m1.multiplyWithThreads(m2);

        System.out.println(result);
        System.out.println("matrizUno" + m1);
        System.out.println("matrizDos" + m2);
    }


}

