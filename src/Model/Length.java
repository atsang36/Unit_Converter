package Model;

import Model.Exceptions.IllegalValueException;

/**
 * Created by AndyTsang on 2017-08-25.
 */
public class Length extends Converter{
    private String[] units;
    private double[] unitConversions;

    public Length(){
        units = new String[] {"km", "m", "cm", "mm", "mi", "yd", "ft", "in"};
        unitConversions = new double[]{1000, 1, 0.01, 0.001, 1609.344, 0.9144, 0.3048, 0.0254};
    }


    @Override
    public void unitsInfo() {
        System.out.println("    - Kilometer (km)");
        System.out.println("    - Meter (m)");
        System.out.println("    - Centimeter (cm)");
        System.out.println("    - Millimeter (mm)");
        System.out.println("    - Mile (mi)");
        System.out.println("    - Yard (yd)");
        System.out.println("    - Foot (ft)");
        System.out.println("    - Inch (in)");
    }

    @Override
    public double convert() throws IllegalValueException {

        String from = getFrom();
        String to = getTo();
        double value = getValue();
        int indexFrom = -1;
        int indexTo = -1;

        for (int i = 0; i < units.length; i++){
            if (from.equals(units[i])){
                indexFrom = i;
            }

            if (to.equals(units[i])){
                indexTo = i;
            }
        }
        if (indexFrom == -1 || indexTo == -1){
            throw new IllegalValueException();
        }
        value = value * unitConversions[indexFrom]/unitConversions[indexTo];

        return value;
    }

    @Override
    public boolean isValidUnit(String from, String to) {
        return false;
    }
}
