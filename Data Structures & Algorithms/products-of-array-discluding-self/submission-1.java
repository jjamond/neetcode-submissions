class Solution {
    public int[] productExceptSelf(int[] nums) {
      int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];
        
        // 1. Llenamos el prefijo (Estrictamente a la izquierda)
        prefix[0] = 1; // A la izquierda del primero no hay nada, ponemos 1.
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        
        // 2. Llenamos el sufijo (Estrictamente a la derecha)
        suffix[n - 1] = 1; // A la derecha del último no hay nada, ponemos 1.
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        
        // 3. Multiplicamos izquierda por derecha (¡Sin IFs ni casos especiales!)
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        
        return result;
    }
  }
