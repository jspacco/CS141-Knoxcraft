

public class TestKnoxcraftLandscape
{
    public static void drawSkyscraper() throws Exception {
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
    

    public static void main(String[] args) throws Exception {
        drawSkyscraper();
        System.out.println("DONE");
    }

}
