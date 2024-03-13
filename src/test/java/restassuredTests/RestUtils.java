package restassuredTests;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	public static String getName() {
		String randomString =  RandomStringUtils.randomAlphabetic(2);
		return "qwerty"+randomString;
	}
	
	public static String getJobName() {
		String randomString =  RandomStringUtils.randomAlphabetic(2);
		return "asdfghj"+randomString;
	}
	
	public static String getSalary() {
		String randomNumber =  RandomStringUtils.randomNumeric(5);
		return randomNumber;
	}
	
	public static String getAge() {
		String randomAge =  RandomStringUtils.randomNumeric(2);
		return randomAge;
	}
}
