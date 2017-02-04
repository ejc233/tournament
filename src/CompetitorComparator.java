import java.util.Comparator;

public class CompetitorComparator implements Comparator<Competitor>
{
    @Override
    public int compare(Competitor c1, Competitor c2)
    {
        if (c1.getStrength() > c2.getStrength())
        {
            return -1;
        }
        if (c1.getStrength() < c2.getStrength())
        {
            return 1;
        }
        return 0;
    }
}