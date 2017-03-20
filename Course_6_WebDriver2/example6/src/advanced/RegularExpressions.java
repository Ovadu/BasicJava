package advanced;

import java.util.regex.Pattern;

public class RegularExpressions {
	
	public static void matchTest(){
		String str = " ---- check this date 01.01.2013 ----";
		boolean b = Pattern.matches(".*check this date \\d{2}\\.\\d{2}\\.\\d{4}.*", str);
		
		if(b){
			System.out.println("1 - match");
		}else{
			System.out.println("1 - no match");
		}
	}

	public static void matchCASE_INSENSITIVE(){
		String str = " ---- Check This Date 01.01.2013 ----";
		Pattern p = Pattern.compile(".*check this date \\d{2}\\.\\d{2}\\.\\d{4}.*", Pattern.CASE_INSENSITIVE);
		boolean b = p.matcher(str).matches();
		
		if(b){
			System.out.println("2 - match");
		}else{
			System.out.println("2 - no match");
		}
	}
	
	public static void matchDOTALL(){
		String str = " Now we will test \n the line terminator";
		System.out.println(str);
		Pattern p = Pattern.compile("(\\s)Now.*terminator", Pattern.DOTALL); //\s - whitespace character
		boolean b = p.matcher(str).matches();
		
		if(b){
			System.out.println("3 - match");
		}else{
			System.out.println("3 - no match");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		matchTest();
		matchCASE_INSENSITIVE();
		matchDOTALL();
		System.out.println("---End---");
	}

}
