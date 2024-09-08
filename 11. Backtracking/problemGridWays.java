// Find total number of ways to reach from (0,0) to (x,y)
public class problemGridWays {
    public static void main(String[] args) {
        System.out.println(gridWay( 0, 0, 2, 2));
    }

    public static int gridWay(int Row, int Col, int destRow, int destCol) {
        if (Row == destRow && Col == destCol) {
            return 1;
        } else if (Row > destRow || Col > destCol) {
            return 0;
        }
        int totalWays = gridWay(Row+1, Col, destRow, destCol) + gridWay(Row, Col+1, destRow, destCol);
        return totalWays;
    }
}
