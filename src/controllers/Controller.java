package controllers;

import models.Person;
import views.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Controller {
    private View view;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;
    private List<Person> personsList;

    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
        this.personsList = new ArrayList<>();
    }

    private Person[] getPersonsArray() {
        return personsList.toArray(new Person[0]);
    }

    public void start() {
        int choice;
        do {
            choice = view.showMenu();
            switch (choice) {
                case 1:
                    inputPersons();
                    break;
                case 2:
                    view.displayPersons(getPersonsArray()); 
                    break;
                case 3:
                    sortPersons(); 
                    break;
                case 4:
                    searchPerson(); 
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación. ¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo..");
            }
        } while (choice != 0);
    }

    public void inputPersons() {
        int count = view.readInt("¿Cuántas personas quieres agregar? ");
        for (int i = 0; i < count; i++) {
            Person newPerson = view.inputPerson();
            personsList.add(newPerson);
            System.out.println("Persona Agregada: " + newPerson.getName());
        }
    }

    public void sortPersons() {
        if (personsList.isEmpty()) {
            System.out.println("La lista está vacía. No se puede ordenar.");
            return;
        }
        Person[] personsArray = getPersonsArray();
        int sortOption = view.selectSortingMethod();

        switch (sortOption) {
            case 1:
                sortingMethods.sortByNameWithBubble(personsArray);
                break;
            case 2:
                sortingMethods.sortByNameWithSelectionDes(personsArray);
                break;
            case 3:
                sortingMethods.sortByAgeWithInsertion(personsArray);
                break;
            case 4:
                sortingMethods.sortByNameWithInsertion(personsArray);
                break;
            default:
                System.out.println("Opción no válida. No se realizó ninguna ordenación..");
                return;
        }
        personsList = new ArrayList<>(Arrays.asList(personsArray)); 
        view.displayPersons(getPersonsArray());
    }

    public void searchPerson() {
        Person[] personsArray = getPersonsArray();
        if (personsArray.length == 0) {
            System.out.println("La lista está vacía. No se puede buscar..");
            return;
        }

        int criterion = view.selectSearchCriterion();
        Person result = null;

        switch (criterion) {
            case 1: 
                int ageToFind = view.readInt("Ingrese la edad a buscar: ");
                if (!searchMethods.isSortedByAge(personsArray)) {
                    System.out.println("La lista no está ordenada por edad. Ordenando...");
                    sortingMethods.sortByAgeWithInsertion(personsArray);
                    personsList = new ArrayList<>(Arrays.asList(personsArray));
                    view.displayPersons(personsArray);
                }
                result = searchMethods.binarySearchByAge(personsArray, ageToFind);
                break;

            case 2: 
                String nameToFind = view.inputName();
                if (!searchMethods.isSortedByName(personsArray)) {
                    System.out.println("La lista no está ordenada por nombre. Ordenando...");
                    sortingMethods.sortByNameWithBubble(personsArray);
                    personsList = new ArrayList<>(Arrays.asList(personsArray));
                    view.displayPersons(personsArray);
                }
                result = searchMethods.binarySearchByName(personsArray, nameToFind);
                break;

            default:
                System.out.println("Invalido.");
                return;
        }

        view.displaySearchResult(result);
    }
}