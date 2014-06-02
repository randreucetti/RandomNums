public class BlumBlumSnub	//class for our blum blum snub generator
{
	static long p = 102607L;	//parameter p and q
	static long q = 98867L;
	static long xi = 608431L;	//our seed
	public static long getNext()	//gets the next value in sequence and updates xi
	{
		xi = (xi*xi)%(p*q);
		return xi;
	}
	public static void main(String [] args)	//main method to test it
	{
		MonobitTest mb = new MonobitTest();		//our 3 tests
		PokerTest p = new PokerTest();
		RunsTest r = new RunsTest();
		while(!p.isFinished())	//generate numbers til finished (20000 bits)
		{
			p.process(BlumBlumSnub.getNext());
		}
		while(!mb.isFinished()) //generate numbers til finished (20000 bits)
		{
			mb.process(BlumBlumSnub.getNext());
		}
		while(!r.isFinished()) //generate numbers til finished (20000 bits)
		{
			r.process(BlumBlumSnub.getNext());
		}
		
		
		mb.display();		//prints results
		System.out.println("=========================");
		p.display();
		System.out.println("=========================");
		r.display();
	}
}
