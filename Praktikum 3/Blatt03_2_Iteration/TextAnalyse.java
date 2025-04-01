/**
 * Diese Klasse bietet die Möglichkeit, Texte zu analysieren.
 * Sie dient als Einstieg in Schleifenkonstrukte und zeigt in
 * der Methode istFrage beispielhaft einige Methodenaufrufe an
 * einem Objekt der Klasse String.
 * 
 * @author Fredrik Winkler, Joerg Rathlev, Petra Becker-Pechau
 * @version 2021
 */
class TextAnalyse
{
    /**
     * Ermittelt, ob es sich bei dem übergebenen Text um eine Frage
     * handelt. Eine Frage erkennt man am abschließenden Fragezeichen.
     * 
     * @param text der zu analysierende Text
     * @return true, wenn es sich um eine Frage handelt, false sonst
     */
    public boolean istFrage(String text)
    {
        if(text.length() > 0)
        {
            int anzahlZeichen = text.length();

            int letztePosition = anzahlZeichen - 1;

            char letztesZeichen = text.charAt(letztePosition);

            boolean endetAufFragezeichen = (letztesZeichen == '?');

            return endetAufFragezeichen;
        } else
        {
            return false;
        }
    }

    /**
     * Ermittelt, ob es sich bei dem übergebenen Text um eine Frage
     * handelt. Eine Frage erkennt man am abschließenden Fragezeichen.
     * 
     * @param text der zu analysierende Text
     * @return true, wenn es sich um eine Frage handelt, false sonst
     */
    public boolean istFrageKompakt(String text)
    {
        return text.charAt(text.length() - 1) == '?';
    }
    
    public int zaehleVokale(String text)
    {
        int anzahl = 0;
        for(int i=0; i<text.length(); i++)
        {
            switch(text.charAt(i)){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    ++anzahl;
                    break;
                default:
                    break;
            }
        }
        return anzahl;
    }
    
    public boolean istPalindrom(String input)
    {
        String text = input.toLowerCase();
        for(int i=0, j=text.length()-1; i<=j; i++, j--)
        {
            if(!(text.charAt(i) == text.charAt(j)))
            {
                return false;
            }
        }
        return true;
    }
}
