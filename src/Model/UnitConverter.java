package Model;

import Model.Exceptions.IllegalValueException;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by AndyTsang on 2017-08-25.
 */
public class UnitConverter {

    public static final Map<String, String> MEASUREMENT;
    static {
        MEASUREMENT = new HashMap<String, String>();
        MEASUREMENT.put("temp", "temperature");
        MEASUREMENT.put("len", "length");
        MEASUREMENT.put("m", "mass");
        MEASUREMENT.put("spd", "speed");
        MEASUREMENT.put("d", "digital");
        MEASUREMENT.put("t", "time");
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Boolean b = true;

        intro();

        while(b){
            String r = "";

            convert(input);
            System.out.println("Exiting Application, Goodbye!");
//            System.out.print("Do you want to choose another type of measurement? Yes(y) or No(n)? ");
//            r = input.nextLine();
//
//            while (!r.toLowerCase().startsWith("n") && !r.toLowerCase().startsWith("y")) {
//                System.out.println("Please choose Yes(y) or No(n)!");
//                System.out.print("Do you want to choose another type of measurement? Yes(y) or No(n)? ");
//                r = input.nextLine();
//            }
//
//            if (r.toLowerCase().startsWith("n")) {
//                b = false;
//            }
        }
    }

    private static void intro(){
        System.out.println();
        System.out.println(" Please Enter The Type Of Measurement To Convert");
        System.out.println();
    }

    public static Converter getConverter(Scanner input){
        String converter = "";
        ConverterFactory converterFactory = new ConverterFactory();
        System.out.println("From the Following: ");
        System.out.println("    - Temperature (temp)");
        System.out.println("    - Length (len)");
        System.out.println("    - Mass (m)");
        System.out.println("    - Speed (spd)");
        System.out.println("    - Digital Storage (d)");
        System.out.println("    - Time (t)");
        System.out.println();

        converter = input.nextLine();
        while (!MEASUREMENT.containsKey(converter)) {
            System.out.println("Please Select The Choices Listed Above");
            converter = input.nextLine();
        }

        return converterFactory.getConverter(MEASUREMENT.get(converter));
    }

    public static void convert(Scanner input){
        Converter converter = getConverter(input);
        Boolean temp = true;

        while(temp){
            String r;

            System.out.println("Choose From: ");
            converter.unitsInfo();


            try {
                converter.giveInput();
                System.out.printf("The value after conversion is %.3f", converter.convert());
                System.out.println();
            }catch(IllegalValueException e){
                System.out.println("Please Enter Applicable Units");
            }catch (InputMismatchException e){
                System.out.println("Amount Needs to be a Number");
            }

            System.out.print("Do you want to convert another unit? Yes(y) or No(n)? ");
            r = input.nextLine();

            while (!r.toLowerCase().startsWith("n") && !r.toLowerCase().startsWith("y")) {
                System.out.println("Please enter Yes(y) or No(n)!");
                System.out.print("Do you want to convert another unit? Yes(y) or No(n)? ");
                r = input.nextLine();
            }

            if (r.toLowerCase().startsWith("n")) {
//                temp = false;
                break;
            }

        }
    }
}
