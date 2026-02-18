import java.util.*;

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if(n != 0) {
            if(m == 0){
                for(int i = 0; i < n; i++){
                    nums1[i] = nums2[i];
                }
            } else {
                int i = m;
                for(int j = 0; j < n; j++, i++){
                    nums1[i] = nums2[j];
                }
            }
        }

        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}