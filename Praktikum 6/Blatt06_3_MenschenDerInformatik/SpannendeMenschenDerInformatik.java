/**
 * Eine Zusammenstellung von Menschen, die die Informatik geprägt haben.
 * 
 * @author Fredrik Winkler, Axel Schmolitzky
 * @version 2021
 */
class SpannendeMenschenDerInformatik 
{
    /**
     * Arrays werden hier konsumiert, aktiv benutzen müsst ihr sie erst auf Blatt 7.
     */
    private final Person[] _urspruenglicheReihenfolge =
    {
        new Person("Ada", "Lovelace", 1815, Geschlecht.WEIBLICH),
        new Person("Charles", "Babbage", 1791, Geschlecht.MAENNLICH),
        new Person("Grace", "Hopper", 1906, Geschlecht.WEIBLICH),
        new Person("Konrad", "Zuse", 1910, Geschlecht.MAENNLICH),

        new Person("Alan", "Kay", 1940, Geschlecht.MAENNLICH),
        new Person("Alonzo", "Church", 1903, Geschlecht.MAENNLICH),
        new Person("Brian", "Kernighan", 1942, Geschlecht.MAENNLICH),
        new Person("Barbara", "Liskov", 1939, Geschlecht.WEIBLICH),
        new Person("John", "Baccus", 1924, Geschlecht.MAENNLICH),
        new Person("Kristen", "Nygaard", 1926, Geschlecht.MAENNLICH),
        new Person("Niklaus", "Wirth", 1934, Geschlecht.MAENNLICH),
        new Person("Ole-Johan", "Dahl", 1931, Geschlecht.MAENNLICH),

        new Person("Adele", "Goldberg", 1945, Geschlecht.WEIBLICH),
        new Person("Linus", "Torvalds", 1969, Geschlecht.MAENNLICH),
        new Person("Jade", "Raymond", 1975, Geschlecht.WEIBLICH),

        new Person("Alan", "Turing", 1912, Geschlecht.MAENNLICH),
        new Person("Claude", "Shannon", 1916, Geschlecht.MAENNLICH),
        new Person("George", "Boole", 1815, Geschlecht.MAENNLICH),
        new Person("Harry", "Nyquist", 1889, Geschlecht.MAENNLICH),
        new Person("John", "Neumann von", 1903, Geschlecht.MAENNLICH),
        new Person("Kurt", "Goedel", 1906, Geschlecht.MAENNLICH),

        new Person("Christiane", "Floyd", 1943, Geschlecht.WEIBLICH),
        new Person("Donald", "Knuth", 1938, Geschlecht.MAENNLICH),
        new Person("Edsger", "Dijkstra", 1930, Geschlecht.MAENNLICH),
        new Person("Radia", "Perlman", 1951, Geschlecht.WEIBLICH),
        new Person("Tony", "Hoare", 1934, Geschlecht.MAENNLICH)
    };

    private Person[] _menschenDerInformatik;
    
    /**
     * Schreibt die Menschen auf die Konsole, geordnet nach einem Kriterium.
     */
    public void schreibeGeordnet(Vergleicher vergleicher)
    {
        _menschenDerInformatik = _urspruenglicheReihenfolge.clone();
        insertionsort(vergleicher);
        System.out.println("========== " + vergleicher.getClass().toString().substring(6) + " ==========");
        for (Person p : _menschenDerInformatik)
        {
            System.out.println(p);
        }
        System.out.println();
    }

    /**
     * Insertionsort ist ein einfacher, aber nicht besonders effizienter Sortieralgorithmus.
     * Bitte verwendet in der Praxis Collections.sort, statt eigene Sortierroutinen zu schreiben!
     * Aber vielleicht interessiert ja den einen oder anderen Studierenden,
     * wie man ein Sortierverfahren von Hand programmieren koennte :)
     */
    private void insertionsort(Vergleicher vergleicher)
    {
        for (int i = 1; i < _menschenDerInformatik.length; ++i)
        {
            // Vorbedingung: Die Liste ist von 0 bis i-1 sortiert
            insert(i, vergleicher);
            // Nachbedingung: Die Liste ist von 0 bis i sortiert
        }
    }

    private void insert(int j, Vergleicher vergleicher)
    {
        Person einzufuegen = _menschenDerInformatik[j];
        while ((j > 0) && vergleicher.vergleiche(einzufuegen, _menschenDerInformatik[j - 1]) < 0)
        {
            _menschenDerInformatik[j] = _menschenDerInformatik[j - 1];
            --j;
        }
        _menschenDerInformatik[j] = einzufuegen;
    }
}
