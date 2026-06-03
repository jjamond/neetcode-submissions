class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        
        // El Key debe ser Double o Long para evitar desbordamiento rápido
        Map<Double, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            double hash = 1.0;
            for (char c : s.toCharArray()) {
                hash *= primes[c - 'a'];
            }
            
            // computeIfAbsent es una forma elegante de hacer el if/else
            map.computeIfAbsent(hash, k -> new ArrayList<>()).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}
