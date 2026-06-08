class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length -1;
        int maxArea = 0;
        while (l<=r){
            int min = Math.min(heights[l], heights[r]);
            int diff = r - l;
            int max = min * diff;
            maxArea = Math.max(max, maxArea);
            if(heights[l] < heights[r]){
                l++;
            }else if(heights[l] > heights[r]){
                r--;
            }else{
                r--;
            }
        }
        return maxArea;
    }
}
