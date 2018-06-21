
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class nlpHw2PhoneNumberFinder {

	 public static void main( String args[] ) throws IOException{
		 
		 /////////REGULAR EXPRESSIONS//////

	      
	      String regexp1 = "\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}";
	   
	      String regexp3 = "\\(\\d{3}\\)-\\d{3}-\\d{4}";
	      String regexp4 = ".\\d{3}..\\d{3}-\\d{4}";
	    
	      
	      String regexp = "(" + regexp1 + ")| (" + regexp3 + ") | (" + regexp4 + ") ";//final expression 
	      //which contains all to be compiled
	      
	      ////////////READ INPUT and OUTPUT FILE/////////////
	      File inputFile = new File(args[0]);//args 0 is input
	      File outputFile = new File(args[1]);//args 1 is output
	      StringBuilder outputAnswers = new StringBuilder((int)outputFile.length());//store answers in this string
	
			FileInputStream fstream = new FileInputStream(inputFile);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			String strLine;
			while ((strLine = br.readLine()) != null) {
				
				Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(strLine);
				
				while (matcher.find()) {
					System.out.println(matcher.group());
					outputAnswers.append( matcher.group() + "\n");
				}
			
			}
		        

	      FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
	      BufferedWriter bw = new BufferedWriter(fw);
	      String bwf =  outputAnswers.toString();
	      bw.write(bwf);
	      bw.close();
	      
	   }//end main
	 
}
