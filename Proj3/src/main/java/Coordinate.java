/**
 * Encapsulates the row and column of one cell in a 2-D coordinate system.
 * Class Invariants: The row and column are nonnegative, coordinate objects are immutable
 */
public class Coordinate {

    private int row;
    private int column;

    /**
     * Constructs a new Coordinate from the specified row and column
     * Parameters:
     * @param row - the row (zero based)
     * @param column - the column (zero based)
     */
    public Coordinate(int row, int column){
        if (row < 0 || column < 0){
            throw new RuntimeException("Row or column must be nonnegative");
        }
        this.row = row;
        this.column = column;
    }

    /**
     * Accessor for the column.
     * @return the column
     */
    public int getColumn(){
        return this.column;
    }

    /**
     * Accessor for the row.
     * @return the row
     */
    public int getRow(){
        return this.row;
    }

}
