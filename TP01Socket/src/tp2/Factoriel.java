package tp2;

public class Factoriel extends Traitrequete {
    int b, fact, i;

    public Factoriel(int n) {
        this.b = n;
    }

    @Override
    public Object execute() {
        for (i = 1; i <= b; i++) {
            fact = fact * i;

        }
        return new Integer(fact);
    }

}

