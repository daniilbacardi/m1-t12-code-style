import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, int depositPeriod) {
        double pay = amount * Math.pow((1 + 0.06 / 12), 12 * depositPeriod);
        return roundValue(pay);
    }

    double calculateSimplePercent(double amount, int depositPeriod) {
        return roundValue(amount + amount * 0.06 * depositPeriod);
    }

    double roundValue(double value) {
        double scaLe = Math.pow (10, 2);
        return Math.round(value * scaLe) / scaLe;
    }

    void calculateDeposit() {
        int period;
        int action;
        int amount;
        double result = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1) {
            result = calculateSimplePercent(amount, period);
        } else if (action == 2) {
            result = calculateComplexPercent(amount, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
