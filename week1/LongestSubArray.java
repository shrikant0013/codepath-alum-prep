package week1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by shrikant.pandhare on 7/19/17.
 */
public class LongestSubArray {
    static int maxLength(int[] a, int k) {

        //1st case check all elements
        int sum = 0;
        for(int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        if (sum <= k) {
            return a.length;
        }

        int windowSize = 1;
        int windowAtIndex = 0;

        while(windowSize < a.length) {
            System.out.println("windowSize:" + windowSize);
            int maxSum = Integer.MIN_VALUE;
            windowAtIndex = 0;
            while(windowAtIndex < a.length) {
                sum = 0;
                System.out.println("windowAtIndex:" + windowAtIndex);
                for(int scanner = 0; scanner < a.length; scanner++) {
                    List<Integer> skipIndices = new ArrayList<>();
                    int temp = windowAtIndex;
                    for (int i = 0; i < windowSize; i++) {
                        skipIndices.add(temp);
                        temp = (temp + 1) % a.length;
                    }
                    if (skipIndices.contains(scanner)) {
                        continue; //Skip these elements
                    }
                    System.out.println("scanner: " + scanner);
                    sum += a[scanner];
                }

                if (sum > maxSum && sum <= k) {
                    maxSum = sum;
                }
                System.out.println("sum:" + sum);
                System.out.println("maxSumn: " + maxSum);
                windowAtIndex++;
            }

            if (maxSum > 0 && maxSum <= k) {
                return a.length - windowSize;
            }
            windowSize++;
        }

        return 1;
    }

    public static void main(String[] args) throws IOException {
        //int[] a = {1,2,3};
        int[] a = {3,1,2,1};
        //System.out.println(maxLength(a, 4));

        File file = new File("input002.txt");

        Scanner input = new Scanner(file);

        List<Integer> inputArr = new ArrayList<>();
        while (input.hasNextLine()) {
            int line = input.nextInt();
            inputArr.add(line);
        }
        System.out.println(maxLength(inputArr.stream().mapToInt(i -> i).toArray(), 22337));
    }
}
