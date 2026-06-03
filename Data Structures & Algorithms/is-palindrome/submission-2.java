class Solution {
    public boolean isPalindrome(String s) {
        String newString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        char[] chars = newString.toCharArray();
        System.out.println(chars);
        int left =0;
        int right = chars.length - 1;
        while(left <= right){
            System.out.println("left " + left + " right " + right);
            if(chars[left]!=chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
