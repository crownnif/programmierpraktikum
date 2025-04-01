
/**
 * Eine Person hat einen Vornamen, einen Nachnamen, ein Geburtsjahr und ein Geschlecht.
 * 
 * @author Fredrik Winkler, Axel Schmolitzky
 * @version 2021
 */
class Person
{
    private final String _vorname;
    private final String _nachname;
    private final int _geburtsjahr;
    private final Geschlecht _geschlecht;
    
    /**
     * Initialisiert ein Person-Objekt mit den angegeben Daten.
     * @param vorname Der Vorname der Person; darf nicht null sein.
     * @param nachname Der Nachname der Person; darf nicht null sein.
     * @param geburtsjahr Das Geburtsjahr der Person.
     * @param maennlich true, wenn die Person maennlich sein soll, false sonst.
     */
    public Person(String vorname, String nachname, int geburtsjahr, Geschlecht geschlecht)
    {
        if (vorname == null || nachname == null)
        {
            throw new IllegalArgumentException("Null-Referenzen nicht erlaubt!");
        }
        _vorname = vorname;
        _nachname = nachname;
        _geburtsjahr = geburtsjahr;
        _geschlecht = geschlecht;
    }

    /**
     * Liefert den Vornamen dieser Person.
     */
    public String gibVorname()
    {
        return _vorname;
    }
    
    /**
     * Liefert den Nachnamen dieser Person.
     */
    public String gibNachname()
    {
        return _nachname;
    }
    
    /**
     * Liefert das Geburtsjahr dieser Person.
     */
    public int gibGeburtsjahr()
    {
        return _geburtsjahr;
    }
    
    /**
     * Liefert das Geschlecht dieser Person.
     */
    public Geschlecht gibGeschlecht()
    {
        return _geschlecht;
    }
        
    /**
     * Liefert eine String-Darstellung im Format
     * Mustermann, Max (1987, maennlich)
     */
    public String toString()
    {
        return String.format("%s, %s (%d, %s)", _nachname, _vorname, _geburtsjahr, _geschlecht);
    }
}
