import enumeration.ContactLabel;
import exception.ContactException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ContactList {
    private List<Contact> contacts;

    public ContactList(){
        contacts = new ArrayList<Contact>();
    }

    public void builder(){
        Contact c1 = new Contact("aga","email", "222222", "333333","","Rio de janeiro");
        Contact c2 = new Contact("teste","email@teste", "22-2222", "33-3333","","Vancouver");
        try {
            this.addContact(c1);
            this.addContact(c2);
        }catch(ContactException ex){
            System.out.println(ex.getClass());
        }

    }

    public ContactList(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact) throws ContactException {
        if(this.contacts.contains(contact))
            throw new ContactException("Contact already exists.");

        contacts.add(contact);
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void printContactList(){
        if(contacts != null){
            for (int i = 0; i < contacts.size(); i++){
                System.out.println(String.format("%d: <%s> (%s:%s, %s:%s, %s:%s, %s:%s, %s:%s)"
                        ,i,contacts.get(i).getName(), ContactLabel.EMAIL.getLabel(),contacts.get(i).getEmail(),
                        ContactLabel.MOBILE_PHONE_NUMBER.getLabel(),contacts.get(i).getMobileNumber(),
                        ContactLabel.WORK_PHONE_NUMBER.getLabel(),contacts.get(i).getWorkNumber(),
                        ContactLabel.HOME_PHONE_NUMBER.getLabel(),contacts.get(i).getHomeNumber(),
                        ContactLabel.CITY.getLabel(),contacts.get(i).getCity()));
            }
        }
    }

    public void showContactDetails(int id) {
        if (id < 0 || id >= contacts.size() || contacts.get(id) == null)
            throw new NoSuchElementException(String.format("Contact with id ( %d ) not found",id));

        System.out.println(contacts.get(id).toString());
    }

    public void removeContact(int id) {
        contacts.remove(id);
    }

    public void updateContact(Contact contact, int editId) throws ContactException {
        if ( this.contacts.contains(contact)
                && this.contacts.indexOf(contact) != editId){
            throw new ContactException("Contact already exists.");
        }
        contacts.set(editId,contact);
    }

    public Contact getContactByIndex(int id) {
        if (id < 0 || id >= contacts.size() || contacts.get(id) == null)
            throw new NoSuchElementException(String.format("Contact with id ( %d ) not found",id));

        return contacts.get(id);
    }
}
