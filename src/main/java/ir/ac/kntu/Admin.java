package ir.ac.kntu;

import java.util.Scanner;

public class Admin {
    private String name ="admin";
    private String password="admin";
    private String email;
    private int phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public Admin(){

    }
    public Admin(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static void changeInformation(){
        Admin admin=new Admin();
        Scanner input=new Scanner(System.in);
        System.out.println("Choose change:");
        System.out.println("1-Name\t2-Password");
        System.out.println("3-email\t4-PhoneNumber");
        switch (input.nextInt()){
            case 1:admin.setName(input.next());
                break;
            case 2:admin.setPassword(input.next());
                break;
            case 3:admin.setEmail(input.next());
                break;
            case 4:admin.setPhoneNumber(input.nextInt());
                break;
        }
    }
}
