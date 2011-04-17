/*
 * Questão 4:
 * Ugly Numbers são números cujos únicos fatores primos são 2, 3 ou 5. Ou seja,
 * é um número cuja decomposição em fatores primos só possui 2, 3 ou 5.
 * Desenvolva um algoritmo ehUgly(x) que, dado um inteiro como entrada, diga se
 * ele é um Ugly number. Faça análise de custo.
 *     ehUgly(4) = True.
 *     ehUgly(12) = True.
 *     ehUgly(5) = True.
 *     ehUgly(14) = False.
 * 
 * Análise:
 * No melhor caso, o número N não é divisível por 2, nem por 3, nem por 5,
 * resultando num custo O(1). No pior caso, o algoritmo fará o máximo possível
 * de divisões. Ora, o número de divisões (e o custo do algoritmo) é dado por
 *     T(N) = log2(X) + log3(Y) + log5(Z),
 * onde X, Y e Z são, respectivamente, as parcelas de N divisíveis por 2, 3 e 5.
 * Mas, sabendo que X, Y e Z são menores que N, podemos fazer
 *     T(N) <= log2(N) + log3(N) + log5(N)
 * ou
 *     T(N) = O(lg(N)).
 * Com relação a espaço, temos um custo O(1);
 */

public class Questao04 {
    public static void main(String[] args) {
        System.out.println("True: " + ehUgly(4));
        System.out.println("True: " + ehUgly(12));
        System.out.println("True: " + ehUgly(5));
        System.out.println("False: " + ehUgly(14));
        System.out.println("False: " + ehUgly(14));
    }

    public static boolean ehUgly(int number) {
        while (number % 2 == 0) {
            number = number / 2;
        }
        while (number % 3 == 0) {
            number = number / 3;
        }
        while (number % 5 == 0) {
            number = number / 5;
        }
        return number == 1;
    }
 }