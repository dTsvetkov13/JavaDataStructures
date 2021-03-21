package models;

public class DoublyNode<T>
{
	private T value;
	private DoublyNode<T> previous;
	private DoublyNode<T> next;
	
	public DoublyNode()
	{
	}
	
	public DoublyNode(T value)
	{
		this.setValue(value);
	}
	
	public void setValue(T value)
	{
		this.value = value;
	}
	
	public void setNext(DoublyNode<T> value)
	{
		this.next = value;
	}
	
	public T getValue()
	{
		return this.value;
	}
	
	public DoublyNode<T> getNext()
	{
		return this.next;
	}
	
	public boolean hasNext()
	{
		return this.next != null;
	}
	
	public void setPrevious(DoublyNode<T> value)
	{
		this.previous = value;
	}
	
	public DoublyNode<T> getPrevious()
	{
		return this.previous;
	}
}
