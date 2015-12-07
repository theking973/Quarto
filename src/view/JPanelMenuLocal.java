/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import launcher.local.PartieBuilder;
import model.Joueur;
import model.Parametre;

/**
 *
 * @author timotheetroncy
 */
public class JPanelMenuLocal extends javax.swing.JPanel {

    private Image backgroundImage;

    /**
     * Creates new form JPanelMenu
     */
    public JPanelMenuLocal() {
        initComponents();
        this.backgroundImage = GUIImageTool.getImage("/images/wood_texture.jpg");
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
        jButtonContinuer = new javax.swing.JButton();
        jButtonAfficherRegle = new javax.swing.JButton();

        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setName("menu"); // NOI18N
        setOpaque(false);

        jButtonParametrer.setText("Paramétrer Partie");
        jButtonParametrer.setName("jButtonParametrer"); // NOI18N
        jButtonParametrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonParametrerActionPerformed(evt);
            }
        });

        jButtonCommencer.setText("Commencer une nouvelle partie");
        jButtonCommencer.setName("jButtonCommencer"); // NOI18N
        jButtonCommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCommencerActionPerformed(evt);
            }
        });

        jButtonContinuer.setText("Continuer la partie");
        jButtonContinuer.setEnabled(false);
        jButtonContinuer.setName("jButtonContinuer"); // NOI18N
        jButtonContinuer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContinuerActionPerformed(evt);
            }
        });

        jButtonAfficherRegle.setText("Règles du jeu");
        jButtonAfficherRegle.setMaximumSize(new java.awt.Dimension(161, 29));
        jButtonAfficherRegle.setMinimumSize(new java.awt.Dimension(161, 29));
        jButtonAfficherRegle.setName("afficherRegle"); // NOI18N
        jButtonAfficherRegle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAfficherRegleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonAfficherRegle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCommencer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonParametrer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonContinuer, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jButtonParametrer, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButtonCommencer, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButtonContinuer, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAfficherRegle, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonParametrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonParametrerActionPerformed
        CardLayout cl = (CardLayout) this.getParent().getLayout();
        cl.show(this.getParent(), "parametres");
    }//GEN-LAST:event_jButtonParametrerActionPerformed

    private void jButtonCommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCommencerActionPerformed
        JPanelParametresLocal panelParametres = null;
        Component[] components = this.getParent().getComponents();
        for (Component c : components) {
            if (c.getName().equals("parametres")) {
                panelParametres = (JPanelParametresLocal) c;
            }
        }
        Parametre p = getParametres(panelParametres);
        Joueur j1 = panelParametres.getJoueur1();
        Joueur j2 = panelParametres.getJoueur2();
        PartieBuilder.buildPartie(p, j1, j2, this);
    }//GEN-LAST:event_jButtonCommencerActionPerformed

    private void jButtonContinuerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContinuerActionPerformed
        CardLayout cl = (CardLayout) this.getParent().getLayout();
        cl.show(this.getParent(), "jeu");
        PartieBuilder.repackPartieQuarto(this);
    }//GEN-LAST:event_jButtonContinuerActionPerformed

    private void jButtonAfficherRegleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAfficherRegleActionPerformed
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(getClass().getClassLoader().getResource("rules.pdf").getFile());
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }
    }//GEN-LAST:event_jButtonAfficherRegleActionPerformed
    private Parametre getParametres(JPanelParametresLocal panelParametres) {
        return new Parametre(
                panelParametres.getForme(),
                panelParametres.getTaille(),
                panelParametres.getCouleur(),
                panelParametres.getCreux(),
                panelParametres.getQuartoCarre(),
                panelParametres.getQuartoAutoValidation(),
                panelParametres.getJoueurRandom(),
                panelParametres.getContreBot(),
                panelParametres.getTorus(),
                panelParametres.getBotSliderValue()
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAfficherRegle;
    private javax.swing.JButton jButtonCommencer;
    private javax.swing.JButton jButtonContinuer;
    private javax.swing.JButton jButtonParametrer;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.drawImage(backgroundImage, 0, 0, this);
    }

}
