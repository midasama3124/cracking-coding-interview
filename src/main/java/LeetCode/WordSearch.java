package LeetCode;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        // Recurse until word is found
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(i, j, 0, board, word)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int idx, char[][] board, String word) {
        if (idx == word.length() - 1) return true;
        board[i][j] -= 65;
        if (i < board.length - 1 && board[i + 1][j] == word.charAt(idx + 1) && dfs(i + 1, j, idx + 1, board, word))
            return true;
        if (i > 0 && board[i - 1][j] == word.charAt(idx + 1) && dfs(i - 1, j, idx + 1, board, word)) return true;
        if (j > 0 && board[i][j - 1] == word.charAt(idx + 1) && dfs(i, j - 1, idx + 1, board, word)) return true;
        if (j < board[0].length - 1 && board[i][j + 1] == word.charAt(idx + 1) && dfs(i, j + 1, idx + 1, board, word))
            return true;
        board[i][j] += 65;    // Recovering changed character
        return false;
    }
}
