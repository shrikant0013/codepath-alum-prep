package week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
	// DO NOT MODIFY THE LIST
	public String largestNumber(final List<Integer> a) {
	    List<Integer> copy = new ArrayList<>(a);

        Collections.sort(copy, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s2.compareTo(s1);
            }
        });

        StringBuilder result = new StringBuilder();
        for (int i : copy) {
            result.append(i);
        }
        Integer resultInt = null;
        try {
            resultInt = Integer.parseInt(result.toString());
        } catch (NumberFormatException e) {
            return result.toString();
        }
        return resultInt.toString();
	}
}
