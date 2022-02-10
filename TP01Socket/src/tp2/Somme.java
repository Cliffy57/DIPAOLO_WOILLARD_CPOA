package tp2;

public class Somme extends Traitrequete{
    int m;

    public Somme(int n){
        this.m=n;
    }

    @Override
    public Object execute() {
        return new Integer(m + m);
    }
}
