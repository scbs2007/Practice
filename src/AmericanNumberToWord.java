import java.util.HashMap;
import java.util.Scanner;

public class AmericanNumberToWord {

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
	
	public static StringBuilder number(int size, int temp, HashMap<Integer, String> ones, HashMap<Integer, String> tens)
	{
		int rem;
		StringBuilder res = new StringBuilder();
		if(size == 3)
		{
			if(temp /100 != 0)
			{
				res.append(ones.get(temp/100));
				res.append(" hundred ");
				temp %= 100;
			}
			else
			{
				temp %= 100;
			}
			if(temp/10 !=0)
			{
				rem = temp %10;
				if(temp /10 ==1|| (temp/10 ==2 && temp%10 ==0))
				{
					if(temp/10 ==2)
						temp/=10;
				
					res.append(tens.get(temp));
				}
				else
				{
					res.append(tens.get(temp/10));
					temp %=10;
					res.append(ones.get(temp));
				}
			}
			else
			{
				temp %=10;
				if(temp !=0)
				{
					res.append(ones.get(temp));
				}
			}
			
		}
		else 
		{
			if(size ==2)
			{
				if(temp /10 ==1 || (temp/10 ==2 && temp%10 ==0))
				{
					if(temp/10 ==2)
						temp/=10;
					res.append(tens.get(temp));
				}
				else
				{
					if(temp/10 !=0)
					{
						res.append(tens.get(temp /10));
						rem = temp % 10;
						temp/=10;
						res.append(ones.get(rem));
					}
				}
			}
			else
			{
				if(temp !=0)
					res.append(ones.get(temp));
			}
		}
		return res;
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
		StringBuilder res = new StringBuilder("");
		
		int count;
		if(noOfDigits > 9)
			count =3;
		else if(noOfDigits > 6 && noOfDigits <10)
			count  = 2;
		else if(noOfDigits > 3 && noOfDigits <7)
			count = 1;
		else 
			count = 0;
		int temp;
		
		while(count>=0)
		{
			temp = (int)(nc/((int)(Math.pow(1000, count))));
			int size = size(temp);
			int length = res.toString().length();
			switch(count)
			{
			
			case 0:
				res.append(number(size, temp, ones, tens));
				break;
			case 1:
				res.append(number(size, temp, ones, tens));
				if(length - res.toString().length()!=0)
				res.append(" thousand ");
				break;
			case 2:
				res.append(number(size, temp, ones, tens));
				if(length - res.toString().length()!=0)
				res.append(" million ");
				break;
			case 3:
				res.append(number(size, temp, ones, tens));
				if(length - res.toString().length()!=0)
				res.append(" trillion ");
				break;
			}

			nc = (long)nc%((int)(Math.pow(1000, count)));
			count -=1;
		}
		System.out.println(res.toString());
	}

}
