class Solution {
    public int countDominantElements(int[] nums) {
       int dom=0;
        if(nums.length==1)return 1;
        for(int i=0;i<nums.length;i++){
            if(i==0) {
               if(i+1<nums.length && nums[i]>nums[i+1])
                dom++;
            }
            else if(i==nums.length-1){
                    if(nums[i]>nums[i-1])
                dom++;
            }
            else{
                int left=nums[i-1];
                int right=nums[i+1];
                int num=nums[i];
                if(num>=(left+right)/2)dom++;
            }
        } 
        return dom;
    }
}