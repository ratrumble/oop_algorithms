package binaryRotationalArray;

class Solution {
    public int search(int[] nums, int target) {
        int upperBound = nums.length - 1;
        int lowerBound = 0;
        int mid = lowerBound + (upperBound - lowerBound) / 2;
        int targetIndex = -1;
        
        if(nums.length == 0){
            return -1;
        }
        if(nums[mid] == target){
            return mid;
        }
        
        return bst(upperBound, lowerBound, target, nums);
        
    }
    
    public int bst(int upperBound, int lowerBound, int target, int[] nums){

        if(upperBound < lowerBound){
            return -1;
        }
        int mid = lowerBound + (upperBound - lowerBound) / 2;
        
        if(nums[mid] == target){
            return mid;
        }
        
        if(nums[lowerBound] <= nums[mid]){
            if(target >= nums[lowerBound] && target <= nums[mid]){
                upperBound = mid - 1;
            }
            else{
                lowerBound = mid + 1;
            }
        }
        else{
            if(target >= nums[mid] && target <= nums[upperBound]){
                lowerBound = mid + 1;
            }
            else{
                upperBound = mid - 1;
            }
        }
        return bst(upperBound, lowerBound, target, nums);
    }
    
}