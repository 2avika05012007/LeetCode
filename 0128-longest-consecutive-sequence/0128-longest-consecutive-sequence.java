import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int Maxcount = 1;
        int count = 1;
        if(nums.length == 0){
            return 0;
        }
        for(int i = 0; i<nums.length-1; i++){
            if((nums[i]+1) == nums[i+1]){
                count ++;
            }
            if(nums[i] == nums[i+1]){
                continue;
            }
            Maxcount = Math.max(count, Maxcount);
            if(!((nums[i]+1) == nums[i+1])){
                count = 1;
            }
        }
        return Maxcount;

    }
}