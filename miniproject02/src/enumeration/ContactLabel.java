package enumeration;/*
@author Agamenon
*/

public enum ContactLabel {

    NOME(0,"Name",true),
    EMAIL(1,"Email", false),
    MOBILE_PHONE_NUMBER(2,"Mobile",true),
    WORK_PHONE_NUMBER(3,"Work",false),
    HOME_PHONE_NUMBER(4,"Home",false),
    CITY(5,"City",false);

    private int id;
    private String label;
    private boolean mandatory;

    ContactLabel(int id,String label,boolean mandatory){
        this.id = id;
        this.label  = label;
        this.mandatory  = mandatory;
    }

    public int getId() {
        return id;
    }
    public String getLabel() {
        return label;
    }
    public boolean isMandatory() {
        return mandatory;
    }
}
