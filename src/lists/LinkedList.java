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

	//O(n) = n
	@Override
	public void add(T item)
	{
		Node<T> node = this.first;
		
		if(node == null)
		{
			this.first = new Node(item);
			return;
		}
		
		while(node != null)
		{
			if(!node.hasNext())
			{
				Node temp = new Node(item);
				node.setNext(temp);
				return;
			}
			
			node = node.getNext();
		}
	}

	@Override
	public void insertAt(T item, int index)
	{
		Node<T> node = this.first;
		Node temp = new Node(item);
		
		int i = 0;
		
		if(index == 0)
		{
			temp.setNext(this.first);
			this.first = temp;
			return;
		}
		
		while(node != null)
		{
			if(i == index - 1)
			{
				temp.setNext(node.getNext());
				node.setNext(temp);
				return;
			}
			
			node = node.getNext();
			i++;
		}
		
		throw new IllegalArgumentException("Index is bigger than the size!");
	}

	@Override
	public void removeFrom(int index)
	{
		Node<T> node = this.first;
		
		if(index == 0)
		{
			this.first = this.first.getNext();
			return;
		}
		
		int i = 0;
		
		while(node != null)
		{
			if(i == index - 1)
			{
				if(node.hasNext())
				{
					node.setNext(node.getNext().getNext());
				}
				return;
			}
			
			node = node.getNext();
			i++;
		}
	}

	@Override
	public void remove(T item)
	{
		Node<T> node = this.first;
		
		if(node.getValue().equals(item))
		{
			this.first = this.first.getNext();
		}
		
		while(node != null)
		{
			if(node.hasNext())
			{
				if(node.getNext().getValue().equals(item))
				{
					node.setNext(node.getNext().getNext());
					return;
				}
			}
			
			node = node.getNext();
		}
		
		throw new IllegalArgumentException("There is no such item!");
	}

	@Override
	public T get(int index) {
		Node<T> node = this.first;
		int i = 0;
		
		while(node != null)
		{
			if(i == index)
			{
				return node.getValue();
			}
			
			node = node.getNext();
			i++;
		}
		
		return null;
	}

	@Override
	public void clear()
	{
		this.first = null;
	}

	@Override
	public int size()
	{
		if(this.first == null) return 0;
		
		Node<T> node = this.first;
		int i = 0;
		
		for(; node.hasNext(); i++)
		{
			node = node.getNext();
		}
		
		return i + 1;
	}
}
