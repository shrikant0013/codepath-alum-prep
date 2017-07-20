package week2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shrikant.pandhare on 7/19/17.
 */
public class Colorful {
    public int colorful(int a) {
        if(a < 10) return 1;

        String colorString = String.valueOf(a);
        int length = colorString.length();

        List<Integer> productMap = new ArrayList<Integer>();

        productMap.add(a);
        for(int i =  0; i < length; i++){
            for (int j = i;  j < length; j++){
                String sub = colorString.substring(i, j + 1);
                int product = getProduct(Integer.parseInt(sub));
                if(productMap.contains(product)) return 0;
                else{
                    productMap.add(product);
                }
            }
        }
        return 1;
    }

    private static int getProduct(int digits) {
        if(digits < 10) return digits;
        int num = digits;
        int product = 1;
        while(num > 0){
            product *=  (num % 10);
            num = num / 10;
        }
        return product;
    }

    public static void main(String[] args) {
        Colorful c = new Colorful();
        System.out.println(c.colorful(99));
    }
}
