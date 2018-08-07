
package registrationScheduler.driver;

import java.io.File;

import registrationScheduler.objectpool.CoursePool;
import registrationScheduler.store.Results;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.FileProcessorInterface;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

public class Driver{

	
	public static void main(String args[]) {
	    Driver dr = new Driver();
	    dr.validateArgs(args);

	    System.out.println("\n Geting Started\n");
	    
	    Results r = new Results();
	    FileProcessorInterface fpi = new FileProcessor(args[0],args[1]);
	    CoursePool cp = CoursePool.getInstance();
	    CreateWorkers cw = new CreateWorkers(fpi, r, cp);
	    cw.startWorkers(Integer.parseInt(args[3]));
	    r.writeScheduleToStdout();
	    r.writeSchedulesToFile(args[2]);
	    Logger.writeMessage("The average preference value is "+r.averagePreferenceScore(r.getMap()), DebugLevel.RELEASE);

	} // end main(...)
	
	private void validateArgs(String args[]){
		//validate number of arguments
		if(args.length==5){
		    // get file names
			
			try{
				String inputfile1 = args[0];
				File file;
				file = new File(inputfile1);
				if(!file.exists() || !file.canRead() || null==inputfile1){
					System.err.println("The input file does not exist or is null.");
					System.exit(1);
				}
				String inputfile2 = args[1];
				file = new File(inputfile2);
				if(!file.exists() || !file.canRead() || null==inputfile1){
					System.err.println("The input file does not exist or is null.");
					System.exit(1);
				}
				String outputfile = args[2];
				if(null==outputfile){
					System.err.println("Please provide a valid .txt filename as argument.");
					System.exit(1);
				}
				Integer NUM_THREADS = Integer.parseInt(args[3]);
				if(NUM_THREADS < 1 || NUM_THREADS > 3){
					System.out.println("The value of the 4th argument must be between 1 and 3.");
					System.exit(1);
				}
				Integer debuglevel = Integer.parseInt(args[4]);
				Logger.setDebugValue(debuglevel);
				
			    // use Integer.parseInt(args[3]);
			    // use debuglevel=Integer.parseInt(args[4]);
			    //validate range of threads and debug level
			    // Set the Logger level
			    // return 

			}catch(IllegalArgumentException ex){
				System.err.println("NumberFormatException-Cannot parse to integer.");
				ex.printStackTrace();
				System.exit(1);
			}
			catch(Exception ex){
				System.err.println("Exception occured.");
				ex.printStackTrace();
				System.exit(1);
			}
			finally{

			}
		}else{
			System.err.println("Invalid number of arguments. Expected [FIXME: provide details here]");
			System.exit(1);
		}
	}

    

} // end public class Driver

