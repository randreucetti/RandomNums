
public class MonobitTest //checks 20000 bits for randomness
{
	private long num1s;	//number of 1s present
	private long totalBits;
	private boolean finished;
	public MonobitTest()
	{
		num1s=0L;
		totalBits=0L;
		finished = false;
	}
	public void process(long l)
	{
		while(l>0&&!isFinished())
		{
			if(l%2==1)	//if bit is one
			{
				num1s++;
			}
			totalBits++;
			l=l/2;
			if(totalBits==20000)
			{
				finished=true;
			}
		}
	}
	public void display()
	{
		System.out.println("Total Bits: "+totalBits);
		System.out.println("Number of 1s: "+num1s);
	}
	public boolean isFinished()
	{
		return finished;
	}
}
