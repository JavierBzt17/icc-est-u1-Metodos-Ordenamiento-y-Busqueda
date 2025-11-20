package controllers;

import models.Person;

public class SortingMethods {

    public void sortByNameWithBubble(Person[] persons) {
        if (persons == null || persons.length < 2) return;
        int n = persons.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (persons[j].getName().compareTo(persons[j + 1].getName()) > 0) {
                    Person temp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        System.out.println("Lista ordenada por nombre (Bubble Sort - Ascendente).");
    }
    
    public void sortByNameWithSelectionDes(Person[] persons) {
        if (persons == null || persons.length < 2) return;
        int n = persons.length;
        for (int i = 0; i < n - 1; i++) {
            int max_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (persons[j].getName().compareTo(persons[max_idx].getName()) > 0) {
                    max_idx = j;
                }
            }
            Person temp = persons[max_idx];
            persons[max_idx] = persons[i];
            persons[i] = temp;
        }
        System.out.println("Lista ordenada por nombre (Selection Sort - Descendente).");
    }

    public void sortByAgeWithInsertion(Person[] persons) {
        if (persons == null || persons.length < 2) return;
        int n = persons.length;
        for (int i = 1; i < n; ++i) {
            Person key = persons[i];
            int j = i - 1;
            while (j >= 0 && persons[j].getAge() > key.getAge()) {
                persons[j + 1] = persons[j];
                j = j - 1;
            }
            persons[j + 1] = key;
        }
        System.out.println("Lista ordenada por edad (Insertion Sort - Ascendente).");
    }

    public void sortByNameWithInsertion(Person[] persons) {
        if (persons == null || persons.length < 2) return;
        int n = persons.length;
        for (int i = 1; i < n; ++i) {
            Person key = persons[i];
            int j = i - 1;
            while (j >= 0 && persons[j].getName().compareTo(key.getName()) > 0) {
                persons[j + 1] = persons[j];
                j = j - 1;
            }
            persons[j + 1] = key;
        }
        System.out.println("Lista ordenada por nombre (Insertion Sort - Ascendente).");
    }
}