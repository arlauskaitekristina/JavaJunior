/*
1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
1.1 Найти максимальное
1.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
3.3 Найти количество чисел, квадрат которых меньше, чем 100_000
 */

package Junior;

public class Main {
    public static void main(String[] args) {
        Numbers numbers = new Numbers();
        numbers.randomNumberList();
        numbers.maxNumberList();
        numbers.sumNumberListByCondition();
        numbers.findNumberOfNumbersByCondition();
    }
}