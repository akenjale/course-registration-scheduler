package registrationScheduler.util;

import java.util.Comparator;

/**
 * Class which implements the Comparator to sort the results by  
 * Student name.
 */
public class StringComparator implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		return (Integer.parseInt(s1.substring(8))-Integer.parseInt(s2.substring(8)));
	}

}
