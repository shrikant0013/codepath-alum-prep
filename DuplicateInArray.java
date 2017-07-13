public class DuplicateInArray {
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
	    Set<Integer> count = new HashSet<>();
        for (int i : a) {
            if (count.contains(i)) {
                return i;
            } else {
                count.add(i);
            }
        }
        return -1;
	}
}
