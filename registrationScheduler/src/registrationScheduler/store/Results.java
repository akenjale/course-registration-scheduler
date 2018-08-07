
package registrationScheduler.store;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import registrationScheduler.student.Student;
import registrationScheduler.util.FileDisplayInterface;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;
import registrationScheduler.util.StdoutDisplayInterface;
import registrationScheduler.util.StringComparator;

public class Results implements StdoutDisplayInterface, FileDisplayInterface {

    // private data structure
	private Map<String, Student> map;
	private Map<String, Student> sorted_map;
	
	/**
	 * Constructor
	 */
	public Results() {
		Logger.writeMessage("Results Constructor is called ", DebugLevel.CONSTRUCTOR);
		setMap(new ConcurrentHashMap<String, Student>());
	}
    // methods to read/write from/to the data structure
	
	/**
	 * Sorts the results ConcurrentHashMap by Student name
	 * @param mapin (Map interface variable)
	 * @return Treemap
	 */
	public Map<String, Student> sortByName(Map<String, Student> mapin) {
		Map<String ,Student> sorted_map = new TreeMap<String, Student>(new StringComparator());
		sorted_map.putAll(mapin);
		return sorted_map;
	}
    
	/**
	 * 
	 * @param map (Map interface variable)
	 * @return double
	 */
	public double averagePreferenceScore(Map<String, Student> map) {
		double aveg;
		double total=0;
		for(Entry<String, Student> entry: map.entrySet()){
    		total += entry.getValue().getPreference_score();
    	}
		aveg = (double)total/80;
		
		return aveg;	
	}
	
	/**
	 * Writes the result to the screen.
	 */
	@Override
    public void writeScheduleToStdout() {
	//    	Logger.writeMessage(??, Logger.DebugLevel.??;
    	Map<String, Student> result = sortByName(getMap());
    	
    	for(Entry<String, Student> entry: result.entrySet()){
    		System.out.println(entry.getValue());
    	}
    	
    	System.out.println("Average preference_score is: "+ averagePreferenceScore(result));
    }
    
    /**
     * Writes the results to the output file.
     */
    @Override
    public void writeSchedulesToFile(String outFileName){
    	FileWriter filewriter =null;
		try {
			filewriter = new FileWriter(outFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	BufferedWriter bw = new BufferedWriter(filewriter);
    	Map<String, Student> result = sortByName(getMap());
    	for(Entry<String, Student> entry: result.entrySet()){
    		try {
				bw.write(entry.getValue().toString()+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	try {
			bw.write("Average preference_score is: "+ averagePreferenceScore(result));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    /**
     * 
     * @return TreeMap object
     */
	public Map<String, Student> getSorted_map() {
		return sorted_map;
	}
	
	/**
	 * 
	 * @param sorted_map (Map interface variable)
	 */
	public void setSorted_map(Map<String, Student> sorted_map) {
		this.sorted_map = sorted_map;
	}
	
	/**
	 * 
	 * @return ConcurrentHashMap object
	 */
	public Map<String, Student> getMap() {
		return map;
	}

	/**
	 * 
	 * @param map (ConcurrentHashMap object)
	 */
	public void setMap(Map<String, Student> map) {
		this.map = map;
	}
	
	/**
	 * Display the ConcurrentHashMap(unsorted) of results and the 
	 * TreeMap(sorted) of the results.
	 */
	@Override
	public String toString() {
		return "Results [map=" + map + ", sorted_map=" + sorted_map + "]";
	}
    
    // other methods
}
