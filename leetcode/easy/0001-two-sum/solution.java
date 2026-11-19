class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer,Integer>mp=new HashMap<>();
       for(int k=0;k<nums.length;k++){
        if(mp.containsKey(nums[k])&&nums[k]*2==target){
            return new int[]{mp.get(nums[k]),k};
        }
        else if(mp.containsKey(target-nums[k])){
            return new int[]{k,mp.get(target-nums[k])};
        }
        mp.put(nums[k],k);
       }
       return new int[2];
    }
}