import java.util.*;

public class Main
{


	public static void main(String [] args)
	{
		System.out.println("Hello World!");		

		Restaurants[] rest = {new Restaurants("In n out", 10),
				      new Restaurants("Chic fil a", 8),
				      new Restaurants("Chipotle", 4),
				      new Restaurants("The Habbit",9)};


                //Collections.sort(rest, Comparator.comparingInt(p->p.score);
		//System.out.println(Arrays.asList(rest));

		Arrays.sort(rest);		


		for(Restaurants temp: rest)
		{
			System.out.println(temp.score + " " + temp.nameOfPlace);
		}

	}
		
}



class Restaurants implements Comparable<Restaurants>
{
	public String nameOfPlace; 
        public int score; 

	public Restaurants(String nameOfPlace, int score)
	{
		this.nameOfPlace = nameOfPlace; 
		this.score	 = score; 
	}

	@Override
	public int compareTo(Restaurants other)
	{
	        return this.score == other.score ? 0 : this.score > other.score ? 1 : -1;
	}
	
}
