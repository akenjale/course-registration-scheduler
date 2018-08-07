package registrationScheduler.student;
import java.util.Vector;

import registrationScheduler.studentinterface.StudentInterface;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

public class Student implements StudentInterface{

	private String name;
	private Vector<String> preferences;
	private Vector<String> registeredcourses;
	private Vector<String> addC;
	private Vector<String> dropC;
	private Integer preference_score;
	
	/**
	 * Constructor 
	 */
	public Student() {
		Logger.writeMessage("Student Constructor is called ", DebugLevel.CONSTRUCTOR);
		this.preferences = new Vector<String>(5);
		this.registeredcourses = new Vector<String>(5,1);
		this.addC = new Vector<String>(10,1);
		this.dropC = new Vector<String>(10,1);
		this.preference_score = 0;
	}
	
	/**
	 * @return String
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @param String
	 */
	public void setName(String new_name) {
		this.name = new_name;
	}

	/**
	 * @return {@link Integer}
	 */
	public Integer getPreferenceScore() {
		return this.preference_score;
	} 
	
	/**
	 * 
	 * @return Vector
	 */
	public Vector<String> getPreferences() {
		return preferences;
	}
	
	/**
	 * 
	 * @param preferences (Vector)
	 */
	public void setPreferences(Vector<String> preferences) {
		this.preferences = preferences;
	}
	
	/**
	 * 
	 * @return Vector
	 */
	public Vector<String> getRegisteredcourses() {
		return registeredcourses;
	}
	
	/**
	 * 
	 * @param registeredcourses (Vector)
	 */
	public void setRegisteredcourses(Vector<String> registeredcourses) {
		this.registeredcourses = registeredcourses;
	}
	
	/**
	 * 
	 * @return Vector
	 */
	public Vector<String> getAddC() {
		return addC;
	}
	
	/**
	 * 
	 * @param addC (Vector)
	 */
	public void setAddC(Vector<String> addC) {
		this.addC = addC;
	}
	
	/**
	 * 
	 * @return Vector
	 */
	public Vector<String> getDropC() {
		return dropC;
	}
	
	/**
	 * 
	 * @param dropC (Vector)
	 */
	public void setDropC(Vector<String> dropC) {
		this.dropC = dropC;
	}
	
	/**
	 * 
	 * @return Integer
	 */
	public Integer getPreference_score() {
		return preference_score;
	}
	
	/**
	 * 
	 * @param preference_score
	 */
	public void setPreference_score(Integer preference_score) {
		this.preference_score = preference_score;
	}
	
	@Override
	public String toString() {
		String result="";
		result+= this.name + " ";
		for(String s: this.registeredcourses){
			result+= s+ " ";
		}
		result+=this.preference_score;
		return result;
	}
}