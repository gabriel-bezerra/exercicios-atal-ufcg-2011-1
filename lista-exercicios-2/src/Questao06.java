/*
 * Forneça um algoritmo que encontre todos os possíveis caminhos em um certo
 * labirinto (de dimensões KxN). Considere que o labirinto é representado por
 * uma matriz de valores binários. Nesse contexto, 0 representa uma parede e 1
 * representa um local possível. M[1,1] e M[K,N] representam o início e fim do
 * labirinto, respectivamente.
 */

public class Questao06 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] labir0 = criaLabirinto0();
        int[][] labir1 = criaLabirinto1();
        int[][] labir2 = criaLabirinto2();
    }

    /* 1 caminho */
    public static int[][] criaLabirinto0() {
        int[][] labirinto = new int[][] {
            {1, 1, 1},
            {0, 0, 1},
            {1, 1, 1}
        };

        return labirinto;
    }

    /* 2 caminhos */
    public static int[][] criaLabirinto1() {
        int[][] labirinto = new int[][] {
            {1, 1, 1, 1, 1},
            {0, 0, 0, 1, 1},
            {1, 1, 0, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1}
        };

        return labirinto;
    }

    /* 4 caminhos */
    public static int[][] criaLabirinto2() {
        int[][] labirinto = new int[][] {
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 1, 1, 0, 1},
            {1, 0, 0, 1, 0, 1, 1, 0, 1},
            {1, 1, 1, 1, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        return labirinto;
    }
}

