package Junior;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;
public class Numbers {
        private List<Integer> integerList;

        /**
         * Метод создающий коллекцию List<'Integer'> из 1000 чисел  от 1 до 1_000_000
         */
        public void randomNumberList() {
            integerList = Stream.generate(() -> ThreadLocalRandom.current().nextInt(1000000)).limit(1000).toList();
           System.out.println(integerList);
        }

        /**
         * Метод находит в списке Lists максимальное число и выводит его в консоль
         */
        public void maxNumberList() {
            int maxNumber = integerList.stream().max(Integer::compare).get();
            System.out.println("Максимальное число в списке: " + maxNumber);
        }

        /**
         * Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
         */
        public void sumNumberListByCondition() {
            int sumNumberList = integerList.stream()
                    .filter(x -> x > 500000)
                    .map(x -> (x * 5) - 150)
                    .reduce(0, Integer::sum);
            System.out.println("Сумма чисел по условию: " + sumNumberList);
        }

        /**
         * Метод нахождения количества чисел, квадрат которых меньше 100_000
         */
        public void findNumberOfNumbersByCondition() {
            long quantity = integerList.stream().map(x -> Math.pow(x, 2)).filter((x) -> x < 100000).count();
            System.out.println("Количество чисел квадрат которых меньше 100_000: " + quantity);
        }
    }

