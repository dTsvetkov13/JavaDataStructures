package models;

public class Node<T>
{
	private T value;
	private Node<T> previous;
	private Node<T> next;
	
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
	
	public void setPrevious(Node<T> value)
	{
		if(value != null)
		{
			this.previous = value;
		}
	}
	
	public void setNext(Node<T> value)
	{
		if(value != null)
		{
			this.next = value;
		}
	}
	
	public T getValue()
	{
		return this.value;
	}
	
	public Node<T> getPrevious()
	{
		return this.previous;
	}
	
	public Node<T> getNext()
	{
		return this.next;
	}
	
	public boolean hasNext()
	{
		return this.next == null;
	}
}
