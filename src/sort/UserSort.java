package sort;

public class UserSort {

/**
 * ÅÅÐò
 * @param sorted Êý×é
 */
	public static void straightSort(double[] sorted) {
		int sortedLen = sorted.length;
		for (int i = 2; i < sorted.length; i++) {
			if (sorted[i] < sorted[i-1]) {
				sorted[0] = sorted[i];
				sorted[i] = sorted[i-1];
				int insertPos = 0;
				for (int j = (i-2); j >= 0; j--) {
					if (sorted[j] > sorted[0]) {
						sorted[j+1] = sorted[j];
					}else {
						insertPos = j+1;
						break;
					}
				}
				sorted[insertPos] = sorted[0];
			}
		}
	}

	
	
}
