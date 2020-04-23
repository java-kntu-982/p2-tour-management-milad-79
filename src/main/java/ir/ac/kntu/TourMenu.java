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
                listTypeTour();
                break;
            case 2:
                listTour();
                break;
            case 3:
                tours.add(addTourStructure());
                break;
            case 4:
                addTour();
                break;
            case 5:editTypeTour();
                break;
            case 6: editTour();
                break;
            case 7:removeTour();
                break;
        }
    }
    public static void removeTour(){
        System.out.println("Choose Tour");
        listTour();
        Scanner input=new Scanner(System.in);
        int index=input.nextInt();
        tours.remove(index);
    }
    public static void editTour(){
        System.out.println("choose Tour");
        listTour();
        Scanner input=new Scanner(System.in);
        int index=input.nextInt();
        Tour tour=tours.get(index);
        while (true) {
            Tour.toString(tour);
            System.out.println("choose element:");
            System.out.println("0-payan virayesh\n1-tarikh shoro\n2-leader\n3-Final Name");
            int choose=input.nextInt();
            if (choose==0){
                break;
            }
            if (choose==1){
                System.out.println("new year:");
                int year = input.nextInt();
                System.out.println("new mah:");
                int month = input.nextInt();
                System.out.println("new roz:");
                int day = input.nextInt();
                tour.setStartTour(new Date(year, month, day));
            }
            if (choose==2){
                System.out.println("Choose new LeaderTour");
                if(!LeaderMenu.listLeader()){
                    System.out.println("leader ra badan entekhab konid");
                } else {
                    int i = input.nextInt();
                    tour.setLeader(LeaderMenu.leaders.get(i));
                }
            }
            if (choose==3){
                System.out.println("Enter new final name:");
                tour.setName(input.next());
            }
            tours.set(index,tour);
        }

    }
    public static void addTour() {
        System.out.println("choose Tour");
        listTypeTour();
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
        if(!LeaderMenu.listLeader()){
            System.out.println("leader ra badan entekhab konid");
        }else {
            int i = input.nextInt();
            tour.setLeader(LeaderMenu.leaders.get(i));
        }
        System.out.println("Final Name?");
        tour.setName(input.next());
        tours.set(index, tour);
    }
    public static void listTour(){
        int i;
        for (i=0; i< tours.size(); i++){
            if(!tours.get(i).isComplete()) {
                continue;
            }
            System.out.print(i+"-");
            System.out.println(tours.get(i).getName());
        }
    }
    public static void listTypeTour(){
        int i;
        for (i=0; i< tours.size(); i++){
            if(tours.get(i).isComplete()) {
                continue;
            }
            Tour.toString(tours.get(i));
        }
    }

    public static void editTypeTour(){
        Scanner input=new Scanner(System.in);
        System.out.println("Choose Tour:");
        listTypeTour();
        Tour tour=tours.get(input.nextInt());
        System.out.println(tour);
        System.out.println("choose element:");
        System.out.println("0-finish vireyesh\n1-Name\n2-time\n3-mentaghe" +
                "\n4-gheymat\n5-kamtarin tadad\n6-bishtarin tadad\n7-mabda\n8-maghsad\n9-tarighe safar\n10-bazdidha");
        while (true) {
            int choose = input.nextInt();

            if (choose == 0) {
                start();
            }
            if (choose == 1) {
                System.out.println("Enter New Name?");
                tour.setName(input.next());
            }
            if (choose == 2) {
                System.out.println("Enter New Time");
                tour.setTime(input.nextInt());
            }
            if (choose == 3) {
                tour.setTime(input.nextInt());
                System.out.println("mantaghe?\n1-dakhely\n2-kharegi");
                if (input.nextInt() == 1) {
                    tour.setTypeArea(TypeArea.INTERNAL);
                } else {
                    tour.setTypeArea(TypeArea.FOREIGN);
                }
            }
            if (choose == 4) {
                System.out.println("New price:");
                tour.setPrice(input.nextInt());
            }
            if (choose == 5) {
                System.out.println("kamtarin tedad");
                tour.setLowestParticipant(input.nextInt());
            }
            if (choose == 6) {
                System.out.println("bishtarin tedad");
                tour.setMostParticipant(input.nextInt());
            }
            if (choose == 7) {
                System.out.println("choose New mabda");
                String name = input.next();
                int flag = Areas.isArea(name);
                if (flag == -1) {
                    System.out.println("mabda taarif nashode.tarif shavad?\n1-yes\t2-no");
                    if (input.nextInt() == 1) {
                        Areas.addlocal(name);
                        tour.setBeginning(name);
                    } else {
                        System.out.println("mabda namoshakhas.badan ba afzodan local, mabda ra virayesh konid");
                    }
                } else {
                    tour.setBeginning(name);
                }
            }
            if (choose == 8) {
                System.out.println("maghsad?");
                String name = input.next();
                int flag = Areas.isArea(name);
                if (flag == -1) {
                    System.out.println("maghsad taarif nashode.tarif shavad?\n1-yes\t2-no");
                    if (input.nextInt() == 1) {
                        Areas.addlocal(name);
                        tour.setDistention(name);
                    } else {
                        System.out.println("maghsad namoshakhas.badan ba afzodan local, maghsad ra virayesh konid");
                    }
                } else {
                    tour.setDistention(name);
                }
            }
            if (choose == 9) {
                System.out.println("tarighe safar?\n1-havaie\n2-zamini");
                if (input.nextInt() == 1) {
                    tour.setTypeTrip(TypeTrip.Air);
                } else {
                    tour.setTypeTrip(TypeTrip.EARTHLY);
                }
            }
            if (choose==10){
                String[] bazdid=new String[tour.getTime()];
                for (int i=0;i<tour.getTime();i++) {
                    System.out.println("enter new Bazdid rooz"+i+1+":");
                    bazdid[i]=input.next();
                }
                tour.setPlaces(bazdid);
            }
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
            tour.setTypeArea(TypeArea.INTERNAL);
        } else{
            tour.setTypeArea(TypeArea.FOREIGN);
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
                tour.setDistention(name);
            } else{
                System.out.println("maghsad namoshakhas.badan ba afzodan local, maghsad ra virayesh konid");
            }
        } else{
            tour.setDistention(name);
        }
        System.out.println("tarighe safar?\n1-havaie\n2-zamini");
        if (input.nextInt()==1){
            tour.setTypeTrip(TypeTrip.Air);
        } else {
            tour.setTypeTrip(TypeTrip.EARTHLY);
        }
        String[] bazdid=new String[tour.getTime()];
        for (int i=1;i<=tour.getTime();i++) {
            System.out.println("enter Bazdid rooz"+i+":");
            bazdid[i-1]=input.next();
        }
        tour.setPlaces(bazdid);
        return tour;
    }
    private TourMenu(){

    }
}
