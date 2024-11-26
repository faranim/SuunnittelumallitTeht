package Prototype;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Recommendation fantasyReaders = new Recommendation("Fantasy Readers");
        fantasyReaders.addBook(new Book("Rebecca Yarros", "Fourth Wing", "Fantasy", 2023));
        fantasyReaders.addBook(new Book("Veronica Roth", "Divergent", "Dystopian", 2012));

        Recommendation romanceReaders = new Recommendation("Romance Readers");
        romanceReaders.addBook(new Book("Colleen Hoover", "November 9", "Romance", 2015));
        romanceReaders.addBook(new Book("Tia Williams", "Seven Days In June", "Romance", 2021));

        Recommendation clonedRecommendation = null;

        while (true) {
            System.out.println("\n--- Book Recommendation System ---");
            System.out.println("1. View All Recommendations");
            System.out.println("2. Edit a Recommendation");
            System.out.println("3. Exit");
            System.out.print("\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // View all recommendations
                    System.out.println("\n--- Recommendations ---");
                    System.out.println(fantasyReaders);
                    System.out.println(romanceReaders);
                    if (clonedRecommendation != null) {
                        System.out.println(clonedRecommendation);
                    }
                    break;

                case 2:
                    // Edit a recommendation
                    System.out.println("\n--- Choose a recommendation to edit ---");
                    System.out.println("1. Fantasy Readers");
                    System.out.println("2. Romance Readers");
                    if (clonedRecommendation != null) {
                        System.out.println("3. Cloned Recommendation");
                    }
                    System.out.print("\nChoose: ");
                    int editChoice = scanner.nextInt();
                    scanner.nextLine();

                    Recommendation selectedRecommendation = switch (editChoice) {
                        case 1 -> fantasyReaders;
                        case 2 -> romanceReaders;
                        case 3 -> clonedRecommendation;
                        default -> null;
                    };

                    if (selectedRecommendation == null) {
                        System.out.println("\nInvalid choice.");
                        break;
                    }

                    System.out.println("\n--- Edit Recommendation ---");
                    System.out.println("1. Add Book");
                    System.out.println("2. Remove Book");
                    System.out.print("\nChoose: ");
                    int editOption = scanner.nextInt();
                    scanner.nextLine();

                    if (editOption == 1) {
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter genre: ");
                        String genre = scanner.nextLine();
                        System.out.print("Enter publication year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();

                        selectedRecommendation.addBook(new Book(title, author, genre, year));
                        System.out.println("\nBook added.");
                    } else if (editOption == 2) {
                        System.out.println("\nBooks in the recommendation:");
                        for (int i = 0; i < selectedRecommendation.getBooks().size(); i++) {
                            System.out.println((i + 1) + ". " + selectedRecommendation.getBooks().get(i));
                        }
                        System.out.print("Enter the number of the book to remove: ");
                        int removeIndex = scanner.nextInt();
                        scanner.nextLine();
                        selectedRecommendation.removeBook(selectedRecommendation.getBooks().get(removeIndex - 1));
                        System.out.println("Book removed.");
                    } else {
                        System.out.println("\nInvalid choice.");
                    }
                    break;

                case 3:
                    // Exit
                    System.out.println("\nExiting the program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }
}


