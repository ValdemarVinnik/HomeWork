package part_2.lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private final String NAME_NOT_FOUND = "Name not found";
    private final String PHONE_NOT_FOUND = "Phone not found";
    private final String WRONG_PHONE_NUMBER = "Wrong phone number";

    private Map<String, ArrayList<String>> map;
    private static Phonebook phonebook;

    private Phonebook(){
        this.map = new HashMap<>();
        this.phonebook = this;
    }

    public static Phonebook getInstance(){
        return phonebook != null? phonebook: new Phonebook();
    }

    public boolean addPerson(String secondName, String phoneNumber){

        if (!isValid(phoneNumber)){
            printMessage(WRONG_PHONE_NUMBER);
            return false;
        }

        if (!map.containsKey(secondName)) {
            ArrayList<String> list = new ArrayList<>();
            list.add(phoneNumber);
            map.put(secondName, list);
        } else {
            map.get(secondName).add(phoneNumber);
        }

        return true;
    }

    public String getNumber(String secondName) {

        map.get(secondName);
        return null;
    }

    public String getPerson(String phoneNumber) {

        if (!isValid(phoneNumber)) {
            return WRONG_PHONE_NUMBER;
        }

        for (Map.Entry<String, ArrayList<String>> pair : map.entrySet()) {
            for (String number : pair.getValue()) {
                if (number.equals(phonebook)) {
                    return pair.getKey();
                }
            }
        }
        return PHONE_NOT_FOUND;
    }

    public boolean deleteNumber(String name, String phoneNumber) {
        if (!isValid(phoneNumber)) {
            printMessage(WRONG_PHONE_NUMBER);
            return false;
        }

        ArrayList<String> list = map.get(name);
        if (list == null) {
            printMessage(NAME_NOT_FOUND);
            return false;
        } else {
            return list.removeIf(number -> number.equals(phoneNumber));
        }
    }

    public void printPhoneBook(){

        for (Map.Entry<String, ArrayList<String>> pair : map.entrySet()){
            System.out.print(String.format("%s : ", pair.getKey()));
            pair.getValue().forEach((e) -> System.out.printf("          %s \n",e));
        }
    }

    private boolean isValid(String phoneNumber) {
        return phoneNumber.matches("\\d{12}");
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
