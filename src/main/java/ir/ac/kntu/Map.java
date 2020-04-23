package ir.ac.kntu;

import ir.ac.kntu.maputil.MapUtil;

import java.util.Scanner;

public class Map {
    public static void start(){
        System.out.println("choose location:");
        System.out.println("0-bazghasht be menu asli");
        System.out.println("1-mabda");
        System.out.println("2-maghsad");
        System.out.println("3-mabda v maghsad");
        System.out.println("4-yek mantaghe");
        System.out.println("5-do mantaghe");
        System.out.println("6-nmayesh mantaghe bazdid tour");
        System.out.println("7-mantaghe Tour");
        System.out.println("8-makan hal Tour");
        Scanner input=new Scanner(System.in);
        switch (input.nextInt()){
            case 0:Main.startMenu();
                break;
            case 1:onelocation(1);
                break;
            case 2:onelocation(2);
                break;
            case 3:twolocation(1);
                break;
            case 4:onelocation(3);
                break;
            case 5:twolocation(2);
                break;
            case 6:placeTour(1);
                break;
            case 7:placeTour(1);
                break;
            case 8:placeTour(2);
                break;
        }
    }
    public static void placeTour(int type){
        Scanner input=new Scanner(System.in);
        if (type==1){
            System.out.println("Type Tour?\n1-Complete Tour\t2-Structure Tour");
            if (input.nextInt()==1){
                System.out.println("Choose Tour:");
                TourMenu.listTour();
                int indexTour=input.nextInt();
                Tour tour=TourMenu.getTours(indexTour);
                System.out.println("Choose day");
                for(int day=1;day<=tour.getTime();day++){
                    System.out.println(day+"-"+tour.getPlaces(day));
                }
                MapUtil.showMap(tour.getPlaces(input.nextInt()));

            }else {
                System.out.println("Choose Structure Tour:");
                TourMenu.listTypeTour();
                int indexTour=input.nextInt();
                Tour tour=TourMenu.getTours(indexTour);
                System.out.println("Choose day");
                for(int day=1;day<=tour.getTime();day++){
                    System.out.println(day+"-"+tour.getPlaces(day));
                }
                MapUtil.showMap(tour.getPlaces(input.nextInt()));
            }

        }else {
            System.out.println("Choose Tour:");
            TourMenu.listTour();
            int indexTour=input.nextInt();
            Tour tour=TourMenu.getTours(indexTour);
            System.out.println("Enter the sal");
            int year=input.nextInt();
            System.out.println("Enter the mah");
            int month=input.nextInt();
            System.out.println("Enter the rooz");
            int day=input.nextInt();
            Date date=new Date(year,month,day);
            if(date.equals(tour.getStartTour())){
                MapUtil.showMap(tour.getBeginning());
            }
            if (date.equals(tour.getFinishTour())){
                MapUtil.showMap(tour.getDistention());
            }
            if (!date.equals(tour.getStartTour())&&!date.equals(tour.getFinishTour())){
                MapUtil.showMap(tour.getPlaces(Date.fasele(date,tour.getStartTour())));
            }
        }
    }
    public static void twolocation(int type){
        Scanner input=new Scanner(System.in);
        if(type==1) {
            TourMenu.listTypeTour();
            int indexTour=input.nextInt();
            MapUtil.showMap(TourMenu.getTours(indexTour).getBeginning());
            MapUtil.showMap(TourMenu.getTours(indexTour).getBeginning());
        }
        if(type==2){
            System.out.println("enter Mabda");
            String mabda=input.next();
            System.out.println("enter Maghsad");
            String maghsad=input.next();
            MapUtil.showMap(mabda,maghsad);
        }
    }
    public static void onelocation(int type){
        Scanner input=new Scanner(System.in);
        if(type==1){
            TourMenu.listTypeTour();
            MapUtil.showMap(TourMenu.getTours(input.nextInt()).getBeginning());
        }
        if (type==2){
            TourMenu.listTypeTour();
            MapUtil.showMap(TourMenu.getTours(input.nextInt()).getDistention());
        }
        if (type==3){
            System.out.println("enter the makan");
            MapUtil.showMap(input.next());
        }
    }

    private Map() {
    }
}
