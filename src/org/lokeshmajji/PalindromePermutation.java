package org.lokeshmajji;

import java.util.Arrays;

public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(isPalindrome2("Tact Coa"));
        System.out.println(isPalindrome2("ABC"));
        System.out.println(isPalindrome2("radar"));
//        System.out.println(pp("racecar"));
        // taco cat
        // tac ocat
    }

    public static boolean pp(String input){
        // a a b
        // 0 1 2
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) != ' ') sb.append(input.charAt(i));
        }
        String spaceRemoved = sb.toString();
        System.out.println(spaceRemoved);
        int i = 0;
        char[] chars = spaceRemoved.toCharArray();
        int cnt = 0;
        while(i < chars.length){
            int j = 1;
            while(j < chars.length){
                String permutation = swap(spaceRemoved.toLowerCase(),i,j);
                System.out.println(i + ","+ j + " permuted:"+permutation);
                if(isPalindrome(permutation) ){
                    System.out.println("palindrome:" + permutation);
                    return true;
                }
                j++;
                cnt++;
            }
            i++;
        }
        System.out.println("total permutations:" + cnt);
        return false;
    }
    public static String swap(String in,int i,int j){
        char[] chars = in.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
    public static boolean isPalindrome(String str) {


        char[] rev = new char[str.length()];
        int j = 0;
        for(int i = str.length() - 1; i >= 0 ; i--){
           rev[j] =  str.charAt(i);
           j++;
        }
        String revstr = new String(rev);
//        System.out.println("reversed:"+revstr);
        return revstr.equalsIgnoreCase(str);
    }

    public static boolean isPalindrome2(String str){
        //store chars in an arr
        int[] chars = new int['z' - 'a' + 1];
        char[] charsstr = str.toCharArray();
        for(int i=0; i < charsstr.length; i++){
            if(!Character.isSpaceChar(charsstr[i])) {
                //store all characters into array
                int t = Character.toLowerCase(charsstr[i]) - 'a';
                chars[t]++;
            }
        }
        boolean singleOdd = false;
        for(int i=0; i< chars.length; i++){
            if(chars[i] % 2 != 0) {
                if(singleOdd) return false;
                else singleOdd = true;
            }
        }
//        System.out.println(Arrays.toString(chars));
        return true;
    }
}
