package general.solomiia_tymoshchuk.lecture3._2;

import static java.lang.Integer.parseInt;

public class BirthDayValidator extends AccountValidator
{

    public BirthDayValidator(Long birthDay){
        this.birthDay = birthDay;
    }

    @Override
    public boolean isValid(){
        boolean value;
        int birthDayConverted = parseInt(String.valueOf(birthDay));
        if(birthDayConverted > 31) {
            value = false;
        } else if(birthDayConverted < 1) {
            value = false;
        }
        else {value = true;}
        return value;
    }
}
