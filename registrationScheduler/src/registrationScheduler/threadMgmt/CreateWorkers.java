
package registrationScheduler.threadMgmt;
import registrationScheduler.objectpool.CoursePool;
import registrationScheduler.store.Results;
import registrationScheduler.util.FileProcessorInterface;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

public class CreateWorkers  {

	private Thread[] t;
	private FileProcessorInterface fp;
	private Results r;
	private CoursePool cp;
	
	/**
	 * 
	 * @param fpi (FileProcessor)
	 * @param rin (Results)
	 * @param courses (CoursePool)
	 */
    public CreateWorkers(FileProcessorInterface fpi, Results rin, CoursePool courses){
    	Logger.writeMessage("CreateWorkers Constructor is called ", DebugLevel.CONSTRUCTOR);
    	fp = fpi;
    	r= rin;
    	cp = courses;
    }
    
    /**
     * 
     * @param noOfThreads
     */
    public void startWorkers(int noOfThreads){

    	t = new Thread[noOfThreads];
    	for(int i=0; i < noOfThreads; i++){
    		t[i] = new Thread(new WorkerThread(fp, r, cp));
    		t[i].start();
    	}
	
    	for(int i=0; i < noOfThreads; i++){
    		try {
				t[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(1);
			}
    		finally{

    		}
    	}
	
    }
}
