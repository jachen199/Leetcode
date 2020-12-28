/* 
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:

1 <= nums.length <= 3 * 104
0 <= nums[i] <= 105

https://leetcode.com/problems/jump-game/

*/




class JumpGame {
    public static void main(String[] args) {
      int[] arr = new int[] { 2, 3, 1, 1, 4 };
      System.out.println(canJump(arr));
    }
  
    public static boolean canJump(int[] nums) {
      if (nums.length == 0)
        return false;
      int furthest = nums[0];
      if (furthest >= nums.length - 1)
        return true;
      for (int i = 0; i < nums.length - 1; i++) {
        furthest = Math.max(furthest - 1, nums[i]);
        if (furthest == 0)
          return false;
      }
      return true;
    }
  }