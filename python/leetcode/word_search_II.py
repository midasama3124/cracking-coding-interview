class Trie:
    def __init__(self):
        self.endOfWord = False
        self.children = [None]*26

    def insert(self, word):
        curr = self
        for c in word:
            idx = ord(c) - ord('a')
            if (curr.children[idx] == None): curr.children[idx] = Trie()
            curr = curr.children[idx]
        curr.endOfWord = True

class Solution:
    def dfs(self, trie, i, j, s):
        c = self.board[i][j]
        if c == '$': return
        self.board[i][j] = '$'   # Use special character to avoid going in circles while recursing
        t = trie.children[ord(c) - ord('a')]
        if t != None:
            ss = s + c
            if (t.endOfWord): self.result.add(ss);
            if (i < len(self.board) - 1): self.dfs(t, i+1, j, ss)
            if (j < len(self.board[0]) - 1): self.dfs(t, i, j+1, ss)
            if (i > 0): self.dfs(t, i-1, j, ss)
            if (j > 0): self.dfs(t, i, j-1, ss)
        self.board[i][j] = c   # Recovering changed character

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        if len(words) == 0: return []
        # Fill up trie
        trie = Trie()
        for s in words:
            trie.insert(s)
        # Recursing through board while comparing to
        self.board = board
        self.result = set()
        for i in range(len(board)):
            for j in range(len(board[0])):
                self.dfs(trie, i, j, "")
        return list(self.result)