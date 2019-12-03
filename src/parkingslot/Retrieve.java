/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingslot;

import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Win10
 */
public class Retrieve extends javax.swing.JFrame {

    /**
     * Creates new form Retrieve
     */
    ParkingSlot parking = new ParkingSlot();
    public Retrieve() {        
        initComponents();
        Init_combo();       
    }
    
    public void Init_combo()
    {
        Statement st = parking.connectDB();
        String query = "SELECT [Vehicle Number] FROM Slot WHERE ID != 'AVAILABLE'";
        ArrayList<String> number = new ArrayList<String>();
        try {
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                number.add(rs.getString("Vehicle Number"));
            }
            vehicleNumberBox.setModel(new DefaultComboBoxModel(number.toArray()));                                                                                  
        } catch (SQLException ex) {
            Logger.getLogger(Retrieve.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Retrieve.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    public int count(String ID)
    {
        int cnt = 0;
        Statement st = parking.connectDB();
        String tableName[] = {"Student Vehicle", "Faculty Vehicle", "Guest Vehicle"};
        int t = 0;
        while( t < tableName.length)
        {
        String query = "SELECT count(ID) AS CountID FROM ["+tableName[t]+"] WHERE ID = '"+ID+"'";
            try {
                ResultSet rs = st.executeQuery(query);
                while(rs.next())
                {
                    int idcount = rs.getInt("CountID");
                    if(idcount != 0)
                    {
                        cnt = idcount;
                    }                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Park.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Park.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        t++;
        }
        return cnt;
    }
    
    public String getName(String Vehicle_Number)
    {
        String name = "";
        Statement st = parking.connectDB();
        String query = "SELECT Name FROM Slot WHERE [Vehicle Number] = '"+Vehicle_Number+"'";
        try {
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                name = rs.getString("Name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Retrieve.class.getName()).log(Level.SEVERE, null, ex);
        }  
        finally
        {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Retrieve.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return name;
    }
    
    public String getID(String Vehicle_Number)
    {
        String id = "";
        Statement st = parking.connectDB();
        String query = "SELECT ID FROM Slot WHERE [Vehicle Number] = '"+Vehicle_Number+"'";
        try {
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                id = rs.getString("ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Retrieve.class.getName()).log(Level.SEVERE, null, ex);
        }  
        finally
        {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Retrieve.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id;
    }
    
    public String getType(String Vehicle_Number)
    {
        String type = "";
        Statement st = parking.connectDB();
        String query = "SELECT Type FROM Slot WHERE [Vehicle Number] = '"+Vehicle_Number+"'";
        try {
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                type = rs.getString("Type");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Retrieve.class.getName()).log(Level.SEVERE, null, ex);
        }       
        finally
        {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Retrieve.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return type;
    }
    
    public void action_combo()
    {
        String vehicleNumber = vehicleNumberBox.getSelectedItem().toString();
        String type = getType(vehicleNumber);
        String id = getID(vehicleNumber);
        vehicleTypeText.setText(type);
        idText.setText(id);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        vehicleTypeText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        vehicleNumberBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Parking Slot System");
        setResizable(false);
        setSize(257, 213);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton1.setText("Retrieve vehicle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 153, 51));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Vehicle Type:");

        vehicleTypeText.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        vehicleTypeText.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("ID:");

        idText.setColumns(20);
        idText.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        idText.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(vehicleTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {idText, vehicleTypeText});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vehicleTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Vehicle Number:");

        vehicleNumberBox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        vehicleNumberBox.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    action_combo();
                }
            })
            ;

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vehicleNumberBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel3))
                    .addGap(41, 41, 41)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(vehicleNumberBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)
                    .addComponent(jButton1)
                    .addContainerGap(57, Short.MAX_VALUE))
            );

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        new MenuFrame().setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(!idText.getText().equals("") || !vehicleTypeText.getText().equals(""))
        {
            Statement st = parking.connectDB();
            String vehicleNumber = vehicleNumberBox.getSelectedItem().toString();
            String type = getType(vehicleNumber);
            String id = getID(vehicleNumber);
            String query = "UPDATE Slot SET ID = NULL, Name = NULL, Type = NULL, [Vehicle Number] = NULL, [Date Parked] = NULL WHERE ID = '"+id+"' AND Type = '"+type+"' AND [Vehicle Number] = '"+vehicleNumber+"'";
            try {
                PreparedStatement ps = parking.con.prepareStatement(query);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "Retrieve successful");
            } catch (SQLException ex) {
                Logger.getLogger(Retrieve.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Retrieve.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "ID or Type is null", "Error", JOptionPane.ERROR_MESSAGE);
        }
        idText.setText("");
        vehicleTypeText.setText("");
        Init_combo();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Retrieve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Retrieve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Retrieve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Retrieve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Retrieve().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox vehicleNumberBox;
    private javax.swing.JTextField vehicleTypeText;
    // End of variables declaration//GEN-END:variables
}
