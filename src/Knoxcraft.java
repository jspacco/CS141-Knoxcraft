
public class Knoxcraft
{
    public static void main(String[] args)
    {
        // change the dimensions if you'd like
        int width=10;
        int length=5;
        int height=10;
        BlockType[][][] grid = new BlockType[width][length][height];
        // TODO: Build an awesome 3D structure
        
        BlockWriter.writeLandscapeToFile(grid, "rename-this-file.json");
    }
}
