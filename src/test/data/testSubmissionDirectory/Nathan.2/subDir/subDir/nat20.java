
public class nat20 {
	int a = 1,b = 1,c = 0;
	public static void main(String args[])
	{
		nat20 fibo = new nat20();
		for (int i = 0; i < 10 ; i++)
		{
		fibo.Fibonacci();
		}
	}
	
	public void Fibonacci()
	{
		System.out.println(a + "\t" + b );
		c = a + b; 
		a = b; 
		b = c;
	}
}