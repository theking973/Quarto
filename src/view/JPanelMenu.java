/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controlleur.ControllerLocal;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Observer;
import javax.swing.JPanel;
import model.Joueur;
import model.NumeroJoueur;
import model.Parametre;
import model.Partie;

/**
 *
 * @author timotheetroncy
 */
public class JPanelMenu extends javax.swing.JPanel {

    /**
     * Creates new form JPanelMenu
     */
    public JPanelMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonParametrer = new javax.swing.JButton();
        jButtonCommencer = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setName("menu"); // NOI18N
        setOpaque(false);

        jButtonParametrer.setText("Paramétrer Partie");
        jButtonParametrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonParametrerActionPerformed(evt);
            }
        });

        jButtonCommencer.setText("Commencer nouvelle partie");
        jButtonCommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCommencerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonCommencer, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonParametrer, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jButtonParametrer, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCommencer, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonParametrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonParametrerActionPerformed
        CardLayout cl = (CardLayout) this.getParent().getLayout();
        cl.show(this.getParent(), "parametres");
    }//GEN-LAST:event_jButtonParametrerActionPerformed

    private void jButtonCommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCommencerActionPerformed
        Parametre p = new Parametre(true, true, true, true, true);
        Joueur j1 = new Joueur("Joueur 1", false, NumeroJoueur.J1);
        Joueur j2 = new Joueur("Joueur 2", false, NumeroJoueur.J2);
        Partie partie = new Partie(p, j1, j2);
        ControllerLocal controllerLocal = new ControllerLocal(partie);
        JPanel panel = new QuartoGUI(controllerLocal);
        controllerLocal.addObserver((Observer) panel);
        panel.setName("jeu");//important
        
        CardLayout cl = (CardLayout) this.getParent().getLayout();

        //on remove le component jeu
        Component[] components = this.getParent().getComponents();
        for (Component c : components) {
            if (c.getName().equals("jeu")) {
                cl.removeLayoutComponent(c);
                this.getParent().remove(c);
            }
        }
        this.getParent().add("jeu", panel);
        
        cl.show(this.getParent(), "jeu");
    }//GEN-LAST:event_jButtonCommencerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCommencer;
    private javax.swing.JButton jButtonParametrer;
    // End of variables declaration//GEN-END:variables
}