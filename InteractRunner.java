import java.util.Scanner;

/**
 * Eeann aey caionea eaeueoeyoi?a. Iiaaa??eaaao aaia iieuciaaoaey.
 */
public class InteractRunner {
    protected boolean wasCalculating = false; //Опеределяет осуществлялись ли ранее вычисления
    protected static Scanner reader = new Scanner(System.in); //Общий сканер
    protected Calculator calc = new Calculator();//Экземпляр калькулятора, который выполняет подсчет

    /**
     * Установка операндов
     *
     * @return String масив с 2 операндами
     */
    public String[] setOperands() {
        String[] operands = new String[2];

        if (!wasCalculating) {
            //Если еще не проводилось вычислений то записать первый аргумент
            System.out.println("Enter first arg : ");
            operands[0] = reader.next();
        } else
            //иначе использовать результат предыдущего вычисления
            operands[0] = Integer.toString(calc.getResult());
        System.out.println("Enter second arg : ");//Ввести второй аргумент
        operands[1] = reader.next();
        return operands;
    }


    /**
     * Выбор дальнейшего действия после получения результата
     * Завершение работы
     * Очистка результата
     *
     * @return Строка с выбором последуйщих действий над
     */
    public String exitAndClenResult() {
        System.out.println("Exit : yes/no "); //Запрос на выход из программы
        String exit = reader.next();

        if (exit.equals("no"))//Если не выходить, то запрос на очистку результата подсчета
            System.out.println("Clear result : yes/no ");
        String resultAction = reader.next();

        if (resultAction.equals("yes")) {
            calc.cleanResult();        //Очистка результата
            wasCalculating = false; //Сброс подсчетов
        }
        return exit;
    }

    public static void main(String[] arg) {
        try {
            InteractRunner runner = new InteractRunner();
            String exit = "no";
            while (!exit.equals("yes")) {
                //Пока не выход - запускать подсчет
                String[] operands = runner.setOperands();//Установка операторов
                System.out.println("Case action: \n 1.+\n 2.-\n 3.*\n 4./\n 5.^");//Выбор действий
                int action = Integer.valueOf(reader.next());
                runner.calc.implementingAction(operands[0], operands[1], action);//Выполнение подсчета
                exit = runner.exitAndClenResult();//Завершение или продолжить работу
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            reader.close();
        }
    }
}