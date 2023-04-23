package Methods;

import Application.Class.Pessoas;

import java.util.Comparator;

public class PessoasComparatorAltura implements Comparator<Pessoas> {
    @Override
    public int compare(Pessoas o1, Pessoas o2) {
        return Double.compare(o1.getAltura(), o2.getAltura());
    }
}
