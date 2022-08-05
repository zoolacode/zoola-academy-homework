package general.solomiia_tymoshchuk.lecture3._2;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.parseLong;
/**
 * Not sure with this task to be honest, it works, but code is written in so baaaad way, will be thankful for advice:)
 * For example I can put all subclasses objects in one list, but how is it possible to call or check whether method isValid
 * returns true for all instances
 **/
public class AccountValidator {

    public AccountValidator(List<Object> dataList) {
        this.dataList = dataList;
    }
    public AccountValidator(){}

    String firstName;
    String lastName;
    String userEmail;
    String phoneNumber;
    Number birthDay;
    Number birthMonth;

    List<Object> dataList = new ArrayList<>();

    public boolean addValues(){
        FirstNameValidator firstNameV = new FirstNameValidator(dataList.get(0).toString());
        LastNameValidator lastNameV = new LastNameValidator(dataList.get(1).toString());
        UserEmailValidator userEmailValidator = new UserEmailValidator(dataList.get(2).toString());
        PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator(dataList.get(3).toString());
        BirthDayValidator birthDayValidator = new BirthDayValidator(parseLong(dataList.get(4).toString()));
        BirthMonthValidator birthMonthValidator = new BirthMonthValidator(parseLong(dataList.get(5).toString()));

        return firstNameV.isValid() && lastNameV.isValid() && userEmailValidator.isValid() && phoneNumberValidator.isValid() && birthDayValidator.isValid() && birthMonthValidator.isValid();
    }

    public boolean isValid(){
        return addValues();
    };

    public static void main(String[] args) {
        List<Object> dataList = new ArrayList<>();
        dataList.add("firstName");
        dataList.add("f");
        dataList.add("userEmail@gmail");
        dataList.add("1234567891");
        dataList.add(15);
        dataList.add(12);
        AccountValidator accountValidator = new AccountValidator(dataList);
        System.out.println(accountValidator.isValid());
    }
}