class Solution {
    public int[] productExceptSelf(int[] nums) {
      int prefix[] = new int[ nums.length ];
      prefix[ 0 ] = nums[ 0 ];
      int suffix[] = new int[ nums.length ];
      suffix[ nums.length - 1 ] = nums[ nums.length - 1 ];
      int result[] = new int[ nums.length ];
      for ( int i = 0; i < nums.length - 1; i++ )
      {
        int espejo = nums.length - 1 - i;
        prefix[ i + 1 ] = nums[ i + 1 ] * prefix[ i ];
        suffix[ espejo - 1 ] = nums[ espejo - 1 ] * suffix[ espejo ];
      }

      for ( int i = 0; i < nums.length; i++ )
      {
        if ( i == 0 )
        {
          result[ i ] = 1 * suffix[ i + 1 ];
          continue;
        }
        if ( i == nums.length - 1 )
        {
          result[ i ] = prefix[ i - 1 ] * 1;
          continue;
        }
        result[ i ] = prefix[ i - 1 ] * suffix[ i + 1 ];
      }
      return result;
    }
  }
