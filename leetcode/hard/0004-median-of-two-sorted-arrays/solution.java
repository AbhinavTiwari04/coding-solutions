class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int [] sol= new int[nums1.length + nums2.length];
        int k=0;
        int i=0,j=0;

        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                sol[k++]=nums1[i++];
            }
            else{
                sol[k++]=nums2[j++];
            }
        }

        while(i<nums1.length){
            sol[k++]=nums1[i++];
        }
        while(j<nums2.length){
            sol[k++]=nums2[j++];
        }

        int m=sol.length;
        double ans;

        if(m%2==0){
            ans=(sol[m/2-1]+sol[m/2])/2.0;
        }
        else{
            ans=sol[m/2];
        }
    return ans;

    }
}
