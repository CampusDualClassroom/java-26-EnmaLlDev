package com.campusdual.classroom;

import java.text.Normalizer;
import java.util.Locale;

public class Contact implements ICallActions {
    private String name;
    private String surname;
    private String phoneNumber;
    private String code;

    public Contact(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.code = makeCode(this.name, this.surname);
    }
    public String makeCode(String name, String surname) {
        StringBuilder newCode = new StringBuilder();
        newCode.append(clearCodeParts(name).substring(0, 1).toLowerCase());
        if (surname.contains(" ")) {
            String[] surnameParts = surname.split(" ");

            if (surnameParts.length > 0) {
                String surnamePart1 = clearCodeParts(surnameParts[0]).substring(0, 1).toLowerCase();
                String surnamePart2 = clearCodeParts(surnameParts[1]).substring(0, surnameParts[1].length() ).toLowerCase();
                for ( int i = 0; i < surnameParts.length; i++ ) {
                    if (i > 1) {
                        surnamePart2 += clearCodeParts(surnameParts[i]).trim().toLowerCase();
                    }
                }
                newCode.append(surnamePart1);
                newCode.append(surnamePart2);
            }
            else {
                newCode.append(clearCodeParts(surnameParts[0]).toLowerCase());
            }
        } else {
            newCode.append(clearCodeParts(surname).toLowerCase());
        }
        return newCode.toString();
    }



    private static String clearCodeParts(String text) {
        if(text == null || text.trim().isEmpty()) {
            return "";
        }
        String textWithoutEspCharts = Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        return textWithoutEspCharts.toLowerCase(Locale.ROOT).trim();

    }

    @Override
    public void callMyNumber() {
        System.out.println("Calling " + getName() + " " + getSurnames() +
                " at my same phone number: " + getPhone());
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println("Calling " + getName() + " " + getSurnames() +
                " at phone number: " + number);
    }

    @Override
    public void showContactDetails() {
        System.out.println(
                "Name: " + getName() +
                "\nLast Name 1: " + getSurnames() +
                "\nPhone Number: " + getPhone() +
                "\nCode: " + getCode()
        );
    }
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getSurnames() {
        return surname + " " + surname;
    }
    public String getPhone() {
        return phoneNumber;
    }
}