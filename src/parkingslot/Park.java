/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingslot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.text.html.parser.DTDConstants;
/**
 *
 * @author Win10
 */
public class Park extends javax.swing.JFrame {

    /**
     * Creates new form Park
     */
    ParkingSlot parking = new ParkingSlot();
    ArrayList<String> vehicleNumbList = new ArrayList<String>();
    public Park() {        
//        System.out.println(getName("GUE0001","ASD-123FV"));        
        initComponents();
        ImageIcon icon = new ImageIcon("src/parkingslot/misc/icon.png");
        this.setIconImage(icon.getImage());
    }    
    public void action_type(String vehNUmber)
    {
        Statement st = parking.connectDB();        
        int t = 0;                
        //Vehicle Number
        String query = "SELECT Type FROM Vehicle WHERE (coalesce(StudentID, '') || \"\" || coalesce(FacultyID, '') || \"\" || (coalesce(GuestID, '') ) ) = '"+idText.getText()+"' AND [Vehicle Number] = '"+vehNUmber+"'";
        try {
            ResultSet rs = st.executeQuery(query);
            String vehType = "";
            while(rs.next())
            {
                vehType = rs.getString("Type");
            }
            if(!vehType.equals(null))
            {
            vehicleTypeText.setText(vehType);  
            }
            else
            {
                vehicleTypeText.setText("");  
            }
        } catch (SQLException ex) {
            Logger.getLogger(Park.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(NullPointerException e)
        {                
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
    
    public String getName(String ID, String vehicleNumber)
    {
        String name = "";
        Statement st = parking.connectDB();                
        String query = "SELECT Name FROM Vehicle WHERE (coalesce(StudentID, '') || \"\" || coalesce(FacultyID, '') || \"\" || (coalesce(GuestID, '') ) ) = '"+ID+"' AND [Vehicle Number] = '"+vehicleNumber+"'";
        try {
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                name = rs.getString("Name");                    
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddVehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(AddVehicle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }           
        return name;
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        vehicleNumberBox = new javax.swing.JComboBox();
        vehicleTypeText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Parking Slot System");
        setResizable(false);
        setSize(new java.awt.Dimension(100, 100));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(7, 30, 34));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(103, 146, 137));
        jLabel2.setText("Vehicle Type:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(103, 146, 137));
        jLabel3.setText("Vehicle Number:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        vehicleNumberBox.setBackground(new java.awt.Color(244, 192, 149));
        vehicleNumberBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        vehicleNumberBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        vehicleNumberBox.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    System.out.print("asdasd");
                    try
                    {
                        action_type(vehicleNumberBox.getSelectedItem().toString());
                    }
                    catch(NullPointerException ee)
                    {}
                }
            })
            ;
            jPanel1.add(vehicleNumberBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 134, -1));

            vehicleTypeText.setBackground(new java.awt.Color(7, 30, 34));
            vehicleTypeText.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
            vehicleTypeText.setBorder(null);
            vehicleTypeText.setEnabled(false);
            jPanel1.add(vehicleTypeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 140, 20));

            jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(103, 146, 137));
            jLabel1.setText("ID:");
            jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

            idText.setBackground(new java.awt.Color(7, 30, 34));
            idText.setColumns(20);
            idText.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
            idText.setBorder(null);
            idText.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    idTextKeyReleased(evt);
                }
            });
            jPanel1.add(idText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 140, 20));

            jButton1.setBackground(new java.awt.Color(244, 192, 149));
            jButton1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
            jButton1.setForeground(new java.awt.Color(51, 51, 51));
            jButton1.setText("Park vehicle");
            jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });
            jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 105, 33));
            jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 161, 140, 10));
            jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 81, 140, 10));

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
            );

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        new MenuFrame().setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    @SuppressWarnings("null")
    private void idTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idTextKeyReleased
        // TODO add your handling code here:        
        String get = idText.getText();
        int length = get.length();
        if(length < 10)
        {
            idText.setEditable(true);
        }
        else
        {
            idText.setEditable(false);
        }
        if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE)
        {
            idText.setEditable(true);
        }
        idText.setText(get.toUpperCase());
        
        //Get Vehicle Number and Type
        Statement st = parking.connectDB();        
        String id = null;
        //Get vehicle number from slots       
        String slotQuery = "SELECT (coalesce(StudentID, '') || \"\" || coalesce(FacultyID, '') || \"\" || (coalesce(GuestID, '') ) ) AS ID, [Vehicle Number]\n" +
                            "  FROM Vehicle\n" +
                            "  WHERE (coalesce(StudentID, '') || \"\" || coalesce(FacultyID, '') || \"\" || (coalesce(GuestID, '') ) ) = '"+idText.getText()+"'";         
        try {
            ResultSet srs = st.executeQuery(slotQuery);
            while(srs.next())
            {
                id = srs.getString("ID");   
                System.out.println(srs.getString("Vehicle Number"));
                vehicleNumberBox.addItem(srs.getString("Vehicle Number"));                     
            }
        } catch (SQLException ex) {
            Logger.getLogger(Park.class.getName()).log(Level.SEVERE, null, ex);
        }                
        if(!get.equals(id))
        {                     
            try
            {
                vehicleNumberBox.removeAllItems();
                vehicleTypeText.setText("");
            }
            catch(Exception e)
            {}   
        }
    }//GEN-LAST:event_idTextKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:  
        vehicleNumberBox.removeAll();
        Statement st = parking.connectDB();
        //Init numbers
        ArrayList<Integer> numIntegers = new ArrayList<Integer>();
        ArrayList<Integer> slotNumbers = new ArrayList<Integer>();
        for(int x = 1 ; x <=50 ;x++)
        {
            numIntegers.add(x);
        }        
        String count_query = "SELECT [Slot Number]\n" +
                            "  FROM Slot\n" +
                            " WHERE ID != '''Available''' AND \n" +
                            "       Type != '''Available''' AND \n" +
                            "       [Vehicle Number] != '''Available''' AND \n" +
                            "       Name != '''Available''' AND \n" +
                            "       [Date Parked] != '''Available''';";
        try {
            ResultSet slotrs = st.executeQuery(count_query);
            while(slotrs.next())
            {
                slotNumbers.add(slotrs.getInt("Slot Number"));
            }
            numIntegers.removeAll(slotNumbers);
            System.out.println(numIntegers);
        } catch (SQLException ex) {
            Logger.getLogger(Park.class.getName()).log(Level.SEVERE, null, ex);
        }
        try
        {
            String id = idText.getText();
            String vehicleNumber = vehicleNumberBox.getSelectedItem().toString();
            String vehicleType = vehicleTypeText.getText();
            String name = getName(id, vehicleNumber);            
            Random ran = new Random();            
            int random_slot = ran.nextInt((numIntegers.size()));            
            if(random_slot != 0)
            {
                if(!vehicleType.equals(""))
                {
                    //Set Slot
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = new Date();
                    String dt = dateFormat.format(date);
                    String parkVehicleQuery = "UPDATE Slot SET "
                                            + "ID = '"+id+"',\n" +
                                            "       Name = '"+name+"',\n" +
                                            "       Type = '"+vehicleType+"',\n" +
                                            "       [Vehicle Number] = '"+vehicleNumber+"',\n" +
                                            "       [Date Parked] = '"+dt+"' WHERE [Slot Number] = "+random_slot+"";                    
                    try {
                        PreparedStatement ps = parking.con.prepareStatement(parkVehicleQuery);                       
                        ps.executeUpdate();                        
                        JOptionPane.showMessageDialog(rootPane, "Park Successful");
                    } catch (SQLException ex) {
//                        Logger.getLogger(Park.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(rootPane, "Vehicle already parked", "Error slot input", JOptionPane.ERROR_MESSAGE);
                    }
                    finally
                    {
                        try {
                            st.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(Park.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Vehicle type is not filled up", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }                                   
        }
        catch(NullPointerException e)
        {            
            JOptionPane.showMessageDialog(rootPane, "ID does not exist");
        }
        //Reset all fields                   
            idText.setText("");
            vehicleTypeText.setText("");
            try
            {
                vehicleNumberBox.removeAllItems();
            }
            catch(NullPointerException e)
            {
                vehicleNumberBox.removeAllItems();
            }
            
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
            java.util.logging.Logger.getLogger(Park.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Park.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Park.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Park.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Park().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JComboBox vehicleNumberBox;
    private javax.swing.JTextField vehicleTypeText;
    // End of variables declaration//GEN-END:variables

    private Timestamp Timestamp(long timeInMillis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
