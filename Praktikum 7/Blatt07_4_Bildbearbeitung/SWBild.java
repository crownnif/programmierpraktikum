 import static java.util.Objects.requireNonNull;

/**
 * SWBild ist eine Klasse, die Graustufenbilder repräsentiert und
 * manipuliert. Die Implementierung erfolgt durch ein einfaches
 * Bildformat: Die Bildpunkte werden in einem zweidimensionalen
 * Array von 'short'-Werten gehalten. Jeder Feldeintrag kann einen
 * Wert zwischen 0 und 255 annehmen. Andere Werte sind unzulässig.
 * Der Wertebereich [0..255] repräsentiert den Graustufenbereich:
 * 0 fuer Schwarz, 255 fuer Weiß und dazwischenliegende Werte für
 * die Grauabstufungen.
 * 
 * Beispielmethode 'dunkler': Ein geladenes Bild kann um
 * ein gegebenes 'delta' abgedunkelt werden.
 * 
 * @author  Axel Schmolitzky, Petra Becker-Pechau
 * @version 2021
 * 
 * @author Finn Kronjäger
 * @version 2022
 */
class SWBild
{
    
    // die Bilddaten dieses Bildes
    private short[][] _bilddaten;

    // die Breite dieses Bildes
    private int _breite;

    // die Höhe dieses Bildes
    private int _hoehe;

    // Leinwand zur Anzeige
    private Leinwand _leinwand;

    /**
     * Initialisiert ein Bild mit einer Bilddatei. Der Benutzer kann interaktiv mit
     * Hilfe eines Dateidialogs die zu ladende Datei auswählen.
     */
    public SWBild()
    {
        _bilddaten = BildEinleser.liesBilddaten();
        if (_bilddaten != null)
        {
            aktualisiereBildgroesse(_bilddaten);
            erzeugeLeinwand();
        }
    }
   
    /**
     * Initialisiert ein Bild mit einer Bilddatei. Der Dateiname kann als absoluter
     * oder relativer Pfad übergeben werden.
     * 
     * @param bilddateiName der Name der Bilddatei; darf nicht null sein
     */
    public SWBild(String bilddateiName)
    {
        requireNonNull(bilddateiName);
        _bilddaten = BildEinleser.liesBilddaten(bilddateiName);
        aktualisiereBildgroesse(_bilddaten);
        erzeugeLeinwand();
    }

    /**
     * Dieses Bild um einen Wert abdunkeln. 
     * 
     * @param delta
     *            Wert der Abdunkelung. Es wird mit dem Betrag von delta gerechnet, 
     *            deshalb darf der Parameter sowohl positiv als auch negativ sein.  
     */
    public void dunkler(int delta)
    {
        if (delta > 0)
        {
            delta = -delta;
        }

        helligkeitDelta(delta);
    }

    /**
     * Dieses Bild um einen Wert aufhellen.
     * 
     * @param delta
     *            Wert der Aufhellung. Es wird mit dem Betrag von delta gerechnet, 
     *            deshalb darf der Parameter sowohl positiv als auch negativ sein.  
     */
    public void heller(int delta)
    {
        if (delta < 0)
        {
            delta = -delta;
        }

        helligkeitDelta(delta);        
    }
    
    /**
     * Verändert den Helligkeitswert um delta.
     */
    private void helligkeitDelta(int delta)
    {
        /**
         * Durch alle Bytes des Bildes gehen und jeden Wert dekrementieren
         */
        for (int y = 0; y < _hoehe; y++)
        {
            for (int x = 0; x < _breite; x++)
            {
                if ((_bilddaten[y][x] + delta) < 1) // Wert darf 0 nicht unterschreiten
                {
                    _bilddaten[y][x] = 0;
                }
                else if((_bilddaten[y][x] + delta) > 254)
                {
                    _bilddaten[y][x] = 255;
                } else 
                {
                    _bilddaten[y][x] = (short) (_bilddaten[y][x] + delta);
                }
            }
        }
        // Neuzeichnen der Bildleinwand, basierend auf den Werten in _bilddaten:
        zeichneBild();
    }

    /**
     * Dieses Bild invertieren.
     */
    public void invertieren()
    {
        // Durch alle Bildpunkte des Bildes gehen und jeden Wert "invertieren"
        for (int y = 0; y < _hoehe; y++)
        {
            for (int x = 0; x < _breite; x++)
            {
                _bilddaten[y][x] = (short) (255 - _bilddaten[y][x]);
            }
        }
        zeichneBild();
    }

    /**
     * Dieses Bild horizontal spiegeln.
     */
    public void horizontalSpiegeln()
    {
        
        for (int y = 0; y < _hoehe/2; y++)
        {
            short[] streifen = _bilddaten[y];
            _bilddaten[y] = _bilddaten[_hoehe-y-1];
            _bilddaten[_hoehe-y-1] = streifen;
        }

        zeichneBild();
    }
    
    /**
     * Dieses Bild weichzeichnen.
     */
    public void weichzeichnen()
    {
        short[][] neueBilddaten = new short[_hoehe][_breite];
        
        for (int y = 0; y < _hoehe; y++)
        {
            for (int x = 0; x < _breite; x++)
            {         
                neueBilddaten[y][x] = punktDurchschnitt(y, x);
            }
        }
        
        _bilddaten = neueBilddaten;
        
        zeichneBild();
    }
    
    private short punktDurchschnitt(int y, int x)
    {
        short durchschnitt = 0;
        short teiler = 0;
        
        if(x > 0)
        {
            durchschnitt = (short) (durchschnitt + _bilddaten[y][x-1]);
            teiler++;
        }
        if(x < _breite -1)
        {
            durchschnitt = (short) (durchschnitt + _bilddaten[y][x+1]);
            teiler++;
        }
        
        if(y > 0)
        {
            durchschnitt = (short) (durchschnitt + _bilddaten[y-1][x]);
            teiler++;
            if(x > 0)
            {
                durchschnitt = (short) (durchschnitt + _bilddaten[y-1][x-1]);
                teiler++;
            }
            if(x < _breite -1)
            {
                durchschnitt = (short) (durchschnitt + _bilddaten[y-1][x+1]);
                teiler++;
            }
        }
        
        if(y < _hoehe -1)
        {
            durchschnitt = (short) (durchschnitt + _bilddaten[y+1][x]);
            teiler++;
            if(x > 0)
            {
                durchschnitt = (short) (durchschnitt + _bilddaten[y+1][x-1]);
                teiler++;
            }
            if(x < _breite -1)
            {
                durchschnitt = (short) (durchschnitt + _bilddaten[y+1][x+1]);
                teiler++;
            }
        }
                                         
        return (short) (durchschnitt/teiler);
    }

    /**
     * Dieses Bild am Mittelpunkt spiegeln.
     */
    public void punktSpiegeln()
    {
        short[][] neueBilddaten = new short[_hoehe][_breite];
        for (int y = 0; y < _hoehe; y++)
        {
            for (int x = 0; x < _breite; x++)
            {         
                neueBilddaten[y][x] = _bilddaten[_hoehe - y - 1][_breite - x - 1];
            }
        }
        
        _bilddaten = neueBilddaten;
        
        zeichneBild();
    }

    /**
     * Erzeuge bei diesem Bild einen Spot mit Radius r, Mittelpunkt x0,y0 und
     * Beleuchtungsintensität i. Außerhalb von r nimmt die Ausleuchtung linear ab.
     * Wie im wirklichen Leben...
     * 
     * @param xo
     *            x-Koordinate des Mittelpunktes
     * @param yo
     *            y-Koordinate des Mittelpunktes
     * @param r
     *            Radius
     * @param i
     *            Beleuchtungsintesitaet
     */
    public void spot(int x0, int y0, int r, short i)
    {
        // HIER FEHLT NOCH WAS
    }

    /**
     * Gib den Wert eines einzelnen Bildpunktes zurück.
     * 
     * @param y
     *            die y-Koordinate des Bildpunktes.
     * @param x
     *            die x-Koordinate des Bildpunktes.
     * @return den Wert des angegebenen Bildpunktes.
     */
    public short gibBildpunkt(int y, int x)
    {
        return _bilddaten[y][x];
    }

    // ==== private Hilfsmethoden ====

    /**
     * Zeichnet das Bild in _bilddaten neu
     */
    private void zeichneBild()
    {
        _leinwand.sichtbarMachen();
        _leinwand.zeichneBild(_bilddaten);
    }

    /**
     * Höhe und Breite neu berechnen, nachdem die Bilddaten verändert worden sind.
     */
    private void aktualisiereBildgroesse(short[][] bilddaten)
    {
        _hoehe = bilddaten.length;
        if (_hoehe == 0)
        {
            _breite = 0;
        }
        else
        {
            _breite = bilddaten[0].length;
        }
    }

    /**
     * Erzeuge die Leinwand zur Darstellung und zeige sie an.
     */
    private void erzeugeLeinwand()
    {
        _leinwand = new Leinwand("Bildbetrachter", _breite, _hoehe);

        zeichneBild();
    }
}
