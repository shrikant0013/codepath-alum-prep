package week1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by shrikant.pandhare on 7/19/17.
 */
public class RestoreIPAddressFormat {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        if (s.length() < 4|| s.length( )> 12) return result;
        dfs(s,"",result,1);
        return result;
    }

    public void dfs(String remainingString, String currentFinding, ArrayList<String> result, int octetCount){
        if (octetCount > 3) {
            if (isValid(remainingString)) {
                result.add(currentFinding + remainingString);
//                System.out.println("result: " + Arrays.toString(result.toArray()));
            }
            octetCount = 0;
            return;
        }

//        System.out.println("octetCount: " + octetCount);
//        System.out.println("currentFinding: " + (currentFinding.isEmpty()? "<EMPTY>" : currentFinding));
        for(int i = 1; i < 4 && i < remainingString.length(); i++){
            String substr = remainingString.substring(0,i);
//            System.out.println("i: " + i);
//            System.out.println("substr: " + substr);
//            System.out.println("remainingString: " + remainingString);
            if (isValid(substr)){
                dfs(remainingString.substring(i), currentFinding + substr + '.', result, octetCount+1);
            }
        }
    }

    public boolean isValid(String s){
        if (s.charAt(0)=='0') return s.equals("0");

        int num = Integer.parseInt(s);

        return num <= 255 && num > 0;
    }

    public static void main(String[] args) {
        RestoreIPAddressFormat ip = new RestoreIPAddressFormat();
        System.out.println(Arrays.toString(ip.restoreIpAddresses("25525511135").toArray()));
        //System.out.println(Arrays.toString(ip.restoreIpAddresses("10101010").toArray()));
    }
}
