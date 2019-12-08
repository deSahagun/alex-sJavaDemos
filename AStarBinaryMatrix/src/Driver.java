//import java.util.LinkedList;
//import java.util.PriorityQueue;
//import java.util.Queue;

//shortestPathBinaryMatrix

import java.util.*;
/**
 * Created by Alex on 7/11/19.
 */


public class Driver {

    public static int rowNum[] = {-1, -1, 0, 0, 1, 1, -1, 1};
    public static int colNum[] = {-1, 0, -1, 1, 0, 1, 1, -1}; //all posibilities


    public static void main(String[] args)
    {

        int[][] firstTest = {{0,1}, {1,0}};

        int[][] secondTest = {{0,0,0,0,1},
                {0,1,1,0,0},
                {1,1,1,0,0},
                {1,1,0,1,0},
                {1,0,1,0,0}};

        int[][] thirdTest  = {{0,0,0,0,1},
                {0,1,1,0,0},
                {1,1,1,0,0},
                {1,1,0,1,0},
                {1,0,1,0,0}}; //


        //it fails this one by one
        int[][] fourthTest = {{0,0,0,0,0,0,0,0},
                              {0,0,0,0,0,1,0,0},
                              {0,0,0,1,0,0,0,1},
                              {0,0,1,0,0,0,0,1},
                              {0,0,0,0,0,0,0,0},
                              {0,0,0,0,0,0,0,0},
                              {0,0,0,0,1,0,1,0},
                              {0,0,0,1,0,0,1,0}};

        int[][] fifthTest = {{0,1,0,1,0,0,0,0},
                             {0,0,0,0,0,1,0,0},
                             {0,0,0,0,0,0,0,0},
                             {1,0,0,0,1,1,1,0},
                             {0,1,0,0,1,0,1,0},
                             {1,1,0,0,0,0,0,0},
                             {0,0,1,1,0,1,0,0},
                             {1,0,0,0,0,1,1,0}};

        int[][] sixthTest = {{0,0,1,0,0,0,0},
                             {0,1,0,0,0,0,1},
                             {0,0,1,0,1,0,0},
                             {0,0,0,1,1,1,0},
                             {1,0,0,1,1,0,0},
                             {1,1,1,1,1,0,1},
                             {0,0,1,0,0,0,0}};

        //long total = 0;


            long startTime = System.nanoTime();

            //int first = AStar(firstTest);
            //System.out.println("Printing the first result: " + first);

            //System.out.println();

            //int second = AStar(secondTest);
            //System.out.println("Printing the second result: " + second);

            //System.out.println();


            //int third = AStar(thirdTest);
            //System.out.println("Printing the third result: " + third);


            //System.out.println();

            //double fourth = AStar(fourthTest);
            //System.out.println("Printing the fourth result: " + fourth);


            //System.out.println();

            //int sixth = AStar(sixthTest);
            //System.out.println("Printing the sixth result: " + sixth);

            System.out.println();
            System.out.println("Printing the big one ");

            int seventh = AStar(seventhTest);


            long endTime = System.nanoTime();

            long duration= (endTime - startTime) / 1000000; //in milliseconds

            System.out.println(duration);




    }


    //cordinateValid to check to see if something is within the params
    static Boolean cordinateValid(int row, int col, int rowLength, int columnLength)
    {

        if((row >= 0) && (row <= rowLength) && (col >= 0) && (col <= columnLength))
            return true;

        return false;
    }




    //try to keep the width and height equal
    public static int AStar(int[][] grid)
    {

        int rowLength    = grid.length; //goal for height or y axis
        int columnLength = grid[0].length;

        if((grid[0][0] == 1) || (grid[rowLength-1][columnLength-1] == 1))
        {
            System.out.println("Cannot solve this binary Maze");
            return -1;
        }

        //int bestScore = 99999;
        int counter = 0;


        boolean visited[][] = new boolean[rowLength][columnLength];
        visited[0][0] = true;


        PriorityQueue<vertex> pQ = new PriorityQueue<vertex>(new Checker());

        int countExpand = 0;


        Point p1 = new Point(0,0);
        vertex root = new vertex(p1, 0, rowLength-1, columnLength-1, null);

        pQ.add(root);


        while(!pQ.isEmpty())
        {

            vertex curr = pQ.poll();
            Point pt = curr.pt;

            countExpand++;

            //check to see if end goal
            if(pt.x == rowLength -1 && pt.y == columnLength -1)
            {

                while(curr != null)
                {
                    counter++;
                    //System.out.print("Path: " + curr.toString());
                    curr = curr.Parent;

                }


                // uncomment this to print path and path cost
                System.out.println(countExpand + " number of expanded");
                System.out.println("Total Path count is: " + counter);


                 return counter;
            }



            //pQ.poll(); //remove since i already have a copy


            for(int i = 0; i < 8; i++)
            {
                int row = pt.x + rowNum[i];
                int col = pt.y + colNum[i];

                if(cordinateValid(row, col, rowLength-1, columnLength-1) == true)
                {

                    if((grid[row][col] == 0) && (visited[row][col] == false))
                    {
                        visited[row][col] = true;
                        Point p2 = new Point(row, col);
                        vertex neighbor = new vertex(p2, curr.distance + 1, rowLength-1,columnLength- 1, curr);
                        pQ.add(neighbor);

                        //totalSteps++;
                    }

                }

            }

        }


        return -1;
    }

}

//this could also have my state and a pointer to parent
class Point
{
    int x;
    int y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

}

//compare the vertices and order them by score 
class Checker implements Comparator<vertex>
{
    public int compare(vertex obj1, vertex obj2)
    {
        if(obj1.score > obj2.score) return 1;

        else return -1;

    }

}


class vertex
{
    Point pt; //cordinates of a cell
    int distance; //cells distance from the source
    int height;
    int width;
    float score;

    vertex Parent;

    //this is the vertex which holds the important data 
    public vertex(Point pt, int distance, int height, int width, vertex Parent)
    {
        this.distance = distance;
        this.pt       = pt;
        this.width    = width;
        this.height   = height;
        this.Parent   = Parent;

        this.score = getScore();

    }


    //calculate the heuristic 
    public float getScore()
    {
          //euclids formula for getting distance between two paths

          float yE = (float) Math.pow(this.pt.y - height, 2.f);

          float xE = (float) Math.pow(this.pt.x - width, 2.f);

          float sq = (float) Math.sqrt(yE + xE);

          //System.out.println(this.distance);

          return sq - this.distance; //  (g(n) - h(n))
    }



    @Override
    public String toString()
    {
        String xy = new String ("");

        xy  = Integer.toString(pt.x);
        xy += " ";
        xy += Integer.toString(pt.y);

        xy += " score: ";
        xy += this.score;
        xy += "\n";

        return xy;
    }
}
