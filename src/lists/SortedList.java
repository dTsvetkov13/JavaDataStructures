package lists;

import interfaces.IList;
import models.Node;

public class SortedList<T extends Comparable<T>> implements IList<T>
{
	private Node<T> first;
	private int count;
	
	public SortedList()
	{
		
	}
	
	@Override
	public boolean isEmpty()
	{
		return this.count <= 0;
	}

	// O(n) complexity
	@Override
	public boolean contains(T item)
	{
		if(this.first == null) return false;
		
		Node<T> currentNode = this.first;
		
		while(currentNode != null)
		{
			if(currentNode.getValue().equals(item))
			{
				return true;
			}
			
			currentNode = currentNode.getNext();
		}
		
		return false;
	}

	@Override
	public void add(T item)
	{
	}

	@Override
	public void insertAt(T item, int index)
	{
	}

	@Override
	public void removeFrom(int index)
	{	
	}

	@Override
	public void remove(T item)
	{	
	}

	@Override
	public T get(int index)
	{
		return null;
	}

	@Override
	public void clear()
	{
		this.first = null;
		this.count = 0;
	}

	@Override
	public int size()
	{
		return this.count;
	}

}
