/* 
https://leetcode.com/problems/detect-capital/

Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.

*/
class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if(!word.equals(word.toUpperCase()) && !word.equals(word.toLowerCase()) && !isFirstLetterCap(word)) 
            return false;
        return true;
        
    
    }
  public boolean isFirstLetterCap(String word) {
    return (
      word.substring(0,1).toUpperCase().equals(word.substring(0,1)) 
      &&
      word.substring(1,word.length()).toLowerCase().equals(word.substring(1,word.length())));

  }
}