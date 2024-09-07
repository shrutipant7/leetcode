// Intuitive solution:
// class Solution {
//     public void rotate(int[] nums, int k) {
//         int n = nums.length;
//         if (n==1 || k ==0) return;
//         int temp[] = new int[n];
//         int t = 0;
//         int mod = k%n;
//         for (int i= n-mod; i<n; i++) {
//             temp[t] = nums[i];
//             t++;
//         }
//         for (int i=0; i<n-mod; i++) {
//             temp[t] = nums[i];
//             t++;
//         }
//         for (int i=0; i<n; i++) {
//             nums[i] = temp[i];
//         }
//     }
// }


//Optimized solution:
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n==1 || k ==0) return;
        int temp[] = new int[n];
        int t = 0;
        int mod = k%n;
        for (int i=0, j=n-mod-1; i<j; i++, j--) {
            swap(nums, i, j);
        }
        for (int i=n-mod, j=n-1; i<j; i++, j--) {
            swap(nums, i, j);
        }
        for (int i=0, j=n-1; i<j; i++, j--) {
            swap(nums, i, j);
        }
    }

    public void swap (int[] nums, int n1, int n2) {
        int temp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = temp;
    }
}
