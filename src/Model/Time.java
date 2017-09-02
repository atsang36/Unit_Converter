package Model;

/**
 * Created by AndyTsang on 2017-08-25.
 */
public class Time extends  Converter {
    private String[] units;
    private double[] unitConversions;

    @Override
    public void unitsInfo() {

    }

    @Override
    public double convert() {
        return 0;
    }

    @Override
    public boolean isValidUnit(String from, String to) {
        return false;
    }
}
