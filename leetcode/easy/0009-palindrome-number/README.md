# Palindrome Number

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an integer `x`, return `true` if `x` is a  **palindrome**, and `false` otherwise.

 

Original
Java
 **Example 1:** 

```
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

```

 **Example 2:** 

```
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

```

 **Example 3:** 

```
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

```

 

 **Constraints:** 

- -231 <= x <= 231 - 1

 

 **Follow up:**  Could you solve it without converting the integer to a string?

## Solution

**Language:** Java  
**Runtime:** 14 ms (beats 35.25%)  
**Memory:** 45.6 MB (beats 71.43%)  
**Submitted:** 2026-11-14T12:47:53.090Z  

```java
class Solution {
    public boolean isPalindrome(int x) {
        int z=x;
        int s=0;
        if(x<0)
        return false;

        while(x!=0){
            int p=x%10;
            s=p+s*10;
            x/=10;

        }
        if(z==s)
        return true;
        return false;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/palindrome-number/)