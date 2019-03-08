import java.util.Scanner;
import java.util.Random;

public class Task28 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        int numbersCount = -1;
        int threadsCount = -1;

        while (numbersCount < 1000000 || numbersCount > 2000000) {
            try {
            System.out.print("Введите количество чисел от 1000000 до 2000000 - ");
            numbersCount = scanner.nextInt();
            } catch (Throwable e) {
                System.out.println("Неверный ввод. Количество чисел будет приравнено к 1000000");
                numbersCount = 1000000;
            }
        }

        System.out.println("");
        scanner = new Scanner(System.in);

        while (threadsCount < 10 || threadsCount > 1000) {
            try {
            System.out.print("Введите количество потоков от 10 до 1000 - ");
            threadsCount = scanner.nextInt();
            } catch (Throwable e) {
                System.out.println("Неверный ввод. Количество потоков будет приравнено к 100");
                threadsCount = 100;
            }
        }

        System.out.println("");

        int relation = numbersCount / threadsCount;
//      System.out.println("Relation = " + relation);

        int array[] = new int[numbersCount];

        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(1000);
        }        
        System.out.println("Массив сгенерирован. Считаю сумму.");
        int summ = 0;
        for (int i = 0; i < array.length; i++) {
            summ += array[i];
        }
        System.out.println("Сумма чисел = " + summ);

        Counter counters[] = new Counter[threadsCount];

        for (int i = 0; i < counters.length - 1; i++) {
//          System.out.println("Поток " + i);
            counters[i] = new Counter(relation * i, relation * (i + 1) - 1, array);
//          System.out.println("Передал в поток. From = " + relation * i + ". To = " + (relation * (i + 1) - 1));
        }
//      System.out.println("Поток " + (counters.length - 1));
        counters[counters.length - 1] = new Counter(relation * (counters.length - 1), array.length - 1, array);
//      System.out.println("Передал в поток. From = " + (relation * (counters.length - 1)) + ". To = " + (array.length - 1));

        System.out.println("Пересчитываю сумму многопоточным методом.");

        for (int i = 0; i < counters.length; i++) {
            counters[i].start();
//          System.out.println("запустил поток " + i + ". Валидность - " + counters[i].valid());
        }

        summ = 0;
        while (threadsCount > 0) {
            for (int i = 0; i < counters.length; i++) {
                if (counters[i].valid()) {
//                  System.out.println("вошел в условный оператор. Поток под номером " + i + " - " + counters[i].valid());
                    summ += counters[i].getSumResult();
                    counters[i].touched();
                    threadsCount--;
                }
            }

        }
        System.out.println("Сумма чисел многопоточным методом = " + summ);
    }
}
