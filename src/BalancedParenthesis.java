import java.util.Scanner;
import java.util.Stack;
public class BalancedParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		int i;
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		for(i = 0; i < str.length(); ++i)
		{
			if(str.charAt(i) == '(')
			{
				stack.push(i);
			}
			if(str.charAt(i) == ')')
			{
				if(stack.empty())
				{
					stack.push(i);
				}
				else
				{
					if(str.charAt(stack.peek()) != ')')
						stack.pop();
					else
						stack.push(i);
				}
			}
		}
		System.out.println("Unbalanced Positions in the string entered:");
		for(; stack.empty()==false;)
		{
			System.out.print(stack.pop() + ", ");
		}
		sc.close();
	}

}

