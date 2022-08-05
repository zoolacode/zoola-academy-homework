package general.solomiia_tymoshchuk.lecture3._2;

import java.util.regex.Pattern;

public class UserEmailValidator extends AccountValidator {

    public UserEmailValidator(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean patternMatches(String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(userEmail)
                .matches();
    }

    @Override
    public boolean isValid() {
        String regexPattern = "^(.+)@(\\S+)$";
        return patternMatches(regexPattern);
    }

}



