package Model;

/**
 * Created by AndyTsang on 2017-08-25.
 */
public class ConverterFactory {
    public Converter getConverter(String measurementType) {
        if (measurementType.equals("temperature")) {
            return new Temperature();
        } else if (measurementType.equals("length")) {
            return new Length();
        } else if (measurementType.equals("mass")) {
            return new Mass();
        } else if (measurementType.equals("speed")) {
            return new Speed();
        }

        return null;
    }
}
