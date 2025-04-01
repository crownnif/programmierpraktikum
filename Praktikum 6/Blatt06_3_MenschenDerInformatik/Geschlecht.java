
/**
 * Ein Aufzählungstyp für das Geschlecht einer Person.
 * 
 * @author  Axel Schmolitzky
 * @version 2021
 */
enum Geschlecht
{
    WEIBLICH, DIVERS, MAENNLICH;
    
    public String toString()
    {
        String result = "";
        switch(this)
        {
            case WEIBLICH:   result = "weiblich"; break;
            case DIVERS:     result = "divers";   break;
            case MAENNLICH : result = "männlich";
        }
        return result;
    }
}
