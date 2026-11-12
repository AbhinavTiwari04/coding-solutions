# Longest Strictly Increasing or Strictly Decreasing Subarray

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given an array of integers `nums`. Return  *the length of the  **longest**  subarray of* `nums` *which is either  **strictly increasing**  or  **strictly decreasing***.

 

Original
Java
 **Example 1:** 

 **Input:**  nums = [1,4,3,3,2]

 **Output:**  2

 **Explanation:** 

The strictly increasing subarrays of `nums` are `[1]`, `[2]`, `[3]`, `[3]`, `[4]`, and `[1,4]`.

The strictly decreasing subarrays of `nums` are `[1]`, `[2]`, `[3]`, `[3]`, `[4]`, `[3,2]`, and `[4,3]`.

Hence, we return `2`.

 **Example 2:** 

 **Input:**  nums = [3,3,3,3]

 **Output:**  1

 **Explanation:** 

The strictly increasing subarrays of `nums` are `[3]`, `[3]`, `[3]`, and `[3]`.

The strictly decreasing subarrays of `nums` are `[3]`, `[3]`, `[3]`, and `[3]`.

Hence, we return `1`.

 **Example 3:** 

 **Input:**  nums = [3,2,1]

 **Output:**  3

 **Explanation:** 

The strictly increasing subarrays of `nums` are `[3]`, `[2]`, and `[1]`.

The strictly decreasing subarrays of `nums` are `[3]`, `[2]`, `[1]`, `[3,2]`, `[2,1]`, and `[3,2,1]`.

Hence, we return `3`.

 

 **Constraints:** 

- 1 <= nums.length <= 50
- 1 <= nums[i] <= 50

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 98.38%)  
**Memory:** 43.9 MB (beats 85.71%)  
**Submitted:** 2026-11-12T14:16:40.482Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/)