class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 1. Prepare the board with empty cells
        List<String> board = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < n; i++) {
            temp += ".";
        }
        for (int i = 0; i < n; i++) {
            board.add(temp);
        }

        if (n == 2 || n == 3)
            return ans;

        fillBoard(board, n, 0);
        return ans;
    }

    private void fillBoard(List<String> board, int n, int row) {
        if (row == n) {
            ans.add(new ArrayList<>(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, n, row, col)) {
                char[] charArr = board.get(row).toCharArray();
                charArr[col] = 'Q';
                board.set((row), new String(charArr));
                fillBoard(board, n, row + 1);
                charArr[col] = '.';
                board.set((row), new String(charArr));
            }
        }
    }

    private boolean isSafe(List<String> board, int n, int row, int col) {
        for (int i = 0; i < n; i++) {
            if (board.get(i).charAt(col) == 'Q')
                return false;
        }
        for (int i = 0; i < n; i++) {
            if (row - i >= 0 && col - i >= 0 && board.get(row - i).charAt(col - i) == 'Q')
                return false;
            if (row - i >= 0 && col + i < n && board.get(row - i).charAt(col + i) == 'Q')
                return false;
        }
        return true;
    }
}
