/* 
https://leetcode.com/problems/can-place-flowers/

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
*/
class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int placed = 0;        
        
        if(flowerbed.length == 1 && flowerbed[0] == 0)
            return 1 >= n;
        if(flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            placed++;
        }
        
        if(flowerbed[flowerbed.length -1] == 0 && flowerbed[flowerbed.length-2] == 0){
            flowerbed[flowerbed.length -1] = 1;
            placed++;
        }
        
        for(int i = 1; i < flowerbed.length-1; i ++) {
            if(flowerbed[i] ==  0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                flowerbed[i] = 1;
                placed ++;
            }
        }
        return placed >= n;
            
    }
}