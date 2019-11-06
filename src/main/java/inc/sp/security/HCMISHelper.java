package inc.sp.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author hcmis-development team
 * @date Mar 11, 2019
 * @version 1.0.0
 */

public class HCMISHelper {

	public static void print(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String className = "";
		if (obj == null) {
			className = "You've passed null object";
		} else {
			className = obj.getClass().getSimpleName();
		}
		System.out.println("--------------------------" + className
				+ "----------------------------------------------------------");
		try {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj));
		} catch (JsonProcessingException e) {
			System.out.println("########################ERROR########################");
			e.printStackTrace();
		}
		System.out.println(
				"-----------------------------------------------------------------------------------------------------");
	}

	public static void print(Object obj, String headerMsg) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			System.out.println("");
			System.out.println("");
			String className;
			if (obj == null) {
				className = "You've passed null object";
			} else {
				className = obj.getClass().getSimpleName();
			}

			String msg = "--------------------------" + className + " (" + headerMsg
					+ ")----------------------------------------------------------";

			System.out.println(msg);

			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj));

		} catch (Exception e) {
			System.out.println("########################ERROR########################");
			e.printStackTrace();
		}

		System.out.println(
				"------------------------------  End of " + headerMsg + " ------------------------------------");
		System.out.println("");
		System.out.println("");
	}

	public static String resourceMessage(Object id) {
		return " resource-id=" + id.toString();
	}

	public static void printParams(Object... objects) {

		HCMISHelper.print(objects, "List of parameters");

	}

}
