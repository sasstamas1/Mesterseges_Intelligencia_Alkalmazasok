package sample;

import static sample.Main.movewhite;

public class Moves {
    public State state = new State();

    public boolean lepes(int x, int y) {
        int[][] a = state.getA();
        int[][] b = new int[8][8];
        int q = 0, w = 0;
        for (int i = 0; i < 8; i++)
            System.arraycopy(a[i], 0, b[i], 0, 8);
        int tmp = 0;
        for (int i = 0; i < 8; i++) {
            tmp++;
            for (int j = 0; j < 8; j++) {
                tmp++;
                if (b[i][j] == 2) {
                    if (alkalmazhato_operatorok(i, j)) {
                        return Main.endgame(" A Fehér");
                    }
                    q = i;
                    w = j;
                    if (alkalmazhato(i, j, x, y)) {
                        b[i][j] = 1;
                        if (tmp % 2 == 0) {
                            Main.clear(i, j, "b");
                        } else {
                            Main.clear(i, j, "w");
                        }
                        break;
                    }
                }
            }
        }

        if (alkalmazhato(q, w, x, y)) {
            b[x][y] = 2;
            state.setA(b);
            return true;
        } else
            return false;

    }

    public boolean geplep(int x, int y) {
        int[][] a = state.getA();
        int[][] b = new int[8][8];
        int q = 0, w = 0;
        for (int i = 0; i < 8; i++)
            System.arraycopy(a[i], 0, b[i], 0, 8);
        int tmp = 0;
        for (int i = 0; i < 8; i++) {
            tmp++;
            for (int j = 0; j < 8; j++) {
                tmp++;
                if (b[i][j] == 3) {
                    if (alkalmazhato_operatorok(i, j)) {
                        return Main.endgame(" A Fekete");
                    }
                    q = i;
                    w = j;
                    x = x + i;
                    y = y + j;
                    if (alkalmazhato(i, j, x, y)) {
                        b[i][j] = 1;
                        if (tmp % 2 == 0) {
                            Main.clear(i, j, "b");
                        } else {
                            Main.clear(i, j, "w");
                        }
                        break;
                    }
                }
            }
        }

        if (alkalmazhato(q, w, x, y)) {
            b[x][y] = 3;
            state.setA(b);
            movewhite(x,y);
            return true;
        } else
            return false;

    }

    public boolean alkalmazhato(int i, int j, int x, int y) {
        int i_x = i - x;
        int j_y = j - y;
        if (i < 8 && y < 8 && x < 8 && j < 8 && i >= 0 && j >= 0 && x >= 0 && y >= 0 && state.getA()[x][y] < 1) {
            switch (i_x) {
                case 1:
                case -1:
                    if (j_y == 2 || j_y == -2)
                        return true;
                    break;
                case 2:
                case -2:
                    if (j_y == 1 || j_y == -1)
                        return true;
                    break;
                default:
                    return false;
            }
        }
        return false;
    }

    private boolean alkalmazhato_operatorok(int i, int j) {
        int[][] a = state.getA();
        if (j + 2 < 8 && i + 1 < 8) {
            if (a[i + 1][j + 2] == 0)
                return false;
        }
        if (i + 1 < 8 && j + 2 < 8) {
            if (a[i + 1][j + 2] == 0)
                return false;
        }
        if (i - 1 >= 0 && j - 2 >= 0) {
            if (a[i - 1][j - 2] == 0)
                return false;
        }
        if (i + 1 < 8 && j - 2 >= 0) {
            if (a[i + 1][j - 2] == 0)
                return false;
        }
        if (i - 1 >= 0 && j + 2 < 8) {
            if (a[i - 1][j + 2] == 0)
                return false;
        }
        if (i + 2 < 8 && j + 1 < 8) {
            if (a[i + 2][j + 1] == 0)
                return false;
        }
        if (i - 2 >= 0 && j - 1 >= 0) {
            if (a[i - 2][j - 1] == 0)
                return false;
        }
        if (i - 2 >= 0 && j + 1 < 8) {
            if (a[i - 2][j + 1] == 0)
                return false;
        }
        if (i + 2 < 8 && j - 1 >= 0) {
            if (a[i + 2][j - 1] == 0)
                return false;
        }

        return true;
    }
}
