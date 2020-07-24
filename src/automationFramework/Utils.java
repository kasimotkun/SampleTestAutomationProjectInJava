package automationFramework;

import java.util.Random;

public class Utils {

	public Utils() {
		// TODO Auto-generated constructor stub
	}

	public static String getRandomNumberInRange(long min, long max) {

		Random r = new Random();
		return String.valueOf(r.longs(min, (max + 1)).limit(1).findFirst().getAsLong());

	}
}
