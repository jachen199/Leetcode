/* 
https://leetcode.com/problems/increasing-triplet-subsequence/
Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
*/
class IncreasingTripletSubseq {
    public boolean increasingTriplet(int[] nums) {
        for(int i = 0; i < nums.length; i ++) {
            for(int j = i + 1; j < nums.length; j ++) {
                if(nums[j] > nums[i]) {
                    for(int k = j + 1; k < nums.length; k ++) {
                        if(nums[k] > nums[j]){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}