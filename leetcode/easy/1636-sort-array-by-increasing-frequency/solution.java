class Solution {
    public int[] frequencySort(int[] nums) {
        
      HashMap<Integer, Integer>mp=new HashMap<>();
      
      for(int k:nums)
        mp.put(k, mp.getOrDefault(k,0)+1);
      Integer arr[]=new Integer[nums.length];
      for(int j=0;j<nums.length;j++)
        arr[j]=(Integer)nums[j];
      Arrays.sort(arr, (a,b)->{
      if(mp.get(a)!=mp.get(b))
      return
      mp.get(a)-mp.get(b);
      else 
      return
      b-a;
      });

      for(int j=0;j<arr.length;j++){
        nums[j]=(int)arr[j];
      }
      return nums;
    //   PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{
    //   if(mp.get(a)!=mp.get(b))
    //   return
    //   mp.get(a)-mp.get(b);
    //   else 
    //   return
    //   b-a;

    //   }
    //   );

    //   for(int k:nums)
    //     mp.put(k, mp.getOrDefault(k,0)+1);
    //   for(Integer k:mp.keySet()){
    //     int t=mp.get(k);    
    //     while(t-->0)
    //         pq.offer(k);
    //   }
    //   int i=0;
    //   int ans[]=new int[nums.length];
    //   while(!pq.isEmpty())
    //     ans[i++]=pq.poll();
      
    //   return ans;
    }
}