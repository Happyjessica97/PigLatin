import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PigLatin extends PApplet {



public void setup() {
	String lines[] = loadStrings("words.txt");
	System.out.println("there are " + lines.length + " lines");
	for (int i = 0 ; i < lines.length; i++) {
	  System.out.println(pigLatin(lines[i]));
	}
}
public void draw()
{
}
public int findFirstVowel(String sWord)
//precondition: sWord is a valid String of length greater than 0.
//postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
{	for(int i = 0; i < sWord.length(); i++){
		if((sWord.charAt(i)=='a')||(sWord.charAt(i)=='e')||(sWord.charAt(i)=='i')||(sWord.charAt(i)=='o')||(sWord.charAt(i)=='u'))
		{
			return i;
		}
	}
	
	return -1;
}

public String pigLatin(String sWord)
//precondition: sWord is a valid String of length greater than 0
//postcondition: returns the pig latin equivalent of sWord
{	
	if(findFirstVowel(sWord) == -1)
	{
		return sWord + "ay";
	}
	else if((sWord.charAt(0)=='q')&&(sWord.charAt(1)=='u'))
	{
		String something = sWord.substring(2,sWord.length());
		return something +"quay";
	}
	else if((sWord.charAt(0)=='a')||(sWord.charAt(0)=='e')||(sWord.charAt(0)=='i')||(sWord.charAt(0)=='o')||(sWord.charAt(0)=='u'))
	{
		return sWord + "way";
		
	}
	else if((findFirstVowel(sWord) <10)&&(findFirstVowel(sWord)>0))
	{
		int somethingy = findFirstVowel(sWord);
		
		return sWord.substring(somethingy,sWord.length()) + sWord.substring(somethingy-somethingy,somethingy) + "ay";
		
	}
	else
	{
		return "ERROR!";
	}

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PigLatin" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
