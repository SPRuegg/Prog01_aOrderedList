import java.util.Arrays;
import java.util.Comparator;

/**
 * aOrderedList Class. A customized data structure similar to an
 * ArrayList, designed for keeping a constantly sorted list, no matter
 * what order you add, or remove in.
 * 
 * CSC 1351 Programming Project No 1
 * Section 2
 * 
 * @author Shane Ruegg
 * @since 03/17/24
 * 
 */

public class aOrderedList {
	
	private final int SIZEINCREMENTS = 20; // size used to increment increasing ordered list
	
	private Car[] oList; // An array used to aggregate the Cars
	
	private int listSize; // Used to keep track of the current size of the list including null values
	
	private int numObjects;	// Used to keep track of the amount of non-null objects in the array
	
	private int curr; // Used to keep track of the last Car accesses by the next() method
	
	/**
	* Assigns the base amount of objects to 0, sets the list size to SIZEINCREMENTS,
	* prepares the Car[] for objects to add, and sets curr to -1.
	*
	* CSC 1351 Programming Project No <enter project number here>
	* Section <insert your section number here>
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public aOrderedList() {
		numObjects = 0;
		listSize = SIZEINCREMENTS;
		oList = new Car[SIZEINCREMENTS];
		curr = -1;
	}
	
	/**
	* If the array needs to allocate more space in order to store the data, this method
	* increases the space availability by SIZEINCREMENTS. It will add a Car object to the list,
	* and maintain a sorted array, increasing the amount of objects in the array.
	*
	* CSC 1351 Programming Project No <enter project number here>
	* Section <insert your section number here>
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public void addCar(Comparable<Car> newCar) {
		if(numObjects == listSize) {
			listSize += SIZEINCREMENTS;
			oList = Arrays.copyOf(oList, listSize);
		}
		oList[numObjects] = (Car) newCar;
		numObjects++;
		Arrays.sort(oList, Comparator.nullsLast(Comparator.naturalOrder()));
	}
	
	/**
	* Returns the amount of non-null objects in the array.
	*
	* CSC 1351 Programming Project No <enter project number here>
	* Section <insert your section number here>
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public int size() {
		return numObjects;
	}
	
	/**
	* Returns the object at a given index
	*
	* CSC 1351 Programming Project No <enter project number here>
	* Section <insert your section number here>
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public Comparable<Car> get(int index) {
		return oList[index];
	}
	
	/**
	* Returns true if there are no objects in the array, and false otherwise
	*
	* CSC 1351 Programming Project No <enter project number here>
	* Section <insert your section number here>
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public boolean isEmpty() {
		return numObjects == 0;
	}
	
	
	/**
	* Removes an object at a given index, if it exists. If it does exist, after removing it
	* this method will decrease the numObjects variable, and check to see if space
	* optimization is possible.
	*
	* CSC 1351 Programming Project No <enter project number here>
	* Section <insert your section number here>
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public void remove(int index) {
		if(index >= numObjects || index < 0) {
			return;
		}
		numObjects--;
		oList[index] = null;
		Arrays.sort(oList, Comparator.nullsLast(Comparator.naturalOrder()));
		if(numObjects == listSize) {
			listSize -= SIZEINCREMENTS;
			oList = Arrays.copyOf(oList, listSize);
		}
	}
	
	/**
	* Removes the first instance of an object that shares both the year and make, if it exists.
	* This method will decrease the numObjects variable, and check to see if space
	* optimization is possible.
	*
	* CSC 1351 Programming Project No <enter project number here>
	* Section <insert your section number here>
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public void remove(Comparable<Car> car) {
		Car removal = (Car) car;
		if(removal == null) { 
			return;
		}
		for(int i = 0; i < numObjects; i++) {
			Car currCar = (Car) oList[i];
			if(currCar.getMake().equals(removal.getMake()) && currCar.getYear() == removal.getYear()) {
				remove(i);
				return;
			}
		}
	}
	
	/**
	* Removes the last element returned by the next() method.
	* This method will decrease the numObjects variable, and check to see if space
	* optimization is possible.
	*
	* CSC 1351 Programming Project No <enter project number here>
	* Section <insert your section number here>
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public void remove() {
		remove(next());
	}
	
	/**
	* Resets the curr value to -1.
	*
	* CSC 1351 Programming Project No <enter project number here>
	* Section <insert your section number here>
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public void reset() {
		curr = -1;
	}
	
	/**
	* Returns true if the next element in the array is within [0, numObjects)
	*
	* CSC 1351 Programming Project No <enter project number here>
	* Section <insert your section number here>
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public boolean hasNext() { 
		return (curr + 1) < numObjects;
	}
	
	/**
	* Returns the next element in the array if it exists, otherwise returns null.
	*
	* CSC 1351 Programming Project No <enter project number here>
	* Section <insert your section number here>
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public Car next() {
		if(hasNext()) {
			curr++;
			return oList[curr];
		}
		return null;
	}
	
	/**
	* Returns a String representation of the list excluding null values.
	*
	* CSC 1351 Programming Project No <enter project number here>
	* Section <insert your section number here>
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	@Override
	public String toString() {
		String list = "[";
		for(int i = 0; i < numObjects; i++) {
			list += oList[i] + " ";
		}
		return "" + list.substring(0, list.length() - 1) + "]";
	}
}
