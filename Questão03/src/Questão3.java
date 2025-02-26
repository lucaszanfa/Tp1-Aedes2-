class Palindromo {
    public static boolean isFim(String s) {
        boolean result = false;
        if (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M') {
            result = true;
        }
        return result;
    }

    public static boolean isPalindromo(String s) {
        boolean result = true;
        int x = 0, y = 0;
        
        for (x = 0, y = s.length() - 1; x < s.length() / 2; x++, y--) {
            if (s.charAt(x) != s.charAt(y)) {
                result = false;
                x = s.length();
            }
        }
        return result;
    }

    public static void Questão3(String[] args) {
        MyIO.setCharset("UTF-8");
        String entrada = "";

        do {
            entrada = MyIO.readLine();
            if (!isFim(entrada)) {
                if (isPalindromo(entrada)) {
                    MyIO.println("SIM");
                } else {
                    MyIO.println("NAO");
                }
            }
        } while (!isFim(entrada));
    }
}





