public class LCG 
{
	static long a = 1664525L;	//parameters for generator
	static long c = 1013904223L;
	static long m = 4294967296L;
	static long xi = 7253L;		//seed
	
	static long getNext()		//gets the next value for x
	{
		xi = (a*xi+c)%m;
		return  (xi);
	}
	
	public static void main(String [] args)
	{
		MonobitTest mb = new MonobitTest();	//our tests
		PokerTest p = new PokerTest();
		RunsTest r = new RunsTest();
		while(!p.isFinished())//generate numbers til finished (20000 bits)
		{
			p.process(LCG.getNext());
		}
		while(!mb.isFinished())//generate numbers til finished (20000 bits)
		{
			mb.process(LCG.getNext());
		}
		while(!r.isFinished())//generate numbers til finished (20000 bits)
		{
			r.process(LCG.getNext());
		}
		
		
		mb.display();
		System.out.println("=========================");
		p.display();
		System.out.println("=========================");
		r.display();		
	}
}
