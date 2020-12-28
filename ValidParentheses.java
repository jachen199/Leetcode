/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
https://leetcode.com/problems/valid-parentheses/

*/
class ValidParentheses {
    public boolean isValid(String s) {
        ArrayList<Character> chars = new ArrayList<Character>();
		char cur;
		char popped;
		for (int i = 0; i < s.length(); i++) {
			cur = s.charAt(i);
			if(cur == '(' || cur == '{' || cur == '[') {
				chars.add(cur);
				//System.out.println("added " + cur);
			}
            
			if(cur == ')') {
                if(chars.size() == 0)
                    return false;
				popped = chars.remove(chars.size() - 1);
				//System.out.println("cur = " + cur + " popped = " + popped);
				if(popped != '(') {
					return false;
				}
			}
			if(cur == '}') {
                if(chars.size() == 0)
                    return false;
				popped = chars.remove(chars.size() - 1);
				//System.out.println("cur = " + cur + " popped = " + popped);
				if(popped != '{') {
					return false;
				}
			}
			if(cur == ']') {
                if(chars.size() == 0)
                    return false;
				popped = chars.remove(chars.size() - 1);
				//System.out.println("cur = " + cur + " popped = " + popped);
				if(popped != '[') {
					return false;
				}
			}
			
		}
		return chars.size() == 0;
    }
}