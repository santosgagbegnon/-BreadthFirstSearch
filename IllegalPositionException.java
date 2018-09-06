     
/**
* The class IllegalPositionException signals that a Color is not a proper color
*/
public class IllegalPositionException extends IllegalArgumentException{

	/**
	* Constructs an IllegalPositionException with no message
	*/
	public IllegalPositionException(){
		super();
	}
	/**
	* Constructs an IllegalPositionException with a message
	*/

	public IllegalPositionException(String message){
		super(message);
	}
}