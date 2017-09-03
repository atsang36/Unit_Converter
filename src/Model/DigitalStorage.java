package Model;

import Model.Exceptions.IllegalValueException;

/**
 * Created by AndyTsang on 2017-08-25.
 */
public class DigitalStorage extends Converter {

    @Override
    public void unitsInfo() {
        System.out.println("    - Bits (bit)");
        System.out.println("    - Bytes (B)");
        System.out.println("    - kiloByte (kB)");
        System.out.println("    - MegaByte (MB)");
        System.out.println("    - GigaByte (GB)");
        System.out.println("    - TeraByte (TB)");
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
        if ((from.equals("bit") || from.equals("B") || from.equals("kB") || from.equals("MB") || from.equals("GB")
                || from.equals("TB"))
                && (to.equals("bit") || to.equals("B") || to.equals("kB") || to.equals("MB") || to.equals("GB")
                || to.equals("TB"))) {
            return true;
        } else
            return false;
    }
}
