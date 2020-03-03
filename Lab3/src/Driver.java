import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        List<Piece> pieces = new ArrayList<>();
        Piece king = new King();
        Piece queen = new Queen();
        Piece rook = new Rook();
        Piece knight = new Knight();
        Piece bishop = new Bishop();
        Piece pawn = new Pawn();
        pieces.add(king);
        pieces.add(queen);
        pieces.add(rook);
        pieces.add(knight);
        pieces.add(bishop);
        pieces.add(pawn);
        pieces.forEach(c-> c.move());

        /*
        p1={value=1, isWhite=true, promoted=true, newPiece=Queen}
        p2={value=1, isWhite=true, promoted=false, newPiece=null}
        p3={value=1, isWhite=false, promoted=false, newPiece=null}
        p4={value=1, isWhite=false, promoted=true, newPiece=Queen}
        p5={value=1, isWhite=true, promoted=true, newPiece=Knight}
        */

        Piece p1 = new Pawn(true,true, new Queen());
        Piece p2 = new Pawn(true,false, null);
        Piece p3 = new Pawn(false,false, null);
        Piece p4 = new Pawn(false,true, new Queen());
        Piece p5 = new Pawn(true,true, new King());

        System.out.println(p1.equals(p2)); // should return false
        System.out.println(p1.equals(p4)); // should return false
        System.out.println(p1.equals(p5)); // should return false
        System.out.println(p2.equals(p3)); // should return false
        System.out.println(p4.equals(p5)); // should return false
    }

}
