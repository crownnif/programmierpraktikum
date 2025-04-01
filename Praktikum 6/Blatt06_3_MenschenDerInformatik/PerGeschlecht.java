import java.util.Objects;

/**
 * Vergleicht zwei Personen anhand ihres Alters.
 * 
 * @author Fredrik Winkler
 * @version 2021
 */
class PerGeschlecht implements Vergleicher
{
    /**
     * @see Vergleicher.vergleiche
     */
    public int vergleiche(Person a, Person b)
    {
        // Achtung: Dieser Trick funktioniert nur, wenn die Differenz garantiert in einen int passt.
        return gibGeschlechtRang(a.gibGeschlecht()) - gibGeschlechtRang(b.gibGeschlecht());
    }
    
    private int gibGeschlechtRang(Geschlecht geschlecht)
    {
        Objects.requireNonNull(geschlecht);
        switch(geschlecht)
        {
            case WEIBLICH:
                return 0;
            case DIVERS:
                return 1;
            case MAENNLICH:
                return 2;
            default:
                return -1;
        }
    }
}
