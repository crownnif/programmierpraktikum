
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
     */
    public void zeichne()
    {
        Kreis kopf;
        Quadrat mund; 
        Dreieck nase;
        Kreis auge1;
        Kreis auge2;

        kopf = new Kreis();
        kopf.sichtbarMachen();
        kopf.farbeAendern("gelb");
        kopf.vertikalBewegen(30);
        kopf.horizontalBewegen(65);
        kopf.groesseAendern(300);
        
        mund = new Quadrat();
        mund.sichtbarMachen();
        mund.farbeAendern("lila");
        mund.vertikalBewegen(90);
        mund.horizontalBewegen(35);
        mund.groesseAendern(35);

        nase = new Dreieck();  
        nase.sichtbarMachen();
        nase.groesseAendern(30, 15);
        nase.horizontalBewegen(60);
        nase.vertikalBewegen(70);

        auge1 = new Kreis();
        auge1.sichtbarMachen();
        auge1.farbeAendern("schwarz");
        auge1.horizontalBewegen(110);
        auge1.vertikalBewegen(-10);
        auge1.groesseAendern(15);
        
        auge2 = new Kreis();
        auge2.sichtbarMachen();
        auge2.farbeAendern("schwarz");
        auge2.horizontalBewegen(60);
        auge2.vertikalBewegen(-5);
        auge2.groesseAendern(20);
    }
}
