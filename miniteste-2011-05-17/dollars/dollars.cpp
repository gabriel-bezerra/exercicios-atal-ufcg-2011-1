#include <iostream>
#include <cstdio>

int main() {
    int numberOfCoins = 11;
    int coins[11] = {5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000};

    int maximumAmount = 30000;
    int numberOfColumns = maximumAmount/5 + 1;

    long long count[numberOfColumns];

    for (int j = 0; j < numberOfColumns; ++j) {
        count[j] = 1;
    }

    for (int i = 1; i < numberOfCoins; ++i) {
        for (int j = 0; j < numberOfColumns; ++j) {
            if (j - coins[i]/5 >= 0) {
                count[j] += count[j - coins[i]/5];
            }
        }
    }

    int a,b;
    scanf("%d.%d",&a,&b);
    int amount = a*100 + b;
    while (amount != 0) {
        //printf("%6.2f%17ld\n", input, count[amount/5]);
        printf("%3d.%02d%17lld\n", amount/100, amount%100, count[amount/5]);

        scanf("%d.%d",&a,&b);
        amount = a*100 +b;
    }

    return 0;
}

