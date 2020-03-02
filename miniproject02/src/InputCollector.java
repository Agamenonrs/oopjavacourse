import enumeration.ContactMenu;

import java.util.Scanner;

public class InputCollector {

    public static String HEADER =  "+===== Contact App =====+";
    public static String FOOTER =  "=========================";
    public static String PIPE = "|";
    public static int MENU_WIDTH = 25;

    public static Scanner in;

    public InputCollector(){
        in = new Scanner(System.in);
    }

    public void startApp(){
        createMenu();

    }

    public void createMenu(){
        System.out.println(HEADER);
        for (ContactMenu menu : ContactMenu.values()){
            String s = "| " + menu.getId() + ". " + menu.getDescription();
            int complete = MENU_WIDTH - s.length();
            s = s.concat("%"+complete+"s");
            System.out.println(String.format(s,"|"));
        }
        System.out.println(FOOTER);
    }

    public static String getUserInput(String prompt){
        System.out.println(prompt);
        String input = in.nextLine();
        return input;
    }

    public static int idConverter(String id){
        try {
            return Integer.parseInt(id);
        }catch (NumberFormatException pex){
            throw new NumberFormatException("It is not a number. Try again.");
        }
    }

}
