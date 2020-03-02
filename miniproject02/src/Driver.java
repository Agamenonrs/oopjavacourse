import enumeration.ContactLabel;
import enumeration.ContactMenu;
import exception.ContactException;

import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class Driver {

    public static final String PHONE_PATTERN = "[0-9\\-]+";
    public static Pattern pattern = Pattern.compile(PHONE_PATTERN);

    public static void main(String[] args) throws Exception {

        InputCollector app = new InputCollector();
        ContactList contactList = new ContactList();
        contactList.builder();
        boolean exit = false;
        while ( !exit ){
            app.createMenu();
            String input = InputCollector.getUserInput("Enter your option: ");
            try{
                ContactMenu menuOption;
                try {
                    menuOption = ContactMenu
                            .getOptionById(Integer.parseInt(input));
                }catch (NumberFormatException pex){
                    throw new NumberFormatException("It is not a number. Try again.");
                }catch (NoSuchElementException nseex){
                    throw new NoSuchElementException("Invalid menu option. Try again.");
                }

                String[] contactParams = new String[6];
                Contact contact = null;
                String confirm = "S";
                String strId = "";
                switch (menuOption) {
                    case QUIT:
                        System.out.println("Bye!!");
                        exit = true;
                        break;
                    case NEW_CONTACT:
                        getContactInput(contactParams,false);
                        insertOrUpdate(contactList,contactParams,-1);
                        break;
                    case ALL_CONTACTS:
                        contactList.printContactList();
                        break;
                    case REMOVE_CONTACT:
                        strId = InputCollector.getUserInput("Type conctact id to remove: ");
                        int idRemove = InputCollector.idConverter(strId);
                        contactList.showContactDetails(idRemove);
                        contact = contactList.getContactByIndex(idRemove);
                        confirm = InputCollector.getUserInput("Confirm? (S/n) ");
                        if ("".equals(confirm) || "S".equals(confirm.toUpperCase())){
                            contactList.removeContact(idRemove);
                            System.out.println(String.format("Sucessfully removed %s!", contact.getName()));
                        }




                        break;
                    case UPDATE_CONTACT:
                        strId = InputCollector.getUserInput("Type conctact id to edit: ");
                        int idUpdate = InputCollector.idConverter(strId);
                        contact = contactList.getContactByIndex(idUpdate);
                        contactParams[ContactLabel.NOME.getId()] = contact.getName();
                        contactParams[ContactLabel.EMAIL.getId()] = contact.getEmail();
                        contactParams[ContactLabel.MOBILE_PHONE_NUMBER.getId()] = contact.getMobileNumber();
                        contactParams[ContactLabel.WORK_PHONE_NUMBER.getId()] = contact.getWorkNumber();
                        contactParams[ContactLabel.HOME_PHONE_NUMBER.getId()] = contact.getHomeNumber();
                        contactParams[ContactLabel.CITY.getId()] = contact.getCity();
                        getContactInput(contactParams,true);
                        insertOrUpdate(contactList, contactParams, idUpdate);
                        break;
                    default:
                        System.out.println("");
                }
            }catch (NumberFormatException nex){
                System.out.println(nex.getMessage());
            }catch (NoSuchElementException nseex){
                System.out.println(nseex.getMessage());
            }catch (ContactException cex){
                System.out.println(cex.getMessage());
            }catch(Exception ex){
                ex.printStackTrace();
                System.out.println("Undefined exception. The app is broken. Sorry :( ");
                throw new Exception();
            }

            }
    }

    private static void insertOrUpdate(ContactList contactList, String[] contactParams, int idUpdate) throws ContactException {
        String confirm;
        Contact contact;
        contact = new Contact(contactParams[ContactLabel.NOME.getId()], contactParams[ContactLabel.EMAIL.getId()],
                contactParams[ContactLabel.MOBILE_PHONE_NUMBER.getId()], contactParams[ContactLabel.WORK_PHONE_NUMBER.getId()],
                contactParams[ContactLabel.HOME_PHONE_NUMBER.getId()], contactParams[ContactLabel.CITY.getId()]);
        confirm = InputCollector.getUserInput(String.format("Confirm %s? (S/n) ", idUpdate >= 0 ? "update" : "insert" ));
        if ("".equals(confirm) || "S".equals(confirm.toUpperCase())) {
            if (idUpdate >= 0){
                contactList.updateContact(contact, idUpdate);
                System.out.println("Sucessfully updated the contact!");
            }else{
                contactList.addContact(contact);
                System.out.println("Sucessfully added a new contact!");

            }

        }
    }

    private static void getContactInput(String[] contactParams, boolean update) {
        String confirm;

        for (ContactLabel cl : ContactLabel.values() ){
            boolean complete = false;
            while (!complete){
                try {
                    if (update) {
                        confirm = InputCollector.getUserInput(String.format("Would you like to update contact %s? (S/n) ", cl.getLabel()));
                        if ("".equals(confirm) || "S".equals(confirm.toUpperCase())) {
                            String input = InputCollector.getUserInput(String.format("Enter %s: ", cl.getLabel()));
                            if (cl.isMandatory() && isEmpty(input)) {
                                throw new ContactException(String.format("Field '%s' is mandatory", cl.getLabel())) ;
                            }
                            if (isPhoneNumber(cl) && !isValidPhoneNumber(input))
                                    throw new ContactException("Invalid phone number");
                            contactParams[cl.getId()] = input;
                        }

                    } else {
                        String input = InputCollector.getUserInput(String.format("Enter %s: ", cl.getLabel()));
                        if (cl.isMandatory() && isEmpty(input)) {
                            throw new ContactException(String.format("Field '%s' is mandatory", cl.getLabel())) ;
                        }

                        if (isPhoneNumber(cl) && !isValidPhoneNumber(input))
                            throw new ContactException("Invalid phone number");
                        contactParams[cl.getId()] = input;
                    }
                    complete = true;
                }catch (ContactException cex){
                    complete = false;
                    System.out.println(cex.getMessage());

                }
            }

        }
    }

    private static boolean isEmpty(String contactParam) {
        return contactParam == null || contactParam.trim().equals("");
    }

    private static boolean isPhoneNumber(ContactLabel cl) {
        return cl.equals(ContactLabel.HOME_PHONE_NUMBER) ||
                cl.equals(ContactLabel.WORK_PHONE_NUMBER)
                || cl.equals(ContactLabel.MOBILE_PHONE_NUMBER);
    }

    public static boolean isValidPhoneNumber(String phone){
        return pattern.matcher(phone).matches();
    }
}
