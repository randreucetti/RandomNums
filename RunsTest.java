
public class RunsTest 
{
	private int [] oneCounters;//stores 1s length 1-6+..
	private int [] zeroCounters;//stores 0s length 1-6+..
	private long totalBits;
	private boolean finished;
	private int consecutiveBits;
	private int numLongRuns;
	private boolean currentlyOne;
	
	public RunsTest() //inits our variables
	{	
		oneCounters = new int[6];
		for(int i=0;i<6;i++)
		{
			oneCounters[i]=0;
		}
		zeroCounters = new int[6];
		for(int i=0;i<6;i++)
		{
			zeroCounters[i]=0;
		}
		totalBits=0;
		finished=false;
		consecutiveBits=0;
		currentlyOne = false;
		numLongRuns = 0;
	}
	public void process(long l)	//process a number
	{
		while(l>0&&!isFinished())
		{
			if(l%2==1)
			{
				if(currentlyOne)//run continues
				{
					consecutiveBits++;
				}
				else//run ends
				{
					if(consecutiveBits!=0)
					{
						if(consecutiveBits<6)
						{
							oneCounters[consecutiveBits-1]++; //update appropriate counter
						}
						else
						{
							oneCounters[5]++;//anything above
							if(consecutiveBits==34)
							{
								numLongRuns++;	//looks for long runs
							}
						}
					}
					consecutiveBits=0;
					consecutiveBits++;
					currentlyOne=true;
				}
			}
			else
			{
				if(!currentlyOne)//run continues
				{
					consecutiveBits++;
				}
				else//run ends
				{
					if(consecutiveBits!=0)
					{
						if(consecutiveBits<6)
						{
							zeroCounters[consecutiveBits-1]++; //updates appropriate counter
						}
						else
						{
							zeroCounters[5]++;//anything above
							if(consecutiveBits==34)
							{
								numLongRuns++; //looks for long runs
							}
						}
					}
					consecutiveBits=0;
					consecutiveBits++;
					currentlyOne=false;
				}
			}
			totalBits++;
			l=l/2;
			if(totalBits==20000)		//all done
			{
				finished=true;
			}
		}
	}
	public boolean isFinished()
	{
		return finished;
	}
	public void display()	//print results
	{
		System.out.println("-------Zeros-------");
		for(int i=0;i<6;i++)
		{
			System.out.println("Length "+(i+1)+" : "+zeroCounters[i]);
		}
		System.out.println("-------Ones-------");
		for(int i=0;i<6;i++)
		{
			System.out.println("Length "+(i+1)+" : "+oneCounters[i]);
		}
		System.out.println("----------------------");
		System.out.println("Number of long runs: "+numLongRuns);
	}
}
