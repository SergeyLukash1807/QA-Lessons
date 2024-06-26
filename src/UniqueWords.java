import java.util.*;

public class UniqueWords {
    public static void printUniqueWords(List<String> array) {
        HashSet<String> tempArray = new LinkedHashSet<>(array);
        for (String tempArr : tempArray) {
            int count = 0;
            for (String arr : array) {
                if(tempArr.equals(arr)) count++;
            }
            System.out.println("Слово \"" + tempArr + "\"" + " встречается в списке " + count + " раз.");
        }
    }
}