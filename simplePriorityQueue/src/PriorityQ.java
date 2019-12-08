/**
 * Created by Alex on 7/11/19.
 */

import java.util.*;

public class PriorityQ
{
    public static void main(String args[])
    {
        PriorityQueue<Integer> pQ = new PriorityQueue<Integer>((x,y)->y-x);

        pQ.add(100);
        pQ.add(2);
        pQ.add(3);
        pQ.add(17);


        while(!pQ.isEmpty()){
            System.out.println(pQ.poll());

        }


        State one = new State(4);
        State two = new State(100);


        PriorityQueue<State> stateQ = new PriorityQueue<State>((x,y)-> x.maxScore - y.maxScore);

        stateQ.add(one);
        stateQ.add(two);

        System.out.println();

        while(!stateQ.isEmpty())
        {
            System.out.println(stateQ.poll());

        }



        State three = new State(8);
        State four  = new State(1000);

        stateQ.add(three);
        stateQ.add(four);




    }


}

class State{

    int maxScore;

    public State(int maxScore)
    {
        this.maxScore = maxScore;
    }


    public String toString(){
        return Integer.toString(maxScore);
    }

}