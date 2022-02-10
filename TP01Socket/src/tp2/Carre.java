package tp2;

public class Carre extends Traitrequete{
    int n;

    public Carre(int n){
        this.n=n;
    }

    @Override
    public Object execute() {
        return new Integer(n * n);
    }
}
