class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();

        //Validate rows
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.')
                    continue;
                if (set.contains(ch))
                    return false;
                set.add(ch);
            }
            set.clear();
        }

        //Validate cols
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[j][i];
                if (ch == '.')
                    continue;
                if (set.contains(ch))
                    return false;
                set.add(ch);
            }
            set.clear();
        }

        //Validate grid
        for (int k = 0; k < 9; k++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int r = (k / 3) * 3 + i;
                    int c = (k % 3) * 3 + j;
                    char ch = board[r][c];
                    if (ch == '.')
                        continue;
                    if (set.contains(ch))
                        return false;
                    set.add(ch);
                }
            }
            set.clear();
        }
        return true;
    }
}
