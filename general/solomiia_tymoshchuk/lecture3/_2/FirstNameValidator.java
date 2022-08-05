package general.solomiia_tymoshchuk.lecture3._2;

import java.util.List;

public class FirstNameValidator extends AccountValidator {

    public FirstNameValidator(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean isValid() {
        return !firstName.isEmpty();
    }

}
