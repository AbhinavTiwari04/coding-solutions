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