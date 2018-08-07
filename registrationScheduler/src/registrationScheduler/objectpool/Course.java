package registrationScheduler.objectpool;

import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

/**
  * Course class stores the information about course that is the 
  * course name and capacity.
  */
public class Course implements CourseInterface{
	
	private String name;
	private int capacity;
	
	/**
	 * Constructor
	 */
	public Course() {
		Logger.writeMessage("Course Constructor is called ", DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * Parameterized constructor
	 * @param capacity_in
	 * @param new_name
	 */
	public Course(int capacity_in, String new_name){
		Logger.writeMessage("Course(parameterized) Constructor is called ", DebugLevel.CONSTRUCTOR);
		this.capacity = capacity_in;
		this.name = new_name;
	}
	
	/**
	 * @return String
	 */
	public String getCourseName() {
		return this.name;
	}
	
	/**
	 * @param String
	 */
	public void setCourseName(String new_name) {
		this.name = new_name;
	}
	
	/**
	 * @return int
	 */
	public int getCapacity() {
		return this.capacity;
	}
	
	/**
	 * 
	 * @param new_capacity
	 */
	public void setCapacity(int new_capacity) {
		this.capacity = new_capacity;
	}
	
	/**
	 * @return String
	 */
	public String toString() {
		return this.name+ " " + this.capacity;
	}


}