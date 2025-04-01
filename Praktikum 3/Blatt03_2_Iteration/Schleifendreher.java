import java.util.Scanner;

/**
 * Halbwegs sinnvolle Beispiele fuer die Schleifenmechanismen von Java.
 * 
 * @author Fredrik Winkler, Axel Schmolitzky
 * @version 2021
 */
class Schleifendreher
{
    // Beispiele fuer for-Schleifen

    /**
     * Gibt die Ziffern 0 bis 9 mit dem Hinweis, dass es sich um Ziffern handelt,
     * auf der Konsole aus.
     */
    public void druckeAlleZiffern()
    {
        for (int i = 0; i < 10; ++i)
        {
            System.out.println(i + " ist eine Ziffer.");
        }
    }

    /**
     * Gibt die druckbaren Zeichen des ASCII-Zeichensatzes auf
     * der Konsole aus.
     */
    public void druckeDruckbareASCIIZeichen()
    {
        for (char c = 32; c < 127; ++c) 
        {
            int i = c;
            System.out.println(i + ". ASCII-Zeichen: " + c); 
        } 
    }
    
    /**
     * Gibt alle Ziffern, die durch drei teilbar sind, mit entsprechendem Hinweis
     * auf der Konsole aus.
     */
    public void druckeDreierZiffernRueckwaerts()
    {
        // Man kann bei beliebigen Werten anfangen
        // und beliebig grosse Schritte in beide Richtungen gehen.
        for (int i = 9; i >= 0; i -= 3)
        {
            System.out.println(i + " ist durch 3 teilbar.");
        }
    }

    /**
     * Gibt alle Paare nicht-negativer Zahlen, deren Summe 9 ergibt, auf der Konsole aus.
     * Die die Addition kommutativ ist, werden redundante Paare bewusst vermieden.
     */
    public void druckeNeunerSummen()
    {
        // Es koennen beliebig viele Schleifenzaehler verwendet werden,
        // zum Beispiel zwei "gegeneinander laufende" Zaehler,
        // die sich in der Mitte treffen (man beachte die Schleifenbedingung).
        for (int a = 0, b = 9; a < b; ++a, --b)
        {
            System.out.println( a + " + " + b + " = " + (a + b));
        }
    }

    /**
     * Gibt die Buchstaben einer Zeichenkette durch Kommata getrennt auf der Konsole aus.
     * 
     * @param text Enthealt den Text, der ausgegeben werden soll.
     */
    public void druckeEinzelneBuchstaben(String text)
    {
        for (int i = 0; i < text.length(); ++i)
        {
            System.out.print(text.charAt(i));
            System.out.print(", ");
        }
        System.out.println();
    }

    
    // Beispiel fuer while-Schleife

    /**
     * Liefert die kleinste Primzahl, welche groesser oder gleich x ist.
     * 
     * @param x Eine Zahl, von der aus mit der Suche begonnen werden soll.
     * 
     * @return die naechste gefundene Primzahl.
     */
    public int findeNaechstePrimzahl(int x)
    {
        while (!istPrimzahl(x))
        {
            ++x;
        }
        return x;
    }


    // Beispiel fuer do-while-Schleife

    /**
     * Fordert den Benutzer wiederholt zur Eingabe eines Passwortes auf,
     * bis er das korrekte Passwort eingegeben hat.
     */
    public void verlangePasswort()
    {
        String zeile;
        do
        {
            System.out.print("Passwort? ");
            zeile = liesZeileVomBenutzer();
        }
        while (!zeile.equals("\116\151\143\141\162\141\147\165\141"));
        
        // C-Hack: Zeichen hier kodiert ueber "octal escapes", siehe JLS §3.10.6
        // Wenn ihr die Zeichen sehen wollt: Zeichenkette in die Direkteingabe
        // von BlueJ kopieren und Enter druecken.

        System.out.println("Du darfst eintreten!");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Die folgenden privaten Hilfsmethoden muessen nicht verstanden werden.

    /**
     * Liest eine Zeile von der Konsole ein und liefert sie zurueck.
     * 
     * @return Ein auf de rKonsole eingegebene Textzeile.
     */
    private String liesZeileVomBenutzer()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    /**
     * Bestimmt, ob es sich bei der uebergebenen Zahl um eine Primzahl handelt.
     * Achtung, diese Loesung ist nicht besonders effizient
     * und sollte auf keinen Fall in Produktionscode verwendet werden!
     * 
     * @param x Eine Zahl, die untersucht werden soll
     * 
     * @return true, falls es sich um eine Primzahl handelt, andernfalls false.
     */
    private boolean istPrimzahl(int x)
    {
        int limit = (int) Math.sqrt(x);
        for (int i = 2; i <= limit; ++i)
        {
            if ((x % i) == 0)
            {
                return false;
            }
        }
        return true;
    }
}
