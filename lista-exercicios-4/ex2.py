WHITE = 0
BLACK = 1

class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None
        self.color = WHITE

    def __str__(self) : return self.value


def caminhaArvore(raiz) : pass


def teste():
    a = Node("a")
    b = Node("b")
    c = Node("c")
    d = Node("d")
    e = Node("e")
    f = Node("f")
    g = Node("g")
    h = Node("h")

    a.left = b
    a.right = c

    b.left = d
    b.right = e

    c.left = f
    c.right = g

    g.right = d
    b.right = e

    c.left = f
    c.right = g

    g.right = h

    caminhaArvore(a)

teste()
