package Model;

import Model.Exceptions.IllegalValueException;

/**
 * Created by AndyTsang on 2017-08-25.
 */
public class Time extends  Converter {

    @Override
    public void unitsInfo() {
        System.out.println("    - millisecond (ms)");
        System.out.println("    - second (s)");
        System.out.println("    - minute (min)");
        System.out.println("    - hour (h)");
        System.out.println("    - day (d)");
        System.out.println("    - week (w)");
        System.out.println("    - year (y)");
        System.out.println("    - decade (de)");
        System.out.println("    - century (c)");
        System.out.println();

    }

    @Override
    public double convert() throws IllegalValueException {
        //TODO
        String from = getFrom();
        String to = getTo();
        double value = getValue();

        if(!isValidUnit(from,to)){
            throw new IllegalValueException();
        }

        if (from.equals("bit")){
            value /= 8;

        }else if (from.equals("kB")){
            value *= 1024;

        }else if (from.equals("MB")){
            value *= Math.pow(1024,2);

        }else if (from.equals("GB")){
            value *= Math.pow(1024,3);

        }else if (from.equals("TB")){
            value *= Math.pow(1024,4);

        }

        if (to.equals("bit")) {
            value *= 8;
        } else if (to.equals("kB")) {
            value /= 1024;
        }else if (to.equals("MB")) {
            value /= Math.pow(1024,2);
        }else if (to.equals("GB")) {
            value /= Math.pow(1024,2);
        }else if (to.equals("TB")) {
            value /= Math.pow(1024,2);
        }

        return value;
    }

    @Override
    public boolean isValidUnit(String from, String to) {
        if ((from.equals("ms") || from.equals("s") || from.equals("min")|| from.equals("h") || from.equals("d")
                || from.equals("w") || from.equals("y") || from.equals("de") || from.equals("c"))
                && (to.equals("ms") || to.equals("s") || to.equals("min") || to.equals("h") || to.equals("d")
                || to.equals("w")  || to.equals("y")  || to.equals("de")  || to.equals("c"))) {
            return true;
        } else
            return false;
    }
}
