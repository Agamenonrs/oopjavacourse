import java.util.Objects;

public abstract class Piece {

    private int value;
    private boolean isWhite;

    public Piece(int value, boolean isWhite){
        this(value);
        this.isWhite = isWhite;
    }

    public Piece(int value){
        this.value = value;
    }

    public abstract void move();

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "value=" + value +
                ", isWhite=" + isWhite +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return value == piece.value &&
                isWhite == piece.isWhite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, isWhite);
    }
}
