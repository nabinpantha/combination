package coding.combination.util;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class EnglishDictionary {

	public static Boolean isEnglishWord(String word) {
		if(StringUtils.isBlank(word)) {
            return false;
        }

		List<String> listOfEnglishWords = Arrays.asList("WORK", "WORKING", "WORN", "WORK", "WOK", "WON", "WIN", "WING",
				"OR", "ORG", "OK", "ON", "RING", "KIN", "KING", "KG", "I", "IN");

		return listOfEnglishWords.contains(word.toUpperCase());
	}

}
