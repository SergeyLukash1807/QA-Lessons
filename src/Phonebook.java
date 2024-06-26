import java.util.*;

public class Phonebook {
    private final Map<Long, String> phonebook;
    Phonebook() {
        phonebook = new HashMap<>();
    }
    public void add(long number, String surname) {
        phonebook.put(number, surname);
    }
    public void get(String surname){
        if(phonebook.containsValue(surname)) {
            Set<Map.Entry<Long, String>> set = phonebook.entrySet();
            for (Map.Entry<Long, String> o : set) {
                if(o.getValue().equals(surname)) {
                    System.out.println(o.getValue() + " : " + o.getKey());
                }
            }
        } else {
            System.out.println("Фамилии " + surname + " нет в спаровочнике.");
        }
    }
}
