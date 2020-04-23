package ir.ac.kntu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            startMenu();
        }
    }

    public static void startMenu() {
        System.out.println("Choose:");
        System.out.println("1-TourLeader");
        System.out.println("2-Tour");
        System.out.println("3-Locals");
        System.out.println("4-Maps");
        System.out.println("5-Change Information");
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()) {
            case 1:
                LeaderMenu.leaderMenu();
                break;
            case 2:
                TourMenu.start();
                break;
            case 3:
                Areas.areaMenu();
                break;
            case 4:
                Map.start();
                break;
            case 5:
                Moshtari.changeInformation();
        }
    }

    private Main() {
    }
}
