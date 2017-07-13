public class Atoi {
	public int atoi(final String aa) {
	   
        if (aa == null || aa.length() == 0 || aa.trim().length() == 0) {
            return 0;
        }
        String a = aa.trim();
        int i = 0;

        boolean isNegative = false;
        if (a.charAt(0) == '-') {
            isNegative = true;
            i++;
        } else if (a.charAt(0) == '+') {
            i++;
        }

        int offset = (int) '0';
        int result = 0;

        try {
            for (; i < a.length(); i++) {
                if (a.charAt(i) >= '0' && a.charAt(i) <= '9') {
                    result = Math.addExact(Math.multiplyExact(result, 10), (a.charAt(i) - offset));
                } else {
                    break;
                }
            }
        } catch (ArithmeticException e) {
            if (isNegative) {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
        if (isNegative) {
            result = result * -1;
        }
        return result;
	}
}
