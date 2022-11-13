/* 733. Flood Fill

An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.
 */
class Solution 
{
    private void floodFill(int [][] image, int row, int col, int val, int newval)
    {
        if (row < 0 || row >= image.length ||
            col < 0 || col >= image[0].length ||
            image[row][col] != val)
            return;

        image[row][col] = newval; // fill current slot
        floodFill(image, row - 1, col, val, newval); // previous row
        floodFill(image, row, col - 1, val, newval); // previous column
        floodFill(image, row + 1, col, val, newval); // next row
        floodFill(image, row, col + 1, val, newval); // next column
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) 
    {
        if (image[sr][sc] == newColor)
            return image;
        floodFill(image, sr, sc, image[sr][sc], newColor);  
        return image;
    }
}
