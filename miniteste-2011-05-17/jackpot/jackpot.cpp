#include <iostream>

int main() {
    int numberOfBets;
    std::cin >> numberOfBets;

    while (numberOfBets != 0) {
        int bets[numberOfBets];

        for (int i = 0; i < numberOfBets; ++i) {
            std::cin >> bets[i];
        }

        int bestBets[numberOfBets];
        bestBets[0] = bets[0];

        for (int i = 1; i < numberOfBets; ++i) {
            bestBets[i] = bets[i] + ((bestBets[i - 1] > 0) ? bestBets[i - 1]
                                                           : 0);
        }

        int best = -10000;
        for (int i = 0; i < numberOfBets; ++i) {
            if (bestBets[i] > best) {
                best = bestBets[i];
            }
        }

        if (best > 0) {
            std::cout << "The maximum winning streak is "
                      << best << '.' << std::endl;
        } else {
            std::cout << "Losing streak." << std::endl;
        }

        std::cin >> numberOfBets;
    }

    return 0;
}

