package general.com.zoolatech.lecture1.tasks._1.solomiia_tymoshchuk;

public class Task8 extends Task7  {
    void checkDivision(){
        for(int i=1;i<=getNumber();i++){
                getNewarr().add(i);}
                    for(int m : getNewarr()){
                        if(m%3==0 && m%2==0){
                            System.out.println(m+"(by 2 and 3)");
                        }
                        else if(m%2==0){
                            System.out.println(m+"(by 2)");
                        }
                        else if(m%3==0){
                            System.out.println(m+"(by 3)");
                        }

        }
    }



    public static void main (String[] args) {
        System.out.println("Enter number");
        Task8 task8 = new Task8();
        task8.checkDivision();
    }
}
