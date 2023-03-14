import java.util.LinkedList;

public class Book {
    static LinkedList<Contacts> book = new LinkedList<Contacts>();

    public static void newContact(String name, String email, Long number) {
        Contacts contact = new Contacts();
        contact.setName(name);
        contact.setEmail(email);
        contact.setNumber(number);
        book.add(contact);
    }

    public static void deleteContact(Contacts cnt) {
        book.remove(book.indexOf(cnt));
    }

    public static LinkedList<Contacts> getContactList() {
        return book;
    }

    public static Contacts getContactByName(String name) {
        Contacts contact = null;
        for (Contacts cnt : book) {
            if (cnt.getName().equals(name)) {
                contact = cnt;
            }
        }
        return contact;
    }

    public static Contacts getContactByEmail(String email) {
        Contacts contact = null;
        for (Contacts cnt : book) {
            if (cnt.getEmail().equals(email)) {
                contact = cnt;
            }
        }
        return contact;
    }

    public static Contacts getContactByNumber(Long number) {
        Contacts contact = null;
        for (Contacts cnt : book) {
            if (cnt.getNumber().equals(number)) {
                contact = cnt;
            }
        }
        return contact;
    }

}
