/* 
https://leetcode.com/problems/add-two-numbers/
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 
Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

*/

class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addFirst(l1,l2);
        
    }
    public ListNode addFirst(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode();
        if(l1 == null && l2 == null) {
            return ret;
        }
        else if(l1 == null) {
            ret.val = l2.val;
            addTwoNumbersHelper(l1,l2.next, 0, ret);
        }
        else if(l2 == null) {
            ret.val = l1.val;
            addTwoNumbersHelper(l1.next,l2, 0, ret);
        }
        else {
            int sum = l1.val + l2.val;
            if(sum >= 10) {
                ret.val = sum - 10;
                addTwoNumbersHelper(l1.next, l2.next, 1, ret);
            }
            else {
                ret.val = sum;
                addTwoNumbersHelper(l1.next, l2.next, 0, ret);
            }
        }
        return ret;
    }
    
    public void addTwoNumbersHelper(ListNode l1, ListNode l2, int carry, ListNode ret) {
        if(l1 == null && l2 == null) {
            if(carry != 0)
                ret.next = new ListNode(carry);
        }
        else if(l1 == null) {
            int sum = carry + l2.val;
            if(sum >= 10) {
                ret.next = new ListNode(sum - 10);
                addTwoNumbersHelper(l1,l2.next, 1, ret.next);
            }
            else {
                ret.next = new ListNode(sum);
                addTwoNumbersHelper(l1,l2.next, 0, ret.next);
            }
        }
        else if(l2 == null) {
            int sum = carry + l1.val;
            if(sum >= 10) {
                ret.next = new ListNode(sum - 10);
                addTwoNumbersHelper(l1.next,l2, 1, ret.next);
            }
            else {
                ret.next = new ListNode(sum);
                addTwoNumbersHelper(l1.next,l2, 0, ret.next);
            }
        }
        else {
            int sum = carry + l1.val + l2.val;
            if(sum >= 10) {
                ret.next = new ListNode(sum-10);
                addTwoNumbersHelper(l1.next, l2.next, 1, ret.next);
            }
            else {
                ret.next = new ListNode(sum);
                addTwoNumbersHelper(l1.next, l2.next, 0, ret.next);
            }
        }
        
    }
}