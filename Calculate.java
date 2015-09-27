public class Calculate {

    public static void main(String[] arg) throws Throwable {
        int first = Integer.valueOf(arg[0]);
        int second = Integer.valueOf(arg[1]);
        System.out.println("sum    " + (first + second));
        System.out.println("minus    " + (first - second));
        System.out.println("multiply    " + (first * second));
        System.out.println("divide    " + (first / second));
        System.out.println("pow    " + (Math.pow(first, second)));
    }
}