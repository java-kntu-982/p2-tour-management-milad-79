package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Areas {
    private static ArrayList<String> area =new ArrayList<>();

    public static void addlocal(){
        Scanner input=new Scanner(System.in);
        String newLocal=input.nextLine();
        area.add(newLocal);
    }
    public static void addlocal(String name){
        area.add(name);
    }
    public static void remove(){
        Scanner input=new Scanner(System.in);
        allArea();
        int index;
        index = input.nextInt();
        area.remove(index);

    }

    public static String getLocal(int index) {
        return area.get(index);
    }

    public static void editArea(){
        Scanner input=new Scanner(System.in);
        System.out.println("choose local:");
        allArea();
        int index=input.nextInt();
        System.out.println("enter new name:");
        String newName=input.next();
        area.set(index,newName);
    }
    public static int isArea(String local){
        return area.indexOf(local);
    }
    public static void allArea(){
        int i;
        for ( i=0;i<area.size();i++) {
            System.out.print(i+"-");
            System.out.println(area.get(i));
        }
        if (i==0){
            System.out.println("Not Found");
        }
    }

    public static void areaMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("0-menu asli");
        System.out.println("1-tamam local");
        System.out.println("2-afzodan local");
        System.out.println("3-hszf local");
        System.out.println("4-virayesh local");
        switch (input.nextInt()) {
            case 0:
                Main.startMenu();
                break;
            case 1:
                Areas.allArea();
                break;
            case 2:
                Areas.addlocal();
                break;
            case 3:
                Areas.remove();
                break;
            case 4:
                Areas.editArea();
                break;
        }
    }
}
