public class Queen extends Piece {

    public  Queen(boolean isWhite){
        super(9,isWhite);
    }

    public Queen(){
        super(9);
    }

    @Override
    public void move() {
        System.out.println("Like bishop and rook");
    }

    @Override
    public String toString() {
        return "Queen{value= "+getValue()+"}";
    }
}
