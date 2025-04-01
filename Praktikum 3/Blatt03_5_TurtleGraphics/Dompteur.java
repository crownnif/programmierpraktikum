 /**
 * Exemplare dieser Klasse veranlassen Turtles dazu,
 * Spuren auf einer Zeichenflaeche zu hinterlassen.
 *
 * @author Axel Schmolitzky
 * @version 2021
 * @author Tommy, Finn
 * @version 11.2021
 */
class Dompteur
{
    /**
     * 'PR1' auf die Zeichenflaeche zeichnen.
     */
    public void start()
    {
        Turtle turtle = new Turtle(50, 100);

        turtle.drehe(-90);
        turtle.geheVor(60);
        turtle.drehe(90);
        turtle.geheVor(30);
        turtle.drehe(90);
        turtle.geheVor(30);
        turtle.drehe(90);
        turtle.geheVor(30);
        turtle.drehe(180);
        
        // Ohne Spur zum naechsten Buchstaben bewegen:
        turtle.hinterlasseKeineSpur();
        turtle.geheZu(100, 100);

        // 'R' zeichnen:
        turtle.hinterlasseSpur();
        turtle.drehe(-90);
        turtle.geheVor(60);
        turtle.drehe(90);
        turtle.geheVor(30);
        turtle.drehe(90);
        turtle.geheVor(30);
        turtle.drehe(90);
        turtle.geheVor(30);
        turtle.drehe(180);
        turtle.hinterlasseKeineSpur();
        turtle.geheVor(15);
        turtle.hinterlasseSpur();
        turtle.drehe(60);
        turtle.geheVor(35);

        // Ohne Spur zum naechsten Buchstaben bewegen:
        turtle.hinterlasseKeineSpur();
        turtle.geheZu(170, 100);

        // '1' zeichnen:
        turtle.drehe(-60);
        turtle.hinterlasseSpur();
        turtle.setzeFarbe("rot");
        turtle.drehe(-90);
        turtle.geheVor(60);
        turtle.drehe(-120);
        turtle.geheVor(20);
    }
    
    /**
     * Die Methode zeichnet ein n-Eck.
     * 
     * @param ecken Die Anzahl der Ecken.
     * @param kantenlaenge  Die Länge der Kanten.
     */
    public void zeichneNEck(int ecken, int kantenlaenge)
    {
        zeichneNEck(ecken, kantenlaenge, 0, 50, 50, "schwarz");
    }
    
    /**
     * Die Methode zeichnet ein n-Eck.
     * 
     * @param ecken Die Anzahl der Ecken.
     * @param kantenlaenge  Die Länge der Kanten.
     * @param x Die x-Koordinate.
     * @param y Die y-Koordinate.
     * @param drehung   Der Drehungswinkel.
     * @param farbe Der Name der Farbe.
     */
    public void zeichneNEck(int ecken, int kantenlaenge, int x, int y, int drehung, String farbe)
    {
        Turtle turtle = new Turtle(x, y);
        double winkel = 360.0/ecken;
        turtle.drehe(drehung);
        
        for(int i=0; i<ecken; i++)
        {
            turtle.geheVor(kantenlaenge);
            turtle.drehe(winkel);
        }
    }
    
    /**
     * Die Methode zeichnet eine Rosette.
     * 
     * @param ecken Die Anzahl der Ecken.
     * @param kantenlaenge  Die Länge der Kanten.
     * @param winkel    Der Winkel zwischen den einzelnen n-Ecken.
     */
    public void zeichneRosette(int ecken, int kantenlaenge, int winkel)
    {
        for(int i=0; i<360; i+=winkel)
        {
            zeichneNEck(ecken, kantenlaenge, 200, 100, i, "schwarz");
        }
    }
    
    /**
     * Die Methode zeichnet eine standard Rosette.
     */
    public void zeichneRosette()
    {
        zeichneRosette(5,20,45);
    }
    
    public void zeichneKochKurve()
    {
        
    }
}
