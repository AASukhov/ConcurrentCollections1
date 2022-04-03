public class Main {

    public static final int EMPLOYEES = 10;

    public static void main(String[] args) {
        Call_Center center = new Call_Center();

        new Thread(null, center::call, "Поток АТС").start();

        for (int i = 0; i <= EMPLOYEES; i++) {
            new Thread(null, center::takingCall, "Оператор №" + i).start();
        }
    }
}
