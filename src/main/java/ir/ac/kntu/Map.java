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
        }
    }
    public static void twolocation(int type){
        Scanner input=new Scanner(System.in);
        if(type==1) {
            TourMenu.listTours();
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
            TourMenu.listTours();
            MapUtil.showMap(TourMenu.getTours(input.nextInt()).getBeginning());
        }
        if (type==2){
            TourMenu.listTours();
            MapUtil.showMap(TourMenu.getTours(input.nextInt()).getDistination());
        }
        if (type==3){
            System.out.println("enter the makan");
            MapUtil.showMap(input.next());
        }
    }

    private Map() {
    }
}
