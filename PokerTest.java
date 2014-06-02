
public class PokerTest 
{
	int [] counters;//counts the number of occurrences
	int store; //hold our 4 bits
	int numProcessed; //we want to process 5000;
	boolean finished;
	int bitsAdded;	//how many bits added to store so far
	
	public PokerTest()
	{
		counters = new int[16];	//inits our array
		for(int i=0;i<16;i++)
		{
			counters[i]=0;
		}
		store=0;	//currently empty store
		numProcessed=0;	//not processed any blocks yet
		finished=false;
		bitsAdded=0;
	}
	public void process(long l)	//process a random number
	{
		while(l>0&&!isFinished())	//checks were not finished with number or the test
		{
			if(bitsAdded==4) //have our 4 bits
			{
				counters[store]++;	//increments appropriately
				store=0;	//empties store and bits added
				bitsAdded=0;
				numProcessed++;	
			}
			if(l%2==1)	//if next bit is a 1
			{
				store=(int) (store+Math.pow(2, bitsAdded));
				bitsAdded++;
			}
			else
			{
				bitsAdded++;
			}
			l=l/2;
			if(numProcessed==5000)
			{
				finished=true;
			}
		}
	}
	public boolean isFinished()
	{
		return finished;
	}
	public void display()	//displays the results
	{
		for(int i=0;i<16;i++)
		{
			System.out.println("Number of "+(i+1)+" : "+counters[i]);
		}
		double x=0;
		for(int i=0;i<16;i++)
		{
			x = x+(counters[i]*counters[i]);
		}
		x = x*16/5000;
		x=x-5000;
		System.out.println("X Value: " + x);
	}
}
