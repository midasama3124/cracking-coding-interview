class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        m = len(board)
        n = len(board[0])
        # Recurse until word is found
        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0] and self.dfs(i, j, 0, board, word): return True
        return False

    def dfs(self, i, j, idx, board, word):
        if idx == len(word) - 1: return True
        board[i][j] = chr(ord(board[i][j]) - 65)
        if i < len(board) - 1 and board[i + 1][j] == word[idx+1] and self.dfs(i + 1, j, idx+1, board, word): return True
        if i > 0 and board[i - 1][j] == word[idx+1] and self.dfs(i - 1, j, idx+1, board, word): return True
        if j > 0 and board[i][j - 1] == word[idx+1] and self.dfs(i, j - 1, idx+1, board, word): return True
        if j < len(board[0]) - 1 and board[i][j + 1] == word[idx+1] and self.dfs(i, j + 1, idx+1, board, word): return True
        board[i][j] = chr(ord(board[i][j]) + 65)    # Recovering changed character
        return False