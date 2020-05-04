package cesar3;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	

	public static void main(String args[]) throws IOException {

		
		System.out.println("test 3: \n");
		String word1 = null;
		String word2 = null;
		Scanner scan=new Scanner(System.in); 
		 
		word1 = scan.nextLine();
		word2 = scan.nextLine();
		 
		
		isTypo(word1,word2);

		 
	}
	
	static void isTypo(String word1,String word2) {
		
		
		Boolean typo = null;
		//check equal length word typo
		if(word1.length() == word2.length()) {
			int cont=0;
			for(int i=0;i<word1.length();i++) {
				 if(word1.codePointAt(i) != word2.codePointAt(i))
					 cont++;
				 if(cont>=2) {
					 typo = false;
					 break;
				 }
			}
			if(cont==1)
				typo = true;
			
		//check word2 adding 1 Character 
		}else if((word1.length()+1) == word2.length()) {
			String temp;
			StringBuilder temp1 = new StringBuilder();
			StringBuilder temp2 = new StringBuilder();
			temp1.append(word1);
			temp2.append(word2);
			
			//Check all possibilities "inside" the word
			for(int i=0;i<word2.length();i++) {
				if(word1.codePointAt(i) != word2.codePointAt(i) ) {
					char tempString = word2.charAt(i);
					temp1.insert(i,tempString);
					temp = temp1.toString();
					if(temp.compareTo(word2) == 0) {
						typo = true;
						break;
					}else {
						typo = false;
						break;
					} 
				}
			}
			//check the first and last character was inserted
			if((word2.substring(1).compareTo(word1) == 0) || (word2.substring(0,word2.length()-1).compareTo(word1)==0))
					typo = true;
		//check word2 removing 1 Character 
		}else if((word1.length()-1) == word2.length()) {
			String temp;
			StringBuilder temp1 = new StringBuilder();
			StringBuilder temp2 = new StringBuilder();
			temp1.append(word1);
			temp2.append(word2);
			//Check all possibilities "inside" the word
			for(int i=0;i<word2.length();i++) {
				if(word1.codePointAt(i) != word2.codePointAt(i) ) {
					temp1.delete(i,i+1);
					temp = temp1.toString();
					if(temp.compareTo(word2) == 0) {
						typo = true;
						break;
					}else {
						typo = false;
						break;
					} 
				}
			}
			//check the first and last character was removed
			if((word1.substring(1).compareTo(word2) == 0) || (word1.substring(0,word1.length()-1).compareTo(word2)==0))
					typo = true;
			
		}else
			typo=false;
			
			
		if(typo)
			System.out.print(word1 + ", " + word2 + " -> " + typo);
		else
			System.out.print(word1 + ", " + word2 + " -> " + typo);
				
	}
	
}