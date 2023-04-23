package Methods;

import Application.ClubUser;

import java.util.Comparator;

public class WageComparator implements Comparator<ClubUser> {
    @Override
    public int compare(ClubUser o1, ClubUser o2) {
        return Float.compare(o1.getWage(), o2.getWage());
    }
}
