
/**
 * Beschreiben Sie hier die Klasse Ratemaschine.
 * 
 * @author Finn Kronnjäger, Tom Hert
 * @version v0.1-abgabe
 */
public class Ratemaschine
{
    private int _zahl;
    private int _rateversuche;
    
    public Ratemaschine(int ratezahl)
    {
        _zahl = ratezahl;
        _rateversuche = 0;
    }

    /**
     * Errate die Zahl
     * 
     * @param zahl
     *      Die Zahl, die man denkt, wäre es
     * @return String -> Stimmt, Größer, Kleiner     
     */
    public String istEsDieseZahl(int zahl)
    {
        String bewertung;
        
        _rateversuche += 1;
        
        if (zahl == _zahl)
        {
            bewertung = "Stimmt! Und das nach nur " + _rateversuche + " Versuchen! ";
            
            switch (_rateversuche)
            {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5: 
                    bewertung += "Das war doch nur Glück!";
                    break;
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    bewertung += "Gar nicht mal so gut!";
                    break;
                default:
                    bewertung += "Vielleicht ist ein anderes Hobby besser!";
            }
            return bewertung;
        }
        else if (zahl < _zahl)
        {
            return "Zu niedrig geraten!";
        }
        else
        {
            return "Zu hoch getippt!";
        }
    }
}
