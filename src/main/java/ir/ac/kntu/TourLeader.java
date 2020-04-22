package ir.ac.kntu;



public class TourLeader {
    private String firsName;
    private String lastName;
    private int nationalNamber;
    private boolean isMarried;
    private Date birth;
    private Date employment;
    private String area;

    public Date getEmployment() {
        return employment;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setEmployment(Date employment) {
        this.employment = employment;
    }


    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNationalNamber() {
        return nationalNamber;
    }

    public void setNationalNamber(int nationalNamber) {
        this.nationalNamber = nationalNamber;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        this.isMarried = married;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
    public TourLeader(){
    }

    @Override
    public String toString() {
        return "TourLeader{" +
                "FirsName='" + firsName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", shomare_meli=" + nationalNamber +
                ", tahol=" + isMarried +
                ", birth=" + birth +
                ", estekhdam=" + employment +
                ", locals='" + area + '\'' +
                '}';
    }
}