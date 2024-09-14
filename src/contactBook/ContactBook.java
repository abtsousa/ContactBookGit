package contactBook;

public class ContactBook {
    static final int DEFAULT_SIZE = 100;

    private int counter;
    private Contact[] contacts;
    private int currentContact;

    public ContactBook() {
        counter = 0;
        contacts = new Contact[DEFAULT_SIZE];
        currentContact = -1;
    }

    //Pre: name != null
    public boolean hasContactByName(String name) {
        return searchIndexByName(name) >= 0;
    }

    //Pre: phone != null
    public boolean hasContactByPhone(int phone) {
        return searchIndexByPhone(phone) >= 0;
    }

    public int getNumberOfContacts() {
        return counter;
    }

    //Pre: name!= null && !hasContactByName(name)
    public void addContact(String name, int phone, String email) {
        if (counter == contacts.length)
            resize();
        contacts[counter] = new Contact(name, phone, email);
        counter++;
    }

    //Pre: name != null && hasContactByName(name)
    public void deleteContact(String name) {
        int index = searchIndexByName(name);
        for(int i=index; i<counter; i++)
            contacts[i] = contacts[i+1];
        counter--;
    }

    //Pre: name != null && hasContactByName(name)
    public int getPhone(String name) {
        return contacts[searchIndexByName(name)].getPhone();
    }

    //Pre: name != null && hasContactByName(name)
    public String getEmail(String name) {
        return contacts[searchIndexByName(name)].getEmail();
    }

    //Pre: phone != null && hasContactByPhone(phone)
    public String getName(int phone) { return contacts[searchIndexByPhone(phone)].getName(); }

    //Pre: name != null && hasContactByName(name)
    public void setPhone(String name, int phone) {
        contacts[searchIndexByName(name)].setPhone(phone);
    }

    //Pre: name != null && hasContactByName(name)
    public void setEmail(String name, String email) {
        contacts[searchIndexByName(name)].setEmail(email);
    }

    private int searchIndexByName(String name) {
        int i = 0;
        int result = -1;

        boolean found = false;
        while (i<counter && !found)
            if (contacts[i].getName().equals(name))
                found = true;
            else
                i++;
        if (found) result = i;
        return result;
    }

    private int searchIndexByPhone(int phone) {
        int i = 0;
        int result = -1;

        boolean found = false;
        while (i<counter && !found)
            if (contacts[i].getPhone() == phone)
                found = true;
            else
                i++;
        if (found) result = i;
        return result;
    }

    private void resize() {
        Contact tmp[] = new Contact[2*contacts.length];
        for (int i=0;i<counter; i++)
            tmp[i] = contacts[i];
        contacts = tmp;
    }

    public void initializeIterator() {
        currentContact = 0;
    }

    public boolean hasNext() {
        return (currentContact >= 0 ) && (currentContact < counter);
    }

    //Pre: hasNext()
    public Contact next() {
        return contacts[currentContact++];
    }

}
