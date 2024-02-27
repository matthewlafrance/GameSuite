import java.util.*;

public class Chess {
    public static void play() {
        System.out.println();
        System.out.println("Welcome to Chess 👑");
        System.out.println();
        System.out.println("Format moves in format 'piece oldposition newposition' with no spaces");
        System.out.println("Pieces are abbreviated to: pawn P, bishop B, knight N, rook R, queen Q, king K");
        System.out.println("Positions follow normal chess terminology, columns 1-8, rows a-h");
        System.out.println("For example Pd2d4 for Pawn on d2 to d4");
        System.out.println("Red is white and blue is black");
        System.out.println();

        Scanner input = new Scanner(System.in);
        Board chessBoard = new Board();
        boolean checkmate = false;
        boolean stalemate = false;

        while (!checkmate && !stalemate) {
            System.out.println(chessBoard);
            System.out.println();

            if (chessBoard.isInCheck(chessBoard.getCurrentPlayer())) {
                System.out.println("" + chessBoard.getCurrentPlayer() + " is in check");
            }

            Piece piece = null;

            System.out.print(chessBoard.getCurrentPlayer() + " to move: ");
            Move move = Move.parse(input.next());
            if (move != null) {
                piece = chessBoard.getPiece(move.src);
            }

            while (move == null || !chessBoard.moveIsInCheck(move)) {
                System.out.println("error: invalid move");
                System.out.print("try again: ");
                move = Move.parse(input.next());
                if (move != null) piece = chessBoard.getPiece(move.src);
            }

            chessBoard.makeMove(move);

            System.out.println();

            checkmate = chessBoard.isCheckmate(chessBoard.getCurrentPlayer());
            if (!checkmate) stalemate = chessBoard.isStalemate(chessBoard.getCurrentPlayer());
        }

        System.out.println(chessBoard);
        System.out.println();

        if (checkmate) System.out.println("Game Over! " + chessBoard.getCurrentPlayer().opposite() + " Wins!");
        if (stalemate) System.out.println("Game Over! It's a draw!");
    }
}