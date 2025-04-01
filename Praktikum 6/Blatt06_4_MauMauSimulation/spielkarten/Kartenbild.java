package spielkarten;

import static spielkarten.Kartenfarbe.*;
import static spielkarten.Kartenrang.*;

/**
 * Die möglichen Kartenbilder eines Kartenspiels als Aufzählung.
 * Ein Kartenbild setzt sich zusammen aus einer Kartenfarbe und einem
 * Kartenrang.<br>
 * Da es im Unicode-Zeichensatz auch Zeichen für Kartenbilder gibt,
 * kennt jedes Kartenbild zusätzlich seinen passenden Codepunkt.<br><br>
 * Beispiel: Das Pik-As (engl.: Ace of Spades) hat den (hexadezimal
 * dargestellten) Codepunkt 1f0a1.<br><br>
 * Dieses Zeichen kann auch direkt hier in HTML dargestellt werden: &#x1f0a1;,
 * etwas vergrößert: <font size="+7">&#x1f0a1;</font>
 * 
 * @author Axel Schmolitzky 
 * @version 2021
 */ 
public enum Kartenbild
{
    /** Herz Zwei <font size="+7">&#x1f0b2</font> */ H2(HERZ, ZWEI, 0x1f0b2), 
    /** Herz Drei <font size="+7">&#x1f0b3</font> */ H3(HERZ, DREI, 0x1f0b3),
    /** Herz Vier <font size="+7">&#x1f0b4</font> */ H4(HERZ, VIER, 0x1f0b4),
    /** Herz Fuenf <font size="+7">&#x1f0b5</font> */ H5(HERZ, FUENF, 0x1f0b5),
    /** Herz Sechs <font size="+7">&#x1f0b6</font> */ H6(HERZ, SECHS, 0x1f0b6),
    /** Herz Sieben <font size="+7">&#x1f0b7</font> */ H7(HERZ, SIEBEN, 0x1f0b7),
    /** Herz Acht <font size="+7">&#x1f0b8</font> */ H8(HERZ, ACHT, 0x1f0b8),
    /** Herz Neun <font size="+7">&#x1f0b9</font> */ H9(HERZ, NEUN, 0x1f0b9),
    /** Herz Zehn <font size="+7">&#x1f0ba</font> */ H10(HERZ, ZEHN, 0x1f0ba),
    /** Herz Bube <font size="+7">&#x1f0bb</font> */ HB(HERZ, BUBE, 0x1f0bb),
    /** Herz Dame <font size="+7">&#x1f0bd</font> */ HD(HERZ, DAME, 0x1f0bd),
    /** Herz Koenig <font size="+7">&#x1f0be</font> */ HK(HERZ, KOENIG, 0x1f0be),
    /** Herz As <font size="+7">&#x1f0b1</font> */ HA(HERZ, AS, 0x1f0b1),

    /** Karo Zwei <font size="+7">&#x1f0c2</font> */ KA2(KARO, ZWEI, 0x1f0c2),
    /** Karo Drei <font size="+7">&#x1f0c3</font> */ KA3(KARO, DREI, 0x1f0c3),
    /** Karo Vier <font size="+7">&#x1f0c4</font> */ KA4(KARO, VIER, 0x1f0c4),
    /** Karo Fuenf <font size="+7">&#x1f0c5</font> */ KA5(KARO, FUENF, 0x1f0c5),
    /** Karo Sechs <font size="+7">&#x1f0c6</font> */ KA6(KARO, SECHS, 0x1f0c6),
    /** Karo Sieben <font size="+7">&#x1f0c7</font> */ KA7(KARO, SIEBEN, 0x1f0c7),
    /** Karo Acht <font size="+7">&#x1f0c8</font> */ KA8(KARO, ACHT, 0x1f0c8),
    /** Karo Neun <font size="+7">&#x1f0c9</font> */ KA9(KARO, NEUN, 0x1f0c9),
    /** Karo Zehn <font size="+7">&#x1f0ca</font> */ KA10(KARO, ZEHN, 0x1f0ca),
    /** Karo Bube <font size="+7">&#x1f0cb</font> */ KAB(KARO, BUBE, 0x1f0cb),
    /** Karo Dame <font size="+7">&#x1f0cd</font> */ KAD(KARO, DAME, 0x1f0cd),
    /** Karo Koenig <font size="+7">&#x1f0ce</font> */ KAK(KARO, KOENIG, 0x1f0ce),
    /** Karo As <font size="+7">&#x1f0c1</font> */ KAA(KARO, AS, 0x1f0c1),


    /** Pik Zwei <font size="+7">&#x1f0a2</font> */ P2(PIK, ZWEI, 0x1f0a2),
    /** Pik Drei <font size="+7">&#x1f0a3</font> */ P3(PIK, DREI, 0x1f0a3),
    /** Pik Vier <font size="+7">&#x1f0a4</font> */ P4(PIK, VIER, 0x1f0a4),
    /** Pik Fuenf <font size="+7">&#x1f0a5</font> */ P5(PIK, FUENF, 0x1f0a5),
    /** Pik Sechs <font size="+7">&#x1f0a6</font> */ P6(PIK, SECHS, 0x1f0a6),
    /** Pik Sieben <font size="+7">&#x1f0a7</font> */ P7(PIK, SIEBEN, 0x1f0a7),
    /** Pik Acht <font size="+7">&#x1f0a8</font> */ P8(PIK, ACHT, 0x1f0a8),
    /** Pik Neun <font size="+7">&#x1f0a9</font> */ P9(PIK, NEUN, 0x1f0a9),
    /** Pik Zehn <font size="+7">&#x1f0aa</font> */ P10(PIK, ZEHN, 0x1f0aa),
    /** Pik Bube <font size="+7">&#x1f0ab</font> */ PB(PIK, BUBE, 0x1f0ab),
    /** Pik Dame <font size="+7">&#x1f0ad</font> */ PD(PIK, DAME, 0x1f0ad),
    /** Pik Koenig <font size="+7">&#x1f0ae</font> */ PK(PIK, KOENIG, 0x1f0ae),
    /** Pik As <font size="+7">&#x1f0a1</font> */ PA(PIK, AS, 0x1f0a1),

    /** Kreuz Zwei <font size="+7">&#x1f0d2</font> */ KR2(KREUZ, ZWEI, 0x1f0d2),
    /** Kreuz Drei <font size="+7">&#x1f0d3</font> */ KR3(KREUZ, DREI, 0x1f0d3),
    /** Kreuz Vier <font size="+7">&#x1f0d4</font> */ KR4(KREUZ, VIER, 0x1f0d4),
    /** Kreuz Fuenf <font size="+7">&#x1f0d5</font> */ KR5(KREUZ, FUENF, 0x1f0d5),
    /** Kreuz Sechs <font size="+7">&#x1f0d6</font> */ KR6(KREUZ, SECHS, 0x1f0d6),
    /** Kreuz Sieben <font size="+7">&#x1f0d7</font> */ KR7(KREUZ, SIEBEN, 0x1f0d7),
    /** Kreuz Acht <font size="+7">&#x1f0d8</font> */ KR8(KREUZ, ACHT, 0x1f0d8),
    /** Kreuz Neun <font size="+7">&#x1f0d9</font> */ KR9(KREUZ, NEUN, 0x1f0d9),
    /** Kreuz Zehn <font size="+7">&#x1f0da</font> */ KR10(KREUZ, ZEHN, 0x1f0da),
    /** Kreuz Bube <font size="+7">&#x1f0db</font> */ KRB(KREUZ, BUBE, 0x1f0db),
    /** Kreuz Dame <font size="+7">&#x1f0dd</font> */ KRD(KREUZ, DAME, 0x1f0dd),
    /** Kreuz Koenig <font size="+7">&#x1f0de</font> */ KRK(KREUZ, KOENIG, 0x1f0de),
    /** Kreuz As <font size="+7">&#x1f0d1</font> */ KRA(KREUZ, AS, 0x1f0d1);
    
    private Kartenfarbe _farbe;
    private Kartenrang _rang;
    private int _codepoint;
    
    private Kartenbild(Kartenfarbe farbe, Kartenrang rang, int codepoint)
    {
        _farbe = farbe;
        _rang = rang;
        _codepoint = codepoint;
    }
    
    public Kartenfarbe farbe()
    {
        return _farbe;
    }
    
    public Kartenrang rang()
    {
        return _rang;
    }
    
    /**
     * Liefert den Codepoint des passenden Zeichens im Unicode-Zeichensatz.
     */
    public int codepoint()
    {
        return _codepoint;
    }

    public String toString()
    {
        return "" + _farbe + "-" + _rang;
    }
        
}
