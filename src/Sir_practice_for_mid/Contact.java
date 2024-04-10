package Sir_practice_for_mid;

class Contact {
    String name;
    String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
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

class PhoneBook {
    Node head;

    public void addContact(String name, String phoneNumber) {
        Contact newContact = new Contact(name, phoneNumber);
        Node newNode = new Node(newContact);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void displayContacts() {
        if (head == null) {
            System.out.println("Phone book is empty.");
            return;
        }
        System.out.println("Phone Book:");
        Node current = head;
        while (current != null) {
            System.out.println("Name: " + current.contact.name + ", Phone Number: " + current.contact.phoneNumber);
            current = current.next;
        }
    }

    public void searchContact(String name) {
        if (head == null) {
            System.out.println("Phone book is empty.");
            return;
        }
        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current.contact.name.equalsIgnoreCase(name)) {
                System.out.println("Name: " + current.contact.name + ", Phone Number: " + current.contact.phoneNumber);
                found = true;
                break;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Contact with name " + name + " not found.");
        }
    }

    public void deleteContact(String name) {
        if (head == null) {
            System.out.println("Phone book is empty.");
            return;
        }
        if (head.contact.name.equalsIgnoreCase(name)) {
            head = head.next;
            System.out.println("Contact with name " + name + " deleted successfully.");
            return;
        }
        Node current = head;
        Node prev = null;
        boolean found = false;
        while (current != null) {
            if (current.contact.name.equalsIgnoreCase(name)) {
                prev.next = current.next;
                System.out.println("Contact with name " + name + " deleted successfully.");
                found = true;
                break;
            }
            prev = current;
            current = current.next;
        }
        if (!found) {
            System.out.println("Contact with name " + name + " not found.");
        }
    }
}

class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("John Doe", "1234567890");
        phoneBook.addContact("Jane Smith", "0987654321");

        phoneBook.displayContacts();

        System.out.println("\nSearching for a contact:");
        phoneBook.searchContact("John Doe");
        phoneBook.searchContact("Alice");

        System.out.println("\nDeleting a contact:");
        phoneBook.deleteContact("Jane Smith");
        phoneBook.displayContacts();
    }
}

