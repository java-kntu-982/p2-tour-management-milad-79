package ir.ac.kntu;

import java.util.Arrays;

public class Tour {
    private String name;
    private boolean isComplete;
    private int time;
    private String beginning;
    private String distination;
    private Date startTour;
    private Date finishTour;
    private int price;
    private int lowestParticipant;
    private int mostParticipant;
    private TypeTrip typeTrip;
    private TypeArea typeArea;
    String[] bazdidha=new String[time];
    private TourLeader leader;

    public String getName() {
        return name;
    }
    public Tour(){

    }

    public void setLeader(TourLeader leader) {
        this.leader = leader;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistination(String distination) {
        this.distination = distination;
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

    public String getDistination() {
        return distination;
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
                ", mabda='" + beginning + '\'' +
                ", maghsad='" + distination + '\'' +
                ", startTour=" + startTour +
                ", finishTour=" + finishTour +
                ", price=" + price +
                ", kamtarintedad=" + lowestParticipant +
                ", bishtarintedad=" + mostParticipant +
                ", noe=" + typeTrip +
                ", noeArea=" + typeArea +
                ", bazdidha=" + Arrays.toString(bazdidha) +
                ", leader=" + leader +
                '}';
    }

    public String toString1() {
        return "Tour{" +
                "name='" + name + '\'' +
                ", takmilTour=" + isComplete +
                ", Time=" + time +
                ", mabda='" + beginning + '\'' +
                ", maghsad='" + distination + '\'' +
                ", StartTour=" + startTour +
                ", FinishTour=" + finishTour +
                ", prize=" + price +
                ", kamtarintedad=" + lowestParticipant +
                ", bishtarintedad=" + mostParticipant +
                ", noe=" + typeTrip +
                ", Local=" + typeArea +
                ", leader=" + leader +
                '}';
    }
}
