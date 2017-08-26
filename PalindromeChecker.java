/*
 * Programmer: Jackson Lee
 * Program: PalindromeFinder
 * Purpose: Checks to see whether the palindromes are regular, word, combo, or non palindromes
 * Date: 3/11/16
 */
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class PalindromeChecker {
    //retruns true if and only if the input is a regular palindrome
    public boolean isRegularPalindrome(String palindrome) {
        palindrome = palindrome.replaceAll("\\W", "");
        
        int left = 0;
        int right = palindrome.length() - 1;

        if(palindrome.length() == 0 || palindrome.length() == 1) {
            return true;
        }
       
        if(palindrome.charAt(left) == palindrome.charAt(right)) {
            return isRegularPalindrome(palindrome.substring(1, right--));
        }
        return false;
    }
    //returns true if and only if the input is a word palindrome
    public boolean isWordPalindrome(String palindrome) {
        Scanner scan = new Scanner(palindrome.replaceAll("\\p{Punct}", ""));
        ArrayList<String> words = new ArrayList<>();
        
        while(scan.hasNext()) {
            words.add(scan.next());
        }
        
        int left = 0;
        int right = words.size() - 1;
        
        if(words.size() == 1) {
            return true;
        }
        
        if(words.size() > 2 && words.get(left).equals(words.get(right))) {
            words.remove(left);
            words.remove(right-1);
            return isWordPalindrome(words.toString());
        }
        
        return false;
    }
    //returns true if and only if the input is a combination palindrome
    public boolean isCombinationPalindrome(String palindrome) {
        if(isRegularPalindrome(palindrome) == true && isWordPalindrome(palindrome) == true) {
            return true;
        } else {
            return false;
        }
    }
}