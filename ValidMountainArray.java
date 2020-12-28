/* 
https://leetcode.com/problems/valid-mountain-array/
Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
*/
class validMountainArray {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3)
            return false;
        boolean increasing = arr[1] > arr[0];
        if(!increasing)
            return false;
        for(int i = 0; i < arr.length-1; i ++){
            if(increasing){
                if(arr[i] >= arr[i+1]){
                    increasing = false;
                    if(arr[i] <= arr[i+1])
                        return false;
                }
                
            }
            else {
              if(arr[i] <= arr[i+1])
                return false;
            }
        }
        System.gc();
        return !increasing;
    }
}