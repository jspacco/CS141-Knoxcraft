import org.knoxcraft.turtle3d.KCTBlockTypes;
import org.knoxcraft.turtle3d.Turtle3D;

import static org.knoxcraft.turtle3d.KCTBlockTypes.*;

public class SpriteWriter
{
    private KCTBlockTypes[] grid;
    private int index;
    private int numRows;
    private int numCols;
    
    public KCTBlockTypes getBlock(int row, int col) {
        return grid[row*numCols + col];
    }
    
    public KCTBlockTypes[][] getGrid() {
        KCTBlockTypes[][] result=new KCTBlockTypes[numRows][numCols];
        for (int r=0; r<numRows; r++){
            for (int c=0; c<numCols; c++){
                result[r][c]=getBlock(r,c);
            }
        }
        return result;
    }
    
    public SpriteWriter(int rows, int cols) {
        this.numRows = rows;
        this.numCols = cols;
        this.grid = new KCTBlockTypes[rows*cols];
        this.index = 0;
    }
    
    public void write(KCTBlockTypes block, int numBlocks) {
        for (int i=0; i<numBlocks; i++) {
            grid[index] = block;
            index++;
        }
    }
    
    public void nextRow() {
        if (index%numCols==0){
            return;
        }
        index=(index/numCols+1)*numCols;
    }
    
    public void skip(int numBlocks) {
        index += numBlocks;
    }
    
    public static KCTBlockTypes[][] link() {
        KCTBlockTypes flesh=SANDSTONE;

        SpriteWriter w=new SpriteWriter(16, 13);
        // row 1
        w.skip(4);
        w.write(GREEN_WOOL, 6);
        w.nextRow();
        
        // row 2
        w.skip(3);
        w.write(GREEN_WOOL, 8);
        w.nextRow();

        // row 3
        w.skip(1);
        w.write(flesh, 1);
        w.skip(1);
        w.write(GREEN_WOOL, 1);
        w.write(BROWN_WOOL, 6);
        w.write(GREEN_WOOL, 1);
        w.skip(1);
        w.write(flesh, 1);
        w.nextRow();
        
        // row 4
        w.skip(1);
        w.write(flesh, 1);
        w.skip(1);
        w.write(BROWN_WOOL, 8);
        w.skip(1);
        w.write(flesh, 1);
        w.nextRow();
        
        // row 5
        w.skip(1);
        w.write(flesh, 2);
        w.write(BROWN_WOOL, 1);
        w.write(flesh, 1);
        w.write(GREEN_WOOL, 1);
        w.write(flesh, 2);
        w.write(GREEN_WOOL, 1);
        w.write(flesh, 1);
        w.write(BROWN_WOOL, 1);
        w.write(flesh, 2);
        w.nextRow();
        
        // row 6
        w.skip(1);
        w.write(flesh, 2);
        w.write(BROWN_WOOL, 1);
        w.write(flesh, 1);
        w.write(WHITE_WOOL, 1);
        w.write(flesh, 2);
        w.write(WHITE_WOOL, 1);
        w.write(flesh, 1);
        w.write(BROWN_WOOL, 1);
        w.write(flesh, 2);
        w.nextRow();
        
        // row 7
        w.skip(2);
        w.write(flesh, 10);
        w.write(BROWN_WOOL, 1);
        w.nextRow();
        
        // row 8
        w.skip(3);
        w.write(GREEN_WOOL, 1);
        w.write(flesh, 2);
        w.write(BROWN_WOOL, 2);
        w.write(flesh, 2);
        w.write(GREEN_WOOL, 1);
        w.write(BROWN_WOOL, 2);
        w.nextRow();
        
        // row 9
        w.skip(1);
        w.write(BROWN_WOOL, 5);
        w.write(flesh, 3);
        w.write(GREEN_WOOL, 3);
        w.write(flesh, 1);
        w.nextRow();
        
        // row 10
        w.write(BROWN_WOOL, 2);
        w.write(YELLOW_WOOL, 1);
        w.write(BROWN_WOOL, 4);
        w.write(GREEN_WOOL, 5);
        w.write(flesh, 1);
        w.nextRow();
        
        // row 11
        w.write(BROWN_WOOL, 1);
        w.write(YELLOW_WOOL, 3);
        w.write(BROWN_WOOL, 2);
        w.write(flesh, 1);
        w.write(BROWN_WOOL, 2);
        w.write(GREEN_WOOL, 2);
        w.write(BROWN_WOOL, 1);
        w.nextRow();

        // row 12
        w.write(BROWN_WOOL, 2);
        w.write(YELLOW_WOOL, 1);
        w.write(BROWN_WOOL, 3);
        w.write(flesh, 1);
        w.write(GREEN_WOOL, 1);
        w.write(BROWN_WOOL, 3);
        w.write(GREEN_WOOL, 1);
        w.nextRow();
        
        // row 13
        w.write(BROWN_WOOL, 2);
        w.write(YELLOW_WOOL, 1);
        w.write(BROWN_WOOL, 3);
        w.write(flesh, 1);
        w.write(BROWN_WOOL, 2);
        w.write(GREEN_WOOL, 3);
        w.nextRow();
        
        // row 14
        w.write(BROWN_WOOL, 6);
        w.write(flesh, 1);
        w.write(GREEN_WOOL, 3);
        w.write(BROWN_WOOL, 1);
        w.nextRow();
        
        // row 15
        w.skip(1);
        w.write(flesh, 5);
        w.skip(2);
        w.write(BROWN_WOOL, 3);
        w.nextRow();
        
        // row 16
        w.skip(8);
        w.write(BROWN_WOOL, 3);
        
        return w.getGrid();
    }

    public static void main(String[] args) {
        Turtle3D t=Turtle3D.createTurtle("link");
        KCTBlockTypes[][] grid=link();
        drawStanding(grid, t);

    }
    
    public static void drawStanding(KCTBlockTypes[][] grid, Turtle3D t) {
        t.setBlockPlace(false);
        t.up(grid.length);
        for (int r=0; r<grid.length; r++) {
            for (int c=0; c<grid[r].length; c++) {
                // get the turtle to the right location
                // place one block
                if (grid[r][c]==null) {
                    t.setBlockPlace(true);
                    t.setBlock(AIR);
                    t.forward(1);
                } else {
                    t.setBlockPlace(true);
                    t.setBlock(grid[r][c]);
                    t.forward(1);
                }
            }
            t.setBlockPlace(false);
            t.backward(grid[r].length);
            t.down(1);
        }
    }


}
