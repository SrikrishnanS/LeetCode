/*
2013. Detect Squares

You are given a stream of points on the X-Y plane. Design an algorithm that:

Adds new points from the stream into a data structure. Duplicate points are allowed and should be treated as different points.
Given a query point, counts the number of ways to choose three points from the data structure such that the three points and the query point form an axis-aligned square with positive area.
An axis-aligned square is a square whose edges are all the same length and are either parallel or perpendicular to the x-axis and y-axis.

Implement the DetectSquares class:

DetectSquares() Initializes the object with an empty data structure.
void add(int[] point) Adds a new point point = [x, y] to the data structure.
int count(int[] point) Counts the number of ways to form axis-aligned squares with point point = [x, y] as described above.

*/

class DetectSquares
{
    private Set<List<Integer>> points;
    private int[][] count;

    public DetectSquares()
    {
        this.points  = new HashSet<List<Integer>>();
        this.count   = new int[1001][1001]; // as 0 <= x, y <= 1000
    }

    public void add(int[] p)
    {
        int x = p[0];
        int y = p[1];

        points.add(Arrays.asList(x, y)); // add to set of points
        ++count[x][y]; // increment count for this pair
    }

    public int count(int[] point)
    {
        int result = 0;
        int x1 = point[0];
        int y1 = point[1];

        // iterate over all the points
        for (List<Integer> p : points)
        {
            int x2 = p.get(0);
            int y2 = p.get(1);

            // find the diagonal point, skip points on same x- or y-
            if (x1 == x2 || y1 == y2 ||
                Math.abs(x1 - x2) != Math.abs(y1 - y2))
                continue;

            // We have a point (x2, y2) that can be diagonal
            // opposite point, provided other points are
            // available. Use count to enforce that.
            result += count[x2][y2] * count[x1][y2] * count[x2][y1];
        }
        return result;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
