import java.util.*;

class StacksUsingQueues
{ 
	static Queue<Integer> q1 = new LinkedList<Integer>(); 
	static Queue<Integer> q2 = new LinkedList<Integer>(); 
	
	static int size; 

	StacksUsingQueues() 
	{ 
		size=0; 
	} 

	static void push(int x) 
	{ 
		size++; 

		q2.add(x); 

		while (!q1.isEmpty())
		{ 
			q2.add(q1.peek()); 
			q1.remove(); 
		} 

		Queue<Integer> q=q1; 
		q1=q2; 
		q2=q; 
	} 

	static void pop() 
	{ 
		if(q1.isEmpty()) 
			return; 
		q1.remove(); 
		size--; 
	} 

	static int top() 
	{ 
		if(q1.isEmpty()) 
			return -1; 
		return q1.peek(); 
	}  

public static void main(String[] args) 
{ 
	StacksUsingQueues a = new StacksUsingQueues(); 
	a.push(1); 
	a.push(2); 
	a.push(3); 

	System.out.println(a.top()); 
	a.pop(); 
	System.out.println(a.top()); 
	a.pop(); 
	System.out.println(a.top()); 
} 
} 