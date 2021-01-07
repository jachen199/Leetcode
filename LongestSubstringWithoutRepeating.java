/* 
Given a string s, find the length of the longest substring without repeating characters.
*/
Class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        String[] longestSubstring = new String[s.length() + 1];
        longestSubstring[0] = s.substring(0,1);
        
        int max = 1;
        for(int i = 1; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(longestSubstring[i-1].contains(String.valueOf(c))) {
                longestSubstring[i] = longestSubstring[i-1].substring(longestSubstring[i-1].indexOf(c) + 1,longestSubstring[i-1].length()) + c;
            }
            else {
                longestSubstring[i] = longestSubstring[i-1] + c;
                int length = longestSubstring[i].length();
                if(length > max)
                    max = length;
            }
        }
        return max;
    }
}