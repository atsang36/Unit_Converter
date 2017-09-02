package Model;

import Model.Exceptions.IllegalValueException;

/**
 * Created by AndyTsang on 2017-08-25.
 */
public class Temperature extends Converter {
    private String[] units;
    private double[] unitConversions;

    @Override
    public void unitsInfo() {
        System.out.println("    - Celsius (c)");
        System.out.println("    - Fahrenheit (f)");
        System.out.println("    - Kelvin (k)");
        System.out.println();
    }

    @Override
    public double convert() throws IllegalValueException {
        String from = getFrom();
        String to = getTo();
        double value = getValue();

        if(!isValidUnit(from,to)){
            throw new IllegalValueException();
        }

        if (from.equals("c")){
            value += 273.15;

        }else if (from.equals("f")){
            value = (value - 32) * 5 / 9 + 273.15;

        }

        if (to.equals("c")) {
            value -= 273.15;
        } else if (to.equals("f")) {
            value = (value - 273.15) * 9 / 5 + 32;
        }

        return value;

    }

    @Override
    public boolean isValidUnit(String from, String to) {
        if ((from.equals("c") || from.equals("f") || from.equals("k")) && (to.equals("f") || to.equals("c") || to.equals("k"))){
            return true;
        }else
            return false;
    }


}
