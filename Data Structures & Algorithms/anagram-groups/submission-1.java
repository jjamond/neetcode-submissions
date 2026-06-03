class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for(String word: strs){
            String frequencyArrayHash = getFrequencyHash(word);
            anagrams.computeIfAbsent(frequencyArrayHash, k -> new ArrayList<>()).add(word);        
        }
        return new ArrayList<>(anagrams.values());
    }

    public String getFrequencyHash (String word){
        int[] frequencyArray = new int[26];
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            frequencyArray[index]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i =0; i<frequencyArray.length; i++){
            sb.append(frequencyArray[i]).append("#");
        }
        return sb.toString();
    }
}
