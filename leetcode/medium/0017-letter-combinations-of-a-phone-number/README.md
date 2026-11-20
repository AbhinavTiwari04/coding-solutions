# Letter Combinations of a Phone Number

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent. Return the answer in  **any order**.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

 

Original
Java
 **Example 1:** 

```
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

```

 **Example 2:** 

```
Input: digits = "2"
Output: ["a","b","c"]

```

 

 **Constraints:** 

- 1 <= digits.length <= 4
- digits[i] is a digit in the range ['2', '9'].

## Solution

**Language:** Java  
**Runtime:** 5 ms (beats 1.52%)  
**Memory:** 48.7 MB (beats 21.48%)  
**Submitted:** 2026-11-20T18:23:15.912Z  

```java
class Solution {
    public List<String> letterCombinations(String digits) {
      HashMap<Integer,List<String>>mp=new HashMap<>();
      mp.put(2,new ArrayList<>(Arrays.asList("a","b","c")));
      mp.put(3,new ArrayList<>(Arrays.asList("d","e","f")));
      mp.put(4,new ArrayList<>(Arrays.asList("g","h","i")));
      mp.put(5,new ArrayList<>(Arrays.asList("j","k","l")));
      mp.put(6,new ArrayList<>(Arrays.asList("m","n","o")));
      mp.put(7,new ArrayList<>(Arrays.asList("p","q","r","s")));
      mp.put(8,new ArrayList<>(Arrays.asList("t","u","v")));
      mp.put(9,new ArrayList<>(Arrays.asList("w","x","y","z")));  

      List<String>res=new ArrayList<>();

        List<String>l1=null;
        List<String>l2=null;
        List<String>l3=null;
        List<String>l4=null;

        if(digits.length()==4){
            l1=mp.get(digits.charAt(0)-'0');
            l2=mp.get(digits.charAt(1)-'0');
            l3=mp.get(digits.charAt(2)-'0');
            l4=mp.get(digits.charAt(3)-'0');
            
            for(int i=0;i<l1.size();i++){
                for(int j=0;j<l2.size();j++){
                    for(int k=0;k<l3.size();k++){
                        for(int l=0;l<l4.size();l++){
                            res.add(l1.get(i)+l2.get(j)+l3.get(k)+l4.get(l));
                        }
                       
                    }
                }
            }



        }else if(digits.length()==3){
            l1=mp.get(digits.charAt(0)-'0');
            l2=mp.get(digits.charAt(1)-'0');
            l3=mp.get(digits.charAt(2)-'0');


            for(int i=0;i<l1.size();i++){
                for(int j=0;j<l2.size();j++){
                    for(int k=0;k<l3.size();k++){
                         res.add(l1.get(i)+l2.get(j)+l3.get(k));
                    }
                   
                }
            }

        }else if(digits.length()==2){
           l1=mp.get(digits.charAt(0)-'0');
           l2=mp.get(digits.charAt(1)-'0');

            for(int i=0;i<l1.size();i++){
                for(int j=0;j<l2.size();j++){
                   res.add(l1.get(i)+l2.get(j));  
                }
                
            }

            
        }else if(digits.length()==1)
        return mp.get(digits.charAt(0)-'0');

        else if(digits.length()==0)
        return new ArrayList<>();


      return res;
    }
   
}
```

---

[View on LeetCode](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)