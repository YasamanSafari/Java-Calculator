package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class CalculatorApp {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        CalculaterService calService = new CalculaterService();
        HistoryService hisService = new HistoryService();

        while (true){

            System.out.println(" "+" "+ "MAIN MENU"+" "+ " ");
            System.out.println("1:" + "Simple OP/ عملیات ساده(2 عدد )");
            System.out.println("2:"+"Advanced OP / عملیات پیشرفته (لیست اعداد)");
            System.out.println("3:"+"History / مشاهده تاریخچه");
            System.out.println("4:"+"Clean the History / پاک کردن تاریخچه");
            System.out.println("0: "+"Exit / خروج");
            System.out.println("گزینه مورد نظر را انتخاب کنید: / Choose");


            try {
                String Choice = input.next();
                if (Choice.equals("0")) break;

                switch (Choice){
                    case "1":
                        System.out.println("عدد اول رو وارد کن: / Enter the First Number");
                        double n1 = input.nextDouble();
//                        String n1string = input.nextLine();
//                        int n1 = Integer.parseInt(n1string);

                        System.out.println("Op (+,-,*,/,%) :  ");
                        char Operator = input.next().charAt(0);

                        System.out.println("عدد بعدی رو وارد کن: / Enter the Next Number");
                        double n2 = input.nextDouble();

                        double result = calService.Calculate(n1 , n2 ,Operator );
                        System.out.println("Result(From Simple) : " + result);
                        hisService.addRecord(n1 + " " + Operator + " "+ n2 + "="+" " + result);
                        break;

                    case "2":
                        System.out.println("On how many numbers? /  محاسبات روی چه تعداد عدد؟ ");
                        int count = input.nextInt();

                        if (count <= 0){
                            throw  new InvalidOperationException ("numbers more than 0 /  تعداد عددها بیشتر از 0 باشد");

                        }
                        ArrayList<Double>  numbers = new ArrayList<>();
                        for (int i = 0 ; i < count ;  i++ ){
                            System.out.println( "عدد"+ (i+ 1) +":");
                            numbers.add(input.nextDouble());
                        }

                        System.out.println("1:Sum , 2:Average , 3:Max , 4:Min");
                        int advanceChoice = input.nextInt();
                        double advanceresult = 0;

                        if (advanceChoice == 1 ) advanceresult = calService.sum(numbers);
                        if (advanceChoice == 2 ) advanceresult = calService.average(numbers);
                        if (advanceChoice == 3 ) advanceresult = calService.findMax(numbers);
                        if (advanceChoice == 4 ) advanceresult = calService.findMin(numbers);
                        hisService.addRecord("Result(Advanced) /  نتیجه عملیات لیست : " + advanceresult);
                        System.out.println("Final: " + advanceresult);
                        break;

                    case "3":
                        hisService.showHistory();
                        break;

                    case "4":
                        hisService.clearHistory();
                        break;

                    default:
                        throw new InvalidOperationException("invalid Choice / گزینه انتخاب شده معتبر نیست");
                }
            }
            catch (InputMismatchException e ){
                    System.out.println("Warning:Just Enter Numbers /  خطا! فقط عدد وارد کنید");
                    input.nextLine();

                }

            catch (InvalidOperationException | ArithmeticException e){
                System.out.println("Logic Exception: / :خطای منطقی " + e.getMessage());
            }

            catch (Exception e){
                System.out.println("unexpected Exception / خطای غیرمنتظره");
            }
        }

        System.out.println("Comeback again  /  بازم به ما سر بزن");
    }

}
