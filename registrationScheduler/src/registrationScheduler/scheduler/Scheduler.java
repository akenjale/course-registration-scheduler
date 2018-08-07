package registrationScheduler.scheduler;
import java.util.Map.Entry;

import registrationScheduler.objectpool.Course;
import registrationScheduler.objectpool.CoursePool;
import registrationScheduler.schedulerinterface.SchedulerInterface;
import registrationScheduler.store.Results;
import registrationScheduler.student.Student;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

/**
  * Scheduler class is where the course is assigned to the students
  * according to their preference.
  */
public class Scheduler implements SchedulerInterface{
	
	/**
	 * Constructor
	 */
	public Scheduler() {
		Logger.writeMessage("Scheduler Constructor is called ", DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * This method does the scheduling for each student for inputfile1. It allocates
	 * the preferred course if it is not full else it allocates the 
	 * other course out of the course pool which is not full.
	 * @param sin (Student object)
	 * @param rin (Results object)
	 * @param cpin (CoursePool object)
	 */
	public synchronized void scheduleStudent(Student sin, Results rin, CoursePool cpin){
		for(int i=0; i<sin.getPreferences().size(); i++){
			if(cpin.getCourseSlot(sin.getPreferences().get(i))){
				sin.getRegisteredcourses().add(i,sin.getPreferences().get(i));
				sin.setPreference_score(sin.getPreference_score()+6-i);
			}
			else{
				for(Entry<String, Course> entry : cpin.map.entrySet()){
					if(!sin.getRegisteredcourses().contains(entry.getKey()) && !sin.getPreferences().contains(entry.getKey()) && cpin.getCourseSlot(entry.getKey())){
						sin.getRegisteredcourses().add(i, entry.getKey());
						sin.setPreference_score(sin.getPreference_score()+ 1);
						break;
					}
				}
			}
		}
	}
	
	/**
	 * This method does the scheduling for inputfile2. It checks 
	 * whether the courses to be added are already allocated to the
	 * student. If not then the course is added to the registered
	 * courses of the student. It also checks whether the course
	 * to be dropped is present in the students registered courses
	 * or not. If yes then it drops the particular courses given in
	 * the inputfile2.
	 * @param sin (Student object)
	 * @param rin (Results object)
	 * @param cpin (CoursePool object)
	 */
	public synchronized void scheduleAddDrop(Student sin, Results rin, CoursePool cpin){
		if(sin.getAddC()!=null){
			for(int i=0; i<sin.getAddC().size(); i++) {
				if(!sin.getRegisteredcourses().contains(sin.getAddC().get(i)) && cpin.getCourseSlot(sin.getAddC().get(i))){
					sin.getRegisteredcourses().add(sin.getAddC().get(i));
					sin.setPreference_score(sin.getPreference_score()+ 1);
				}
			}
		}
		if(sin.getDropC()!=null){
			for(int i=0; i<sin.getDropC().size(); i++) {
				if(sin.getRegisteredcourses().contains(sin.getDropC().get(i))){
					sin.getRegisteredcourses().remove(sin.getDropC().get(i));
					cpin.returnCourseSlot(sin.getDropC().get(i));
				}
			}
		}
	}
	
	@Override
	public String toString(){
		return "Scheduler";
	}

}