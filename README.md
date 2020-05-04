# Typos


T(n) = 

	static void isTypo(String word1,String word2) {
		
		
		Boolean typo = null;                                      1
		//check equal length word typo                            
		if(word1.length() == word2.length()) {                    1    
			int cont=0;                                             1
			for(int i=0;i<word1.length();i++) {                     n+1
				 if(word1.codePointAt(i) != word2.codePointAt(i))     n
					 cont++;                                            n
				 if(cont>=2) {                                        n
					 typo = false;                                      n
					 break;                                             n
				 }
			}
			if(cont==1)                                             1
				typo = true;                                          1
			
		//check word2 adding 1 Character 
		}else if((word1.length()+1) == word2.length()) {          1
			String temp;                                            1
			StringBuilder temp1 = new StringBuilder();              1
			StringBuilder temp2 = new StringBuilder();              1
			temp1.append(word1);                                    1
			temp2.append(word2);                                    1
			
			//Check all possibilities "inside" the word
			for(int i=0;i<word2.length();i++) {                     n+1
				if(word1.codePointAt(i) != word2.codePointAt(i) ) {   n
					char tempString = word2.charAt(i);                  n
					temp1.insert(i,tempString);                         n
					temp = temp1.toString();                            n
					if(temp.compareTo(word2) == 0) {                    n
						typo = true;                                      n
						break;                                            n
					}else {             
						typo = false;                                     n
						break;                                            n
					} 
				}
			}
			//check the first and last character was inserted
			if((word2.substring(1).compareTo(word1) == 0) || (word2.substring(0,word2.length()-1).compareTo(word1)==0))     1
					typo = true;                                                                                                1
		//check word2 removing 1 Character 
		}else if((word1.length()-1) == word2.length()) {                                                                  1
			String temp;                                                                                                    1
			StringBuilder temp1 = new StringBuilder();                                                                      1
			StringBuilder temp2 = new StringBuilder();                                                                      1
			temp1.append(word1);                                                                                            1
			temp2.append(word2);                                                                                            1
			//Check all possibilities "inside" the word
			for(int i=0;i<word2.length();i++) {                                                                             N+1
				if(word1.codePointAt(i) != word2.codePointAt(i) ) {                                                           n
					temp1.delete(i,i+1);                                                                                        n
					temp = temp1.toString();                                                                                    n
					if(temp.compareTo(word2) == 0) {                                                                            n
						typo = true;                                                                                              n
						break;                                                                                                    n
					}else {
						typo = false;                                                                                             n
						break;                                                                                                    n
					} 
				}
			}
			//check the first and last character was removed
			if((word1.substring(1).compareTo(word2) == 0) || (word1.substring(0,word1.length()-1).compareTo(word2)==0))     1
					typo = true;                                                                                                1
			
		}else
			typo=false;                                                                                                     1
			                                                                                                               = 25n + 25
			
		if(typo)
			System.out.print(word1 + ", " + word2 + " -> " + typo);
		else
			System.out.print(word1 + ", " + word2 + " -> " + typo);
				
	}
	
}
