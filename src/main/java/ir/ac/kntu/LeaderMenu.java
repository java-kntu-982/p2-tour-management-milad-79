package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class LeaderMenu {
    public static ArrayList<TourLeader> leaders=new ArrayList<>();

    public static void leaderMenu(){
        System.out.println("Choose");
        System.out.println("0-bazgasht menu asli");
        System.out.println("1-tamam leaders");
        System.out.println("2-afzoden leader");
        System.out.println("3-hazf leader");
        System.out.println("4-virayesh leader");
        Scanner input=new Scanner(System.in);
        switch (input.nextInt()){
            case 0:Main.startMenu();
                break;
            case 1:listLeader();
                break;
            case 2:leaders.add(add());
                break;
            case 3:
                removeLeader();
                break;
            case 4:
                editMenu();
                break;
        }
    }

    public static void editMenu() {
        listLeader();
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();
        System.out.println(leaders.get(index));

        while (true) {
            System.out.println("choose element:");
            System.out.println("0-finish vireyesh\n1-FistName\n2-LastName\n3-shomare meli" +
                    "\n4-tahol\n5-Date birth\n6-Date enteghdam\n7-Locals");
            int ch = input.nextInt();
            if (ch == 0) {
                break;
            }
            if (ch == 1) {
                String s = input.next();
                leaders.get(index).setFirsName(s);
            }
            if (ch == 2) {
                String s = input.nextLine();
                leaders.get(index).setLastName(s);
            }

            if (ch == 3) {
                int n = input.nextInt();
                leaders.get(index).setNationalNumber(n);
            }
            if (ch == 4) {
                if (input.nextInt() == 0) {
                    leaders.get(index).setMarried(true);
                } else {
                    leaders.get(index).setMarried(false);
                }
            }
            if (ch == 5) {
                int year = input.nextInt();
                int month = input.nextInt();
                int day = input.nextInt();
                leaders.get(index).setBirth(new Date(year, month, day));
            }
            if (ch == 6) {
                int year = input.nextInt();
                int month = input.nextInt();
                int day = input.nextInt();
                leaders.get(index).setEmployment(new Date(year, month, day));
            }
            if (ch == 7) {
                String s = input.next();
                int i = Areas.isArea(s);
                if (i != -1) {
                    leaders.get(index).setArea(s);
                } else {
                    System.out.println("tarif nashode.tarif shavad?\n1-yes\t2-no");
                    if (input.nextInt() == 1) {
                        Areas.addlocal(s);
                        leaders.get(index).setArea(s);
                    } else {
                        System.out.println("badan local ra moshakhas konid");
                    }
                }
            }
        }
    }

    public static void removeLeader(){
        System.out.println("choose Leader:");
        listLeader();
        Scanner input=new Scanner(System.in);
        leaders.remove(input.nextInt());
    }
    public static boolean listLeader(){
        System.out.println("  FirstName\tLastName");
        int i;
        for(i=0;i<leaders.size();i++){
            System.out.print(i+"-");
            System.out.print(leaders.get(i).getFirsName());
            System.out.print("\t\t");
            System.out.println(leaders.get(i).getLastName());
        }
        if (i==0){
            System.out.println("Not Found");
            return false;
        }
        return true;
    }

    public static TourLeader add(){
        TourLeader leader=new TourLeader();
        Scanner input=new Scanner(System.in);
        System.out.println("FisrName?");
        leader.setFirsName(input.nextLine());
        System.out.println("ListName?");
        leader.setLastName(input.nextLine());
        System.out.println("shomare meli?");
        leader.setNationalNumber(input.nextInt());
        System.out.println("tahol?\n1-yes\n2-no");
        if (input.nextInt()==1){
            leader.setMarried(true);
        } else{
            leader.setMarried(false);
        }
        System.out.println("sal tavalo? YY");
        int year=input.nextInt();
        System.out.println("mah tavalo? MM");
        int month=input.nextInt();
        System.out.println("roz tavalo? DD");
        int day=input.nextInt();
        leader.setBirth(new Date(year,month,day));
        System.out.println("sal estekhdam? YY");
        year=input.nextInt();
        System.out.println("mah estekhdam? MM");
        month=input.nextInt();
        System.out.println("roz estekhdam? DD");
        day=input.nextInt();
        leader.setEmployment(new Date(year,month,day));
        System.out.println("choose the local:");
        String name=input.next();
        int flag=Areas.isArea(name);
        if(flag==-1){
            System.out.println("local taarif nashode.tarif shavad?\n1-yes\t2-no");
            if (input.nextInt()==1){
                Areas.addlocal(name);
                leader.setArea(name);
            } else{
                System.out.println("badan local ra moshakhas konid");
            }
        }
        return leader;
    }
    private LeaderMenu(){

    }
}

