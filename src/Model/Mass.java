package Model;

import Model.Exceptions.IllegalValueException;

/**
 * Created by AndyTsang on 2017-08-25.
 */
public class Mass extends Converter{
    private String[] units;
    private double[] unitConversions;

    public Mass(){
        units = new String[] { "ton", "kg", "g", "mg", "lb", "oz"};
        unitConversions = new double[]{1000, 1, 0.001, 0.000001, 0.45359237, 0.0283495};
    }

    @Override
    public void unitsInfo() {
        System.out.println("    - Metric ton (ton)");
        System.out.println("    - Kilogram (kg)");
        System.out.println("    - Gram (g)");
        System.out.println("    - Milligram (mg)");
        System.out.println("    - Pound (lb)");
        System.out.println("    - Ounce (oz)");
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

