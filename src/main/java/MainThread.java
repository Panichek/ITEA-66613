
public class MainThread {
    public static void main(String[] args) {
        HomePhaser phsr = new HomePhaser(1, 5);
        System.out.println(" Зaпycк  потоков\n ");

        new ManThread(phsr, "А");
        new ManThread(phsr, "В");
        new ManThread(phsr, "С");
        new ManThread(phsr, "D");
        new ManThread(phsr, "E");
        // ожидать завершения определенного количества фаз
        while (!phsr.isTerminated()) {
            phsr.arriveAndAwaitAdvance();//указать завершение фазы

            phsr.arriveAndDeregister();   //уменьшаем кол-во участников
        }
        System.out.println("Cинxpoнизaтop  фаз  завершен");
    }
}
