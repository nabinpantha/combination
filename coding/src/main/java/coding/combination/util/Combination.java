package coding.combination.util;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class Combination {

	public static Set<String> findCombination(String word) {
		Set<String> combinationList = new LinkedHashSet<String>();
		combinationList = combination(combinationList, "", word);

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
			totalNumberOfCombination = totalNumberOfCombination * i;
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
				System.out.println("The word " + str + " is a english word.");
			} else {
				System.out.println("The word " + str + " is not a english word.");
			}

		}

	}

}
