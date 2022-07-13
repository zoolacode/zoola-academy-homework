package general.com.zoolatech.lecture1.tasks._1.solomiia_tymoshchuk;

import java.util.Scanner;

public class Task1 {
    double kms;
    String sentence;

    public double getKms(){
        return kms;
    }
    public String getSentence(){
        return sentence;
    }

    public String setSentence(){
        return sentence;
    }

    public String enterDataSentence(String sentence)
    {
        System.out.println(sentence);
        return sentence;
    }

    public Double convertKmstoMiles(double kms)
    {
        double milesValue = 1.609;
        double miles = kms*milesValue;
        System.out.println(miles);
        return miles;
    }

    public Task1(double kms, String sentence) {
        this.kms = kms;
        this.sentence = sentence;
    }

    public static void main (String[] args) {
        String sentence = "Enter km value,please";

        Scanner sc = new Scanner(System.in);
        double kms = sc.nextDouble();
        Task1 task1 = new Task1(kms, sentence);
        task1.enterDataSentence(sentence);
        task1.convertKmstoMiles(kms);

    }
}
