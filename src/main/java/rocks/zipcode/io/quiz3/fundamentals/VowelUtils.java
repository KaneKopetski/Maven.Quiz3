package rocks.zipcode.io.quiz3.fundamentals;

import java.util.Arrays;
import java.util.List;

/**
 * @author leon on 09/12/2018.
 */
public class VowelUtils {
    private static final List<Character> vowels = Arrays.asList('a','e','i','o','u');

    public static Boolean hasVowels(String word) {
        return getIndexOfFirstVowel(word) != -1;
    }

    public static Integer getIndexOfFirstVowel(String word) {
        char[] charArray = word.toCharArray();
        Integer index = -1;
        for (int i = 0; i < charArray.length; i++) {
            if(isVowel(charArray[i])){
                index = i;
                break;
            }
        }
        return index;
    }


    public static Boolean startsWithVowel(String word) {
        return isVowel(word.charAt(0));
    }

    public static Boolean isVowel(Character character) {
        Character lowercaseCh = Character.toLowerCase(character);
        return vowels.stream().anyMatch(ch -> ch == lowercaseCh);
    }
}
