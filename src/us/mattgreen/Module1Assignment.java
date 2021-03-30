package us.mattgreen;

import java.util.Scanner;
import java.util.ArrayList;

public class Module1Assignment {
    Scanner keyboard = new Scanner(System.in);
    public ArrayList<Talkable> addAnimal;

    public Module1Assignment(ArrayList<Talkable> addAnimal) {
        this.addAnimal = addAnimal;
    }

    //decisions
    public void decisions(){
        System.out.println("what type of animal they want to create?(cat/dog)");
        String choice = keyboard.nextLine().toLowerCase();
        switch (choice){
            case "cat":
                System.out.println("Cat's Name: ");
                String catName = keyboard.nextLine();
                addAnimal(new Cat(validateFormat(), catName));
                break;
            case "dog":
                System.out.println("Dog's Name: ");
                String dogName = keyboard.nextLine();
                boolean isFriendly = friendly();
                addAnimal(new Dog(isFriendly, dogName));
            default:
                System.out.println("End");
                break;
        }
    }

    //exceptions
    public int validateFormat(){
        System.out.println("mousesKilled? ");
        while(true) {
            try {
                return Integer.parseInt(keyboard.nextLine());
            } catch ( NumberFormatException e) {
                System.out.println("Enter a integer/number");
            }
        }
    }

    public boolean friendly(){
        while (true){
            System.out.println("Is friendly? (y/n)");
            String answer = keyboard.nextLine();
            if(answer.equals("y")){
                return true;
            } else if (answer.equals("n")){
                return false;
            } else {
                System.out.println("Enter y or n.");
            }
        }
    }

    public void addAnimal(Talkable pet){
        addAnimal.add(pet);
    }

    public ArrayList<Talkable> getList(){
        return addAnimal;
    }
}


