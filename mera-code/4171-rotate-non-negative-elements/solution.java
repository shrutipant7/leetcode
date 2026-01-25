class Solution {
    public int[] rotateElements(int[] nums, int k) {
        int len = nums.length;
        if (k == 0 || len == 1)
            return nums;
        List<Integer> pos = new ArrayList<>();
        for (int x : nums) {
            if (x >= 0)
                pos.add(x);
        }
        if (pos.size() == 0 || k % (pos.size()) == 0)
            return nums;
        rotate(pos, k);
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] >= 0)
                nums[i] = pos.get(j++);
        }
        return nums;
    }

    public void rotate(List<Integer> nums, int k) {
        int n = nums.size();
        int mod = k % n;
        for (int i = 0, j = mod - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
        for (int i = mod, j = n - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    public void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
