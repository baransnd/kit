package edu.kit.informatik.UB3.AufgabeA;

import java.util.Scanner;
/**
 * The Main class which runs the program, and executes the right method,
 * in accordance to the given command and input, through a switch-case.
 * @author uboal
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityList priorityList = new PriorityList();

        while (true) {
            String input = scanner.nextLine();
            String[] strings = input.split(" ");
            if (strings[0].equals("quit")) {
                break;
            }
            switch (strings[0]) {
                case "add":
                    strings = strings[1].split(":");
                    priorityList.add(Integer.parseInt(strings[0]), strings[1], strings[2],
                            Integer.parseInt(strings[3]), Integer.parseInt(strings[4]));
                    break;
                case "remove":
                    System.out.print(priorityList.remove(Integer.parseInt(strings[1]), true));
                    break;
                case "play":
                    priorityList.play(Integer.parseInt(strings[1]));
                    break;
                case "skip":
                    priorityList.skip();
                    break;
                case "peek":
                    System.out.print(priorityList.peek());
                    break;
                case "list":
                    System.out.print(priorityList.list());
                    break;
                case "history":
                    System.out.print(priorityList.history());
                    break;
            }
        }
        scanner.close();
    }

}
