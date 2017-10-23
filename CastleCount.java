import java.util.Arrays;

/**
 * Returns the number of castles to build depending on the number of peaks
 * and valleys in a stretch of land (defined by an array of integers).
 * 
 * These are the rules determining the count:
 * 
 * 	- always build a castle at the start of the array, provided it is non-empty.
 *	- build one castle per peak or valley.
 *	- A peak is an integer or series of integers that is above the immediately preceding and following
 *	  integers. For example, in the sequence [2,6,6,6,3] the sequence of 3 6s is a peak.
 *	- A valley is an integer or series of integers that is below the immediately preceding and
 *	  following integers. For example, in the sequence [6,1,4] the "1" would be a valley.
 */
public class CastleCount {

	/**
	 * Application entry point.
	 * @param args array of command line parameters
	 */
	public static void main(String[] args) {
        CastleCount app = new CastleCount();		
		app.run(args); 
	}
	
	/**
	 * Run application.
	 * @param args array of command line parameters
	 */
	public void run(String[] args) {
		int[] stretchOfLand = argsToIntArray(args);
		if (stretchOfLand == null) {
			String msg = getErrorMsg();
			System.out.println(msg);
		}
		else {
			int count = countPeaksValleys(stretchOfLand);
			System.out.println("Will build " + count + " castle(s)");
		}
	}
	
	/**
	 * Returns last error message.
	 * @return error message
	 */
	public String getErrorMsg() {
		return errorMsg;
	}
	
	/**
	 * Converts arguments to integer array. 
	 * @param args array of command line parameters
	 * @return array of integers or null
	 */
	public int[] argsToIntArray(String[] args) {
		if ((args != null) && (args.length == 1)) {
			try {
				String[] stringArray = args[0].split(",");
				int[] intArray = Arrays.stream(stringArray).mapToInt(Integer::parseInt).toArray();
				return intArray;
			} catch (Exception e) {
				errorMsg = "Invalid input parameters";
			}
		}
		else {
			errorMsg = "Invalid number of parameters";
		}
		return null;
	}
	
	/**
	 * Counts the number of 'peaks' and 'valleys' in an array of integers.
	 * @param intArray array of integers
	 * @return count
	 */
	public int countPeaksValleys(int[] intArray) {
		if (intArray != null) {
			int length = intArray.length;
			if (length == 1 || length == 2) {
				return 1;
			}
			else if (length > 2) {
				int count = 1; // Start the count with the first element, assuming last peak or
				               // valley is not counted
				int start = 0, end = 0;
				for (int i = 1; i < length - 1; i++) {
					// Calculate start and end of sequence
					if (intArray[i - 1] != intArray[i]) {
						start = i; 
					}
					if (intArray[i] != intArray[i + 1]) {
						end = i;
					}
					if (start != 0 && end != 0) {
						// Add a peak
						if ((intArray[start - 1] < intArray[start]) && (intArray[end + 1] < intArray[start])) {
							count++;
						}
						// Add a valley
						if ((intArray[start - 1] > intArray[start]) && (intArray[end + 1] > intArray[start])) {
							count++;
						}
					}
				}
				return count;
			}
		}
		return 0;
	}
	
	private String errorMsg = "";
}
