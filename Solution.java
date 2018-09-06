      
/**
* A solution is a data structure that stores 1-4 cubes. It represents a partial solution to the instant insanity puzzle
*/
public class Solution {
	/**
	* Cubes stores the cubes in the solution
	*/
	private Cube[] cubes; 
	/**
	* Keeps track of the number of calls that have been made to any of the isValid() methods
	*/
	private static int numberOfCalls = 0;
	/**
	*Constructs a solution with the array of cubes given. Note: if the given array is larger than 4, the first 4 cubes will taken and the rest will be left out.
	*@param cubes A list of cubes to create a solution with
	*@throws IllegalStateException if a null cube is in the given cubes array
	*/

	public Solution(Cube[] cubes){
		if(cubes == null) {
			throw new NullPointerException();
		}

		int length = cubes.length;
		for(int i = 0; i < cubes.length; i++){
			if( cubes[i] == null){
				throw new IllegalStateException("Null is not a valid cube.");
			}
		}

		if(length > 4){
			this.cubes = new Cube[4];
			for(int i = 0; i < 4; i++){
				this.cubes[i] = cubes[i].copy();
			}
		}else{
			this.cubes = new Cube[cubes.length];
			for(int i = 0; i < length; i++){
				this.cubes[i] = cubes[i].copy();
			}
		}
	}
	/**
	*Constructs a new solution by creating a deep copy of the solution, and if there are less than 4 cubes in the given solution, the cube given will be added to the new solution
	*@param other The solution that will be duplicated
	*@param c The cube that will be added to the new solution, if there is room.
	*/
	public Solution(Solution other, Cube c){
		int length = 0;
		int index = -1;
		boolean willIncrease = false;
		if(c == null){
			throw new NullPointerException("Cube is null");
		}

		if(other != null){
			if(other.cubes.length < 4){
				this.cubes = new Cube[other.cubes.length+1];
				willIncrease = true;
			}
			else{
				this.cubes = new Cube[4];
			}

			for(int i = 0; i < other.cubes.length; i++){
				this.cubes[i] = other.cubes[i].copy();
				index++;
			}

			if(willIncrease){
				this.cubes[index+1] = c.copy();
			}
		}else{
			this.cubes[0] = c.copy();
			Solution.numberOfCalls = 0;
		}
	}

	/**
	*Determines if the solution is valid (each side of the piles of cubes have no dupicate colors, excluding the top and bottom)
	*@return Returns true if the solution is vaid and false otherwise
	*/
	public boolean isValid(){
		boolean valid = true;
		for(int j = 0; j < cubes.length - 1; j++){
			for(int k = j+1; k < cubes.length; k ++){
				if(cubes[j].getLeft() == cubes[k].getLeft()){
					valid = false;
					break;
				}
				if(cubes[j].getFront() == cubes[k].getFront()){
					valid = false;
					break;
				}
				if(cubes[j].getRight() == cubes[k].getRight()){
					valid = false;
					break;
				}
				if(cubes[j].getBack() == cubes[k].getBack()){
					valid = false;
					break;
				}
			}
		}
		Solution.numberOfCalls++;
		return valid;
	}

	/**
	*Determines if the solution will remain valid if the cube passed in is added.(each side of the piles of cubes have no dupicate colors, excluding the top and bottom)
	*@return Returns true if the solution will remain valid when the given cube is added. 
	*/
	public boolean isValid(Cube next){
		if(next == null){
			throw new NullPointerException("Null is not a valid parameter");
		}
		int length = cubes.length + 1;
		Cube[] copyOfCubes = new Cube[length];

		for(int i = 0; i < length-1; i++){
			copyOfCubes[i] = cubes[i].copy();
		}

		copyOfCubes[length-1] = next.copy();
		Solution tempSolution = new Solution(copyOfCubes);

		numberOfCalls++;

		return tempSolution.isValid();
	}
	/**
	* Getter for the size of the solution (The number of cubes in the solution)
	* @return Returns the size of solution
	*/

	public int size(){
		return cubes.length;
	}

	/**
	* Getter for a cube at a certain position
	* @param pos The position of the cube wanted 
	* @return Returns the cube in the solution at the given position
	* @throws IllegalPositionException if the position given in the parameter is < 0 or larger than the length of the solution
	*/

	public Cube getCube(int pos){
		if(pos >= cubes.length || pos < 0){
			throw new IllegalPositionException(pos + " is an invalid position");
		}
		return cubes[pos];

	}
	/**
	*Getter for the static variable numerOfCalls 
	*@return Returns the number of calls to the method isValid
	*/
	public static int getNumberOfCalls(){
		return Solution.numberOfCalls;
	}
	/**
	* Resets the static variable numberOfCalls to 0
	*/
	public static void resetNumberOfCalls(){
		Solution.numberOfCalls = 0;
	}
	/**
	*Builds a string representation of the solution
	*@return Returns the string representation of the solution
	*/
	public String toString(){
		String temp;
		temp  = "[";
		for(int i = 0; i < this.cubes.length -1; i++){
			temp += this.cubes[i] + ", \n";
		}
		temp += this.cubes[cubes.length -1] + "]";
		return temp;
	}

}