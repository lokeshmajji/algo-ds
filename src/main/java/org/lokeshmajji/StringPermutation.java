package  org.lokeshmajji;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {
    public static void main(String[] args) {
        System.out.println(check1("abc", "cba"));
        System.out.println(check1("abc", "def"));
        System.out.println(check1("abab", "baba"));
        System.out.println(check1("abab", "baaa"));



    }
    public static boolean check(String s1,String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int cnt = 0;
        for(int i=0; i< c1.length; i++){
            for(int j=0; j < c2.length; j++){
                if(c1[i] == c2[j]) {
                    cnt++;
                    break;
                }
            }
        }

        return  c1.length == cnt;
    }
    public static boolean check1(String s1,String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
//        step 1: cnt the no of alphabets in the array
//        step 2: reduce the counts from the second array
//        step 3: sum of counts should be 0
        int cnt = 0;
        Map<Character,Integer> map = new HashMap<>();
        if( c1.length != c2.length) return false;
        for(int i=0; i< c1.length; i++){
                if(map.containsKey(c1[i])) {
                map.computeIfPresent(c1[i], (key, oldval) -> 1 + oldval);
            } else {
                    map.put(c1[i],1);

                }
        }
        for(int i=0; i< c2.length; i++){
            if(map.containsKey(c2[i])) {
                map.computeIfPresent(c2[i], (key, oldval) ->  oldval -1);
            } else {
                return false;
            }
        }

        System.out.println(map);
        for(Integer val: map.values()){
            if(val != 0) return false;
        }
        return true ;
    }
}