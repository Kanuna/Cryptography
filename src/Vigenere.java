public class Vigenere {
    public static void main(String[] args) {
        String plainText = "HELLO";
        String keyWord = "JAVA";

        System.out.println("encrypt: " + encrypt(plainText, keyWord));
        String encryptedText = encrypt(plainText, keyWord);
        System.out.println("decrypt: " + decrypt(encryptedText, keyWord));
    }

    public static String encrypt(String plainText, String keyword) {
        StringBuilder cipher = new StringBuilder();
        plainText = plainText.toUpperCase();
        keyword = keyword.toUpperCase();

        for (int i = 0, j = 0; i < plainText.length(); i++) {
            char currentChar = plainText.charAt(i);
            if (Character.isAlphabetic(currentChar)) {
                int shift = keyword.charAt(j % keyword.length()) - 'A';
                char encryptedChar = (char) ((currentChar + shift - 'A') % 26 + 'A');
                cipher.append(encryptedChar);
                j++;
            }
            else {
                cipher.append(currentChar);
            }
        }
        return cipher.toString();
    }

    public static String decrypt(String cipherText, String keyWord) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0, j = 0; i < cipherText.length(); i++) {
            char currentChar = cipherText.charAt(i);
            if (Character.isAlphabetic(currentChar)) {
                int shift = keyWord.charAt(j % keyWord.length()) - 'A';
                char decryptedChar = (char) ((currentChar - shift - 'A' + 26) % 26 + 'A');
                decryptedText.append(decryptedChar);
                j++;
            }
            else{
                decryptedText.append(currentChar);
            }
        }
        return decryptedText.toString();
    }
}