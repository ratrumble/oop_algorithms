package binaryRotationalArray;

class Solution {
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
            
            if(target > nums[nums.length - 1] && nums[lowerBound] < nums[0]){
                upperBound = lowerBound;
                lowerBound = 0;
                return rightHelper(upperBound, lowerBound, target, nums);
            }
            else{
                if(nums[mid] < target){
                    lowerBound += 1;
                    return right(upperBound, lowerBound, target, nums);
                }
                else{
                    if(nums[mid] > nums[nums.length-1]){
                        lowerBound = mid + 1;
                        return right(upperBound, lowerBound, target, nums);
                    }
                    upperBound -= 1;
                    return right(upperBound, lowerBound, target, nums);
                }
            }
        }
        return -1;
    }
    
    public int rightHelper(int upperBound, int lowerBound, int target, int[] nums){

        if(upperBound >= lowerBound){
            int mid = lowerBound + (upperBound - lowerBound) / 2;
            if(nums[mid]==target){
                return mid;
            }
            
            if(nums[mid] < target){
                lowerBound += 1;
                return rightHelper(upperBound, lowerBound, target, nums);
            }
            else{
                upperBound -= 1;
                return rightHelper(upperBound, lowerBound, target, nums);
            }
        }
        return -1;
    }
}
