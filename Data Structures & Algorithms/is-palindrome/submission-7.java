class Solution {
    public boolean isPalindrome( String s )
    {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase().trim();
        while ( left < right )
        {
            while ( !Character.isLetterOrDigit( s.charAt( left )) && left<right ) 
            {
                left++;
            }
            while ( !Character.isLetterOrDigit( s.charAt( right )) && left<right )  
            {
                right--;
            }
            if ( s.charAt( left ) == s.charAt( right ) )
            {
                left++;
                right--;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}
