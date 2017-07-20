package week2;

import java.util.*;

/**
 * Created by shrikant.pandhare on 7/20/17.
 */
public class Anagrams {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Set<Integer> foundAnagrams = new HashSet<>();
        for (int i = 0; i < a.size(); i++) {
            char[] charA = a.get(i).toCharArray();
            Arrays.sort(charA);

            ArrayList<Integer> list = new ArrayList<>();
            boolean addedI = false;
            for (int j = i + 1; j < a.size(); j++) {

                char[] charB = a.get(j).toCharArray();

                Arrays.sort(charB);

                if (String.valueOf(charA).equals(String.valueOf(charB))) {

                    if (!foundAnagrams.contains(j + 1)) {
                        if (!addedI) { //only first entry
                            list.add(i + 1);
                            addedI = true;
                        }
                        list.add(j + 1);

                        foundAnagrams.add(i + 1);
                        foundAnagrams.add(j + 1);
                    }
                }
            }

            if (list.isEmpty() && !foundAnagrams.contains(i + 1)) {
                list.add(i + 1);
            }
            if (!list.isEmpty()) {
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("cat");
        input.add("dog");
        input.add("god");
        input.add("tca");
        input.add("tac");

        Anagrams obj = new Anagrams();
        ArrayList<ArrayList<Integer>> result = obj.anagrams(input);

        for (List l : result) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
}
