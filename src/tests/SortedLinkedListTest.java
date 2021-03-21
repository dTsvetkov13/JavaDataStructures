package tests;

import lists.LinkedList;
import lists.SortedLinkedList;

public class SortedLinkedListTest
{

	public static void main(String[] args)
	{
		SortedLinkedList<Integer> l = new SortedLinkedList<Integer>();
		
		l.add(5);
		l.add(6);
		l.add(6);
		l.add(2);
		l.add(1);
		l.add(7);
		l.add(6);
		
		printSortedLinkedList(l);
		
		l.remove(6);
		l.remove(1);
		l.removeFrom(0);
		l.removeFrom(3);
		
		printSortedLinkedList(l);
	}
	
	public static <T extends Comparable<T>> void printSortedLinkedList(SortedLinkedList<T> l)
	{
		System.out.print("Items in the list: ");
		
		for(int i = 0; i < l.size(); i++)
		{
			System.out.print(l.get(i) + " ");
		}
		
		System.out.println();
	}
}
