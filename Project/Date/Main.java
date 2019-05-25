import java.sql.Date;
class Main {
public static void main(String[] args) {
	String dateString = "%2019-05-19%";
//	Date dateSql = Date.valueOf(dateString);
	char[] charArray = new char[10];
	dateString.getChars(1, 11, charArray, 0);

//	for (int i = 0; i < charArray.length; i++) {
//		System.out.print(charArray[i]);
//	}
//	System.out.println("");
	String newString = charArray[0] + "" + charArray[1] + "" + charArray[2] + "" + charArray[3] + "" + charArray[4]
	+ "" + charArray[5] + "" + charArray[6] + "" + charArray[7] + "" + charArray[8] + "" + charArray[9];
//	System.out.println(newString);
//	Date dateSql = Date.valueOf(newString);
}
}