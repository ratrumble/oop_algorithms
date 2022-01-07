class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int upperBound = nums.length - 1;
        int lowerBound = 0;
        int targetIndex1 = -1;
        int targetIndex2 = -1;
        int searchTarget = search(upperBound, lowerBound);
        targetIndex1 = lowerTarget(nums, lowerBound, upperBound, target, searchTarget);
        targetIndex2 = upperTarget(nums, lowerBound, upperBound, target, searchTarget);
        if(targetIndex1==-1){
            targetIndex1 = targetIndex2;
        }
        if(targetIndex2==-1){
            targetIndex2 = targetIndex1;
        }
        
        return new int[] {targetIndex1, targetIndex2};
        
    }
    
    public int lowerTarget(int[] nums, int lowerBound, int upperBound, int target, int searchTarget){
        
        if (upperBound >= lowerBound) {
            if ((searchTarget == 0 || target > nums[searchTarget - 1]) && nums[searchTarget] == target) {
                return searchTarget;
            }
            else if (target > nums[searchTarget]) {
                lowerBound = searchTarget + 1;
                searchTarget = search(upperBound, lowerBound);
                return lowerTarget(nums, lowerBound, upperBound, target, searchTarget);
            }
            else {
                upperBound = searchTarget - 1;
                searchTarget = search(upperBound, lowerBound);
                return lowerTarget(nums, lowerBound, upperBound, target, searchTarget);
            }
        }
        return -1;
    }
    
    
    public int upperTarget(int nums[], int lowerBound, int upperBound, int target, int searchTarget){
        
        if (upperBound >= lowerBound) {
            if ((searchTarget == nums.length - 1 || target < nums[searchTarget + 1]) && nums[searchTarget] == target) {
                return searchTarget;
            }
            else if (target < nums[searchTarget]) {
                upperBound = searchTarget - 1;
                searchTarget = search(upperBound, lowerBound);
                return upperTarget(nums, lowerBound, upperBound, target, searchTarget);
            }
            else {
                lowerBound = searchTarget + 1;
                searchTarget = search(upperBound, lowerBound);
                return upperTarget(nums, lowerBound, upperBound, target, searchTarget);
            }
        }
        return -1;
    }
    
    public int search(int upperBound, int lowerBound){
        return lowerBound + (upperBound - lowerBound) / 2;
    }
}