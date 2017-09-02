package Model;

import Model.Exceptions.IllegalValueException;

/**
 * Created by AndyTsang on 2017-08-25.
 */
public class Speed extends Converter{
    private String[] units;
    private double[] unitConversions;

    public Speed(){
        units = new String[] { "mph", "fps", "mps", "kph"};
        unitConversions = new double[]{ 0.44704, 0.3048, 1, 0.27778};
    }

    @Override
    public void unitsInfo() {
        System.out.println("    - Mile/hour (mph)");
        System.out.println("    - Feet/second (fps)");
        System.out.println("    - Meter/second (mps)");
        System.out.println("    - Kilometer/hour (kph)");
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

