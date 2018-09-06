     
/** 
*The interface Queue insures the methods that implememnt have all the valid methods of a queue.
*/
public interface Queue<T> {
	void enqueue(T object);
	T dequeue();
	boolean isEmpty();
}