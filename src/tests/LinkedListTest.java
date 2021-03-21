package tests;

import lists.LinkedList;

public class LinkedListTest
{
	public static void main(String[] args)
	{
		LinkedList<Integer> l = new LinkedList<Integer>();
		
		System.out.print("Entered numbers: ");
		for(int i = 0; i < 3; i++)
		{
			l.add(i);
			System.out.print(i + " ");
		}
		System.out.println();
		
		printLinkedList(l);
		
		System.out.println("Does it contain 1: " + l.contains(1));
		System.out.println("Does it contain 4: " + l.contains(4));
		
		System.out.println("We remove the third number.");
		l.remove(2);
		
		printLinkedList(l);
		
		System.out.println("Clear.");
		l.clear();
		
		printLinkedList(l);
		
		System.out.println("Insert 2 in first position and 4 in second.");
		
		l.insertAt(2, 0);
		l.insertAt(4, 1);
		
		printLinkedList(l);
	}
	
	public static <T> void printLinkedList(LinkedList<T> l)
	{
		System.out.print("Items in the list: ");
		
		for(int i = 0; i < l.size(); i++)
		{
			System.out.print(l.get(i) + " ");
		}
		
		System.out.println();
	}
}
