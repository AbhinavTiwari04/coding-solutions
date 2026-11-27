class Solution {
    public int[] frequencySort(int[] nums) {
      HashMap<Integer, Integer>mp=new HashMap<>();
      PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{
        int getA=mp.get(a), getB=mp.get(b);
      if(getA!=getB)
      return
      getA-getB;
      else 
      return
      b-a;

      }
      );

      for(int k:nums)
        mp.put(k, mp.getOrDefault(k,0)+1);
      for(Integer k:mp.keySet()){
        int t=mp.get(k);    
        while(t-->0)
            pq.offer(k);
      }
      int i=0;
      int ans[]=new int[nums.length];
      while(!pq.isEmpty())
        ans[i++]=pq.poll();
      
      return ans;
    }
}