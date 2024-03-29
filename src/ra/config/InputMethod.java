package ra.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputMethod {
    private static String ERROR_VALUE = "Your Input is in valid";
    private static String ERROR_EMPTY = "Your Input Not Be Empty";
    private static String ERROR_DATE = "Your Input Date Is Wrong Format";

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public static Date getDate(){
        String regex = "(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/20(0[0-9]|1[0-9]|2[0-5])";

        do{
        try {
            return sdf.parse(inputFromUser(regex,ERROR_DATE));
        }catch (ParseException e){
            System.out.println(ERROR_DATE);
        }
        }while (true);


    }

    public static String getProductStatus(){

        return inputFromUser("(ACTIVE|BLOCK|INACTIVE)", ERROR_VALUE);
    }

    public static int getInt(){
        return Integer.parseInt(inputFromUser("\\d+",ERROR_VALUE));

    }

    public static float getFLoat(){
        return Float.parseFloat(inputFromUser("\\d+",ERROR_VALUE));

    }

    public static byte getByte(){
        return Byte.parseByte(inputFromUser("\\d+",ERROR_VALUE));

    }

    public static boolean getBoolean(){

        return Boolean.parseBoolean(inputFromUser("(true|false)",ERROR_VALUE));
    }
    public static String getString(){
        return inputFromUser("\\w{1,50}",ERROR_EMPTY);

    }

    public static String checkProductId(){
        return inputFromUser("(C|S|A)\\w{3}",ERROR_VALUE);
    }

    public static String getInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String inputFromUser(String regex, String alert){

        while (true){
            String value = getInput();
            if(isValid(regex, value)){
                return value;
            }
            else{
                System.out.println(alert);
            }
        }
    }

    public static boolean isValid(String regex, String value){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();

    }
}
