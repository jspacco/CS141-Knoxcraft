

public class TestKnoxcraft
{
    public static void drawSkyscraper() {
        BlockType[][][] grid = new BlockType[8][6][40];
        for (int floor=0; floor<10; floor++){
            for (int x=0; x<grid.length; x++){
                for (int z=0; z<grid[x].length; z++){
                    grid[x][z][floor*4] = BlockType.IRON_BLOCK;
                    grid[x][z][floor*4 + 1] = BlockType.GLASS;
                    grid[x][z][floor*4 + 2] = BlockType.GLASS;
                    grid[x][z][floor*4 + 3] = BlockType.GLASS;
                }
            }
        }
        BlockWriter.writeLandscapeToFile(grid, "test.json");
    }
    
    public static void drawSkyscraper2() {
        // this one has the floors hollowed out
        BlockType[][][] grid = new BlockType[8][6][40];
        for (int y=0; y<40; y++){
            for (int x=0; x<grid.length; x++){
                for (int z=0; z<grid[x].length; z++){
                    if (y % 4 == 0) {
                        grid[x][z][y] = BlockType.IRON_BLOCK;
                    } else if ((x==1 || x==6) && (z>0 &&  z<5)) {
                        // System.out.println("x = "+x+", z= "+z+", y="+y);
                        grid[x][z][y] = BlockType.GLASS;
                    } else if (x > 0 && x < 8 && z == 4){
                        grid[x][z][y] = BlockType.GLASS;
                    }
                }
            }
        }
        BlockWriter.writeLandscapeToFile(grid, "sky2.json");
    }

    public static void main(String[] args) throws Exception {
        drawSkyscraper();
        System.out.println("DONE");
    }

}
