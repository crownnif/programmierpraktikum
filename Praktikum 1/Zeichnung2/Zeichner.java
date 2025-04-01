
/**
 * Exemplare dieser Klasse zeichnen eine einfache Zeichnung.
 * Um die Zeichnung auf dem Bildschirm anzuzeigen, muss die
 * Methode zeichne an einem Exemplar aufgerufen werden.
 *
 * Diese Klasse ist als fruehes Java-Lehrbeispiel mit BlueJ gedacht.
 * 
 * @author  Axel Schmolitzky
 */
class Zeichner
{
 
    /**
     * Zeichne die Zeichnung.
     * @param mundFarbe
     *          Die Farbe, welche der Mund haben soll.
     */
    public void zeichneGesicht(String mundFarbe, int hBewegen, int vBewegen)
    {
        Kreis kopf;
        Quadrat mund; 
        Dreieck nase;
        Kreis auge1;
        Kreis auge2;

        kopf = zeichneKopf(65+hBewegen, 30+vBewegen, 250);
        
        mund = zeichneMund(mundFarbe, 35+hBewegen, 90+vBewegen, 35);

        nase = zeichneNase(60+hBewegen, 70+vBewegen, 30, 15);

        auge1 = zeichneAuge(110+hBewegen, -10+vBewegen, 15);
        
        auge2 = zeichneAuge(60+hBewegen, -5+vBewegen, 20);
    }
    
    public void zeichneGesichter()
    {
        zeichneGesicht("lila", 0, 0);
        zeichneGesicht("gruen", 500, 100);
        zeichneGesicht("rot", 250, 190);
    }
    
    /**
     * Zeichnet den Kopf.
     */
    private Kreis zeichneKopf(int hBewegen, int vBewegen, int groesse)
    {
        Kreis kopf = new Kreis();
        kopf.sichtbarMachen();
        kopf.farbeAendern("gelb");
        kopf.horizontalBewegen(hBewegen);
        kopf.vertikalBewegen(vBewegen);
        kopf.groesseAendern(groesse);
        return kopf;
    }
    
    private Quadrat zeichneMund(String mundFarbe, int hBewegen, int vBewegen, int groesse)
    {
        Quadrat mund = new Quadrat();
        mund.sichtbarMachen();
        mund.farbeAendern(mundFarbe);
        mund.horizontalBewegen(hBewegen);
        mund.vertikalBewegen(vBewegen);
        mund.groesseAendern(groesse);
        return mund;
    }
    
    private Dreieck zeichneNase(int hBewegen, int vBewegen, int hGroesse, int vGroesse)
    {
        Dreieck nase = new Dreieck();  
        nase.sichtbarMachen();
        nase.horizontalBewegen(hBewegen);
        nase.vertikalBewegen(vBewegen);
        nase.groesseAendern(hGroesse, vGroesse);
        return nase;
    }
    
    private Kreis zeichneAuge(int hBewegen, int vBewegen, int groesse)
    {
        Kreis auge = new Kreis();
        auge.sichtbarMachen();
        auge.farbeAendern("schwarz");
        auge.vertikalBewegen(vBewegen);
        auge.horizontalBewegen(hBewegen);
        auge.groesseAendern(groesse);
        return auge;
    }
}
