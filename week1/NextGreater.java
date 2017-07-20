package week1;

import java.util.ArrayList;
import java.util.List;

public class NextGreater {
    public ArrayList<Integer> nextGreater(List<Integer> a) {
        ArrayList<Integer> result =  new ArrayList<>();

        for (int i = 0 ; i < a.size(); i++) {
            boolean found = false;
            for (int j = i; j < a.size(); j++) {
                if (a.get(j) > a.get(i)) {
                    found = true;
                    result.add(i, a.get(j));
                    break;
                }
            }
            if (!found) {
                result.add(i, -1);
            }
        }
        return result;
    }
}
