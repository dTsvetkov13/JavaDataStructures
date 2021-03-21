package tests;

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
		
		for(int i = 0; i < l.size(); i++)
		{
			System.out.println(l.get(i));
		}
	}

}
