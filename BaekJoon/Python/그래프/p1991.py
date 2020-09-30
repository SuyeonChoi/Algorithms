import sys
input = sys.stdin.readline
N = int(input())
lc = [0] * N
rc = [0] * N


def preorder(root):
    print(chr(root+65),end='')
    if lc[root] != 0:
        preorder(lc[root])
    if rc[root] != 0:
        preorder(rc[root])

def inorder(root):
    if lc[root] != 0:
        inorder(lc[root])
    print(chr(root + 65), end='')
    if rc[root] != 0:
        inorder(rc[root])

def postorder(root):
    if lc[root] != 0:
        postorder(lc[root])
    if rc[root] != 0:
        postorder(rc[root])
    print(chr(root + 65), end='')

for i in range(N):
    node, left, right = map(str, input().split())
    if left != '.':
        lc[ord(node)-65] = ord(left) - 65
    if right != '.':
        rc[ord(node)-65] = ord(right) - 65

preorder(0)
print()
inorder(0)
print()
postorder(0)