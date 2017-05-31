/**
 * Created by Arkadiusz Nowak on 31.05.2017.
 */
public class DataAttribute {

    double baseValue;
    double currentValue;

    public DataAttribute(double initialValue){
        this.baseValue = initialValue;
        this.currentValue = this.baseValue;
    }

    public void returnToBase(){
        currentValue = baseValue;
    }
}
