/*
 * Ugly Numbers são números cujos únicos fatores primos são 2, 3 ou 5. Ou seja,
 * é um número cuja decomposição em fatores primos só possui 2, 3 ou 5.
 * Desenvolva um algoritmo ehUgly(x) que, dado um inteiro como entrada, diga se
 * ele é um Ugly number. Faça análise de custo.
 *     ehUgly(4) = True.
 *     ehUgly(12) = True.
 *     ehUgly(5) = True.
 *     ehUgly(14) = False.
 */

public class Questao04 {
    public static void main(String[] args) {
        System.out.println("True: " + ehUgly(4));
        System.out.println("True: " + ehUgly(12));
        System.out.println("True: " + ehUgly(5));
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