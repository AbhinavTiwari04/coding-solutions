class Solution {
    public boolean canAliceWin(int n) {
        if(n<10)return false;
        int i=10;
        while(n>=0){
            if(n-i<0)return i%2==0 ?false: true;
            n-=i;
            i--;
        }
        return false;
    }
}