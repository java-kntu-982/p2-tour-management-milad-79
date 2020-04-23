package ir.ac.kntu;

import java.util.Arrays;

public class Tour {
    private String name;
    private boolean isComplete;
    private int time;
    private String beginning;
    private String distention;
    private Date startTour;
    private Date finishTour;
    private int price;
    private int lowestParticipant;
    private int mostParticipant;
    private TypeTrip typeTrip;
    private TypeArea typeArea;
    private TourLeader leader;
    private String[] places =new String[time];

    public String getName() {
        return name;
    }
    public Tour(){
    }

    public int getTime() {
        return time;
    }

    public void setPlaces(String[] places) {
        this.places = places;
    }

    public Date getStartTour() {
        return startTour;
    }

    public Date getFinishTour() {
        return finishTour;
    }

    public String getPlaces(int i) {
        return places[i];
    }

    public void setLeader(TourLeader leader) {
        this.leader = leader;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistention(String distention) {
        this.distention = distention;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        this.isComplete = complete;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getBeginning() {
        return beginning;
    }

    public void setBeginning(String beginning) {
        this.beginning = beginning;
    }

    public String getDistention() {
        return distention;
    }

    public void setStartTour(Date startTour) {
        this.startTour = startTour;
        setFinishTour();
    }


    public void setFinishTour() {
        this.finishTour=this.startTour;
        for (int i=0;i<this.time;i++){
            this.finishTour=this.finishTour.nextDay();
        }
    }

    public void setTypeArea(TypeArea typeArea) {
        this.typeArea = typeArea;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public void setLowestParticipant(int lowestParticipant) {
        this.lowestParticipant = lowestParticipant;
    }

    public void setMostParticipant(int mostParticipant) {
        this.mostParticipant = mostParticipant;
    }


    public void setTypeTrip(TypeTrip typeTrip) {
        this.typeTrip = typeTrip;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", beginning='" + beginning + '\'' +
                ", distention='" + distention + '\'' +
                ", price=" + price +
                ", lowestParticipant=" + lowestParticipant +
                ", mostParticipant=" + mostParticipant +
                ", typeTrip=" + typeTrip +
                ", typeArea=" + typeArea +
                ", places=" + Arrays.toString(places) +
                '}';
    }

    public static void toString(Tour tour) {
        System.out.println( "Tour{" +
                "name='" + tour.name + '\'' +
                ", isComplete=" + tour.isComplete +
                ", time=" + tour.time +
                ", beginning='" + tour.beginning + '\'' +
                ", distination='" + tour.distention + '\'' +
                ", startTour=" + tour.startTour +
                ", finishTour=" + tour.finishTour +
                ", price=" + tour.price +
                ", lowestParticipant=" + tour.lowestParticipant +
                ", mostParticipant=" + tour.mostParticipant +
                ", typeTrip=" + tour.typeTrip +
                ", typeArea=" + tour.typeArea +
                ", leader=" + tour.leader +
                '}');
    }
}
