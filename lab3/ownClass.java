package lab3;

import java.util.Scanner;

public class ownClass{ 
    public static void clientCreate(Scanner input) {
        System.out.println("Hello, Nurik!");
        System.out.println("It's second problem");
        System.out.println("You can make account for your client");
        Client client;
        while(true){
            System.out.println("Write username (at least 4 letters, optional):");
            String username = input.next(); // .nextLine() лучше, чтобы считать пустой ввод

            System.out.println("Write password (at least 6 letters):");
            String password = input.next();

            if(!username.isEmpty() && username.length() > 4 && password.length() >= 6) {
                client = new Client(username, password);
                break;
            } else if(password.length() >= 6) {
                client = new Client(password);
                break;
            }
        }
        System.out.println("Client created with username: " + client.getUsername());
        System.out.println("Password: " + client.getPassword());
        System.out.println("ID: " + client.getID());

    }
}





class Client {
    private static int lenghtPassword = 8;
    private static boolean hasNumber = true; 
    private static boolean hasUpper = true; 
    private static boolean hasLower = true; 

    private final String id = "00001";
    private String username;    

    private String password;
    public Client(String username, String password) {
        this.username = username;
        this.password = password;

    }
    public Client(String password) {
        this.username = "user" + id;
        this.password = password;

    }

    public String getUsername(){
        return this.username; 
    }

    public String getID(){
        return this.id; 
    }

    public String getPassword(){
        return this.password; 
    }
    
    public void setPassword(String pass){ 
        this.password = pass; 
    }

    public void setUsername(String usName){ 
        this.username = usName; 
    }

    
}
