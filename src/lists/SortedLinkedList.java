package lists;

import interfaces.ISortedList;
import models.DoublyNode;

public class SortedLinkedList<T extends Comparable<T>> implements ISortedList<T>
{
	private DoublyNode<T> first;
	private int count;
	
	public SortedLinkedList()
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
		
		DoublyNode<T> currentNode = this.first;
		
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

	// O(n) complexity
	@Override
	public void add(T item)
	{
		if(this.first == null)
		{
			this.first = new DoublyNode<T>(item);
			this.count++;
			return;
		}
		
		DoublyNode<T> currentNode = this.first;
		
		while(currentNode != null && 
			  currentNode.getValue().compareTo(item) < 0)
		{
			if(currentNode.hasNext())
			{
				currentNode = currentNode.getNext();	
			}
			else break;
		}
		
		if(!currentNode.hasNext())
		{
			DoublyNode<T> toAdd = new DoublyNode<T>(item);
			currentNode.setNext(toAdd);
			toAdd.setPrevious(currentNode);
			this.count++;
			return;
		}
		
		if(this.first.equals(currentNode))
		{
			DoublyNode<T> toAdd = new DoublyNode<T>(item);
			toAdd.setNext(currentNode);
			currentNode.setPrevious(toAdd);
			
			this.first = toAdd;
			this.count++;
			return;
		}
		
		DoublyNode<T> toAdd = new DoublyNode<T>(item);
		toAdd.setNext(currentNode);
		toAdd.setPrevious(currentNode.getPrevious());
		
		currentNode.getPrevious().setNext(toAdd);
		currentNode.setPrevious(toAdd);
		this.count++;
	}

	@Override
	public void removeFrom(int index)
	{
		if(this.first == null)
		{
			throw new RuntimeException("The list is empty.");
		}
		
		if(index < 0)
		{
			throw new IllegalArgumentException("Index cannot be negative number.");
		}
		
		if(index == 0)
		{
			this.first = this.first.getNext();
			this.count--;
			return;
		}
		
		DoublyNode<T> currentNode = this.first.getNext();
		
		int counter = 1;
		
		while(currentNode != null && counter < index)
		{
			currentNode = currentNode.getNext();
			counter++;
		}
		
		if(currentNode == null || counter != index)
		{
			throw new IllegalArgumentException("Invalid index.");	
		}
		
		currentNode.getPrevious().setNext(currentNode.getNext());
		this.count--;
	}
	
	//O(n) complexity
	@Override
	public void remove(T item)
	{
		if(this.first == null)
		{
			throw new RuntimeException("The list is empty.");
		}
		
		if(this.first.getValue().equals(item))
		{
			this.first = this.first.getNext();
			this.count--;
			return;
		}
		
		DoublyNode<T> currentNode = this.first.getNext();
		
		while(currentNode != null)
		{
			if(currentNode.getValue().equals(item))
			{
				currentNode.getPrevious().setNext(currentNode.getNext());
				this.count--;
				return;
			}
			
			currentNode = currentNode.getNext();
		}
		
		throw new IllegalArgumentException("The list does not contain such item.");
	}
	
	// O(n) complexity
	@Override
	public T get(int index)
	{
		if(this.first == null) throw new IllegalArgumentException("Invalid index");
		
		DoublyNode<T> currentNode = this.first;
		int i = 0;
		
		while(currentNode != null)
		{
			if(i == index)
			{
				break;
			}
			
			currentNode = currentNode.getNext();
			i++;
		}
		
		if(i < index)
		{
			throw new IllegalArgumentException("Invalid index");
		}
		
		return currentNode.getValue();
	}

	// O(1) complexity
	@Override
	public void clear()
	{
		this.first = null;
		this.count = 0;
	}
	
	// O(1) complexity
	@Override
	public int size()
	{
		return this.count;
	}

}
