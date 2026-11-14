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