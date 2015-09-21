// Jonathan Parks jqp


public class HW1_8
{
	public static void main(String[] args)
	{
		System.out.println(Qa(5));
		System.out.println(Qa(50));
		System.out.println(Qa(500));

		System.out.println(Qb(5));
		System.out.println(Qb(50));
		System.out.println(Qb(500));

		System.out.println(Qc(5));
		System.out.println(Qc(50));
		System.out.println(Qc(500));	
	}

	public static long Qa(int n)
	{
		long startTime = System.nanoTime();
		long sum = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < i; j++)
				sum++;
		long endTime = System.nanoTime();
		return (endTime - startTime);
	}

	public static long Qb(int n)
	{
		long startTime = System.nanoTime();
		long sum = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < i*i; j++)
				for (int k = 0; k < j; k++)
					sum++;
		long endTime = System.nanoTime();
		return (endTime - startTime);
	}

	public static long Qc(int n)
	{
		long startTime = System.nanoTime();
		long sum = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < i*i; j++)
				if (j % i == 0)
					for (int k = 0; k < j; k++)
						sum++;
		long endTime = System.nanoTime();
		return (endTime - startTime);
	}


}
