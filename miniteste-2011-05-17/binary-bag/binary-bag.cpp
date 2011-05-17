#include <iostream>

int main() {
    int numberOfTests;
    std::cin >> numberOfTests;

    for (; numberOfTests > 0; --numberOfTests) {
        // parse objects
        int numberOfObjects;
        std::cin >> numberOfObjects;

        int price[numberOfObjects];
        int weight[numberOfObjects];

        for (int i = 0; i < numberOfObjects; ++i) {
            std::cin >> price[i];
            std::cin >> weight[i];
        }


        // parse bags
        int familyTotal = 0;

        int numberOfBags;
        std::cin >> numberOfBags;

        for (int i = 0; i < numberOfBags; ++i) {
            int bagWeight;
            std::cin >> bagWeight;

            // maximal price matrix:
            // number_of_objects (including 0) x weight (including 0)
            int maximalPrice[numberOfObjects + 1][bagWeight + 1];

            // for weight 0, maximal price = 0
            for (int i = 0; i <= numberOfObjects; ++i) {
                maximalPrice[i][0] = 0;
            }
            // for 0 objects, maximal price = 0
            for (int j = 0; j <= bagWeight; ++j) {
                maximalPrice[0][j] = 0;
            }
            // for n objects, maximal price = max(with object i, without object i)
            for (int i = 1; i <= numberOfObjects; ++i) {
                for (int j = 1; j <= bagWeight; ++j) {
                    int priceWithoutI = maximalPrice[i-1][j];

                    // max(with i, without i)
                    // price and weight arrays are shifted by -1 from i
                    int maximal = priceWithoutI;
                    if (weight[i-1] <= j) { // i-th object weight may not be greater than the bag's weight
                        int priceWithI = price[i-1] + maximalPrice[i-1][j - weight[i-1]];

                        if (priceWithI > priceWithoutI) {
                            maximal = priceWithI;
                        }
                    }

                    maximalPrice[i][j] = maximal;
                }
            }

            // add the maximal price to the familyTotal
            familyTotal += maximalPrice[numberOfObjects][bagWeight];
        }

        std::cout << familyTotal << std::endl;
    }
}
