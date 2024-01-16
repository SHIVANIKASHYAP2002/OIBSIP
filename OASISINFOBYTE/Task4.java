import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Task4 {
                                        
    public static void main(String[] args) {
        Candidate.register_user();
    }
}

 class Test{
    public static int score=0;  
    void begin_test(){
        Date startime=new Date();
        Date endtime=new Date(startime.getTime() + (60*5) *1000);
        System.out.println("Test stated at"+startime + "Test will end at "+endtime);

        Scanner sc=new Scanner(System.in);
        File Question=new File("question.txt");
        File Answer=new File("answer.txt");
      
        try {
           Scanner readQuestion = new Scanner(Question);
           Scanner readAnswer=new Scanner(Answer);
            while(readQuestion.hasNextLine() || readAnswer.hasNextLine()){
                String Questionline=readQuestion.nextLine();
                String Answerline=readAnswer.nextLine();
                System.out.println(Questionline);
                System.out.println("Enter your answer");
                String ans=sc.next();
                if(ans.equals(Answerline)){
                    score++;
                }
            }
            if(score==13){
                System.out.println("OBTAINED SCORE ="+score);
                System.out.println();
                System.out.println("***HURRAYYY*** you got the full marks");
            }
            else if(score>=5){
                System.out.println("OBTAINED SCORE ="+score);
                System.out.println();
                System.out.println("very good you pass the examination");
            }
            else{
                System.out.println("OBTAINED SCORE ="+score);
                System.out.println("OOPSS YOU FAILED BETTER LUCK NEXT TIME");
            }
            readAnswer.close();
            readQuestion.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
class Candidate{
    static String Name;
    static int roll_no;
    final static int Test_id=111;
    static int correct_respose;
    static int incorrect_reponse;
    static String password;

    static void register_user(){
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER YOUR NAME");
        Name=sc.nextLine();
        System.out.println("ENTER YOU ROLL NUMBER");
        roll_no=sc.nextInt();
        System.out.println("SET THE PASSWORD");
        password=sc.next();
        System.out.println("PLEASE REMEMBER THE PASSWORD YOU ARE DIRECTING TO EXAMINATION LOGIN PAGE");
        System.out.println();
        Portal.login();
    }
    static void update_user(){
        Scanner sc=new Scanner(System.in);
        System.out.println("YOU CAN ALTER YOUR PASSWORD");
        System.out.println("SET YOUR NEW PASSEORD");
        password=sc.nextLine();
        System.out.println("PASSWORD UPDATED SUCCESSFULLY");
    }

class Portal{
    static void login(){
        System.out.println();
        System.out.println("****************************ENTER YOUR CREDENTIALs***********************");
        System.out.println();
        int test_id;
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER YOUR TEST_ID");
        test_id=sc.nextInt();
        if(test_id==Test_id){

             System.out.println("ENTER YOUR ROLL_NUMBER");
            int roll=sc.nextInt();
            if(roll==roll_no){
                System.out.println("ENTER PASSWORD");
                String pass=sc.next();
                if(pass.equals(password)){
                    System.out.println("LOGIN SUCCESSFULLY");
                    Test t=new Test();
                    t.begin_test();
                }
                else{
                    System.out.println("DO YOU FORGET YOUR PASSWORD");
                    String ch=sc.next();
                    if(ch.equals("yes")){
                        Candidate.update_user();
                    }
                    System.out.println("ENTER YOUR PASSWord AGAIN");
                    pass=sc.next();
                    if(pass.equals(password)){
                        System.out.println("LOGIN SUCCESSFULLY_____________");
                        Test t=new Test();
                        t.begin_test();

                    }

                }
                
            }
            else{
                System.out.println("INCOREC ROLL NUMBER");
                System.exit(1); 
            }
        }
        else{
            System.out.println("NOT A VALID TEST_ID");
            System.exit(1);
        }
        
    }
}

}