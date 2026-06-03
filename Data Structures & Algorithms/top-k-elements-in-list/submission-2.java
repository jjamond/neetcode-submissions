class Solution {
    public int[] topKFrequent(int[] nums, int k) {
// 1. Contar frecuencias correctamente
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // 2. Usar un Min-Heap (PriorityQueue) de tamaño K
        // Le enseñamos al heap a ordenar comparando las frecuencias del mapa
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> frequencyMap.get(a) - frequencyMap.get(b)
        );
        
        // 3. Meter las llaves al heap. Al dejarlo en tamaño K, el heap 
        // siempre expulsará a los que tengan menor frecuencia.
        for (int num : frequencyMap.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Saca el menos frecuente
            }
        }
        
        // 4. Pasar los K elementos restantes al arreglo final
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}