from collections import deque

class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def __str__(self) : return self.value

    def children(self):
        return [x for x in (self.left, self.right) if x != None]


def printQueue(queue):
    for i in queue:
        print i, " ",
    print


def caminhaArvore(raiz):
    nextLevel = deque()
    nextLevel.append(raiz)

    while len(nextLevel) > 0:
        printQueue(nextLevel)

        previousLevel = nextLevel
        nextLevel = deque()

        for node in previousLevel:
            nextLevel.extend(node.children())


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

