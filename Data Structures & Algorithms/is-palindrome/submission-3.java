class Solution {
    public boolean isPalindrome(String s) {
        // Inicializamos los punteros en los extremos del String original
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            // Puntero izquierdo: avanza si NO es una letra o número
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            
            // Puntero derecho: retrocede si NO es una letra o número
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            // Comparamos transformando a minúsculas en tiempo real
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false; // Si un par no coincide, ya no es palíndromo
            }
            
            // Si eran iguales, movemos ambos punteros hacia el centro
            left++;
            right--;
        }
        
        return true;
    }
}
