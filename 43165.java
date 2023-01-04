class Solution {
    private int dfs(int nums[], int t, int index, int curr) {
        if (index >= nums.length)
            return curr == t ? 1 : 0;
        
        return dfs(nums, t, index + 1, curr + nums[index]) +
            dfs(nums, t, index + 1, curr + -nums[index]);
    }
    
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
}
