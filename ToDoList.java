import java.util.*;

public class ToDoList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList(null);
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        System.out.println("Welcome " + name +" to Your To Do List. Created by Kieran Seidita. Please select your options:");
        
        /* Create a menu for the user to select to-do list options */
        boolean menu = true;
        while(menu){
            System.out.println("=====To-Do List Menu=====");
            System.out.println("1. Add First Task to To-Do List");
            System.out.println("2. Add Another Task");
            System.out.println("3. Display To-Do List");
            System.out.println("4. Delete");
            System.out.println("5. Exit");

            /* Take in the user's choice */
        int option = sc.nextInt();
        sc.nextLine();

        switch(option){
            case 1:
            System.out.println("Please enter your task.");
            String task = sc.nextLine();
            list.addToList(task);
            System.out.println("Your task " + task + " has been added to your To-Do List");
            break;
            case 2:
            System.out.println("Please enter your task.");
            String task2 = sc.nextLine();
            list.addAnotherTask(task2);
            System.out.println("Your task " + task2 + " has been added to your To-Do List");
            break;
            case 3:
            System.out.println("Here is your To-Do List: ");
            list.displayList();
            break;
            case 4:
            System.out.println("Type in the task your want to delete");
            String task3 = sc.nextLine();
            Node deletedNode = list.deleteTask(task3);
            if (deletedNode != null){
                System.out.println("Your task "+task3+" has been deleted");
            }
            else{
                System.out.println("Task not found");
            }
            break;
            case 5:
            System.out.println("Good bye " + name +"");
            System.out.println("Thank you for using the To-Do List");
            menu = false;
            break;
            default:
            System.out.println("Invalid option. Please try again.");
            break;
        }
    }


        sc.close();
    }
}

class Node{
    String data;
    Node next;

    public Node(String data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList{
    Node head;

    public LinkedList(Node head){
        this.head = head;
    }

    //Method to add stuff to the List
    public void addToList(String data){
        Node n = new Node(data);

        if(head == null){
            head = n;
        }
    }

    //Method to display your to-do list

    public void displayList(){
        Node current = head;
        while(current != null){
            System.out.println("-" + current.data + "");
            current = current.next;
        }
    }

    //Method to add mores tasks to a list

    public void addAnotherTask(String data){
        Node n = new Node(data);
        if(head == null){
            head = n;
        }
        else{
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
         curr.next = n;
        }
    }

    //Method to delete any task
    Node deleteTask(String data){
        Node curr = head;
        Node toDelete = null;

        //This is for when we look at the first task in the LinkedList
        if(curr != null && curr.data.equals(data)){
            toDelete = curr;
            head = head.next; //Update the head to go to next in the LinkedList
            return toDelete;
        }

        //This is for when we are checking the other items in the list
        while(curr != null){
            if(curr.next.data.equals(data)){
                toDelete = curr.next;
                curr.next = toDelete.next;
                break;
            }
            curr = curr.next;
        }
        return toDelete;
    }
}
