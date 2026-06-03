class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                
                if (val != '.') { // Si hay un número
                    // Creamos los tres identificadores semánticos
                    String rowKey = val + " en fila " + r;
                    String colKey = val + " en col " + c;
                    String boxKey = val + " en caja " + (r / 3) + "-" + (c / 3);
                    
                    // Si al intentar añadir alguno al Set devuelve false,
                    // significa que ya existía un duplicado en esa fila, col o caja.
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
