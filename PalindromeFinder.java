/*
 * Programmer: Jackson Lee
 * Program: PalindromeFinder
 * Purpose: Take in a list of palindromes and sort them into an ArrayList depending on what type of palindrome they are, then prints the ArrayLists
 * Date: 3/11/16
 */
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class PalindromeFinder extends PalindromeChecker{
    //main method: reads the list of palindromes and sorts them into their proper ArrayList, then prints the lists out
    public static void main(String[]args) {
        PalindromeFinder finder = new PalindromeFinder();
        ArrayList<String> regularPalindromes = new ArrayList<>();
        ArrayList<String> wordPalindromes = new ArrayList<>();
        ArrayList<String> combinationPalindromes = new ArrayList<>();
        ArrayList<String> nonPalindromes = new ArrayList<>();
        
        try {
            Scanner scan = new Scanner(new File("possiblePalindromes.txt"));
            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                String lineUpperCase = line.toUpperCase();
                boolean isPalindrome = false;
                               
                if(finder.isRegularPalindrome(lineUpperCase) == true) {
                    regularPalindromes.add(line);
                    isPalindrome = true;
                }
                
                if(finder.isWordPalindrome(lineUpperCase) == true) {
                    wordPalindromes.add(line);
                    isPalindrome = true;
                }
                
                 if(finder.isCombinationPalindrome(lineUpperCase) == true) {
                    combinationPalindromes.add(line);
                } 
                
                if(!isPalindrome) {
                    nonPalindromes.add(line);
                }
            }
        } catch(IOException e) {
            
        } finally {
            System.out.println("REGULAR PALINDROMES: ");
            for(int i = 0; i < regularPalindromes.size(); i++) {
                int lineNum = i + 1;
                System.out.println(lineNum + ". " + regularPalindromes.get(i));
            }
            System.out.println();
            
            System.out.println("WORD PALINDROMES: ");
            for(int i = 0; i < wordPalindromes.size(); i++) {
                int lineNum = i +1;
                System.out.println(lineNum + ". " + wordPalindromes.get(i));
            }
            System.out.println();
            
            System.out.println("COMBINATION PALINDROMES: ");
            for(int i = 0; i < combinationPalindromes.size(); i++) {
                int lineNum = i +1;
                System.out.println(lineNum + ". " + combinationPalindromes.get(i));
            }
            System.out.println();
            
            System.out.println("NON-PALINDROMES: ");
            for(int i = 0; i < nonPalindromes.size(); i++) {
                int lineNum = i +1;
                System.out.println(lineNum + ". " + nonPalindromes.get(i));
            }
        }
    }
}