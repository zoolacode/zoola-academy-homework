package general.solomiia_tymoshchuk.lecture3._2;

import java.util.List;

public class LastNameValidator extends AccountValidator {

    public LastNameValidator(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean isValid() {
        return !lastName.isEmpty();
    }
}
