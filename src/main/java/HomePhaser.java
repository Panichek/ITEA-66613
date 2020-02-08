import java.util.concurrent.Phaser;

public class HomePhaser extends Phaser {
    int numPhases;
    int awaitAdvance() {
        return 0;
    }
       HomePhaser(int parties, int phaseCount) {
        super(parties);
        numPhases = phaseCount - 1;
    }

    // переопределить  метод  onAdvance( ),  чтобы  выполнить определенное  количество  фаз
    protected boolean onAdvance(int count, int regParties) {
        System.out.println("Фaзa  " + count + " завершена \n");
        //возвратить логическое значение true, если все фазы завершены
        if (count == numPhases || regParties == 0) return true;
        return false;
    }
}