package rocks.zipcode.io.quiz3.fundamentals;

/**
 * @author leon on 09/12/2018.
 */
public class PigLatinGenerator {

    public String translate(String str) {
        String[] words = str.split(" ");
        String result = "";
        for(String word : words) {
            if (VowelUtils.startsWithVowel(word)) {
                result += word + "way" + " ";
            }
            else{
                int startIndex = VowelUtils.getIndexOfFirstVowel(word);
                if(startIndex != -1){
                    result += word.substring(startIndex) + word.substring(0, startIndex) + "ay" + " ";
                }else{
                    result += word + "ay" + " ";
                }
            }
        }
        return result.substring(0, result.length()-1);
    }
}
