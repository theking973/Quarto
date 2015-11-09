/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;

import controlleur.observables.Notification;
import controlleur.observables.NotificationQuartoDetecte;
import model.EntreeGUI;
import model.EtatGUI;
import model.SortieGUI;
import model.MatriceDeSortie;
import model.MatriceDeTransition;
import controlleur.observables.NotificationPieceDonnee;
import controlleur.observables.NotificationPiecePlacee;
import controlleur.observables.NotificationPieceSelectionnee;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Coord;
import model.NumeroJoueur;
import model.Parametre;
import model.Partie;

/**
 *
 * @author Flo
 */
public class ControllerLocal extends Observable implements IControlleur {

    Partie partie;

    public ControllerLocal(Partie partie) {
        this.partie = partie;

    }

    @Override
    public boolean poserPiece(Coord coord) {
        boolean rep = partie.poserPiece(coord);
        if (rep) {

            EtatGUI etatprecedent = partie.getEtatGUI();
            EntreeGUI entree = EntreeGUI.Plateau;
            EtatGUI etatActuel = partie.passerEtatSuivant(entree);
            NotificationPiecePlacee notif = new NotificationPiecePlacee(coord, getJoueurCourant(), etatActuel, etatprecedent, getSortieGui());

            envoyerNotification(notif);
            boolean quarto = partie.thereIsQuarto(coord);
            if (quarto && partie.isValidationAutoEnabled()) {
                etatActuel = getJoueurCourant() == NumeroJoueur.J1 ? EtatGUI.J1ATrouveUnQuarto : EtatGUI.J2ATrouveUnQuarto;
                NotificationQuartoDetecte notifQuarto = new NotificationQuartoDetecte(getJoueurCourant(), etatActuel, etatprecedent, getSortieGui());
                envoyerNotification(notifQuarto);

            }
        }
        return rep;
    }

    /**
     * Permet d'envoyer une notification.
     *
     * @param notif
     */
    private void envoyerNotification(Notification notif) {
        setChanged();
        notifyObservers(notif);

        // Faire une pause permet au controlleur d'envoyer plusieur notification
        // Cela donne le temps à la GUI de traiter la notification précédente.
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControllerLocal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean donnerPieceAdversaire() {
        boolean rep = partie.donnerPieceAdversaire();

        if (rep) {
            EtatGUI etatprecedent = partie.getEtatGUI();
            EntreeGUI entree = getJoueurCourant() == NumeroJoueur.J1 ? EntreeGUI.DonnerJ1 : EntreeGUI.DonnerJ2;
            EtatGUI etatActuel = partie.passerEtatSuivant(entree);
            NotificationPieceDonnee notif = new NotificationPieceDonnee(getJoueurCourant(), etatActuel, etatprecedent, getSortieGui());
            partie.changerJoueurCourant();
            envoyerNotification(notif);
        }
        return rep;
    }

    @Override
    public boolean selectionPiece(String nomPiece) {

        boolean rep = partie.selectionPiece(nomPiece);
        if (rep) {
            EtatGUI etatprecedent = partie.getEtatGUI();
            EntreeGUI entree = EntreeGUI.ListePiece;
            EtatGUI etatActuel = partie.passerEtatSuivant(entree);
            NotificationPieceSelectionnee notif = new NotificationPieceSelectionnee(nomPiece, getJoueurCourant(), etatActuel, etatprecedent, getSortieGui());
            envoyerNotification(notif);
        }

        return rep;
    }

    @Override
    public boolean annoncerQuarto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean annoncerMatchNul() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getListPieceDisponible() {

        return partie.getListPieceNameDisponibles();
    }

    @Override
    public NumeroJoueur getJoueurCourant() {
        return partie.getNumeroJoueurCourant();
    }

    @Override
    public List<String> getListPiecePlacee() {
        return partie.getListPieceNamePlacees();
    }

    @Override
    public EtatGUI getEtatCourant() {
        return partie.getEtatGUI();
    }

    @Override
    public SortieGUI getSortieGui() {
        return partie.getSortieGUI();
    }

    @Override
    public boolean confirmerMatchNull() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNomJoueur(NumeroJoueur nj) {
        return partie.getNameJoueurFromNumero(nj);
    }

    @Override
    public Boolean getIsValidationAutoEnabled() {
        return partie.isValidationAutoEnabled();
    }

}


