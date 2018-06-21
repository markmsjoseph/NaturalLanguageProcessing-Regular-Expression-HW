
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

public class nlp_hw2_moneyFinder {

	 public static void main( String args[] ) throws IOException{
		 
		 /////////REGULAR EXPRESSIONS//////
	      String numbers = "(\\d+.|one|two|three|four|five|six|seven|eight|nine|ten|eleven|twelve|thirteen|fourteen|fifteen|sixteen|seventeen|eighteen|nineteen|twenty-?|thirty-?|forty-?|fifty-?|sixty-?|seventy-?|eighty-?|ninety-?)";
	      String hundredsMillsEtc = "(hundred|thousand|million|billion|trillion|and|\\s)*";
	      String regexNumbers = "((" + numbers + ")|((" + numbers + "|,)+" + numbers + "+))";//numbers or numbers wwith comma 
	      String dollarsAndCoins = "(\\$-?\\d+\\.\\d+)";
	      String dollarsAlone = "(\\$-?\\d+)";
	      String largeDollarsAlone = "(\\$-?\\d+[^\\s\\)]+)";
	      
	      
	      String regexp1 = "(\\$?" + regexNumbers + hundredsMillsEtc + ")+.dollars?";
	      String regexp2 = "\\$(" + regexNumbers + hundredsMillsEtc + ")+";
	      String regexp3 = "(\\$?" + regexNumbers + hundredsMillsEtc + ")+.cents?";
	      String regexp4 = dollarsAndCoins;
	      String regexp5 = dollarsAlone;
	      String regexp6 = largeDollarsAlone;
	      String regexp7 = "(\\$?" + regexNumbers + ")+.cents?";
	      
	      String regexp = "(" + regexp1 + ")|(" + regexp2 + ")| (" + regexp3 + ") | (" + regexp4 + ") | (" + regexp5 + ") | (" + regexp6 + ")| (" + regexp7 + ")";//final expression 
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
