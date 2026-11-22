class Solution {
    public boolean checkString(String s) {
        int b=s.indexOf('b');
        if(b<s.lastIndexOf('a') && b!=-1)return false;
        return true;
    }
}