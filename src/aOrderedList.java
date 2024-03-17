import java.util.Arrays;

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

public class aOrderedList <T> {
	
	private final int SIZEINCREMENTS = 20; // size used to increment increasing ordered list
	
	private T[] oList; // An array used to aggregate the Cars
	
	private int listSize; // Used to keep track of the current size of the list including null values
	
	private int numObjects;	// Used to keep track of the amount of non-null objects in the array
	
	private int curr; // Used to keep track of the last Car accesses by the next() method
	
	/**
	* Assigns the base amount of objects to 0, sets the list size to SIZEINCREMENTS,
	* prepares the Car[] for objects to add, and sets curr to -1.
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	@SuppressWarnings("unchecked")
	public aOrderedList() {
		numObjects = 0;
		listSize = SIZEINCREMENTS;
		oList = (T[]) new Object[SIZEINCREMENTS];
		curr = -1;
	}
	
	/**
	* If the array needs to allocate more space in order to store the data, this method
	* increases the space availability by SIZEINCREMENTS. It will add a Car object to the list,
	* and maintain a sorted array, increasing the amount of objects in the array.
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public void add(T newObject) {
		if(numObjects == listSize) {
			listSize += SIZEINCREMENTS;
			oList = Arrays.copyOf(oList, listSize);
		}
		oList[numObjects] = newObject;
		numObjects++;
		Arrays.sort(oList, 0, numObjects);
	}
	
	/**
	* Returns the amount of non-null objects in the array.
	*
	* CSC 1351 Programming Project No 1
	* Section 2
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
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public T get(int index) {
		if(index < 0 || index >= numObjects) {
			throw new IndexOutOfBoundsException();
		}
		return oList[index];
	}
	
	/**
	* Returns true if there are no objects in the array, and false otherwise
	*
	* CSC 1351 Programming Project No 1
	* Section 2
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
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public void remove(int index) {
		if(index < 0 || index >= numObjects) {
			throw new IndexOutOfBoundsException();
		}
		
		for(int i = index; i < numObjects - 1; i++) {
			oList[i] = oList[i + 1];
		}
		oList[numObjects - 1] = null;
		numObjects--;
		
		if(numObjects == listSize) {
			listSize -= SIZEINCREMENTS;
			oList = Arrays.copyOf(oList, listSize);
		}
	}
	
	/**
	* Removes the last element returned by the next() method.
	* This method will decrease the numObjects variable, and check to see if space
	* optimization is possible.
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public void remove() {
		if(curr >= 0) {
			remove(curr);
			curr--;
		}
	}
	
	/**
	* Resets the curr value to -1.
	*
	* CSC 1351 Programming Project No 1
	* Section 2
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
	* CSC 1351 Programming Project No 1
	* Section 2
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
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public T next() {
		if(hasNext()) {
			curr++;
			return oList[curr];
		}
		return null;
	}
	
	/**
	* Returns a String representation of the list excluding null values.
	*
	* CSC 1351 Programming Project No 1
	* Section 2
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
