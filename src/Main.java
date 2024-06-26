import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> wordArray = new ArrayList<>();
        wordArray.add("Астон");
        wordArray.add("Астон");
        wordArray.add("Астон");
        wordArray.add("Лекция");
        wordArray.add("Лекция");
        wordArray.add("Астон");
        wordArray.add("QA");
        wordArray.add("QA");
        wordArray.add("Лекция");
        wordArray.add("AQA");

        System.out.println(wordArray);
        UniqueWords.printUniqueWords(wordArray);

        Phonebook phonebook = new Phonebook();

        phonebook.add(89996549645L, "Сергеев");
        phonebook.add(89875437643L, "Иванов");
        phonebook.add(89095468643L, "Иванов");
        phonebook.add(89165746456L, "Петров");
        phonebook.add(89994357623L, "Сергеев");
        phonebook.add(89967770102L, "Иванов");

        phonebook.get("Иванов");
        phonebook.get("Сергеев");
        phonebook.get("Галышев");
        phonebook.get("Петров");
    }
}