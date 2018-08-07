
package registrationScheduler.threadMgmt;

import registrationScheduler.objectpool.CoursePool;
import registrationScheduler.scheduler.Scheduler;
import registrationScheduler.store.Results;
import registrationScheduler.student.Student;
import registrationScheduler.util.FileProcessorInterface;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

public class WorkerThread implements Runnable  {

	String line = null;
	private FileProcessorInterface fp;
	private Results r;
	private CoursePool cp;
	private Scheduler sch = new Scheduler();
	
	/**
	 * Constructor
	 */
    public WorkerThread() {
    	Logger.writeMessage("WorkerThread Constructor is called ", DebugLevel.CONSTRUCTOR);
    }
    
    /**
     * Parameterized constructor
     * @param fpin (FileProcessor)
     * @param rin (Results)
     * @param cpin (CoursePool)
     */
    public WorkerThread(FileProcessorInterface fpin, Results rin, CoursePool cpin) {
    	Logger.writeMessage("WorkerThread Constructor is called ", DebugLevel.CONSTRUCTOR);
    	fp = fpin;
		r = rin;
		cp = cpin;
	}
    
    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
	public void run() {
		Logger.writeMessage(Thread.currentThread().getName()+" run method is called ", DebugLevel.IN_RUN);

    	while((line=fp.readLineFromFile1()) != null){
    		String[] parts = line.split(" ");
    		Student s = new Student();
    		s.setName(parts[0]);
    		for(int i = 0; i<5; i++){
    			s.getPreferences().add(parts[i+1]);
    		}
    		sch.scheduleStudent(s, r, cp);
    		r.getMap().put(s.getName(),s);
    	}
	
    	while((line=fp.readLineFromFile2()) != null){
    		Student s=null;
    		String[] parts = line.split(" ");
    		for (int i=0; i<parts.length;i++){
    			s = r.getMap().get(parts[0]);
    			for(int j =2; j<parts.length; j++){
    				if(parts[1].equals("1")) {
    					s.getAddC().add(parts[j]);
    				}
    				if(parts[1].equals("0")) {
    					s.getDropC().add(parts[j]);
    				}
    			}
    		}
    		sch.scheduleAddDrop(s, r, cp);
    	} 	
    }
   
}
