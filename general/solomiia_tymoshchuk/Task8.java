package general.solomiia_tymoshchuk;

/**
 * Write a program that prints all numbers from 1 to N, that are divisible by 2, 3 or by both.
 * If a number is divisible by only 2 - print it and add in parentheses “(by 2)”,
 * if only by 3 - “(by 3)”, if by both numbers - “(by 2 and 3)”.
 * Every number should be printed on the new line.
 * Create two versions of the program: one should use the for loop, second - the while loop.
 **/
public class Task8 extends Task7 {

    void checkNumbers() {
        for (int m : getNewarr()) {
            if (m % 3 == 0 && m % 2 == 0) {
                System.out.println(m + "(by 2 and 3)");
            } else if (m % 2 == 0) {
                System.out.println(m + "(by 2)");
            } else if (m % 3 == 0) {
                System.out.println(m + "(by 3)");
            }

        }
    }

    void checkDivision() {
        for (int i = 1; i <= getNumber(); i++) {
            getNewarr().add(i);
        }
        checkNumbers();
    }

    void checkDivisionWhileLoop() {
        int i = 1;
        while (i <= getNumber()) {
            getNewarr().add(i);
            i++;
        }
        checkNumbers();
    }

    public static void main(String[] args) {
        System.out.println("Enter number");
        Task8 task8 = new Task8();
        task8.checkDivisionWhileLoop();
    }
}
