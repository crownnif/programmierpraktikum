
import javafx.stage.Stage;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.*;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

/**
 * Diese Klasse ŸberprŸft, ob ein Exemplar der Klasse Osterauskunft die
 * richtigen Werte liefert. Das Ergebnis der PrŸfung wird grafisch geliefert,
 * indem fŸr jeden falsch gelieferten Wert ein Button angezeigt wird.
 * 
 * @author Fredrik Winkler, Axel Schmolitzky
 * @version 2021
 */
class Osterpruefer 
{
    private Stage _stage;

    /**
     * Initialisiert eine Osterpruefer-UI mit Buttons fŸr alle falsch gelieferten Ostertage.
     */
    public Osterpruefer()
    {
        new JFXPanel();
        Platform.setImplicitExit(false);
        Platform.runLater( () -> {
                _stage = new Stage();
                TilePane fehleranzeige = initialisiere(_stage);

                final Osterauskunft auskunft = new Osterauskunft();

                boolean allesKorrekt = beantwortetAllesKorrekt(auskunft,fehleranzeige);

                if (allesKorrekt)
                {
                    ersetzeFehleranzeigeDurchGlueckwunsch(_stage);
                }

                _stage.setOnCloseRequest(e -> System.exit(0));
                _stage.setAlwaysOnTop(true);
                _stage.show();
                _stage.setAlwaysOnTop(false);
            });
    }

    private void ersetzeFehleranzeigeDurchGlueckwunsch(Stage stage)
    {
        Label label = new Label(GLUECKWUNSCH);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setFont(new Font("Arial",20));
        label.setTextFill(Color.GREEN);
        label.setPadding(new Insets(5,5,5,5));
        Scene scene = new Scene(label);
        stage.setScene(scene);
    }

    // Ueberprueft, ob der Parameter "ostern" alle Werte korrekt liefert.
    // Fuer jeden Fehler wird in den Parameter "fehler" ein Button eingefuegt.
    private boolean beantwortetAllesKorrekt(Osterauskunft ostern, TilePane fehler)
    {
        boolean korrekt = true;
        final Font font = new Font("Arial", 12);

        int jahr = 1800;
        for (int erwartet: ERWARTET)
        {
            final int tag = ostern.wannIstOsternImJahr(jahr);
            if (tag != erwartet)
            {
                korrekt = false;
                final int art = (tag == -erwartet) ? 1
                    : gueltigesDatum(tag) ? ((tag == 26 && erwartet == 19) ? 2
                            : (tag == 25 && erwartet == 18) ? 3 : 4)
                    : 0;

                final Button button = new Button(datum(tag, jahr));
                button.setFont(font);
                button.setMaxWidth(Double.MAX_VALUE);
                button.setTextFill(fehlerFarbe[art]);
                button.setTooltip(new Tooltip(fehlerKurz[art]));
                button.setOnAction(new ButtonHandler(fehlerKurz[art],
                        String.format(fehlerLang[art], datum(erwartet, jahr),
                            datum(tag, jahr))));
                fehler.getChildren().add(button);
            }
            ++jahr;
        }
        return korrekt;
    }

    /**
     * Initialisiert die Stage und liefert den TilePane, der die
     * weiteren Nodes aufnimmt.
     */
    private TilePane initialisiere(Stage stage)
    {
        stage.setTitle("Osterpruefer");
        stage.setMaxHeight(480);
        TilePane root = new TilePane(Orientation.HORIZONTAL);
        root.setAlignment(Pos.CENTER);
        root.setPrefColumns(4);
        root.setPrefWidth(440);
        ScrollPane scroller = new ScrollPane();
        scroller.setContent(root);
        scroller.setFitToWidth(true);
        Scene scene = new Scene(scroller);
        stage.setScene(scene);
        return root;
    }

    /**
     * Eine innere Klasse zur Implementierung eines ActionListeners,
     * die bei einem Aktivierung ein Meldungsfenster ausgibt.
     */
    private class ButtonHandler implements EventHandler<ActionEvent>
    {
        private final String _kurz, _lang;

        /**
         * Initialisiert einen ButtonHandler mit einer Kurz- und einer Lang-Meldung
         * @param kurz Eine kurze Meldung
         * @param lang Eine lange Meldung
         */
        public ButtonHandler(String kurz, String lang)
        {
            _kurz = kurz;
            _lang = lang;
        }

        /**
         * Gibt einen Dialog mit der Kurz- und der Lang-Meldung aus.
         */
        public void handle(ActionEvent e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(_kurz);
            alert.setHeaderText(_lang);
            _stage.setAlwaysOnTop(false);
            alert.showAndWait();
            _stage.setAlwaysOnTop(true);
        }
    }

    /**
     * Prueft ob ein Tag ein gueltiger Tag ist.
     * @param tag Ein zu ueberpruefender Tag.
     */
    private boolean gueltigesDatum(int tag)
    {
        return tag >= -31 && tag != 0 && tag <= 30;
    }

    /**
     * Gibt fuer ein Tag und ein Jahr einen passende Stringrepraesentation zurueck.
     * @param tag Ein Tag
     * @param jahr Ein Jahr
     * @return eine Stringrepraesentation von Tag und Jahr.
     */
    private String datum(int tag, int jahr)
    {
        final boolean april = tag >= 0;
        return String.format("%02d. %s %d", april ? tag : -tag, april ? "April"
            : "Maerz", jahr);
    }

    /**
     * Abschnitt mit Klassenkonstanten.
     */

    private static final Color[] fehlerFarbe = { Color.RED, Color.ORANGE,
            Color.BLUE, Color.MAGENTA, Color.BLACK };

    private static final String[] fehlerKurz = { "ungueltiges Datum",
            "Vorzeichenfehler", "Sonderregel 26./19. April",
            "Sonderregel 25./18. April", "falsches Datum" };

    private static final String[] fehlerLang = {
            "Das Datum %2$s existiert nicht.",
            "Der Tag stimmt, aber der Monat ist falsch.",
            "Anstelle des 26. Aprils ist immer der 19. April zu setzen!",
            "Anstelle des 25. Aprils ist hier der 18. April zu setzen!",
            "Das korrekte Datum ist der %1$s." };

    private static final int[] ERWARTET = { 13, 5, 18, 10, 1, 14, 6, -29, 17,
            2, 22, 14, -29, 18, 10, -26, 14, 6, -22, 11, 2, 22, 7, -30, 18, 3,
            -26, 15, 6, 19, 11, 3, 22, 7, -30, 19, 3, -26, 15, -31, 19, 11,
            -27, 16, 7, -23, 12, 4, 23, 8, -31, 20, 11, -27, 16, 8, -23, 12, 4,
            24, 8, -31, 20, 5, -27, 16, 1, 21, 12, -28, 17, 9, -31, 13, 5, -28,
            16, 1, 21, 13, -28, 17, 9, -25, 13, 5, 25, 10, 1, 21, 6, -29, 17,
            2, -25, 14, 5, 18, 10, 2, 15, 7, -30, 12, 3, 23, 15, -31, 19, 11,
            -27, 16, 7, -23, 12, 4, 23, 8, -31, 20, 4, -27, 16, 1, 20, 12, 4,
            17, 8, -31, 20, 5, -27, 16, 1, 21, 12, -28, 17, 9, -24, 13, 5, 25,
            9, 1, 21, 6, -28, 17, 9, -25, 13, 5, 18, 10, 1, 21, 6, -29, 17, 2,
            22, 14, -29, 18, 10, -26, 14, 6, -29, 11, 2, 22, 14, -30, 18, 10,
            -26, 15, 6, 19, 11, 3, 22, 7, -30, 19, 3, -26, 15, -31, 19, 11, 3,
            16, 7, -30, 12, 4, 23, 15, -31, 20, 11, -27, 16, 8, -23, 12, 4, 24,
            8, -31, 20, 5, -27, 16, 1, 21, 12, 4, 17, 9, -31, 20, 5, -28, 16,
            1, 21, 13, -28, 17, 9, -25, 13, 5, 25, 10, 1, 21, 6, -29, 17, 9,
            -25, 14, 5, 18, 10, 2, 21, 6, -29, 18, 2, 22, 14, -30, 18, 10, -26,
            15, 6, -29, 11, 3, 22, 14, -30, 19, 10, -26, 15, 7, 19, 11, 3, 23,
            7, -30, 19, 4, -26, 15, -31, 20, 11, 3, 16, 8, -30, 12, 4, 24, 15,
            -31, 20, 12, -28, 17, 9, -25, 13, 5, 18, 10, 1, 21, 6, -29, 17, 2,
            22, 14, -29, 18, 10, -26, 14, 6, -29, 11, 2, 22, 14, -30, 18, 10,
            -26, 15, 6, 19, 11, 3, 22, 7, -30, 19, 3, -26, 15, -31, 19, 11, 3,
            16, 7, -30, 12, 4, 23, 15, -31, 20, 11, -27, 16, 8, -23, 12, 4, 24,
            8, -31, 20, 5, -27, 16, 1, 21, 12, 4, 17, 9, -31, 20, 5, -28, 16,
            1, 21, 13, -28, 17, 9, -25, 13, 5, 25, 10, 1, 21, 6, -29, 17, 9,
            -25, 14 };

    private static final String GLUECKWUNSCH = "Herzlichen Glueckwunsch!\nDeine Implementation hat den Test bestanden!";

}
