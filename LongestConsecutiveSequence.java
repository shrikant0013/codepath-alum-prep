public class LongestConsecutiveSequence {
    public int longestConsecutive(final List<Integer> a) {
        int result = 0;
        Set<Integer> uniqueElements = new HashSet<>(a);
        for (int i : a) {
            int count = 0;
            if (!uniqueElements.contains(i - 1))
            {
                int j = i;
                while (uniqueElements.contains(j)) {
                    j++;
                    count++;
                }
                if (count > result) {
                    result = count;
                }
            }
        }
        return result;
    }
}
