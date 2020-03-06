import enumeration.BoardIcons;

public class Bishop extends Piece {

    public  Bishop(boolean isWhite, Position position){
        super(3, isWhite, position);
    }

    public Bishop(boolean b){
        super(3);
    }

    @Override
    public boolean isValidMove(Position newPosition){
        if ( super.isValidMove(newPosition) &&
                Math.abs(newPosition.getCol() - this.position.getCol()) ==
                Math.abs(newPosition.getRow() - this.position.getRow())){
            return true;
        }
        return  false;
    }

    @Override
    public void move() {
        System.out.println("Diagonally");
    }

    @Override
    public String getIcon(){
        return isWhite ? BoardIcons.WHITE_BISHOP.getCode() : BoardIcons.BLACK_BISHOP.getCode();
    }

    @Override
    public String toString() {
        return "Bishop{value= "+getValue()+"}";
    }
}
