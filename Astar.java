import java.util.PriorityQueue;
import java.util.Stack;

public class Astar {


    public static class Pair {
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Pair && this.first == ((Pair)obj).first && this.second == ((Pair)obj).second;
        }
    }

    public static class Details {
        double value;
        int i;
        int j;

        public Details(double value, int i, int j) {
            this.value = value;
            this.i = i;
            this.j = j;
        }
    }

    public static class Cell {
        public Pair parent;
        public double f, g, h;
        Cell()
        {
            parent = new Pair(-1, -1);
            f = -1;
            g = -1;
            h = -1;
        }

        public Cell(Pair parent, double f, double g, double h) {
            this.parent = parent;
            this.f = f;
            this.g = g;
            this.h = h;
        }
    }

    boolean isValid(int[][] grid, int rows, int cols,
                    Pair point)
    {
        if (rows > 0 && cols > 0)
            return (point.first >= 0) && (point.first < rows)
                    && (point.second >= 0)
                    && (point.second < cols);

        return false;
    }


    boolean isUnBlocked(int[][] grid, int rows, int cols,
                        Pair point)
    {
        return isValid(grid, rows, cols, point)
                && grid[point.first][point.second] == 1;
    }

    boolean isDestination(Pair position, Pair dest)
    {
        return position == dest || position.equals(dest);
    }

    double calculateHValue(Pair src, Pair dest)
    {
        return Math.sqrt(Math.pow((src.first - dest.first), 2.0) + Math.pow((src.second - dest.second), 2.0));
    }


    void tracePath(
            Cell[][] cellDetails,
            int cols,
            int rows,
            Pair dest)
    {   //A* Search algorithm path
        System.out.println("The Path:  ");

        Stack<Pair> path = new Stack<>();

        int row = dest.first;
        int col = dest.second;

        Pair nextNode = cellDetails[row][col].parent;
        do {
            path.push(new Pair(row, col));
            nextNode = cellDetails[row][col].parent;
            row = nextNode.first;
            col = nextNode.second;
        } while (cellDetails[row][col].parent != nextNode); // until src


        while (!path.empty()) {
            Pair p = path.peek();
            path.pop();
            System.out.println("-> (" + p.first + "," + p.second + ") ");
        }
    }


    void aStarSearch(int[][] grid,
                     int rows,
                     int cols,
                     Pair src,
                     Pair dest)
    {

        if (!isValid(grid, rows, cols, src)) {
            System.out.println("Source is invalid...");
            return;
        }


        if (!isValid(grid, rows, cols, dest)) {
            System.out.println("Destination is invalid...");
            return;
        }


        if (!isUnBlocked(grid, rows, cols, src)
                || !isUnBlocked(grid, rows, cols, dest)) {
            System.out.println("Source or destination is blocked...");
            return;
        }


        if (isDestination(src, dest)) {
            System.out.println("We're already (t)here...");
            return;
        }


        boolean[][] closedList = new boolean[rows][cols];//our closed list

        Cell[][] cellDetails = new Cell[rows][cols];

        int i, j;
        i = src.first;
        j = src.second;
        cellDetails[i][j] = new Cell();
        cellDetails[i][j].f = 0.0;
        cellDetails[i][j].g = 0.0;
        cellDetails[i][j].h = 0.0;
        cellDetails[i][j].parent = new Pair( i, j );




        PriorityQueue<Details> openList = new PriorityQueue<>((o1, o2) -> (int) Math.round(o1.value - o2.value));


        openList.add(new Details(0.0, i, j));

        while (!openList.isEmpty()) {
            Details p = openList.peek();
            i = p.i;
            j = p.j;

            openList.poll();
            closedList[i][j] = true;


            for (int addX = -1; addX <= 1; addX++) {
                for (int addY = -1; addY <= 1; addY++) {
                    Pair neighbour = new Pair(i + addX, j + addY);
                    if (isValid(grid, rows, cols, neighbour)) {
                        if(cellDetails[neighbour.first] == null){ cellDetails[neighbour.first] = new Cell[cols]; }
                        if (cellDetails[neighbour.first][neighbour.second] == null) {
                            cellDetails[neighbour.first][neighbour.second] = new Cell();
                        }

                        if (isDestination(neighbour, dest)) {
                            cellDetails[neighbour.first][neighbour.second].parent = new Pair ( i, j );
                            System.out.println("The destination cell is found");
                            tracePath(cellDetails, rows, cols, dest);
                            return;
                        }

                        else if (!closedList[neighbour.first][neighbour.second]
                                && isUnBlocked(grid, rows, cols, neighbour)) {
                            double gNew, hNew, fNew;
                            gNew = cellDetails[i][j].g + 1.0;
                            hNew = calculateHValue(neighbour, dest);
                            fNew = gNew + hNew;

                            if (cellDetails[neighbour.first][neighbour.second].f == -1
                                    || cellDetails[neighbour.first][neighbour.second].f > fNew) {

                                openList.add(new Details(fNew, neighbour.first, neighbour.second));


                                cellDetails[neighbour.first][neighbour.second].g = gNew;
                                cellDetails[neighbour.first][neighbour.second].h = hNew;
                                cellDetails[neighbour.first][neighbour.second].f = fNew;
                                cellDetails[neighbour.first][neighbour.second].parent = new Pair( i, j );
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Failed to find the Destination Cell");
    }

    public static void main(String[] args) {


        int[][] grid = {
                { 1, 1, 0, 0, 1, 0, 0, 0 },
                { 1, 0, 0, 1, 1, 0, 1, 0 },
                { 1, 1, 0, 1, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 0, 0, 1, 1, 1 },
                { 0, 1, 1, 1, 0, 1, 1, 0 },
                { 1, 1, 0, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1 }

        };


        Pair src = new Pair(0,0);

        Pair dest = new Pair(6, 6);

        Main app = new Main();

        app.aStarSearch(grid, grid.length , grid[0].length, src, dest);

    }
}

