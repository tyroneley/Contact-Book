import java.util.Scanner;
import java.util.LinkedList;
public class Main {
    public static void main (String[] args) {

        // Init
        Contacts currentContact = null;

        while (true) {

            // Display
            System.out.println("******************************");
            System.out.println("(A)dd");
            System.out.println("(D)elete");
            System.out.println("(E)mail Search");
            System.out.println("(P)rint List");
            System.out.println("(S)earch");
            System.out.println("(Q)uit");
            System.out.println("******************************");

            if (currentContact != null) {
                System.out.println("Selected contact: " + currentContact.getName() + ", " + currentContact.getEmail() + ", " + currentContact.getNumber()); 
            } else {
                System.out.println("Selected contact = nil");
            }

            System.out.println("******************************");
            
            // Display Input
            Scanner scn = new Scanner(System.in);
            char input = Character.toUpperCase(scn.nextLine().charAt(0));
            switch (input) {
                case 'A':
                    System.out.println("PROMPT: Please enter your new contact name ");
                    String newName = scn.nextLine();
                    System.out.println("PROMPT: Please enter your new contact email ");
                    String newEmail = scn.nextLine();
                    System.out.println("PROMPT: Please enter your new contact number ");
                    Long newNumber = scn.nextLong();
                    Book.newContact(newName, newEmail, newNumber);
                    break;
                case 'D':
                    if (currentContact != null) {
                        System.out.println("OUTPUT: Successfully deleted contact " + currentContact.getName());
                        Book.deleteContact(currentContact);
                        currentContact = null;
                    } else {
                        System.out.println("OUTPUT: You have not selected a contact");
                    }
                    break;
                case 'E':
                    System.out.println("PROMPT: Please enter an email (must be complete email)");
                    String email = scn.nextLine();
                    Contacts contact = Book.getContactByEmail(email);
                    if (contact != null) {
                        currentContact = contact;
                        System.out.println("OUTPUT: Selected contact of name " + contact.getName() + " with email " + contact.getEmail());
                    } else {
                        System.out.println("OUTPUT: That email does not in exist in the contact book");
                    }
                    break;
                case 'P':
                    LinkedList<Contacts> contactList = Book.getContactList();
                    if (contactList.size() > 0) {
                        System.out.println("NAME | EMAIL | NUMBER");
                        for ( Contacts cnt : contactList ) {
                            System.out.println(cnt.getName() + " | " + cnt.getEmail() + " | " + cnt.getNumber());
                        }
                    } else {
                        System.out.println("OUTPUT: There are no contacts in the list");
                    }
                    break;
                case 'S':
                LinkedList<Contacts> searchList = Book.getContactList();
                if (searchList.size() > 0) {
                        while (true) {
                            System.out.println("PROMPT: Type in the [NUM] of the contact you would like to select. Input [0] to return to menu");
                            // System.out.println("CONTACT LIST:");
                            System.out.println("[NUM] NAME | EMAIL | NUMBER");
                            for ( Contacts cnt : searchList ) {
                                System.out.println("[" + (searchList.indexOf(cnt)+ 1) +"] " + cnt.getName() + " | " + cnt.getEmail() + " | " + cnt.getNumber());
                            }
                            Integer contactIndex = scn.nextInt();
                            if (contactIndex == 0) {
                                break;
                            }
                            Contacts selectedContact = searchList.get(contactIndex - 1);
                            if (searchList.contains(selectedContact)) {
                                System.out.println("OUTPUT: Successfully selected contact [" + contactIndex + "] " + selectedContact.getName());
                                currentContact = selectedContact;
                                break;
                            } else {
                                System.out.println("OUTPUT: That contact does not exist in the list");
                            }
                        }                        
                    } else {
                        System.out.println("OUTPUT: There are no contacts in the list");
                    }
                    break;
                case 'Q':
                    scn.close();
                    exitProgram();
                    break;
                default:
                    System.out.println("OUTPUT: Not a valid input");
                    break;
            }
        }
        
        // Contacts contact = Book.getContactByName("Tyrone");
        // System.out.println(contact.getName() + " " + contact.getEmail());
    } 

    static void exitProgram() {
        System.out.println("OUTPUT: Program exited");
        System.exit(0);
    }
}