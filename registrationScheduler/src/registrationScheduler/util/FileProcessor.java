package registrationScheduler.util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import registrationScheduler.util.Logger.DebugLevel;

public class FileProcessor implements FileProcessorInterface{
	private FileReader filereader1, filereader2;
	private BufferedReader br1,br2;
	
	/**
	 * Constructor
	 * @param inputfile1
	 * @param inputfile2
	 */
	public FileProcessor(String inputfile1, String inputfile2) {
		Logger.writeMessage("FileProcessor Constructor is called ", DebugLevel.CONSTRUCTOR);
		try {
			filereader1 = new FileReader(inputfile1);
			filereader2 = new FileReader(inputfile2);
			br1 = new BufferedReader(filereader1);
			br2 = new BufferedReader(filereader2);
		}
		catch(FileNotFoundException ex) {
			System.err.println("Unable to open file '" + inputfile1 + "' or '"+ inputfile2+"'");
			ex.printStackTrace();
			System.exit(1);
		}
		
		finally{

		}
		
	}
	
	/**
	 * @return String
	 */
	public synchronized String readLineFromFile1() {
		try {
			
			return br1.readLine();
		}
		catch(FileNotFoundException ex) {
			System.err.println("Unable to open file.");
			ex.printStackTrace();
			System.exit(1);
			return null;
		}
		catch(IOException ex) {
			System.err.println("Unable to open file.");
			ex.printStackTrace();
			System.exit(1);
			return null;
		}
		finally{

		}
	}
	
	/**
	 * @return String
	 */
	public synchronized String readLineFromFile2() {
		try {
			
			return br2.readLine();
		}
		catch(FileNotFoundException ex) {
			System.err.println("Unable to open file.");
			ex.printStackTrace();
			System.exit(1);
			return null;
		}
		catch(IOException ex) {
			System.err.println("Unable to open file.");
			ex.printStackTrace();
			System.exit(1);
			return null;
		}
		finally{

		}
	}

}