package Model;

import Model.Exceptions.IllegalValueException;

import java.util.Scanner;

/**
 * Created by AndyTsang on 2017-08-25.
 */
public abstract class Converter {
    private String convertFrom;
    private String convertTo;
    private Double value;
    private Scanner input;


    public Converter(){
        this.convertFrom = "";
        this.convertTo = "";
        this.value = 0.0;
        this.input = new Scanner(System.in);
    }


    public String getFrom(){
        return convertFrom;
    }

    public String getTo(){
        return convertTo;
    }

    public Double getValue(){
        return value;
    }

    public void giveInput(){
        System.out.println("Enter unit to convert from: ");
        this.convertFrom = input.nextLine();
        System.out.println("Enter unit to convert to: ");
        this.convertTo = input.nextLine();
        System.out.println("Enter the amount to convert: ");
        this.value = input.nextDouble();
        input.nextLine();
    }

    public abstract void unitsInfo();

    public abstract double convert() throws IllegalValueException;

    public abstract boolean isValidUnit(String from, String to);
}
