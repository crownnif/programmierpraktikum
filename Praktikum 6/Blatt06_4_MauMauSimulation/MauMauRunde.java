import spielkarten.Skatspiel;
import spielkarten.Spielkarte;
import spielkarten.Kartenfarbe;
import spielkarten.Kartenrang;
import java.util.Map;
import java.util.HashMap;

/**
 * Eine Mau-Mau-Runde besteht hier aus drei Spielern und einem Skatspiel (32 Karten).
 * In einer Mau-Mau-Runde werden mehrere Spiele gespielt. <br>
 * In einem einzelnen Spiel wird bzw. werden nacheinander: <br>
 * - an jeden Spieler fuenf Karten verteilt; <br>
 * - von den restlichen Karten die oberste aufgedeckt; <br>
 * - von jedem Spieler reihum eine zur obersten Karte passende Karte abgelegt, 
 *   bis ein Spieler keine Karten mehr hat. <br>
 * Eine Karte "passt", wenn sie die gleiche Kartenfarbe oder den gleichen Kartenrang 
 * wie die oberste Karte hat.<br>
 * Hat ein Spieler keine passende Karte, wenn er an der Reihe ist, muss er eine weitere
 * Karte vom Kartenstapel ziehen.<br>
 * 
 * @author Axel Schmolitzky 
 * @version 2021
 */
class MauMauRunde
{
    private Spieler _spieler1;
    private Spieler _spieler2;
    private Spieler _spieler3;
    private Skatspiel _kartensatz;
    

    /**
     * Eine Mau-Mau-Runde besteht aus einem Skatspiel 
     * (32 Karten) und drei Spielern.
     * Anfangs haben alle Spieler noch keine Karten.
     */
    public MauMauRunde()
    {
        _kartensatz = new Skatspiel();
        Map<Kartenrang, Integer> kartenWertMap = Map.of(
            Kartenrang.SIEBEN, 3,
            Kartenrang.ACHT, 3,
            Kartenrang.NEUN, 3,
            Kartenrang.BUBE, 2,
            Kartenrang.KOENIG, 6,
            Kartenrang.DAME, 6,
            Kartenrang.ZEHN, 4,
            Kartenrang.AS, 11
        );
        
        _spieler1 = new Spieler("Spieler1", kartenWertMap);
        _spieler2 = new Spieler("Spieler2", kartenWertMap);
        _spieler3 = new Spieler("Spieler3", kartenWertMap);
    }

    public KartenTripel zieheDreiBilder()
    {
        Kartenstapel stapel = new Kartenstapel();
        Spielkarte k1 = zieheEinBild(stapel);
        Spielkarte k2 = zieheEinBild(stapel);
        Spielkarte k3 = zieheEinBild(stapel);
        KartenTripel tripel = new KartenTripel(k1,k2,k3);
        return tripel;
    }
    
    private Spielkarte zieheEinBild(Kartenstapel stapel)
    {
        Spielkarte karte = null;
        do
        {
            karte = stapel.obersteKarteZiehen();
        } while (!istBild(karte));
        return karte;
    }
    
    private boolean istBild(Spielkarte karte)
    {
        return karte.rang() == Kartenrang.KOENIG 
            || karte.rang() == Kartenrang.DAME 
            || karte.rang() == Kartenrang.BUBE;
    }

    /**
     * Karten verteilen: Jeder Spieler erhält fünf Karten.
     * Die restlichen Karten werden als Ergebnis geliefert.
     */
    public Kartenstapel kartenVerteilen()
    {
        Kartenstapel stapel = new Kartenstapel(_kartensatz);

        for (int i=0; i < 5; ++i)
        {
            _spieler1.nimmKarte(stapel.obersteKarteZiehen());
            _spieler2.nimmKarte(stapel.obersteKarteZiehen());
            _spieler3.nimmKarte(stapel.obersteKarteZiehen());
        }
        return stapel;
    }

    /**
     * Diese Methode simuliert ein Spiel in einer Mau-Mau-Runde.
     */
    public void spielenBisGewinnerErmittelt()
    {
        Kartenstapel kartenstapel = kartenVerteilen();
        Spielkarte obersteKarte = kartenstapel.obersteKarteZiehen();
        Kartenansicht ansicht = new Kartenansicht("oberste Karte");
        ansicht.zeige(obersteKarte);
        while (jederSpielerHatNochMindestensEineKarte())
        {
            obersteKarte = eineRundeSpielen(ansicht, obersteKarte,kartenstapel);
        }
        Spieler gewinner = gewinnerErmitteln();
        Spieler verlierer = verliererErmitteln();
        kartenEinsammeln();
        System.out.println("Gewinner: " + gewinner + "\nVerlierer: " + verlierer);
    }

    /**
     * Jeder Spieler bekommt Gelegenheit, eine Karte abzulegen, es sei denn,
     * ein Spieler legt seine letzte Karte ab. Liefert als Ergebnis die
     * zuletzt abgelegte Spielkarte. Wenn ein Spieler nicht bedienen kann,
     * muss er eine frische Karte vom Stapel ziehen.
     * @param ablage die Kartenansicht, die die zuletzt abgelegte Karte zeigt.
     * @param obersteKarte die zuletzt abgelegte Karte.
     * @param stapel der Stapel mit den "frischen" Karten, falls ein Spieler
     *               nicht bedienen kann.
     */
    public Spielkarte eineRundeSpielen(Kartenansicht ablage,
                                       Spielkarte obersteKarte, 
                                       Kartenstapel stapel)
    {
        obersteKarte = obersteKarteDurch(_spieler1,ablage,obersteKarte,stapel);
        if (_spieler1.anzahlKarten() == 0)
        {
            return obersteKarte;  // Ausstieg, Spiel zuende
        }
        obersteKarte = obersteKarteDurch(_spieler2,ablage,obersteKarte,stapel);
        if (_spieler2.anzahlKarten() == 0)
        {
            return obersteKarte; // Ausstieg, Spiel zuende
        }
        return obersteKarteDurch(_spieler3,ablage,obersteKarte,stapel);
    }

    private Spielkarte obersteKarteDurch(Spieler spieler, Kartenansicht ansicht,
                                         Spielkarte oberste, Kartenstapel stapel)
    {
        Spielkarte neueOberste = spieler.bediene(oberste);
        if (neueOberste != oberste) // Spieler konnte bedienen
        {
            ansicht.zeige(neueOberste);
        }
        else // Spieler konnte nicht bedienen, Karte ziehen
        {
            spieler.nimmKarte(stapel.obersteKarteZiehen());
        }
        return neueOberste;
    }

    private boolean jederSpielerHatNochMindestensEineKarte()
    { 
        return _spieler1.anzahlKarten() > 0
        && _spieler2.anzahlKarten() > 0
        && _spieler3.anzahlKarten() > 0;
    }

    /**
     * Liefert während eines Spiels den Spieler, der als erster 
     * keine Karten mehr hat.
     */
    private Spieler gewinnerErmitteln()
    {
        if (_spieler1.anzahlKarten() == 0)
        {
            return _spieler1;
        }
        else if (_spieler2.anzahlKarten() == 0)
        {
            return _spieler2;
        }
        else if (_spieler3.anzahlKarten() == 0)
        {
            return _spieler3;
        }
        else
        {
            return null;
        }
    }
    
    /**
     * Liefert am Ende des Spiels den Verlierer.
     */
    private Spieler verliererErmitteln()
    {
        Spieler spieler = _spieler1;
        
        if (_spieler2.zaehlePunkte() >= spieler.zaehlePunkte())
        {
            spieler = _spieler2;
        }
        else if (_spieler3.zaehlePunkte() >= spieler.zaehlePunkte())
        {
            spieler = _spieler3;
        }
        
        return spieler;
    }

    /**
     * Alle Karten einsammeln, damit neu verteilt werden kann.
     */
    public void kartenEinsammeln()
    {
        _spieler1.gibAlleKartenAb();
        _spieler2.gibAlleKartenAb();
        _spieler3.gibAlleKartenAb();
    }

    /**
     * Liefert Spieler 1 dieser Runde.
     */
    public Spieler spieler1()
    {
        return _spieler1;
    }

    /**
     * Liefert Spieler 2 dieser Runde.
     */
    public Spieler spieler2()
    {
        return _spieler2;
    }

    /**
     * Liefert Spieler 3 dieser Runde.
     */
    public Spieler spieler3()
    {
        return _spieler3;
    }

}
