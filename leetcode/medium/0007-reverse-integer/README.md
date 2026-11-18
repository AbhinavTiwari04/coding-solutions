# Reverse Integer

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a signed 32-bit integer `x`, return `x` *with its digits reversed*. If reversing `x` causes the value to go outside the signed 32-bit integer range `[-231, 231 - 1]`, then return `0`.

 **Assume the environment does not allow you to store 64-bit integers (signed or unsigned).** 

 

Original
Java
 **Example 1:** 

```
Input: x = 123
Output: 321

```

 **Example 2:** 

```
Input: x = -123
Output: -321

```

 **Example 3:** 

```
Input: x = 120
Output: 21

```

 

 **Constraints:** 

- -231 <= x <= 231 - 1

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 99.99%)  
**Memory:** 42.2 MB (beats 63.80%)  
**Submitted:** 2026-11-18T20:51:01.064Z  

```java
class Solution {
    public int reverse(int x) {
        int y=x;
        if(x<0)y*=-1;
        long ans=0;
        while(y>0){
            ans=ans*10+y%10;
            y/=10;
        }
        if(ans>Integer.MAX_VALUE)return 0;
      return  x<0?(int)ans*-1:(int)ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/reverse-integer/)