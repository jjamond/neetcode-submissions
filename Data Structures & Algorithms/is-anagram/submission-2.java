class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;
        int[] alphabet1 = new int[26];
        for( int i =0; i< s.length(); i++){
            alphabet1[s.charAt(i) - 'a']++;
            alphabet1[t.charAt(i) - 'a']--;
        }

        for ( int i = 0; i < alphabet1.length; i++ )
        {
           if(alphabet1[i] != 0){
            return false;
           }
        }
        return true;
    }
}
