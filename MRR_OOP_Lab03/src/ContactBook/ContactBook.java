/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContactBook;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ADMIN
 */
public class ContactBook {

    HashMap<String, ContactComplete> ContactBookMap = new HashMap<>();
    ArrayList<ContactComplete> ContactBookList = new ArrayList<>();
    HashSet<ContactComplete> ConctactBookSet = new HashSet<>();

    public void AddContactInfo() {
        System.out.println("How many Contacts u wan't to create? ..............");
        Scanner in = new Scanner(System.in, "windows-1251");
        int CountOfContact;

        while (true) {
            try {
                if (in.hasNextInt()) {
                    CountOfContact = in.nextInt();
                    break;
                }
            } catch (Exception ex) {

                System.err.println("Invalid string in argumment");
                in.next();
            }
        }
        for (int i = 0; i < CountOfContact; i++) {
            System.out.println("Text a Name of contact");
            String Name = in.next();
            String Number = GetNumberWithPatternCheck();
            System.out.println("Text an Organisation of contact");
            String Organisation = in.next();
            String SecondNumber = GetNumberWithPatternCheck();
            System.out.println("Text has contact Telegram? Да/Нет");
            String CheckHas = in.next();
            boolean hasTelegram;
            hasTelegram = CheckHas.equalsIgnoreCase("Да");

            ContactComplete Contact = new ContactComplete(Name, Number, Organisation, hasTelegram, SecondNumber);
            CreateContactBookWithHashMap(Contact);
            CreateContactBookWithHashSet(Contact);
            CreateContactBookWithArrayList(Contact);
        }

    }

    public void CreateContactBookWithHashMap(ContactComplete Contact) {

        System.out.println("Generate Unique ID");
        String uniqueID = UUID.randomUUID().toString();
        ContactBookMap.put(uniqueID, Contact);

    }

    public void CreateContactBookWithHashSet(ContactComplete Contact) {

        ConctactBookSet.add(Contact);
    }

    public void CreateContactBookWithArrayList(ContactComplete Contact) {

        ContactBookList.add(Contact);
    }

    public void PrintContactMap() {
        ContactBookMap.values().stream().map(Contact -> {
            PrintStream n = System.out;
            n.println("****************************");
            n.println("Контактные данные: ");
            n.println("Имя: ");
            n.println(Contact.getName());
            n.println("Номер: ");
            n.println(Contact.Number);
            n.println("Организация: ");
            n.println(Contact.getOrganisation());
            n.println("Дополнительный номер: ");
            n.println(Contact.SecondNumber);
            n.println("Наличие телеграмма: ");
            n.println(Contact.getTelegram());
            return n;
        }).forEachOrdered(n -> {
            n.println("****************************\n");
        });
    }

    public void PrintContactList() {

        ContactBookList.stream().map(Contact -> {
            PrintStream n = System.out;
            n.println("****************************");
            n.println("Контактные данные: ");
            n.println("Имя: ");
            n.println(Contact.getName());
            n.println("Номер: ");
            n.println(Contact.Number);
            n.println("Организация: ");
            n.println(Contact.getOrganisation());
            n.println("Дополнительный номер: ");
            n.println(Contact.SecondNumber);
            n.println("Наличие телеграмма: ");
            n.println(Contact.getTelegram());
            return n;
        }).forEachOrdered(n -> {
            n.println("****************************\n");
        });
    }

    public void PrintContactSet() {
        Iterator R = ContactBookList.listIterator();
        ContactComplete ct;
        while (R.hasNext()) {
            ct = (ContactComplete) R.next();
            PrintStream n = System.out;
            n.println("****************************");
            n.println("Контактные данные: ");
            n.println("Имя: " + ct.getName());
            n.println("Номера: " + ct.Number);
            n.println("Организация: " + ct.getOrganisation());
            n.println("Доп.номер: " + ct.SecondNumber);
            n.println("Наличие телеграмма: " + ct.getTelegram());
            n.println("****************************\n");

        }
    }

    public void DoTask() {
        int WantToFix = 0;

        ContactBookMap.remove(ContactBookMap.keySet().toArray()[0]);
        ConctactBookSet.remove(ConctactBookSet.toArray()[0]);
        ContactBookList.remove(ContactBookList.toArray()[0]);

        System.out.println("Select what do u want to edit at last element");
        System.out.println("0 - Name ; 1 - Number ; 2 - Organisation ; 3 - SecondNumber ; 4 - hasTelegram");
        Scanner in = new Scanner(System.in, "windows-1251");
        WantToFix = in.nextInt();
        if (ContactBookMap.values().size() == 0) {
            System.out.println("Извини, но после удаления книга контактов пуста");
            return;
        }
        switch (WantToFix) {
            case 0:
                String Name = ContactBookMap.get(ContactBookMap.keySet().toArray()[ContactBookMap.size() - 1]).Name;
                System.out.println("Current name = " + Name + " " + "Text new Name param");
                Name = in.next();
                ContactBookMap.get(ContactBookMap.keySet().toArray()[ContactBookMap.size() - 1]).Name = Name;
                break;
            case 1:
                String Number = ContactBookMap.get(ContactBookMap.keySet().toArray()[ContactBookMap.size() - 1]).Number;
                System.out.println("Current name = " + Number + " " + "Text new Name param");
                Number = in.next();
                ContactBookMap.get(ContactBookMap.keySet().toArray()[ContactBookMap.size() - 1]).Number = Number;
                break;

            case 2:
                String Organisation = ContactBookMap.get(ContactBookMap.keySet().toArray()[ContactBookMap.size() - 1]).Organisation;
                System.out.println("Current name = " + Organisation + " " + "Text new Name param");
                Organisation = in.next();
                ContactBookMap.get(ContactBookMap.keySet().toArray()[ContactBookMap.size() - 1]).Organisation = Organisation;
                break;
            case 3:
                String SecondNumber = ContactBookMap.get(ContactBookMap.keySet().toArray()[ContactBookMap.size() - 1]).SecondNumber;
                System.out.println("Current name = " + SecondNumber + " " + "Text new Name param");
                SecondNumber = in.next();
                ContactBookMap.get(ContactBookMap.keySet().toArray()[ContactBookMap.size() - 1]).SecondNumber = SecondNumber;
                break;
            case 4:
                boolean hasTelegram = ContactBookMap.get(ContactBookMap.keySet().toArray()[ContactBookMap.size() - 1]).hasTelegram;
                System.out.println("Current name = " + hasTelegram + " " + "Text new Name param");
                hasTelegram = in.nextBoolean();
                ContactBookMap.get(ContactBookMap.keySet().toArray()[ContactBookMap.size() - 1]).hasTelegram = hasTelegram;
                break;

        }
    }

    private String GetNumberWithPatternCheck() {
        Scanner in = new Scanner(System.in);
        System.out.println("Text a Number of contact with format +7-777-777-77-77");
        Pattern pattern = Pattern.compile("\\A[+]\\d[-]\\d{3}[-]\\d{3}[-]\\d{2}[-]\\d{2}$");
        String Number = in.next();
        Matcher matcher = pattern.matcher(Number);
        while (!matcher.find()) {
            System.out.println("Please stay in format +7-777-777-77-77");
            Number = in.next();
            matcher = pattern.matcher(Number);
            if (matcher.find()) {
                break;
            }
        }
        Number = Number.substring(matcher.start(), matcher.end());
        return Number;

    }

    @Override
    public String toString() {
        return (ConctactBookSet.toString());
    }
}
