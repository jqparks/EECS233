// Jonathan Parks jqp
// Annotates an array of numbers so that any number:
// Divisible by 3 is replaced with "Fizz"
// Divisible by 5 is replaced with "Buzz"
// Divisible by both is replaced with "FizzBuzz"

public class Annotation
{
	// Fields
	private int value;

	// Main method
	public static void main(String[] args)
	{
		if (args.length == 2)
		{
			int start = Integer.parseInt(args[0]);
			int end = Integer.parseInt(args[1]);
			String output = annotateList(start, end);
			System.out.println(output);
		}
		else
		{
			System.out.println("Please input a range to fizzbuzz");
		}
	

	}

	// Constructors
	// Default constructor; assumes value is zero
	public Annotation()
	{
		value = 0;	
	}

	// Stores integer n as value
	public Annotation(int n)
	{
		value = n;
	}


	// Methods
	// Returns the value of the stored integer
	public int getn()
	{
		return value;
	}

	// Returns annotated FizzBuzz string for current value
	public String toString()
	{
		Integer temp = getn();
		String output = temp.toString();
	
		if (value % 3 == 0)
		{
			output = "Fizz";
			if (value % 5 == 0)
			{
				output += "Buzz";
			}
		}
		else if (value % 5 == 0)
		{
			output = "Buzz";
		}

		output += " ";
		return output;
	}

	// Takes a range of numbers and annotates using FizzBuzz notation
	public static String annotateList(int start, int end)
       	{
		String output = "";

		for (int i = start; i <= end; i++)
		{
			Annotation fizzbuzz = new Annotation(i);
			output += fizzbuzz.toString();
		}

		return output;
	}
}
