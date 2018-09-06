/**
* The class IllegalColorException signals that a Color is not a proper color
*/
public class IllegalColorException extends IllegalArgumentException{
	/**
	* Constructs an IllegalColorException wth no message
	*/

	public IllegalColorException(){
		super();
	}

	/**
	* Constructs an IllegalColorException wth a message
	*/
	public IllegalColorException(String message){
		super(message);
	}
}