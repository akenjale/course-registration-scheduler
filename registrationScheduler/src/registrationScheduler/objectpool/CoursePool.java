package registrationScheduler.objectpool;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

public class CoursePool implements ObjectPoolInterface{

	public Map<String, Course> map;
	private volatile static CoursePool uniqueInstance;
	
	/**
	 * Constructor
	 */
	private CoursePool(){
		Logger.writeMessage("CoursePool Constructor is called ", DebugLevel.CONSTRUCTOR);
		createMap();
	}
	
	/**
	 * Creates ConcurrentHashMap with course name as key and course 
	 * object as value.
	 */
	public void createMap(){
		map = new ConcurrentHashMap<String, Course>();
		
		Course course1 = new Course(60, "A");
		Course course2 = new Course(60, "B");
		Course course3 = new Course(60, "C");
		Course course4 = new Course(60, "D");
		Course course5 = new Course(60, "E");
		Course course6 = new Course(60, "F");
		Course course7 = new Course(60, "G");
		Course course8 = new Course(60, "H");
		
		map.put("A", course1);
		map.put("B", course2);
		map.put("C", course3);
		map.put("D", course4);
		map.put("E", course5);
		map.put("F", course6);
		map.put("G", course7);
		map.put("H", course8);
	}
	
	/**
	 * Gives unique instance of CoursePool.
	 * @return CoursePool
	 */
	public static synchronized CoursePool getInstance(){
		if(null == uniqueInstance)
		{
			uniqueInstance = new CoursePool();
		}
		return uniqueInstance;
	}
	
	/**
	 * 
	 */
	@Override
	public synchronized boolean getCourseSlot(String course) {
		if(map!=null && map.get(course)!=null && map.get(course).getCapacity()>0){
			map.get(course).setCapacity(map.get(course).getCapacity()-1);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * 
	 */
	@Override
	public synchronized void returnCourseSlot(String course) {
		if(map!=null && map.get(course)!=null){
			map.get(course).setCapacity(map.get(course).getCapacity()+1);
		}
	}

}
