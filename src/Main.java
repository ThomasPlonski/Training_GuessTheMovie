import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {


//declare file
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);

//check number of titles in file
        int noOfRow = 0;
        while (scanner.hasNextLine()) {
           noOfRow ++;
           scanner.nextLine();
        }
        scanner.close();

//declare array with all file titles
        String [] allMovies = new String[noOfRow];

        Scanner scanner2 = new Scanner(file);
        for (int i = 0; i < 25 ; i++) {
            allMovies[i] = scanner2.nextLine();
        }

//pickRandomMovie
        String randomlyPickedMovie  = allMovies[(int) (Math.random() * 24)];
//        System.out.printf(randomlyPickedMovie);

//      create object game and pass title that has been drawn
            Game game = new Game(randomlyPickedMovie);

            // just to test
//        System.out.println(game.getMovieTitleToGuess());
//        System.out.println(game.getHiddenTittle());
//        System.out.println(game.getPoints());

//        Run the game
        if (game.startGame()) {
            System.out.println("YOU WIN!");
        } else {
            System.out.println("YOU LOOSE... Try again later.");
        }
        System.out.println("Guessed tittle was: " + game.getMovieTitleToGuess());


        }
    }
