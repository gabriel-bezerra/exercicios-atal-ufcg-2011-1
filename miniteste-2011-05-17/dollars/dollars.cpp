#include <iostream>
#include <cstdio>

int main() {
    int numberOfCoins = 11;
    int coins[11] = {5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000};

    int maximumAmount = 30000;
    int numberOfColumns = maximumAmount/5 + 1;

    int count[numberOfCoins][numberOfColumns];

    for (int j = 0; j < numberOfColumns; ++j) {
        count[0][j] = 1;
    }

    for (int i = 1; i < numberOfCoins; ++i) {
        for (int j = 0; j < numberOfColumns; ++j) {
            count[i][j] = count[i-1][j];

            if (j - coins[i]/5 >= 0) {
                count[i][j] += count[i][j - coins[i]/5];
            }

        }
    }

    float input;
    std::cin >> input;
    int amount = int (100 * input);
    while (amount != 0) {
        printf("%6.2f%17d\n", input, count[numberOfCoins - 1][amount/5]);

        std::cin >> input;
        amount = int (100 * input);
    }

    return 0;
}

