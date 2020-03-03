public class Bishop extends Piece {

    public  Bishop(boolean isWhite){
        super(3,isWhite);
    }

    public Bishop(){
        super(3);
    }

    @Override
    public void move() {
        System.out.println("Diagonally");
    }

    @Override
    public String toString() {
        return "Bishop{value= "+getValue()+"}";
    }
}
