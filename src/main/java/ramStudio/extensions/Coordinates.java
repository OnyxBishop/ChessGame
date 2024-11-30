package ramStudio.extensions;

public class Coordinates {
    private byte column;
    private byte row;

    public Coordinates(byte column, byte row){
        this.column = column;
        this.row = row;
    }

    public void change(byte column, byte row){
        if(column < 0 || row < 0)
            throw new RuntimeException("Coords cannot be smaller than 0");
    }
}
