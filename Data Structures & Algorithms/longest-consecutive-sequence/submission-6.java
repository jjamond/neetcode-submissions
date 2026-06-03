class Solution {
    public int longestConsecutive(int[] nums) {
    
        Set<Integer> numSet = new HashSet<>();
        for(Integer num: nums){
            numSet.add(num);
        }
    
        int maxLength = 0;
        for (int num : numSet) {
            // TRUCO CLAVE: ¿Es este el inicio de una secuencia?
            // Si el set contiene (num - 1), significa que "num" NO es el inicio.
            // Lo saltamos porque otra iteración se encargará de contar toda esta secuencia.
            if (!numSet.contains(num - 1)) {
                
                int currentNum = num;
                int currentStreak = 1; // TRUCO: Asumimos que "num" ya cuenta como longitud 1

                // Buscamos activamente los sucesores (num + 1, num + 2...)
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Conservamos el máximo alcanzado
                maxLength = Math.max(maxLength, currentStreak);
            }
        }

        return maxLength;
    }
}
