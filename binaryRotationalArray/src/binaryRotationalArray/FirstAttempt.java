/**
package binaryRotationalArray;

did not work at first, should create a helper method whenever meeting a possible StackOverFlow condition
helper might be sloppy, could probably figure out a better condition to find out when the array begins rotating

forgot basics(method to figure out mid and the if(nums[index] > target) conditions

public class Solution {
    public int search(int[] nums, int target) {
        int upperBound = nums.length - 1;
        int lowerBound = 0;
        int mid = lowerBound + (upperBound - lowerBound) / 2;
        
        if(nums.length == 0){
            return -1;
        }
        if(nums[mid] == target){
            return mid;
        }
        
        return right(upperBound, lowerBound, target, nums);
        
    }
    
    public int right(int upperBound, int lowerBound, int target, int[] nums){

        if(upperBound >= lowerBound){
            int mid = lowerBound + (upperBound - lowerBound) / 2;
            if(nums[mid]==target){
                return mid;
            }
            System.out.println("lowerBound value is " + nums[lowerBound]);
            if(target > nums[nums.length - 1] && nums[lowerBound] < nums[0]){
                upperBound = lowerBound;
                lowerBound = 0;
                System.out.println("line 31 \n upperBound is " + upperBound + "\n lowerBound is " + lowerBound);
                return right(upperBound, lowerBound, target, nums);
            }
            else{
                if(nums[mid] > target){
                    lowerBound += 1;
                    System.out.println("line 37 \n upperBound is " + upperBound + "\n lowerBound is " + lowerBound);
                    return right(upperBound, lowerBound, target, nums);
                }
                else{
                    upperBound -= 1;
                    return right(upperBound, lowerBound, target, nums);
                }
            }
        }
        return -1;
    }
    
    public static void main (String[] args) {
    	Solution sol = new Solution();
    	int nums[] = {4, 5, 6, 0, 1, 2};
    	sol.search(nums, 3);
    }
}
**/