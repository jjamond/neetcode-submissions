class Solution {
    public int longestConsecutive(int[] nums) {
  
    
        Set<Integer> numsWithoutDuplication = new HashSet<>();
        for(Integer num: nums){
            numsWithoutDuplication.add(num);
        }
    
        int max =0;
        int count =0;
        for(Integer num: nums){
            int current = num;
            while(numsWithoutDuplication.contains(current)){
                count++; 
                current = current +1;
            }
            if(count>max){
                max = count;
            }
            count = 0;
        }
        return max;
    }
}
