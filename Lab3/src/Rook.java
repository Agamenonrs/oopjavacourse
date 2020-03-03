public class Rook extends Piece {

    public  Rook(boolean isWhite){
        super(5,isWhite);
    }

    public Rook(){
        super(5);
    }

    @Override
    public void move() {
        System.out.println("Horizontally or vertically");
    }

    @Override
    public String toString() {
        return "Rook{value= "+getValue()+"}";
    }
}
