# Sort Array by Increasing Frequency

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array of integers `nums`, sort the array in  **increasing**  order based on the frequency of the values. If multiple values have the same frequency, sort them in  **decreasing**  order.

Return the  *sorted array*.

 

Original
Java
 **Example 1:** 

```
Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

```

 **Example 2:** 

```
Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

```

 **Example 3:** 

```
Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]
```

 

 **Constraints:** 

- 1 <= nums.length <= 100
- -100 <= nums[i] <= 100

## Solution

**Language:** Java  
**Runtime:** 8 ms (beats 64.08%)  
**Memory:** 44.9 MB (beats 85.06%)  
**Submitted:** 2026-11-27T12:25:07.187Z  

```java
class Solution {
    public int[] frequencySort(int[] nums) {
        
      HashMap<Integer, Integer>mp=new HashMap<>();
      
      for(int k:nums)
        mp.put(k, mp.getOrDefault(k,0)+1);
      Integer arr[]=new Integer[nums.length];
      for(int j=0;j<nums.length;j++)
        arr[j]=(Integer)nums[j];
      Arrays.sort(arr, (a,b)->{
        int getA=mp.get(a);
        int getB=mp.get(b);
      if(getA!=getB)
      return
      getA-getB;
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
```

---

[View on LeetCode](https://leetcode.com/problems/sort-array-by-increasing-frequency/)