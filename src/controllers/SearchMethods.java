package controllers;

import models.Person;

public class SearchMethods {

    public boolean isSortedByAge(Person[] persons) {
        if (persons == null || persons.length < 2) return true;
        for (int i = 0; i < persons.length - 1; i++) {
            if (persons[i].getAge() > persons[i + 1].getAge()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isSortedByName(Person[] persons) {
        if (persons == null || persons.length < 2) return true;
        for (int i = 0; i < persons.length - 1; i++) {
            if (persons[i].getName().compareTo(persons[i + 1].getName()) > 0) {
                return false;
            }
        }
        return true;
    }
    
    public Person binarySearchByAge(Person[] persons, int age) {
        System.out.println("Realizando búsqueda binaria por edad...");
        int low = 0;
        int high = persons.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midAge = persons[mid].getAge();
            if (midAge == age) {
                return persons[mid];
            } else if (midAge < age) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public Person binarySearchByName(Person[] persons, String name) {
        System.out.println("Realizando búsqueda binaria por nombre...");
        int low = 0;
        int high = persons.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            String midName = persons[mid].getName();
            int comparison = midName.compareTo(name);
            if (comparison == 0) {
                return persons[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}