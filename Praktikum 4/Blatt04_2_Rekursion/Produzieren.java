/**
 * In dieser Klasse sind rekursive Algorithmen umzusetzen.
 * 
 * @author Fredrik Winkler, Axel Schmolitzky
 * @version 2021
 */
class Produzieren
{
    /**
    * Liefert die Fakultaet von n, also das Produkt aller natuerlichen Zahlen bis n.
    * Die Fakultaet von 0 ist per mathematischer Definition 1.
    *
    * Beispielauswertung:
    * 
    *   fak(4)
    * -> 4 * fak(3)
    * -> 4 * (3 * fak(2))
    * -> 4 * (3 * (2 * fak(1)))
    * -> 4 * (3 * (2 * (1 * fak(0))))
    * -> 4 * (3 * (2 * (1 * 1)))
    * -> 4 * (3 * (2 * 1))
    * -> 4 * (3 * 2)
    * -> 4 * 6
    * -> 24
    */
    public int fak(int n)
    {
        return 0;
    }
    
    /**
     * Berechnet n modulo m, also den Rest der ganzzahligen Division n/m.
     * 
     * modulo(14,3) -> modulo(11,3) -> modulo(8,3) -> modulo(5,3) -> modulo(2,3) -> 2
     * 
     * @param n ein beliebiger Wert >= 0
     * @param m ein beliebiger Wert > 0
     */
    public int modulo(int n, int m)
    {
        if(n>m)
        {
             return modulo(n-m, m);
        }
        else
        {
            return n;
        }
    }
    
    /**
    * Gibt an, ob die Zeichenkette einen Vokal enthaelt. Auswertungen:
    * 
    * enthaeltVokal("brei") -> enthaeltVokal("rei") -> enthaeltVokal("ei") -> true
    * enthaeltVokal("xyz") -> enthaeltVokal("yz") -> enthaeltVokal("z") -> enthaeltVokal("") -> false
    * @param s ein beliebiger String ungleich null
    */
    public boolean enthaeltVokal(String s)
    {
        if(s.length() == 0)
        {
            return false;
        }
        else if (istVokal(s.charAt(0)))
        {
            return true;
        }
        else
        {
            return enthaeltVokal(s.substring(1));
        }
    }
    
    /**
    * Gibt an, ob die Zeichenkette ein Palindrom ist. Auswertungen:
    * 
    * istPalindrom("anna") -> istPalindrom("nn") -> istPalindrom("") -> true
    * istPalindrom("asta") -> istPalindrom("st") -> false
    * istPalindrom("axa") -> istPalindrom("x") -> true
    * istPalindrom("xyz") -> false
    * @param s ein beliebiger String ungleich null
    */
    public boolean istPalindrom(String s)
    {
        if(s.length() <2)
        {
            return true;
        }
        else if(s.charAt(0)==s.charAt(s.length()-1))
        {
            return istPalindrom(s.substring(1,s.length()-1));
        }
        else
        {
            return false;
        }
    }
    
    /**
    * Berechnet die Anzahl Leerzeichen in der Zeichenketten. Auswertung:
    * 
    * anzahlLeerzeichen("a bc d")
    * -> 0 + anzahlLeerzeichen(" bc d")
    * -> 0 + (1 + anzahlLeerzeichen("bc d"))
    * -> 0 + (1 + (0 + anzahlLeerzeichen("c d")))
    * -> 0 + (1 + (0 + (0 + anzahlLeerzeichen(" d"))))
    * -> 0 + (1 + (0 + (0 + (1 + anzahlLeerzeichen("d")))))
    * -> 0 + (1 + (0 + (0 + (1 + (0 + anzahlLeerzeichen(""))))))
    * -> 0 + (1 + (0 + (0 + (1 + (0 + 0)))))
    * -> 0 + (1 + (0 + (0 + (1 + 0))))
    * -> 0 + (1 + (0 + (0 + 1)))
    * -> 0 + (1 + (0 + 1))
    * -> 0 + (1 + 1)
    * -> 0 + 2
    * -> 2
    * @param s ein beliebiger String ungleich null
    */
    public int anzahlLeerzeichen(String s)
    {
        return anzahlLeerzeichenHelper(s,0);
    }
    
    private int anzahlLeerzeichenHelper(String s, int counter)
    {
        if(s.length()==0)
        {
            return counter;
        } else
        {
            if(s.charAt(0) == ' ')
            {
                counter++;
            }
            return anzahlLeerzeichenHelper(s.substring(1),counter);
        }
    }
    
    /**
    * Liefert die umgedrehte Zeichenkette. Auswertung:
    * 
    *   umgedreht("regal")
    * -> umgedreht("egal") + 'r'
    * -> (umgedreht("gal") + 'e') + 'r'
    * -> ((umgedreht("al") + 'g') + 'e') + 'r'
    * -> (((umgedreht("l") + 'a') + 'g') + 'e') + 'r'
    * -> (((          "l"  + 'a') + 'g') + 'e') + 'r'
    * -> ((           "la"        + 'g') + 'e') + 'r'
    * -> (            "lag"              + 'e') + 'r'
    * ->              "lage"                    + 'r'
    * ->              "lager"
    * @param s ein beliebiger String ungleich null
    */
    public String umgedreht(String s)
    {
        return "Loetzinn";
    }
    
    private boolean istVokal(char c)
    {
        char ch = Character.toLowerCase(c);
        switch(ch)
        {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
    
    /**
     * Hier finden die Aufrufe statt, die in den Diagrammen
     * auf dem Aufgabenblatt veranschaulicht werden (sollen).
     */
    public void testeAlleMethoden()
    {
        testeMethode(modulo(14,3), 2, "Modulo");
        testeMethode(enthaeltVokal("lllllllraall"), true, "Vokal Ja");
        testeMethode(enthaeltVokal("lllllllrll"), false, "Vokal Nein");
        testeMethode(istPalindrom("AnnA"), true, "Pali Ja");
        testeMethode(istPalindrom("AninA"), true, "Pali Ja");
        testeMethode(istPalindrom("AnkA"), false, "Pali Nein");
        testeMethode(anzahlLeerzeichen("An nA"), 1, "Leerzeichen");
    }
    
    private boolean testeMethode(Object o, Object expectedO, String testname)
    {
        if(o.equals(expectedO))
        {
            System.out.println(testname+ " test succeeded. :)");
            return true;
        }
        else
        {
            System.out.println(testname+ " test failed. >:(");
            return false;
        }
    }
}
