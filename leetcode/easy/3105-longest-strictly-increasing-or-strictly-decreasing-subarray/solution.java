class Solution {
    public int longestMonotonicSubarray(int[] nums) {
      //check for SI
      int left=0, lenSI=1, lenSD=1;
      for(int right=1;right<nums.length;right++){
        if(nums[right]<=nums[right-1]){
            left=right;
            continue;
        }
            lenSI=Math.max(lenSI, right-left+1);
      }
      //check for SD
      left=0;
      for(int right=1;right<nums.length;right++){
        if(nums[right]>=nums[right-1]){
            left=right;
            continue;
        }
            lenSD=Math.max(lenSD, right-left+1);
      }
      return Math.max(lenSI, lenSD);  
    }
}