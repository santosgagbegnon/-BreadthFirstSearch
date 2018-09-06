/**
* The class LinkedQueue represents a generic Queue, implemented with linked elements
*/
public class LinkedQueue<T> implements Queue<T>{
	/**
	* The static class Node represents linked elements with generic elements.
	*/
	private static class Node<E> {
		/**
		* Value stores the value of the generic type given when a Node is made
		*/
		private E value;
		/**
		*Next stores the node given, creating the linked element effect
		*/
		private Node<E> next;
		/**
		*Constructs a Node element with instance variables vaue and next
		*@param value The generic element that will be stored in the value next
		*@param next The node that will be stored inside the Node being made 
		*/
		private Node(E value, Node<E> next){
			this.value = value;
			this.next = next;
		}
	}
	/**
	* Front points to the front of the linked queue 
	*/

	private Node<T> front;
	/**
	* Back point to the back of the linked queue 
	*/
	private Node<T> back;

	/**
	* This method will add the given object to the end of the queue 
	* @param object The object that will be added to the queue
	*/
	public void enqueue(T object){
		Node<T> newNode = new Node<T>(object,null); 
		if(back == null){
			back = newNode;
			front = newNode;
		}
		else{
			back.next = newNode;
			back = newNode;
		}
	}

	/**
	* This method will remove the object that is in the front of the queue and return it.
	* @return Returns the object that was just removed from the queue 
	*/
	public T dequeue(){
		T removedObject = front.value;
		if(front != null && front.next == null){
			front = null;
			back = null;
		}
		else{
			front = front.next;
		}
		return removedObject;
	}
	/**
	* This method will add the given object to the end of the queue 
	* @return Returns true if the queue is empty, and false otherwise
	*/
	public boolean isEmpty(){
		return front == null;
	}
}