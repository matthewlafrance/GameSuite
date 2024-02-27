public class Square {
    public int row;
    public int column;

    public Square(int column, int row) {
        this.row = row;
        this.column = column;
    }

    public static Square parse(char c, char r) {
        int column;
        int row;

        if (r >= '1' && r <= '8') {
            row = r - '1';
        } else {
            return null;
        }

        if (c >= 'a' && c <= 'h') {
            column = c - 'a';
        } else {
            return null;
        }

        return new Square(column, row);
    }

    @Override
    public boolean equals(Object other) {
        Square sq = (Square)other;
        return this.row == sq.row && this.column == sq.column;
    }

    public String toString() {
        return "row: " + this.row + " col: " + this.column;
    }

    public static boolean isHorizontalPath(Square src, Square dest) {
        return src.row == dest.row;
    }

    public static boolean isVerticalPath(Square src, Square dest) {
        return src.column == dest.column;
    }

    public static boolean isDiagonalPath(Square src, Square dest) {
        int deltaR = dest.row - src.row;
        int deltaC = dest.column - src.column;

        return Math.abs(deltaR) == Math.abs(deltaC);
    }

    public static boolean isStraightPath(Square src, Square dest) {
        return Square.isDiagonalPath(src, dest)
            || Square.isHorizontalPath(src, dest)
            || Square.isVerticalPath(src, dest);
    }

    public static int straightPathLength(Square src, Square dest) {
        int dr = Math.abs(dest.row - src.row);
        int dc = Math.abs(dest.column - src.column);

        return Integer.max(dr, dc);
    }

    public static int horizontalPathLength(Square src, Square dest) {
        return Math.abs(dest.column - src.column);
    }

    public static int verticalPathLength(Square src, Square dest) {
        return Math.abs(dest.row - src.row);
    }
}