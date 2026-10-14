package hometheatre.app;

import hometheatre.config.Configuration;
import hometheatre.facade.Facade;

public class Main {

    public static void main(String[] args) {
        Facade theater = Configuration.createHomeTheater();

        System.out.println("=== NORMAL MOVIE SESSION ===");
        theater.watchMovie("The Truman Show");
        theater.endMovie();

        System.out.println("\n=== INVALID MOVIE TITLE ===");
        try {
            theater.watchMovie("   ");
        } catch (IllegalStateException exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        System.out.println("\n=== START AFTER FAILED ATTEMPT ===");
        theater.watchMovie("Inception");

        System.out.println("\n=== REPEATED START ===");
        try {
            theater.watchMovie("The Matrix");
        } catch (IllegalStateException exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        theater.endMovie();

        System.out.println("\n=== REPEATED END ===");
        theater.endMovie();
    }
}