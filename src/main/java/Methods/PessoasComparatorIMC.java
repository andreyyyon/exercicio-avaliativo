package Methods;

import Application.Class.Pessoas;

import java.util.Comparator;

public class PessoasComparatorIMC implements Comparator<Pessoas> {

    @Override
    public int compare(Pessoas o1, Pessoas o2) {
        return Double.compare(o1.getIMC(),o2.getIMC());
    }
}
