import java.lang.Exception;
import java.lang.Integer;
import java.lang.String;
import java.util.Scanner;

/**
	Eeann aey caionea eaeueoeyoi?a. Iiaaa??eaaao aaia iieuciaaoaey.
*/
public class InteractRunner {
	protected static boolean wasCalculating = false; //Опеределяет осуществлялись ли ранее вычисления
	protected static Scanner reader = new Scanner(System.in); //Общий сканер
	protected static Calculator calc = new Calculator();//Экземпляр калькулятора, который выполняет подсчет

	/**
	 * Установка операндов
	 * @return String масив с 2 операндами
	 */
	public static String[] SetOperands( ){
		String [] operands = new String[2];

		if (!wasCalculating) {
			//Если еще не проводилось вычислений то записать первый аргумент
			System.out.println("Enter first arg : ");
			operands[0] = reader.next();
		}
		else
			//иначе использовать результат предыдущего вычисления
			operands[0] = Integer.toString(calc.getResult());
		System.out.println("Enter second arg : ");//Ввести второй аргумент
		operands[1] = reader.next();
		return operands;
	}

	/**
	 * Выполнение действий над операндами
	 * @param first Первый операнд
	 * @param second Второй операнд
	 * @param casedAction Флаг выбранного действия
	 *  Прокидывание исключений (может возникнуть при делении на 0)
	 */
	public static void ImplementingAction(String first, String second,
								   int casedAction) throws Exception{
		switch (casedAction){
			case 1:
				//Добавление
				calc.add(Integer.valueOf(first), Integer.valueOf(second));
				break;

			case 2:
				//Отнимание
				calc.minus(Integer.valueOf(first), Integer.valueOf(second));
				break;

			case 3:
				//Умножение
				calc.multiply(Integer.valueOf(first), Integer.valueOf(second));
				break;

			case 4:
				//Деление
				calc.div(Integer.valueOf(first), Integer.valueOf(second));
				break;

			case 5:
				//Возведение в степень
				calc.pow(Integer.valueOf(first), Integer.valueOf(second));
				break;
		}
		System.out.println("Result : " + calc.getResult());//Вывод результата
		wasCalculating = true;//Обозначение выполнения подсчета
	}

	/**
	 * Выбор дальнейшего действия после получения результата
	 * Завершение работы
	 * Очистка результата
	 * @return Строка с выбором последуйщих действий над
	 */
	public static String ExitAndClenResult(){
		System.out.println("Exit : yes/no "); //Запрос на выход из программы
		String exit = reader.next();

		if(exit.equals("no"))//Если не выходить, то запрос на очистку результата подсчета
			System.out.println("Clear result : yes/no ");
		String resultActin = reader.next();

		if(resultActin.equals("yes")) {
			calc.cleanResult();		//Очистка результата
			wasCalculating = false; //Сброс подсчетов
		}
		return exit;
	}

	public static void main(String[] arg) {
		try {
			String exit = "no";
			while (!exit.equals("yes")) {
				//Пока не выход - запускать подсчет
				String[] operands = SetOperands();//Установка операторов
				System.out.println("Case action: \n 1.+\n 2.-\n 3.*\n 4./\n 5.^");//Выбор действий
				int action = Integer.valueOf(reader.next());
				ImplementingAction(operands[0], operands[1], action);//Выполнение подсчета
				exit = ExitAndClenResult();//Завершение или продолжить работу
			}
		}	catch (Exception e){
			System.out.println(e.getMessage());
		}	finally {
			reader.close();
		}
	}
}