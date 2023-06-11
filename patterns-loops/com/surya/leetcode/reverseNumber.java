package com.surya.leetcode;

public class reverseNumber {
    // A Very bad approach
    // public int reverse(int x) {
    // return x < 0 ? -revNum(-x) : revNum(x);
    // }

    // public int revNum(int x) {
    // List<String> revList = Arrays.asList(Integer.toString(x).split(""));
    // Collections.reverse(revList);
    // int rev;
    // try{
    // rev = Integer.parseInt(String.join("", revList));
    // }catch(NumberFormatException e){
    // rev=0;
    // }

    // return rev;
    // }
    public int reverse(int x) {
        return x > 0 ? revNum(x) : -revNum(-1*x);
    }

    public int revNum(int x) {
        int rev=0;
        int lastDigit=0;
        while(x!=0){
            lastDigit=x%10;
            x=x/10;
            //checks for int boundary
            if(rev>0 && rev>(Integer.MAX_VALUE-lastDigit)/10) return 0;
            if(rev<0 && rev<(Integer.MAX_VALUE-lastDigit)/10) return 0;
            rev=(rev*10)+lastDigit;
        }
        
        return rev;
    }
}
