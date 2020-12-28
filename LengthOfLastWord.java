/* 
Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.

A word is a maximal substring consisting of non-space characters only.

Example 1:

Input: s = "Hello World"
Output: 5
Example 2:

Input: s = " "
Output: 0
https://leetcode.com/problems/length-of-last-word/
*/
class lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int indexStart = 0;
        if(s.equals(""))
            return 0;
        s = removeTrailingSpaces(s);
        for(int i = s.length() - 1; i >= 0; i --) {
            char c = s.charAt(i);
            if(c == ' ')
                return s.length() - i - 1;
        }
        return s.length();
    }
    
    public String removeTrailingSpaces(String s) {
        String newString = "";
        boolean adding = false;
        for(int i = s.length() -1; i >= 0; i --) {
            if(!adding && s.charAt(i) != ' ')
                adding = true;
            if(adding)
                newString = s.charAt(i) + newString;
        }
        return newString;
        
    }
}