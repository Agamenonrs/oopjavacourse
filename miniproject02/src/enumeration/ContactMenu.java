package enumeration;

import java.util.Arrays;

public enum ContactMenu {
    ALL_CONTACTS(1,"List all Contacts"),
    NEW_CONTACT(2,"Add new Contact"),
    REMOVE_CONTACT(3,"Remove Contact"),
    UPDATE_CONTACT(4,"Update Contact"),
    QUIT(5,"Quit");

    private int id;
    private String description;

    ContactMenu(int id, String description){
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static ContactMenu getOptionById(int id){
        return Arrays.asList(ContactMenu.values())
                .stream().filter(c-> c.getId() == id).findFirst().get();
    }
}
