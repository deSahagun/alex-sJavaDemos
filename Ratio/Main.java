public class Main
{
	public static void main(String[] args)
	{

		float rangeOne= 1.00f;
		float rangeTwo= 24.0f;
		TimeObject first = new TimeObject(rangeOne, rangeTwo);

		float openOne = 6.00f;
		float openTwo = 10.00f; 
		TimeObject second = new TimeObject(openOne, openTwo);
		float res1 = ratioOpen(first, second);
		System.out.println("first restaurant's result " + res1);

		//****************************************************

		float r1 = 7.00f; 
		float r2 = 18.00f;

		TimeObject third = new TimeObject(r1,r2);

		float o1 = 4.00f;
		float o2 = 8.00f;

		TimeObject fourth = new TimeObject(o1,o2);

		float res2 = ratioOpen(third, fourth);

		System.out.println("Second restaurant's result " + res2);

		//*********************************************************

		float oRange = 14.00f;
		float cRange = 21.00f;

		TimeObject yelpCheck = new TimeObject(oRange, cRange);
		
		float resOpen = 2.00f; 
		float resClose = 4.30f;

		TimeObject resHours = new TimeObject(resOpen, resClose);
 		
		float diffRanges = ratioOpen(yelpCheck, resHours);

		System.out.println("Different range results " + diffRanges);


	}



	static float ratioOpen(TimeObject range, TimeObject open)
	{
		float ratio = 0f; //initialize the float  

		//get the overlapping time range 
		float left =  Math.max(range.start, open.start);
		float right = Math.min(range.end, open.end); 


		System.out.println(left + "  " + right);

		if(Math.max(open.start, range.start) <= Math.min(open.end, range.end))
		{
			  ratio = (right - left) / (range.end - range.start);
	                  return ratio;	
		}


		else{
			return 0f; 
		}

		//calculate the ratio here 
		//ratio = (right - left) / (range.end - range.start);

		//return ratio;
	}

}


class TimeObject
{
	float start;
	float end;

	TimeObject(float start, float end)
	{
		this.start = start;
		this.end   = end;
	}


}


