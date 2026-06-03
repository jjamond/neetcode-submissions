class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visited = new HashMap<>();
        for(int i =0; i< nums.length; i++){
            int res = target - nums[i];
            if(visited.containsKey(res)){
                return new int[]{visited.get(res), i};
            }
            visited.put(nums[i], i);
        }
        return new int[]{};
    }
}
