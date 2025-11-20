package views;
import java.util.Scanner;
import models.Person;

public class View {
    private Scanner scanner;

    public View(){
        this.scanner = new Scanner(System.in);
    }

    public int showMenu(){
        System.out.println("\n---- MENU ----");
        System.out.println("1. Ingresar Personas");
        System.out.println("2. Mostrar Personas");
        System.out.println("3. Ordenar Personas");
        System.out.println("4. Buscar Persona");
        System.out.println("0. Salir");
        return readInt("Seleccione una opcion: ");
    }

    public String inputName() {
        System.out.print("Nombre: ");
        return scanner.nextLine();
    }

    public Person inputPerson() {
        System.out.println("\n--- Ingrese nueva persona ---");
        String name = inputName();
        int age = readInt("Edad: ");
        return new Person(name, age);
    }

    public int readInt(String prompt) {
        int value = -1;
        boolean validInp = false;
        while (!validInp) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                value = Integer.parseInt(input);
                validInp = true;
            } catch (NumberFormatException e) {
                System.out.println("Inválido, por favor ingrese un número válido.");
            }
        }
        return value;
    }

    public void displayPersons(Person[] persons) {
        if (persons == null || persons.length == 0) {
            System.out.println("No hay personas para mostrar.");
            return;
        }
        System.out.println("\n--- Lista de Personas ---");
        for (Person p : persons) {
            System.out.println(p);
        }
    }

    public void displaySearchResult(Person person) {
        if (person != null) {
            System.out.println("\nPersona encontrada: " + person);
        } else {
            System.out.println("\nError, persona no encontrada.");
        }
    }

    public int selectSortingMethod() {
        System.out.println("\n--- SELECCIONE EL MÉTODO DE ORDENACIÓN ---");
        System.out.println("1. Por nombre (Bubble - Ascendente)");
        System.out.println("2. Por nombre (Selection - Descendente)");
        System.out.println("3. Por edad (Insertion - Ascendente)");
        System.out.println("4. Por nombre (Insertion - Ascendente)");
        return readInt("Seleccione una opcion: ");
    }
    
    public int selectSearchCriterion() {
        System.out.println("\n--- SELECCIONE EL CRITERIO DE BÚSQUEDA ---");
        System.out.println("1. Buscar por Edad");
        System.out.println("2. Buscar por Nombre");
        return readInt("Seleccione una opcion: ");
    }
}