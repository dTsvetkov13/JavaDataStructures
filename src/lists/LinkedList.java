package lists;

import java.util.Arrays;
import interfaces.IList;
import models.Node;

public class LinkedList<T> implements IList<T>
{
	private Node<T> first;
	private Node<T> last;
	
	public LinkedList()
	{
		this.clear();
	}
	
	public LinkedList(Iterable<T> iterable)
	{
		for(T item : iterable)
		{
			this.add(item);
		}
	}
	
	public LinkedList(T[] array)
	{
		this(Arrays.asList(array));
	}
	
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

	//O(1)
	@Override
	public void add(T item)
	{
		if(this.first == null)
		{
			this.first = new Node<T>(item);
		}
		else if(this.last == null)
		{
			this.last = new Node<T>(item);
			this.first.setNext(last);
		}
		else
		{
			Node<T> previousLast = this.last;
			this.last = new Node<T>(item);
			
			previousLast.setNext(last);
		}
	}

	@Override
	public void insertAt(T item, int index)
	{
		Node<T> node = this.first;
		Node<T> temp = new Node(item);
		
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
			if(node.getNext().getValue().equals(item))
			{
				if(node.getNext().hasNext())
				{
					node.setNext(node.getNext().getNext());	
				}
				else
				{
					node.setNext(null);
				}
				
				return;
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
