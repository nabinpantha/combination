package coding.combination.util;

import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import static coding.combination.constants.Constants.IS_ENGLISH_WORD;
import static coding.combination.constants.Constants.IS_NOT_ENGLISH_WORD;
import static coding.combination.constants.Constants.THE_WORD;
import static coding.combination.constants.Constants.EMPTY_STRING;

public class Combination {

	public static Set<String> findCombination(String word) {
		Set<String> combinationList = new LinkedHashSet<String>();
		combinationList = combination(combinationList, EMPTY_STRING, word);
		
		if(System.getProperty("reverseCombo").equalsIgnoreCase("true")) {
            combinationList = combination(combinationList, EMPTY_STRING, findReverse(word));
        }

		return combinationList;

	}

	public static Set<String> combination(Set<String> combinationList, String prefix, String s) {
		int lengthOfString = s.length();
		if (StringUtils.isNotBlank(prefix)){
			combinationList.add(prefix);
		}
		for (int i = 0; i < lengthOfString; i++) {
			combination(combinationList, prefix + s.charAt(i), s.substring(i + 1));
		}

		return combinationList;
	}

	/* formula is an assumption */
	public static int totalCombination(String word) {

		int lengthOfString = word.length();
		int totalNumberOfCombination = lengthOfString;
		for (int i = lengthOfString - 1; i > 1; i--) {
			totalNumberOfCombination *=  i;
		}

		return totalNumberOfCombination;

	}

	public static void printList(Set<String> combinationList) {
		for (String str : combinationList) {
			System.out.println(str);
		}
	}

	public static void combinationStringList(Set<String> combinationList) {

		for (String str : combinationList) {

			Boolean isEnglishWord = EnglishDictionary.isEnglishWord(str);

			if (isEnglishWord) {
				System.out.println(THE_WORD + str + IS_ENGLISH_WORD);
			} else {
				System.out.println(THE_WORD + str + IS_NOT_ENGLISH_WORD);
			}

		}

	}
	

    public static String findReverse(String word){
        StringBuilder reverseWord = new StringBuilder();
        char[] characters = word.toCharArray();


        for(int i = characters.length - 1; i >= 0; i--) {
            reverseWord.append(characters[i]);
        }
        return reverseWord.toString();
    }

}
