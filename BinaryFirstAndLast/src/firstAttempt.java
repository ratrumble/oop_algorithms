/**
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int searchIndex = (nums.length-1)/2;
        int[] range = new int[2];
        int targetIndex = -1;
        int targetIndex2 = -1;
        int upperBound = nums.length-1;
        int lowerBound = 0;
        if(nums.length == 0){
            return new int[] {targetIndex, targetIndex};
        }
        if(nums[searchIndex]!=target){
            
            if(nums[searchIndex] < target){
                lowerBound = searchIndex + 1;
                if(lowerBound > upperBound){
                    return new int[] {targetIndex, targetIndex};
                }
                searchIndex = lowerBound + (upperBound - lowerBound)/2;
                return searchRangeHelper(nums, target, upperBound, lowerBound, targetIndex, searchIndex);
            }
            else{
                upperBound = searchIndex-1;
                if(upperBound < lowerBound){
                    return new int[] {targetIndex, targetIndex};
                }
                searchIndex = lowerBound + (upperBound - lowerBound)/2;
                return searchRangeHelper(nums, target, upperBound, lowerBound, targetIndex, searchIndex);
            }
            
            
        }
        else{
            targetIndex = searchIndex;
            if(checkLeft(targetIndex, nums, target, lowerBound)>-1){
                targetIndex2 = checkLeft(targetIndex, nums, target, lowerBound);
            }
            else{
                targetIndex2 = checkRight(targetIndex, nums, target, upperBound);
            }
            //case where no 2nd target
            if(targetIndex2 == -1){
                targetIndex2 = targetIndex;
            }
            //put the smaller index first
            if(targetIndex > targetIndex2){
                return new int[] {targetIndex2, targetIndex};
            }
            else{
                return new int[] {targetIndex, targetIndex2};
            }
        }
    }
    
    public int[] searchRangeHelper(int[] nums, int target, int upperBound, int lowerBound, int targetIndex, 
                                  int searchIndex) {
        int[] range = new int[2];
        int targetIndex2 = -1;
        
        if(nums[searchIndex]!=target){
            
            if(nums[searchIndex] < target){
                lowerBound = searchIndex + 1;
                if(lowerBound > upperBound){
                    return new int[] {targetIndex, targetIndex};
                }
                searchIndex = lowerBound + (upperBound - lowerBound)/2;
                return searchRangeHelper(nums, target, upperBound, lowerBound, targetIndex, searchIndex);
            }
            else{
                upperBound = searchIndex-1;
                if(upperBound < lowerBound){
                    return new int[] {targetIndex, targetIndex};
                }
                searchIndex = lowerBound + (upperBound - lowerBound)/2;
                return searchRangeHelper(nums, target, upperBound, lowerBound, targetIndex, searchIndex);
            }
            
            
        }
        else{
            targetIndex = searchIndex;
            if(checkLeft(targetIndex, nums, target, lowerBound)>-1){
                targetIndex2 = checkLeft(targetIndex, nums, target, lowerBound);
            }
            else{
                targetIndex2 = checkRight(targetIndex, nums, target, upperBound);
            }
            //case where no 2nd target
            if(targetIndex2 == -1){
                targetIndex2 = targetIndex;
            }
            //put the smaller index first
            if(targetIndex > targetIndex2){
                return new int[] {targetIndex2, targetIndex};
            }
            else{
                return new int[] {targetIndex, targetIndex2};
            }
        }
    }
    
    this one was extremely messy because 
    firstly, i tried to return both targetIndex1 and targetIndex2 at the same time into one array
    what I should've done is make that solely the return method, and rely on other methods to recurse themselves
    
    my approach to find the very end was to go until -1 is returned
    a much simpler approach when binary searching is to use index-1 and compare it to the target, that way
    the targets on the sorted array has come to an end
    
    
    decided to completely wipe this attempt due to messy code, felt like i needed to create many helper classes
    
    public int checkLeft(int index, int[] nums, int target, int lowerBound){
        int upperBound = index - 1;
        int searchIndex = upperBound/2;
        return searchRangeHelper(nums, target, upperBound, lowerBound, index, searchIndex)[0];
    }
    
    
    public int checkRight(int index, int[] nums, int target, int upperBound){
        int lowerBound = index + 1;
        int searchIndex = (lowerBound + (upperBound - lowerBound) / 2);
        return searchRangeHelper(nums, target, upperBound, lowerBound, index, searchIndex)[1];
    }
}
**/