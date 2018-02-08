package com.example.helloworld;
import java.util.Scanner;

public class HelloWorld {

    public static void main(String args[]) {

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        int count = 1;
        int turn = 1;
        String n1, n2 = "";
        int score = 0;
        int strikeCount = 0;
        boolean spare = false;

        while (count < 11) {
            System.out.println("frame number: " + turn);
            count++;
            turn++;

            System.out.println("Try 1 Enter a score (1-9,-,X): ");
            n1 = reader.nextLine(); // Scans the next token of the input as an int.

            if (count > 10 && n1.equals("X") && turn < 12){
                count = count - 2;
                strikeCount = 0;
            } else if (count > 10 && n2.equals("/") && turn < 12){
                count--;
                strikeCount = 0;
                spare = false;
            }

            if (n1.equals("X")){
                score = score + 10;
                if (strikeCount > 2){
                    strikeCount = strikeCount - 2;
                    score = score + 20;
                } else if (strikeCount > 0){
                    strikeCount--;
                    score = score + 10;
                } else if (spare){
                    spare = false;
                    score = score + 10;
                }
                strikeCount = strikeCount + 2;
                continue;
            } else if (n1.equals("-")){
                if (strikeCount > 2){
                    strikeCount = strikeCount - 2;
                } else if (strikeCount > 0){
                    strikeCount--;
                } else if (spare){
                    spare = false;
                }
            } else {
                if (strikeCount > 2){
                    strikeCount = strikeCount - 2;
                    score = score + Integer.parseInt(n1)*2;
                } else if (strikeCount > 0){
                    strikeCount--;
                    score = score + Integer.parseInt(n1);
                } else if (spare){
                    spare = false;
                    score = score + Integer.parseInt(n1);
                }
                score = score + Integer.parseInt(n1);
            }

            //catch spare on 10th frame
            if (count == 11 && n2.equals("/")){
                continue;
            }

            System.out.println("Try 2 Enter a score (1-9,-,/): ");
            n2 = reader.nextLine(); // Scans the next token of the input as an int.

            if (n2.equals("/")){
                if (!n1.equals("-")) {
                    score = score - Integer.parseInt(n1);
                    spare = true;
                    score = score + 10;
                }
            } else if (n2.equals("-")){

            } else {
                score = score + Integer.parseInt(n2);
            }
        }
        System.out.println(score);
    }
}
