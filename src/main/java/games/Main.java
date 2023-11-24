package games;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("C:\\Users\\Valerius\\Desktop\\words.txt"));
        Scanner input = new Scanner(System.in);

        List<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            words.add(scanner.next());
        }

        Random rand = new Random();

        String word = words.get(rand.nextInt(words.size()));

        System.out.println(word);

        List<Character> playerGuesses = new ArrayList<>();
        String dummy = "";

        int wrongCount = 0;
        for (int i = 0; i < 6; ) {


            System.out.println("Please enter a letter(Remaining Chance: " + (6 - i) + ")");
            String letterGuess = input.nextLine();
            //if (letterGuess.length()==word.length())
            playerGuesses.add(letterGuess.charAt(0));

            dummy = "";

            boolean bool = false;

            for (int j = 0; j < word.length(); j++) {
                if (playerGuesses.contains(word.charAt(j))) {
                    System.out.print(word.charAt(j));
                    dummy += word.charAt(j);
                    bool = true;
                } else {
                    System.out.print("-");
                    dummy += "-";
                }

            }
            if(!bool){
                wrongCount++;
            } else {
                bool=false;
            }
            if(wrongCount>=6){
                System.out.println("you ded");
                System.exit(0);
            }
            System.out.println();
            System.out.println(wrongCount);

        }
        if (dummy.contains("-")){
            System.out.println("You lose :(");
        } else {
            System.out.println("You win!!!");
        }


    }
}