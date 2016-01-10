import java.util.HashMap;
import java.util.Scanner;

public class NumberToWords {

	public static void insertOnes(HashMap<Integer, String> ones)
	{
		ones.put(0, "zero");
		ones.put(1, "one");
		ones.put(2, "two");
		ones.put(3, "three");
		ones.put(4, "four");
		ones.put(5, "five");
		ones.put(6, "six");
		ones.put(7, "seven");
		ones.put(8, "eight");
		ones.put(9, "nine");
		
	}
	public static void insertTens(HashMap<Integer, String> tens)
	{
		
		tens.put(2, "twenty");
		tens.put(3, "thirty");
		tens.put(4, "fourty");
		tens.put(5, "fifty");
		tens.put(6, "sixty");
		tens.put(7, "seventy");
		tens.put(8, "eighty");
		tens.put(9, "ninety");
		tens.put(10, "ten");
		tens.put(11, "eleven");
		tens.put(12, "twelve");
		tens.put(13, "thirteen");
		tens.put(14, "fourteen");
		tens.put(15, "fifteen");
		tens.put(16, "sixteen");
		tens.put(17, "seventeen");
		tens.put(18, "eighteen");
		tens.put(19, "nineteen");
	}
	
	public static int size(long n)
	{
		int co = 0;
		while(n!=0)
		{
			n/=10;
			++co;
		}
		return co;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		long n = sc.nextLong();
		long nc = n;
		int noOfDigits = size(n);
		HashMap<Integer, String> ones = new HashMap<Integer, String>();
		
		HashMap<Integer, String> tens = new HashMap<Integer, String>();
		insertOnes(ones);
		insertTens(tens);
		
		if(noOfDigits == 1)
		{
			System.out.println(ones.get((int)n));
		}
		else if(noOfDigits == 2 && n%100 >9 && n%100 <20)
		{
			System.out.println(tens.get((int)n));
		}
		else
		{
			StringBuilder result = new StringBuilder("");
			long temp;
			int count = 0;
			String r = "";
			while(n!=0)
			{
				result.delete(0, result.length());
				temp = n%10;
				switch (count)
				{	
					case 0:
						if(temp == 0)
							break;
						if(n%100 >9 && n%100<20)
							break;
						result.append(ones.get((int)temp)+"");
						break;
					case 1:
						if(temp == 0)
							break;
						if(temp ==1)
						{
							temp *=10;
							temp += nc%10;
						}
						result.append(tens.get((int)temp)+" ");
						break;
					case 2:
						if(temp == 0)
							break;
						result.append(ones.get((int)temp)+" hundred ");
						break;
					case 3:
						if(temp == 0 || temp == 1)
						{
							if(n > 0 && n < 10)
								result.append(" thousand ");
							break;
						}
						result.append(ones.get((int)temp)+" thousand ");
						break;
					case 4:
						if(temp == 0 )
						{
							break;
						}
						if(temp == 1)
						{
							result.append(ones.get((int)temp)+" ");
							break;
						}
						result.append(tens.get((int)temp)+" ");
						break;
					case 5:
						if(temp == 0 || temp == 1)
						{
							if(n > 0 && n < 10)
								result.append(" lakh ");
							break;
						}
						result.append(ones.get((int)temp)+" lakh ");
						break;
					case 6:
						if(temp == 0 || temp == 1)
						{
							if(n > 0 && n < 10)
								result.append(" million ");
							break;
						}
						result.append(ones.get((int)temp)+" million ");
						break;
					case 7:
						if(temp == 0 || temp == 1)
							break;
						if(temp == 1)
						{
							result.append(ones.get((int)temp)+" ");
							break;
						}
						result.append(tens.get((int)temp)+" ");
						break;
					case 8:
						if(temp == 0 || temp == 1)
						{
							if(n > 0 && n < 10)
								result.append(" billion ");
							break;
						}
						result.append(ones.get((int)temp)+" billion ");
						break;
					case 9:
						if(temp == 0)
							break;
						if(temp == 1)
						{
							result.append(ones.get((int)temp)+" ");
							break;
						}
						result.append(tens.get((int)temp)+" ");
						break;
					case 10:
						if(temp == 0 || temp == 1)
						{
							result.append(" trillion ");
							break;
						}
						result.append(ones.get((int)temp)+" trillion ");
						break;
					case 11:
						if(temp == 0)
							break;
						if(temp == 1)
						{
							result.append(ones.get((int)temp)+" ");
							break;
						}
						result.append(tens.get((int)temp)+" ");
						break;
				}
				r = result.toString() + r;
				count++;
				n/=10;
			}
			System.out.println(r);
		}
	}

}
