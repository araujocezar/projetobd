/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entidades.ServicoQuarto;
import exceção.ItemCadastradoException;
import fachada.Fachada;
import javax.swing.JOptionPane;
/**
 *
 * @author Gabi
 */
public class TelaCadastroRoomService extends javax.swing.JFrame {

    Fachada fachada;
    
    public TelaCadastroRoomService(Fachada fachada) {
        this.fachada = fachada;
        this.setTitle("Golden Hotel");
        initComponents();
        setSize(482,595);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        entryDescricao = new javax.swing.JTextField();
        entryPreco = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        entryId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Imagem2.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 10, 404, 170);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Descrição:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 290, 110, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Preço:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 350, 80, 22);

        entryDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryDescricaoActionPerformed(evt);
            }
        });
        getContentPane().add(entryDescricao);
        entryDescricao.setBounds(180, 300, 170, 30);

        entryPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryPrecoActionPerformed(evt);
            }
        });
        getContentPane().add(entryPreco);
        entryPreco.setBounds(180, 340, 170, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(210, 400, 90, 30);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(370, 510, 90, 30);

        jLabel4.setText("ID:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(140, 240, 60, 30);

        entryId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryIdActionPerformed(evt);
            }
        });
        getContentPane().add(entryId);
        entryId.setBounds(180, 240, 170, 30);
        entryId.getAccessibleContext().setAccessibleName("");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fundo.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 0, 482, 595);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entryDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entryDescricaoActionPerformed

    private void entryPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entryPrecoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String id = entryId.getText();
        String descrição = entryDescricao.getText();
        
        String p = entryPreco.getText();
        if(descrição.equals("") || p.equals("")){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
        else{
            try{
                int idA = Integer.parseInt(id);
                double preço = Double.parseDouble(p);
                ServicoQuarto s = new ServicoQuarto(idA,descrição,preço);
                fachada.adicionarServico(s);
                JOptionPane.showMessageDialog(null, "Cadastrado Realizado!");
                this.dispose();
            } catch (ItemCadastradoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Digite um preço válido!");
            }
            
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void entryIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entryIdActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField entryDescricao;
    private javax.swing.JTextField entryId;
    private javax.swing.JTextField entryPreco;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
