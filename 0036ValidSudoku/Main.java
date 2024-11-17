import java.util.HashSet;
import java.util.Set;

public class Main {

    public static boolean isValidSudoku(char[][] board) {
        Set<Character> nums = new HashSet<>();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;

                if(nums.contains(board[i][j])) return false;
                nums.add(board[i][j]);
            }
            nums.clear();
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[j][i] == '.') continue;

                if(nums.contains(board[j][i])) return false;
                nums.add(board[j][i]);
            }
            nums.clear();
        }

        for(int box = 0; box < 3; box++) {
            for(int i = 0; i < 9; i++) {

                if(i % 3 == 0) nums.clear();

                for(int j = 0; j < 3; j++) {
                    int r = ((3 * box) + i % 3);
                    int c = (j + 3 * (i / 3));

                    if(board[r][c] == '.') continue;

                    if (nums.contains(board[r][c]))
                        return false;
                    nums.add(board[r][c]);

                }
            }
            nums.clear();
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'.','.','.','.','5','.','.','1','.'},
            {'.','4','.','3','.','.','.','.','.'},
            {'.','.','.','.','.','3','.','.','1'},
            {'8','.','.','.','.','.','.','2','.'},
            {'.','.','2','.','7','.','.','.','.'},
            {'.','1','5','.','.','.','.','.','.'},
            {'.','.','.','.','.','2','.','.','.'},
            {'.','2','.','9','.','.','.','.','.'},
            {'.','.','4','.','.','.','.','.','.'}
        };
        System.out.println(isValidSudoku(board));
    }
}
