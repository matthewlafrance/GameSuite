public class Move {
    public final Piece.Kind piece;
    public final Square src;
    public final Square dest;

    public Move(Piece.Kind piece, Square src, Square dest) {
        this.piece = piece;
        this.src = src; 
        this.dest = dest;
    }

    public static Move parse(String move) {
        if (move.length() != 5) {
            return null;
        }

        Piece.Kind piece = Piece.Kind.parse(move.charAt(0));
        Square src = Square.parse(move.charAt(1), move.charAt(2));
        Square dest = Square.parse(move.charAt(3), move.charAt(4));

        if (piece == null) {
            return null;
        }

        if (src == null) {
            return null;
        }

        if (dest == null) {
            return null;
        }

        return new Move(piece, src, dest);
    }

    public String toString() {
        return "" + this.piece + this.src + this.dest;
    }
}