package Lab_midterm;

class Contact {
    String name;
    String phoneNo;

    public Contact(String name, String phoneNo) {
        this.name = name;
        this.phoneNo = phoneNo;
    }
}
class Node {
    Contact contact;
    Node next;

    public Node(Contact contact) {
        this.contact = contact;
        this.next = null;
    }
}
class ContactList {
    Node head;

    public void addContact(String name, String phoneNo) {
        Contact newContact = new Contact(name, phoneNo);
        Node newNode = new Node(newContact);

        if (head == null) {
            head = newNode;

        }
        else {
            Node curr = head;

            while (curr.next != null) {

                curr = curr.next;
            }
            curr.next = newNode;
        }
    }
    public void deleteContact(String name) {
        if (head == null) {
            System.out.println("Contact List is empty. You cannot Delete");
            return;
        }
        if (head.contact.name.equalsIgnoreCase(name))
        {

            head = head.next;

            System.out.println("Contact with the  name " + name + "  is deleted successfully.");
            return;
        }

        Node curr = head;
        Node prev = null;

        boolean found = false;

        while (curr != null)
        {
            if (curr.contact.name.equalsIgnoreCase(name))
            {
                prev.next = curr.next;
                System.out.println("Contact with the name " + name + " is deleted successfully.");
                found = true;
                break;
            }


            prev = curr;
            curr = curr.next;
        }
        if (!found) {
            System.out.println("Contact with the name " + name + " is not found.");
        }
    }


    public void displayContacts() {
        if (head == null)
        {
            System.out.println("Contact List  is empty. You have to add Contacts");
            return;
        }
        System.out.println("Contact List:");

        Node curr = head;
        while (curr != null)
        {
            System.out.println("Name: " + curr.contact.name + ", Phone Number: " + curr.contact.phoneNo);
            curr = curr.next;
        }
    }

}
class Main {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();

        contactList.deleteContact("Faiq Yousaf");

contactList.displayContacts();

        contactList.addContact("Faiq Yousaf", "03134594113");
        contactList.addContact("Khawaja Ahmed", "03244449204");
        contactList.addContact("Abdullah Tehami", "03019731095");

        contactList.displayContacts();




        System.out.println("\nDeleting a contact:");
        contactList.deleteContact("Faiq Yousaf");
        contactList.displayContacts();


    }
}
