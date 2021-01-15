package se.lexicon.samuel;

import java.io.*;


public class App 
{
    public static void main( String[] args ) {

        //this way you can save and read an object easily
        AppUser appUser = new AppUser("Sam", "Adetoye", 23, "123456");
        File file = new File("src/main/resources/user.ser");

        //writing
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(appUser);

        }catch(IOException ex){
            ex.printStackTrace();
        }

        //reading
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
            Object deserialized = in.readObject();
            System.out.println(deserialized.toString());

            //here we have 2 exceptions type specified. IOException and class not found
        }catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }

    }
}
