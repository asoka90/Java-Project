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
import javax.swing.ImageIcon;
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
        ImageIcon icon = new ImageIcon("src/parkingslot/misc/icon.png");
        this.setIconImage(icon.getImage());
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

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        vehicleTypeText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        vehicleNumberBox = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Parking Slot System");
        setResizable(false);
        setSize(257, 213);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(7, 30, 34));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(103, 146, 137));
        jLabel2.setText("Vehicle Type:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));

        vehicleTypeText.setBackground(new java.awt.Color(7, 30, 34));
        vehicleTypeText.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        vehicleTypeText.setBorder(null);
        vehicleTypeText.setEnabled(false);
        jPanel3.add(vehicleTypeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 140, 20));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(103, 146, 137));
        jLabel1.setText("ID:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        idText.setBackground(new java.awt.Color(7, 30, 34));
        idText.setColumns(20);
        idText.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        idText.setBorder(null);
        idText.setEnabled(false);
        jPanel3.add(idText, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 140, 20));

        jButton1.setBackground(new java.awt.Color(244, 192, 149));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Retrieve vehicle");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 150, 30));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(103, 146, 137));
        jLabel3.setText("Vehicle Number:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        vehicleNumberBox.setBackground(new java.awt.Color(244, 192, 149));
        vehicleNumberBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        vehicleNumberBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        vehicleNumberBox.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    action_combo();
                }
            })
            ;
            jPanel3.add(vehicleNumberBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 130, -1));
            jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 153, 140, 10));
            jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 83, 140, 10));

            getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 450, 205));

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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox vehicleNumberBox;
    private javax.swing.JTextField vehicleTypeText;
    // End of variables declaration//GEN-END:variables
}
