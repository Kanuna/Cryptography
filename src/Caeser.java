import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Caeser {

    public static void main(String[] args) {
        String text = "This text should be encrypted";
        int shift = 3;
        //OWN TEXT
        //String cipherText = encrypt(text, shift);
        //System.out.println(decrypt(cipherText, shift));

        //BRUTEFORCE TEXT
        /*String bruteText = "rfwhzx mfw js txyj\n";
        bruteForce(bruteText);*/

        //SONG/LYRIC TEXT
        /*String song = usingBufferReader("songs/FadedSong.txt");
        String lyrics = decrypt(song, shift);
        System.out.println(encrypt(lyrics, shift));*/

        //printLetterFrequenciesAsPercentages(song);
    }

    public static void printLetterFrequenciesAsPercentages(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int totalLetters = 0;

        for (char ch : text.toLowerCase().toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
                totalLetters++;
            }
        }

        System.out.println("Letter Frequencies (in %):");
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            double percentage = (entry.getValue() / (double) totalLetters) * 100;
            System.out.printf("%c: %.2f%%\n", entry.getKey(), percentage);
        }
    }

    public static String usingBufferReader(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        StringBuilder text = new StringBuilder();
        String st;

        while ((st = br.readLine()) != null)
            text.append(st).append("\n");
        br.close();
        return text.toString();
    }

    public static String encrypt(String text, int shift) {
        StringBuilder cipherText = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                int oriAlphaPos = character - base;
                int newAlphaPos = (oriAlphaPos + shift) % 26;

                if (newAlphaPos < 0) {
                    newAlphaPos += 26;
                }

                char newChar = (char) (base + newAlphaPos);
                cipherText.append(newChar);
            }
            else {
                cipherText.append(character);
            }
        }
        return cipherText.toString();
    }

    public static String decrypt(String text, int shift) {
        StringBuilder plainText = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                int oriAlphaPos = character - base;
                int newAlphaPos = (oriAlphaPos - shift) % 26;

                if (newAlphaPos < 0) {
                    newAlphaPos += 26;
                }

                char newChar = (char) (base + newAlphaPos);
                plainText.append(newChar);
            }
            else {
                plainText.append(character);
            }
        }
        return plainText.toString();
    }

    private static void bruteForce(String text) {
        int count = 26;
        for (int shift = 0; shift < count; shift++) {
            System.out.println("Shift " + shift + ": " + decrypt(text, shift));
        }
    }

/*    public static String decrypt(String cipherText, int key) {
        StringBuilder text = new StringBuilder();

        for (char character : cipherText.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                int oriAlphaPos = character - base;
                int newAlphaPos = (oriAlphaPos - key) % 26;

                char newChar = (char) (base + newAlphaPos);
                text.append(newChar);
            } else {
                text.append(character);
            }
        }
        return text.toString();
    }*/
}