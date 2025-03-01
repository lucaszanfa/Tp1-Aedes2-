import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Questão13 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String linha;
            while (true) {
                linha = br.readLine();
                if (linha.equals("FIM")) {
                    break;
                }
                String[] partes = linha.split(" ", 2);
                String endereco = partes[0];
                String nomePagina = partes[1];
                String html = obterHTML(endereco);
                contarCaracteres(html, nomePagina);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String obterHTML(String endereco) {
        StringBuilder conteudo = new StringBuilder();
        try {
            URL url = new URI("https://" + endereco).toURL();
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");
            BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                conteudo.append(linha);
            }
            leitor.close();
        } catch (Exception e) {
            System.out.println("Erro ao acessar: " + endereco);
        }
        return conteudo.toString();
    }

    private static void contarCaracteres(String html, String nomePagina) {
        String vogais = "aáàãâeéèêiíìîoóòõôuúùû";
        int[] contagem = new int[26];
        int consoantes = 0;
        for (char c : html.toLowerCase().toCharArray()) {
            if (vogais.indexOf(c) != -1) {
                contagem[vogais.indexOf(c)]++;
            } else if (Character.isLetter(c)) {
                consoantes++;
            }
        }
        int brCount = contarPadrao(html, "<br>");
        int tableCount = contarPadrao(html, "<table>");
        int nomePaginaCount = contarPadrao(html, nomePagina);

        System.out.printf("a(%d) e(%d) i(%d) o(%d) u(%d) ", contagem[0], contagem[5], contagem[9], contagem[13], contagem[17]);
        System.out.printf("á(%d) é(%d) í(%d) ó(%d) ú(%d) ", contagem[1], contagem[6], contagem[10], contagem[14], contagem[18]);
        System.out.printf("à(%d) è(%d) ì(%d) ò(%d) ù(%d) ", contagem[2], contagem[7], contagem[11], contagem[15], contagem[19]);
        System.out.printf("ã(%d) õ(%d) â(%d) ê(%d) î(%d) ô(%d) û(%d) ", contagem[3], contagem[8], contagem[4], contagem[12], contagem[16], contagem[20], contagem[21]);
        System.out.printf("consoante(%d) <br>(%d) <table>(%d) nomepágina(%d)\n", consoantes, brCount, tableCount, nomePaginaCount);
    }

    private static int contarPadrao(String texto, String padrao) {
        Matcher matcher = Pattern.compile(Pattern.quote(padrao)).matcher(texto);
        int count = 0;
        while (matcher.find()) count++;
        return count;
    }
}

