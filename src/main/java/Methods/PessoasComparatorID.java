package Methods;

import Application.Class.Pessoas;

import java.util.Comparator;

public class PessoasComparatorID implements Comparator<Pessoas> {

    @Override
    public int compare(Pessoas o1, Pessoas o2) {
        return Integer.compare(o1.getID(), o2.getID());
    }
}
