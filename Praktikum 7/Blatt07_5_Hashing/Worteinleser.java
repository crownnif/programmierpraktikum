import java.io.*;
import java.util.*;
import java.util.regex.*;

/**
 * Ein Worteinleser dient zum Einlesen von Wörtern aus einer Datei.
 * 
 * @author Fredrik Winkler, Petra Becker-Pechau, Axel Schmolitzky
 * @version 2021
 */
class Worteinleser
{
    private List<String> _text;

    /**
     * Liest einen Text aus einer Datei ein und liefert ihn als Liste von Wörtern zurück.
     */
    public static List<String> dateiAlsText(String dateiName)
    {
        return new Worteinleser().ausDatei(dateiName).fertig();
    }
    
    /**
     * Initialisiert einen neuen Wortleser.
     */
    private Worteinleser()
    {
        _text = new ArrayList<String>();
    }

    /**
     * Gibt den bisher eingelesenen Text als Liste zurück und setzt den Worteinleser zurück.
     * Die zurückgegebene Liste ist damit unabhängig vom internen Zustand des Worteinlesers.
     */
    private List<String> fertig()
    {
        List<String> result = _text;
        _text = new ArrayList<String>();
        return result;
    }
    
    /**
     * Liest eine Liste von Wörtern aus einer Textdatei ein.
     * 
     * @param dateiName der Dateiname der einzulesenden Textdatei
     * @return this
     */
    private Worteinleser ausDatei(String dateiName) 
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(dateiName)))
        {
            String zeile;
            while ((zeile = reader.readLine()) != null)
            {
                verarbeiteZeile(zeile);
            }
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        return this;
    }
    
    private static final Pattern pattern = Pattern.compile("[a-z]+");

    private void verarbeiteZeile(String zeile)
    {
        Matcher matcher = pattern.matcher(zeile.toLowerCase());
        while (matcher.find())
        {
            _text.add(matcher.group());
        }
    }

}
