package comVISh;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Введите две строки (каждая строка должна быть выделена в кавычках) и знак операции +,- ,/ ,*.");
        System.out.println("Вторая строка м.б. числом от 1 до 10 и не выделяется кавычками");
        System.out.println("Максимальное количество символов в строке должно быть не более 10 символов");

        ClassAnaliz classAnaliz = new ClassAnaliz();

        Scanner console = new Scanner(System.in);
        String value = console.nextLine();

        classAnaliz.analiz_value(value);

    }
}
