package models;

public class Node<T>
{
	private T value;
	private T previous;
	private T next;
	
	public Node()
	{
		
	}
	
	public Node(T value)
	{
		this.setValue(value);
	}
	
	public void setValue(T value)
	{
		if(value != null)
		{
			this.value = value;
		}
	}
	
	public void setPrevious(T value)
	{
		if(value != null)
		{
			this.previous = value;
		}
	}
	
	public void setNext(T value)
	{
		if(value != null)
		{
			this.next = value;
		}
	}
	
	public void getValue(T value)
	{
		if(value != null)
		{
			this.value = value;
		}
	}
	
	public void getPrevious(T value)
	{
		if(value != null)
		{
			this.previous = value;
		}
	}
	
	public void getNext(T value)
	{
		if(value != null)
		{
			this.next = value;
		}
	}
}
