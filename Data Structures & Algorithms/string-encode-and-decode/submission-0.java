class Solution {

 public  String encode( List<String> strs )
  {
    StringBuilder encodedString = new StringBuilder();
    for ( String word : strs )
    {
      for ( char letter : word.toCharArray() )
      {
        encodedString.append( ( int ) letter ).append( "#" );
      }
      encodedString.append( "|" );
    }
    return encodedString.toString();
  }

  public  List<String> decode( String str)
  {
    List<String> palabrasDecodificadas = new ArrayList<>();
    
    // REGLA 1: Si el string está totalmente vacío, significa que la lista original estaba vacía [ ]
    if ( str == null || str.isEmpty() )
    {
      return palabrasDecodificadas; // Devuelve la lista vacía de inmediato
    }

    // REGLA 2: Usamos el segundo parámetro (-1) en el split.
    // Al usar split("\\|", -1), Java NO ignorará los bloques vacíos al final del String.
    // Esto es vital para diferenciar entre una lista vacía y una lista que contiene un [""] (que genera un "|" al codificarse)
    String[] bloques = str.split( "\\|", -1 );
    
    // El split siempre dejará una posición vacía al final debido al último '|', la ignoramos restando 1 al tamaño
    for ( int i = 0; i < bloques.length - 1; i++ )
    {
      String bloque = bloques[i];
      StringBuilder palabra = new StringBuilder();
      String[] numerosAscii = bloque.split( "#" );

      for ( String numStr : numerosAscii )
      {
        if ( !numStr.isEmpty() )
        { 
          int asciiValue = Integer.parseInt( numStr );
          palabra.append( ( char ) asciiValue ); 
        }
      }
      palabrasDecodificadas.add( palabra.toString() );
    }

    return palabrasDecodificadas;
  }

}
