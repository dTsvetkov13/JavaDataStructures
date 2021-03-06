package lists;

import interfaces.IList;
import models.Node;

public class LinkedList<T> implements IList<T>
{
	private Node<T> first;
	
	@Override
	public boolean isEmpty()
	{
		if(first == null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(T item)
	{
		Node<T> node = this.first;
		
		while(node != null)
		{
			if(node.getValue() == item)
			{
				return true;
			}
			
			node = node.getNext();
		}
		
		return false;
	}

	@Override
	public void add(T item)
	{
		Node<T> node = this.first;
		
		while(node != null)
		{
			if(!node.hasNext())
			{
				Node temp = new Node(item);
				temp.setPrevious(node);
				
				node.setNext(temp);
				return;
			}
			
			node = node.getNext();
		}
	}

	@Override
	public void insertAt(T item, int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFrom(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(T item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
