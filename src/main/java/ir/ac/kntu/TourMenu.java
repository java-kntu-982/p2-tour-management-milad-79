package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class TourMenu {
    private static ArrayList<Tour> tours =new ArrayList<>();

    public static Tour getTours(int index){
        return tours.get(index);
    }

    public static void start(){
        System.out.println("choose:");
        System.out.println("0-bazghasht be Menu asli");
        System.out.println("1-tamam noe Tours");
        System.out.println("2-Tamam Tours");
        System.out.println("3-afzodan noe Tour");
        System.out.println("4--afzodan  Tour");
        System.out.println("5-viryesh noe Tour");
        System.out.println("6-viryesh Tour");
        System.out.println("7-hazf Tour");
        Scanner input=new Scanner(System.in);
        switch (input.nextInt()){
            case 0:Main.startMenu();
                break;
            case 1:
                listTour();
                break;
            case 2:
                listTours();
                break;
            case 3:
                tours.add(addTourStructure());
                break;
            case 4:
                addTour();
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
        }
    }
    public static void addTour() {
        System.out.println("choose Tour");
        listTour();
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();
        Tour tour = tours.get(index);
        tour.setComplete(true);
        System.out.println(tour);
        System.out.println("tarikh shoroe?");
        System.out.println("sal?");
        int year = input.nextInt();
        System.out.println("mah?");
        int month = input.nextInt();
        System.out.println("rooz?");
        int day = input.nextInt();
        tour.setStartTour(new Date(year, month, day));
        System.out.println("choose Leader Tour");
        LeaderMenu.listLeader();
        int i = input.nextInt();
        tour.setLeader(LeaderMenu.leaders.get(i));
        System.out.println("Final Name?");
        tour.setName(input.next());
        tours.set(index, tour);
    }
    public static void listTour(){
        int i;
        for (i=0; i< tours.size(); i++){
            if(tours.get(i).isComplete()) {
                continue;
            }
            System.out.println(i+"-"+ tours.get(i).getName());
        }
    }
    public static void listTours(){
        int i;
        for (i=0; i< tours.size(); i++){
            if(!tours.get(i).isComplete()) {
                continue;
            }
            System.out.println(i+"-"+ tours.get(i).getName());
        }

    }
    public static Tour addTourStructure(){
        Tour tour=new Tour();
        tour.setComplete(false);
        Scanner input=new Scanner(System.in);
        System.out.println("Name?");
        tour.setName(input.next());
        System.out.println("modat Tour?");
        tour.setTime(input.nextInt());
        System.out.println("mantaghe?\n1-dakhely\n2-kharegi");
        if(input.nextInt()==1) {
            tour.setNoe(TypeArea.INTERNAL);
        } else{
            tour.setNoe(TypeArea.FOREIGN);
        }
        System.out.println("gheymat?");
        tour.setPrice(input.nextInt());
        System.out.println("kamtarin tetad sherkat konande?");
        tour.setLowestParticipant(input.nextInt());
        System.out.println("bishtarin tetad sherkat konande?");
        tour.setMostParticipant(input.nextInt());
        System.out.println("mabda?");
        System.out.println("choose mabda");
        String name=input.next();
        int flag=Areas.isArea(name);
        if(flag==-1){
            System.out.println("mabda taarif nashode.tarif shavad?\n1-yes\t2-no");
            if (input.nextInt()==1){
                Areas.addlocal(name);
                tour.setBeginning(name);
            } else{
                System.out.println("mabda namoshakhas.badan ba afzodan local, mabda ra virayesh konid");
            }
        } else{
            tour.setBeginning(name);
        }
        System.out.println("maghsad?");
        name=input.next();
        flag=Areas.isArea(name);
        if(flag==-1){
            System.out.println("maghsad taarif nashode.tarif shavad?\n1-yes\t2-no");
            if (input.nextInt()==1){
                Areas.addlocal(name);
                tour.setBeginning(name);
            } else{
                System.out.println("maghsad namoshakhas.badan ba afzodan local, maghsad ra virayesh konid");
            }
        } else{
            tour.setBeginning(name);
        }
        System.out.println("tarighe safar?\n1-havaie\n2-zamini");
        if (input.nextInt()==1){
            tour.setTypeTrip(TypeTrip.BYAIR);
        } else {
            tour.setTypeTrip(TypeTrip.EARTHLY);
        }
        return tour;
    }
}
