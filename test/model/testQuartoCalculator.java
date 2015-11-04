/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.logging.Level;
import java.util.logging.Logger;
import static model.QuartoCalculator.thereIsQuarto;
import org.junit.*;

/**
 *
 * @author Anis
 */
public class testQuartoCalculator {

    private Joueur j1;
    private Joueur j2;
    private Parametre p;
    private Partie partie;

    public testQuartoCalculator() {
    }

    @Before
    public void setUp() {
        p = new Parametre(true, true, true, true, true);
        j1 = new Joueur("Joueur1", false, NumeroJoueur.J1);
        j2 = new Joueur("Joueur2", false, NumeroJoueur.J2);
        partie = new Partie(p, j1, j2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testPlateauJeu() {
        try {
            partie.getPlateauJeu().addPiece(new Coord(0, 0), partie.findPieceAvailable("CARRE_GRAND_CLAIR_CREUX"));
            partie.getPlateauJeu().addPiece(new Coord(0, 1), partie.findPieceAvailable("CARRE_GRAND_FONCE_CREUX"));
            partie.getPlateauJeu().addPiece(new Coord(0, 2), partie.findPieceAvailable("CARRE_PETIT_FONCE_CREUX"));
            partie.getPlateauJeu().addPiece(new Coord(0, 3), partie.findPieceAvailable("CARRE_GRAND_CLAIR_CREUX"));
            partie.getPlateauJeu().addPiece(new Coord(1, 0), partie.findPieceAvailable("CARRE_GRAND_FONCE_CREUX"));
            partie.getPlateauJeu().addPiece(new Coord(1, 1), partie.findPieceAvailable("CARRE_PETIT_FONCE_CREUX"));
            partie.getPlateauJeu().addPiece(new Coord(1, 2), partie.findPieceAvailable("CARRE_GRAND_CLAIR_CREUX"));
            partie.getPlateauJeu().addPiece(new Coord(1, 3), partie.findPieceAvailable("CARRE_GRAND_FONCE_CREUX"));
            partie.getPlateauJeu().addPiece(new Coord(2, 0), partie.findPieceAvailable("CARRE_GRAND_FONCE_CREUX"));
            partie.getPlateauJeu().addPiece(new Coord(2, 1), partie.findPieceAvailable("CARRE_PETIT_FONCE_CREUX"));
            partie.getPlateauJeu().addPiece(new Coord(2, 2), partie.findPieceAvailable("CARRE_GRAND_CLAIR_CREUX"));
            partie.getPlateauJeu().addPiece(new Coord(2, 3), partie.findPieceAvailable("CARRE_GRAND_FONCE_CREUX"));
            partie.getPlateauJeu().addPiece(new Coord(3, 0), partie.findPieceAvailable("CARRE_GRAND_FONCE_CREUX"));
            partie.getPlateauJeu().addPiece(new Coord(3, 1), partie.findPieceAvailable("CARRE_PETIT_FONCE_CREUX"));
            partie.getPlateauJeu().addPiece(new Coord(3, 2), partie.findPieceAvailable("CARRE_GRAND_CLAIR_CREUX"));
            partie.getPlateauJeu().addPiece(new Coord(3, 3), partie.findPieceAvailable("CARRE_GRAND_FONCE_CREUX"));

            System.out.println(QuartoCalculator.thereIsQuarto(partie.getPlateauJeu(), p, new Coord(2, 1)).toString());
        } catch (Exception ex) {
            Logger.getLogger(testQuartoCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}