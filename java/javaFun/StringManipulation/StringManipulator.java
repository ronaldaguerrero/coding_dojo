public class StringManipulator {
	public static String trimAndConcat(String alpha, String beta) {
		String result = alpha.trim() + " " + beta.trim();
		return result;
	}
	public static Integer getIndexOrNull(String string, char cha) {
		int result = string.indexOf(cha);
			if (result == -1){
				return null;
			} else {
				return result;
			}
	}
	public static Integer getIndexOrNull(String alpha, String beta) {
		int result = alpha.indexOf(beta);
			if (result == -1){
				return null;
			} else {
				return result;
			}
	}
	public static String concatSubstring(String alpha, int num1, int num2, String beta) {
		String cha = alpha.substring(num1,num2);
		String result = cha + beta;
		return result;
	}
}

