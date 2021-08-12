package coding.combination;

import java.util.Set;

import coding.combination.util.Combination;

class CombinationMain {

	public static void main(String[] args) {

		String word = "working";

		Set<String> combinationList = Combination.findCombination(word);

		System.out.println("The total number of combination is " + combinationList.size());

		System.out.println("The total number of combination using formula " + Combination.totalCombination(word));

		System.out.println("Combination of " + word + ": \n");

		Combination.printList(combinationList);

		Combination.combinationStringList(combinationList);
	}

}