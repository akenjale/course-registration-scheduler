package registrationScheduler.schedulerinterface;

import registrationScheduler.objectpool.CoursePool;
import registrationScheduler.store.Results;
import registrationScheduler.student.Student;

public interface SchedulerInterface {
	public void scheduleStudent(Student s, Results r, CoursePool cp);
	public void scheduleAddDrop(Student s, Results r, CoursePool cp);
}