package interfaces;

public interface ISortedList<T>
{
	boolean isEmpty(); 

	boolean contains(T item); 

	void add(T item);

	void removeFrom(int index);

	void remove(T item);

	T get(int index);

	void clear();
	
	int size();
}
