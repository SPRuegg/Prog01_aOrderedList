/**
 * Car Object Class, that allows for making, a Car given three params,
 * and providing access to those params. Implements the Comparable Interface
 * allowing for the Arrays.sort() method to sort accordingly.
 * 
 * CSC 1351 Programming Project No 1
 * Section 2
 * 
 * @author Shane Ruegg
 * @since 03/17/24
 * 
 */

public class Car implements Comparable<Car> {
	
	private String make; // A String representation of the make of the Car
	private int year; // An integer that represents the year of the Car
	private int price; // An integer that represents the price of the Car
	
	/**
	* Assigns the data values for the Car's make, year, and price
	*
	* CSC 1351 Programming Project No <enter project number here>
	* Section <insert your section number here>
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public Car(String make, int year, int price) {
		this.make = make;
		this.year = year;
		this.price = price;
	}
	
	/**
	* Returns the make of the Car
	*
	* CSC 1351 Programming Project No <enter project number here>
	* Section <insert your section number here>
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public String getMake() {
		return make;
	}
	
	/**
	* Returns the year of the Car
	*
	* CSC 1351 Programming Project No <enter project number here>
	* Section <insert your section number here>
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public int getYear() {
		return year;
	}
	
	/**
	* Returns the price of the Car
	*
	* CSC 1351 Programming Project No <enter project number here>
	* Section <insert your section number here>
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public int getPrice() {
		return price;
	}
	
	/**
	* An Implementation of the Comparable Interface, returns an integer less than 0
	* if the Car it is compared to is greater than that of the Car the method is called on.
	* returns an integer equal to 0 if the Car it is compared to is identical to the Car
	* the method is called on(ignoring price), or returns an integer greater than 0 if
	* the Car it is compared to is lower than that of the Car the method is called on.
	*
	* CSC 1351 Programming Project No <enter project number here>
	* Section <insert your section number here>
	*
	* @author Shane Ruegg
	* @since 03/17/24
	*
	*/
	public int compareTo(Car Other) {
		if(make.compareTo(Other.make) != 0) {
			return make.compareTo(Other.make);
		}
		return Integer.compare(year, Other.year);
	}
	
	/**
	* Returns a String representation of the Car.
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
		return String.format("Make: %s, Year: %d, Price: %d", make, year, price);
	}
}
