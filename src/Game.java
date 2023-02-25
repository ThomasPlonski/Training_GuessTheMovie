import java.util.Scanner;

public class Game {

    private String movieTitleToGuess;
    private String hiddenTittle;
    private int points = 10;

    private String alreadyTypedLetters = "";
    private String alreadyTypedWrongLetters = "";

    public Game(String movieTitleToGuess) {
        this.movieTitleToGuess = movieTitleToGuess;
        this.hiddenTittle = hideTittleUderscore(movieTitleToGuess);
//        this.points = points;
    }

    public boolean startGame() {
        System.out.println("Program draw from database one movie title and hide letters from you.");
        System.out.println("Please guess full tittle by guessing letters. you have 10 shots.");
//        System.out.println("Title: " + hiddenTittle);

        boolean isGameOver = false;

        while (!isGameOver) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Title: " + hiddenTittle);
            System.out.println("Please type one letter:");
            String typedLetter = scanner.next();
//            alreadyTypedLetters += typedLetter;

            //        check if typed sign is a letter
            if (wasAlreadyTyped(typedLetter)) {
                System.out.println("Letter '" + typedLetter + "' was already typed (you do not lose point).");
                continue;
            }

            if (guessLetterInTitle(typedLetter)) {
                if (isTitleGuessed()) {
//                    break;
                    return true;
                }
                System.out.print("You have guessed! '" + typedLetter + "' is in the title. ");
                if (points == 1) {
                    System.out.println("You have still ONLY ONE point!.");
                } else {
                    System.out.println("You have still " + points + " points.");
                    }
                System.out.println("(Already typed wrong letters are: " + alreadyTypedWrongLetters +")");

            } else {
                System.out.print("You have NOT guessed and lose 1 point! '" + typedLetter + "' is NOT in the tittle. ");
                if (points == 1) {
                    System.out.println("Now you have ONLY ONE point!.");
                } else {
                    System.out.println("Now you have " + points + " points.");
                }

                System.out.println("(Already typed WRONG letters are: " + alreadyTypedWrongLetters +")");

                if (points == 0) {
//                    break;
                    return false;
                }
            }

//            System.out.println(hiddenTittle);

        }
        return false;
    }

    private boolean guessLetterInTitle(String letter) {



        boolean letterGuessed = false;
        StringBuilder tempTitle = new StringBuilder(hiddenTittle);
        for (int i = 0; i < movieTitleToGuess.length() ; i++) {
            if (movieTitleToGuess.charAt(i) == letter.charAt(0)) {
                tempTitle.setCharAt(i, letter.charAt(0));
                letterGuessed = true;
            }
        }

        hiddenTittle = tempTitle.toString();

        if (letterGuessed) {
            return true;
        } else {
            points--;
            if (alreadyTypedWrongLetters.isEmpty()) {
            alreadyTypedWrongLetters += letter;
            } else {
                alreadyTypedWrongLetters += ", " + letter;
            }
            return false;
        }

    }

    private boolean isTitleGuessed() {
        return movieTitleToGuess.equals(hiddenTittle);
    }

    private boolean wasAlreadyTyped(String letter) {
        if (alreadyTypedLetters.isEmpty()) {
            alreadyTypedLetters += letter;
            return false;
        }

        for (int i = 0; i < alreadyTypedLetters.length() ; i++) {
            if (alreadyTypedLetters.charAt(i) == letter.charAt(0)) {
                return true;
            }
        }
        alreadyTypedLetters += letter;
        return false;
    }

    public String getMovieTitleToGuess() {
        return movieTitleToGuess;
    }

    public void setMovieTitleToGuess(String movieTitleToGuess) {
        this.movieTitleToGuess = movieTitleToGuess;
    }

    public String getHiddenTittle() {
        return hiddenTittle;
    }

    public void setHiddenTittle(String hiddenTittle) {
        this.hiddenTittle = hiddenTittle;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    private String hideTittleUderscore (String title) {
        String uderscoreTitle = "";

        for (int i = 0; i < title.length() ; i++) {
            if (title.charAt(i) == ' ') {
                uderscoreTitle += " ";
            } else {
                uderscoreTitle += "_";
            }
        }

        return uderscoreTitle;
    }

}
