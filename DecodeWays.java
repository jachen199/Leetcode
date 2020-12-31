/*
A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "111" can have each of its "1"s be mapped into 'A's to make "AAA", or it could be mapped to "11" and "1" ('K' and 'A' respectively) to make "KA". Note that "06" cannot be mapped into 'F' since "6" is different from "06".

Given a non-empty string num containing only digits, return the number of ways to decode it.

The answer is guaranteed to fit in a 32-bit integer.

https://leetcode.com/problems/decode-ways/

*/

class DecodeWays {
    public int numDecodings(String s) {
        if(s.length() == 0)
            return 0;
        int[] possibleWays = new int[s.length() + 1];
        //index of possibleWays is the # of digits in the string currently
        possibleWays[0] = 1;
        
        if(s.charAt(0) == '0') //if it begins with 0, then thats not a number
            possibleWays[1] = 0;
        else
            possibleWays[1] = 1; //otherwise theres only 1 way to represent 1 number
        
        for(int i = 1; i < s.length(); i ++) { 
            if(s.charAt(i) != '0')
                possibleWays[i+1] += possibleWays[i]; // if the character is counted as as single digit
            int lastTwoDigits = Integer.parseInt(s.substring(i-1,i+1)); // combine the previous digit with the current one
            if(lastTwoDigits > 9 && lastTwoDigits < 27) // 9 < lastTwoDigits < 27 - can be represented as two digit number
                possibleWays[i+1] += possibleWays[i-1]; //if char counted as single digit + last two digits are combined  
        }
        return possibleWays[s.length()];
    }
}
