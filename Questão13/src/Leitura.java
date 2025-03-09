import java.io.*;
import java.net.*;

public class Leitura 
{
    static final char[] especial = 
    {
        225, 233, 237, 243, 250, 224, 232, 236, 242, 249, 227, 245, 226, 234, 238, 244, 251
    };
    static int[] vogais;

    public static void main( String[] args ) throws IOException 
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        String nome = "";
        String endereco = "";
        String html = "";
        int consoantes = 0, br = 0, table = 0;

        do
        {
            nome = reader.readLine();
            if( !isFim(nome) )
            {
                endereco = reader.readLine();
                html = getHtml(endereco);

                countVogais( html );
                consoantes = countConsoantes( html );
                br = countBr( html );
                table = countTable( html );

                vogais[0]  -= table;              
                vogais[1]  -= table;              
                consoantes -= ( 2*br + 3*table ); 

                printVariaveis( );
                System.out.printf( "consoante(%d) " , consoantes );
                System.out.printf( "<br>(%d) " , br );
                System.out.printf( "<table>(%d) " , table );
                System.out.printf( "%s\n" , nome );
            }
        } while( !isFim( nome ) );
    }

    public static boolean isFim( String s )
    {
        return s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M';
    }

    public static void countVogais( String html ) 
    {
        vogais = new int[23];
        for (int x = 0; x < html.length(); x++) 
        {
            char c = html.charAt(x);
            if (c == 'a') vogais[0]++;
            else if (c == 'e') vogais[1]++;
            else if (c == 'i') vogais[2]++;
            else if (c == 'o') vogais[3]++;
            else if (c == 'u') vogais[4]++;
            else if (isEspecial(c)) 
            {
                for( int y = 0; y < especial.length; y++ ) 
                {
                    if( c == especial[y] ) 
                    {
                        vogais[y + 5]++;
                        break;
                    }
                }
            }
        }
    }
    
    public static boolean isEspecial( char c ) 
    {
        for (int x = 0; x < especial.length; x++) 
        {
            if( c == especial[x] ) 
            {
                return true;
            }
        }
        return false;
    }

    public static int countConsoantes( String html )
    {
        int result = 0;
        String consoantes = "bcdfghjklmnpqrstvwxyz";
        for( int x = 0; x < consoantes.length(); x++ )
        {
            char consoantechar = consoantes.charAt(x);
            for( int y = 0; y < html.length(); y++ )
            {
                char htmlchar = html.charAt(y);
                if( htmlchar == consoantechar )
                {
                    result++;
                }
            }
        }
        return result;
    }

    public static int countBr( String html )
    {
        int result = 0;
        for( int x = 0; x < html.length() - 4; x++ )
        {
            if( isEquals( subString(html, x, x + 4), "<br>" ) )
            {
                result++;
            }
        }
        return result;
    }

    public static int countTable( String html )
    {
        int result = 0;
        for( int x = 0; x < html.length() - 7; x++ )
        {
            if( isEquals( subString(html, x, x + 7), "<table>") )
            {
                result++;
            }
        }
        return result;
    }

    public static void printVariaveis( )
    {
        System.out.printf( "a(%d) "  ,                vogais[0] );
        System.out.printf( "e(%d) "  ,                vogais[1] );
        System.out.printf( "i(%d) "  ,                vogais[2] );
        System.out.printf( "o(%d) "  ,                vogais[3] );
        System.out.printf( "u(%d) "  ,                vogais[4] );
        System.out.printf( "%c(%d) " , especial[0] , vogais[5] );
        System.out.printf( "%c(%d) " , especial[1] , vogais[6] );
        System.out.printf( "%c(%d) " , especial[2] , vogais[7] );
        System.out.printf( "%c(%d) " , especial[3] , vogais[8] );
        System.out.printf( "%c(%d) " , especial[4] , vogais[9] );
        System.out.printf( "%c(%d) " , especial[5] , vogais[10] );
        System.out.printf( "%c(%d) " , especial[6] , vogais[11] );
        System.out.printf( "%c(%d) " , especial[7] , vogais[12] );
        System.out.printf( "%c(%d) " , especial[8] , vogais[13] );
        System.out.printf( "%c(%d) " , especial[9] , vogais[14] );
        System.out.printf( "%c(%d) " , especial[10] , vogais[15] );
        System.out.printf( "%c(%d) " , especial[11] , vogais[16] );
        System.out.printf( "%c(%d) " , especial[12] , vogais[17] );
        System.out.printf( "%c(%d) " , especial[13] , vogais[18] );
        System.out.printf( "%c(%d) " , especial[14] , vogais[19] );
        System.out.printf( "%c(%d) " , especial[15] , vogais[20] );
        System.out.printf( "%c(%d) " , especial[16] , vogais[21] ); 
    }

    public static String subString( String s, int start, int end )
    {
        StringBuilder result = new StringBuilder();
        for( int x = start; x < end; x++ )
        {
            result.append(s.charAt(x));
        }
        return result.toString();
    }

    public static boolean isEquals( String obj1, String obj2 )
    {
        return obj1.equals(obj2);
    }

    public static String getHtml( String endereco )
    {
        URL url;
        InputStream is = null;
        BufferedReader br;
        StringBuilder resp = new StringBuilder();
        String line;
        try 
        {
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while( (line = br.readLine()) != null ) 
            {
                resp.append(line).append("\n");
            }
        } 
        catch( MalformedURLException mue ) 
        {
            mue.printStackTrace();
        } 
        catch( IOException ioe ) 
        {
            ioe.printStackTrace();
        }
        finally 
        {
            try 
            {
                if (is != null) is.close();
            } 
            catch (IOException ioe) 
            {
                ioe.printStackTrace();
            }
        }
        return resp.toString();
    }
}

