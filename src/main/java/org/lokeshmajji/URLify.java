package org.lokeshmajji;

public class URLify {

    public static void main(String[] args) {
        System.out.println(urlify2("Mr John Smith a b        ",17));
        System.out.println(urlify2("Mr John Smith a      ",15));
        System.out.println(urlify2("Mr John Smith    ",13));
        System.out.println(urlify2("Mr John  ",7));

//         M - 0 R 1  ' ' 2 j 3 o 4 h 5 n 6 ' ' 7 S 8 m 9 i 10 t 11 h 12
//        how to replace a char
        // concurrent modification
    }

    public static String urlify1(String str,int len ){
       char[] carr = str.toCharArray();
        int i = 0;
        while(i < len){
            char c = carr[i];
            if(c == ' ') {
                //
                int k = carr.length - len;
                int j = len+1;
                while(j > i ){
                    System.out.println(carr[j] + " : " + carr[j-1]);
                    carr[j+2] = carr[j];
                    carr[j+1] = carr[j-1];
                    j--;
                    System.out.println(carr);

                }
               carr[i] = '%';
               carr[i+1] = '2';
               carr[i+2] = '0';

           }
            i++;
        }
        return new String(carr);
    }
    public static String urlify2(String str,int len ){
       char[] carr = str.toCharArray();
        int i = 0;
        int cntSpaces = 0;
        while(i < carr.length){
            if(carr[i] == ' ') {
                cntSpaces++;
            }
            i++;
            }
        System.out.println("No of spaces:"+ cntSpaces);
        int endIndex = len - 1;
        i =0;
        while(i < carr.length){
            char c = carr[i];
            if(c == ' ') {
               int j = endIndex;
               while(j > i){
                   carr[j+2] = carr[j];
                   carr[j+1] = carr[j-1];
                   j--;
               }
              endIndex += 2;
                // change
               carr[i] = '%';
               carr[i+1] = '2';
               carr[i+2] = '0';

           }
            i++;
        }
        return new String(carr);
    }
}
