import unittest

def balde(M, x, y):
    i = x - 1
    j = y - 1
    balde1(M, i, j, M[i][j])


def balde1(M, x, y, antigo):
    tinta = '-'

    if not M[x][y] == antigo:
        return

    M[x][y] = tinta

    # divisao
    for i in [-1, 0, 1]:
        for j in [-1, 0, 1]:

            # verifica se esta nos limites do array
            if not (0 <= x + i < len(M) and
                    0 <= y + j < len(M[x + i])):
                return

            # conquista
            balde1(M, x + i, y + j, antigo)

    # combinacao  trivial


class BaldeTestCase(unittest.TestCase):

    def test1(self):
        M = [['*','*','*','*'],
             ['#','*','#','#'],
             ['#','#','#','#'],
             ['*','*','*','*'],
             ['*','*','*','*']]

        balde(M, 2, 2)


        self.assertEquals(M, [['-','-','-','-'],
                              ['#','-','#','#'],
                              ['#','#','#','#'],
                              ['*','*','*','*'],
                              ['*','*','*','*']])

#----------------------------------------

    def test2(self):
        M = [['*','*','*','*'],
             ['#','*','#','#'],
             ['#','#','#','#'],
             ['*','*','*','*'],
             ['*','*','*','*']]

        balde(M, 4, 2)

        self.assertEquals(M, [['*','*','*','*'],
                              ['#','*','#','#'],
                              ['#','#','#','#'],
                              ['-','-','-','-'],
                              ['-','-','-','-']])


#----------------------------------------

    def test3(self):
        M = [['*','#','*','*'],
             ['#','*','#','#'],
             ['#','#','#','#'],
             ['*','*','*','*'],
             ['*','*','*','*']]

        balde(M, 2, 2)

        self.assertEquals(M, [['-','#','-','-'],
                              ['#','-','#','#'],
                              ['#','#','#','#'],
                              ['*','*','*','*'],
                              ['*','*','*','*']])

#----------------------------------------

    def test4(self):
        M = [['*','#','*','*'],
             ['#','*','#','#'],
             ['#','#','*','#'],
             ['*','*','*','*'],
             ['*','*','*','*']]

        balde(M, 2, 2)

        self.assertEquals(M, [['-','#','-','-'],
                              ['#','-','#','#'],
                              ['#','#','-','#'],
                              ['-','-','-','-'],
                              ['-','-','-','-']])


if __name__ == '__main__':
    unittest.main()


