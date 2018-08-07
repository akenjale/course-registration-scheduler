package registrationScheduler.objectpool;

public interface ObjectPoolInterface {
	public void createMap();
	public boolean getCourseSlot(String course);
	public void returnCourseSlot(String course);
}
