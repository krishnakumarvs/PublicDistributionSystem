/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import db.Dbcon;
import java.awt.Image;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class MonthlyItemOrder extends javax.swing.JFrame {

    int currentPage = 1;
    int noItemsInPage = 4;
    int totalNoOfItems = 0;
    String searchName = "";
    int itemId1, itemId2, itemId3, itemId4;

    /**
     * Creates new form MonthlyItemOrder
     */
    public MonthlyItemOrder() {
        initComponents();
        setLocationRelativeTo(null);
        checkTotalNoOfItems();
        loadAllItems();
    }

    public void checkTotalNoOfItems() {
        try {
            String selectQuery = "SELECT count(*) FROM retailer_items, items WHERE retailer_id=" + HomePageCustomer.retailerId + " AND retailer_items.item_id = items.id AND items.monthly_item = TRUE AND items.name LIKE '%" + searchName + "%' ";
            ResultSet rs = new Dbcon().select(selectQuery);
            if (rs.next()) {
                totalNoOfItems = Integer.parseInt(rs.getString(1));
                System.out.println("totalNoOfItems " + totalNoOfItems);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearAllItems() {
        item_name_1.setText("");
        item_name_2.setText("");
        item_name_3.setText("");
        item_name_4.setText("");

        item_price_1.setText("");
        item_price_2.setText("");
        item_price_3.setText("");
        item_price_4.setText("");

        photo_label_1.setIcon(null);
        photo_label_2.setIcon(null);
        photo_label_3.setIcon(null);
        photo_label_4.setIcon(null);

        view_item_1.setVisible(false);
        view_item_2.setVisible(false);
        view_item_3.setVisible(false);
        view_item_4.setVisible(false);

    }

    public void loadAllItems() {
        clearAllItems();
        try {
            String selectQuery = "SELECT retailer_items.id AS id, items.id AS item_id, retailer_items.quantity AS quantity, items.* FROM retailer_items, items WHERE retailer_id=" + HomePageCustomer.retailerId + " AND retailer_items.item_id = items.id AND items.monthly_item = TRUE AND items.name LIKE '%" + searchName + "%' limit " + ((currentPage - 1) * noItemsInPage) + " , " + noItemsInPage;
            System.out.println("selectQuery " + selectQuery);
            ResultSet rs = new Dbcon().select(selectQuery);

            //1
            if (rs.next()) {
                String itemName = rs.getString("name");
                System.out.println("name " + itemName);

                item_name_1.setText(rs.getString("name"));
                item_price_1.setText(rs.getString("price_apl"));
                itemId1 = Integer.parseInt(rs.getString("id"));

                Blob imageBlob = rs.getBlob("image");
                if (imageBlob != null) {
                    InputStream binaryStream = imageBlob.getBinaryStream(1, imageBlob.length());
                    byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());

                    ImageIcon icon = new ImageIcon(imageBytes);

                    Image sc = icon.getImage().getScaledInstance(photo_label_1.getWidth(), photo_label_1.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon iconScaled = new ImageIcon(sc);
                    photo_label_1.setIcon(iconScaled);
                }
                view_item_1.setVisible(true);
            }

            //2  
            if (rs.next()) {
                String itemName = rs.getString("name");
                System.out.println("name " + itemName);

                item_name_2.setText(rs.getString("name"));
                item_price_2.setText(rs.getString("price_apl"));
                itemId2 = Integer.parseInt(rs.getString("id"));
                Blob imageBlob = rs.getBlob("image");
                if (imageBlob != null) {
                    InputStream binaryStream = imageBlob.getBinaryStream(1, imageBlob.length());
                    byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());

                    ImageIcon icon = new ImageIcon(imageBytes);

                    Image sc = icon.getImage().getScaledInstance(photo_label_2.getWidth(), photo_label_2.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon iconScaled = new ImageIcon(sc);
                    photo_label_2.setIcon(iconScaled);
                }
                view_item_2.setVisible(true);
            }

            //3
            if (rs.next()) {
                String itemName = rs.getString("name");
                System.out.println("name " + itemName);

                item_name_3.setText(rs.getString("name"));
                item_price_3.setText(rs.getString("price_apl"));
                itemId3 = Integer.parseInt(rs.getString("id"));

                Blob imageBlob = rs.getBlob("image");
                if (imageBlob != null) {
                    InputStream binaryStream = imageBlob.getBinaryStream(1, imageBlob.length());
                    byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());

                    ImageIcon icon = new ImageIcon(imageBytes);

                    Image sc = icon.getImage().getScaledInstance(photo_label_3.getWidth(), photo_label_3.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon iconScaled = new ImageIcon(sc);
                    photo_label_3.setIcon(iconScaled);
                }
                view_item_3.setVisible(true);
            }

            //4
            if (rs.next()) {
                String itemName = rs.getString("name");
                System.out.println("name " + itemName);

                item_name_4.setText(rs.getString("name"));
                item_price_4.setText(rs.getString("price_apl"));
                itemId4 = Integer.parseInt(rs.getString("id"));

                Blob imageBlob = rs.getBlob("image");
                if (imageBlob != null) {
                    InputStream binaryStream = imageBlob.getBinaryStream(1, imageBlob.length());
                    byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());

                    ImageIcon icon = new ImageIcon(imageBytes);

                    Image sc = icon.getImage().getScaledInstance(photo_label_4.getWidth(), photo_label_4.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon iconScaled = new ImageIcon(sc);
                    photo_label_4.setIcon(iconScaled);
                }
                view_item_4.setVisible(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        search_name = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        photo_label_1 = new javax.swing.JLabel();
        item_name_1 = new javax.swing.JLabel();
        item_price_1 = new javax.swing.JLabel();
        view_item_1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        photo_label_2 = new javax.swing.JLabel();
        item_name_2 = new javax.swing.JLabel();
        item_price_2 = new javax.swing.JLabel();
        view_item_2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        photo_label_3 = new javax.swing.JLabel();
        item_name_3 = new javax.swing.JLabel();
        item_price_3 = new javax.swing.JLabel();
        view_item_3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        photo_label_4 = new javax.swing.JLabel();
        item_name_4 = new javax.swing.JLabel();
        item_price_4 = new javax.swing.JLabel();
        view_item_4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel14.setText("Order your Items......");

        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setText("View cart");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        photo_label_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        item_name_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        item_name_1.setText("Name");

        item_price_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        item_price_1.setText("Price");

        view_item_1.setText("View");
        view_item_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_item_1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(item_name_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(item_price_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(view_item_1)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(photo_label_1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(photo_label_1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(item_name_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(item_price_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(view_item_1)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        photo_label_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        item_name_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        item_name_2.setText("Name");

        item_price_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        item_price_2.setText("Price");

        view_item_2.setText("View");
        view_item_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_item_2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(item_name_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(item_price_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(view_item_2)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(photo_label_2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(photo_label_2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(item_name_2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(item_price_2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(view_item_2)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        photo_label_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        item_name_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        item_name_3.setText("Name");

        item_price_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        item_price_3.setText("Price");

        view_item_3.setText("View");
        view_item_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_item_3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(item_name_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(item_price_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(view_item_3)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(photo_label_3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(photo_label_3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(item_name_3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(item_price_3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(view_item_3)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        photo_label_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        item_name_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        item_name_4.setText("Name");

        item_price_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        item_price_4.setText("Price");

        view_item_4.setText("View");
        view_item_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_item_4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(item_name_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(item_price_4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(view_item_4)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(photo_label_4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(photo_label_4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(item_name_4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(item_price_4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(view_item_4)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        jLabel1.setText("<");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        jLabel2.setText(">");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search_name, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(136, 136, 136))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)))
                .addComponent(jButton5)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        HomePageCustomer homePageCustomer = new HomePageCustomer();
        homePageCustomer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void view_item_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_item_1ActionPerformed
        // TODO add your handling code here:
        ItemViewCustomer itemViewCustomer = new ItemViewCustomer(itemId1);
        itemViewCustomer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_view_item_1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        ViewCartItems viewCartItems = new ViewCartItems();
        viewCartItems.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void view_item_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_item_2ActionPerformed
        ItemViewCustomer itemViewCustomer = new ItemViewCustomer(itemId2);
        itemViewCustomer.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_view_item_2ActionPerformed

    private void view_item_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_item_3ActionPerformed

        // TODO add your handling code here:
        ItemViewCustomer itemViewCustomer = new ItemViewCustomer(itemId3);
        itemViewCustomer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_view_item_3ActionPerformed

    private void view_item_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_item_4ActionPerformed

        // TODO add your handling code here:
        ItemViewCustomer itemViewCustomer = new ItemViewCustomer(itemId4);
        itemViewCustomer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_view_item_4ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        if (currentPage <= 1) {
            System.out.println("Lower limit reached");
        } else {
            --currentPage;
            loadAllItems();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

        if ((currentPage * noItemsInPage) >= totalNoOfItems) {
            System.out.println("Upper limit reached");
        } else {
            ++currentPage;
            loadAllItems();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        searchName = search_name.getText().trim();
        currentPage = 1;
        checkTotalNoOfItems();
        loadAllItems();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(MonthlyItemOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonthlyItemOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonthlyItemOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonthlyItemOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MonthlyItemOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel item_name_1;
    private javax.swing.JLabel item_name_2;
    private javax.swing.JLabel item_name_3;
    private javax.swing.JLabel item_name_4;
    private javax.swing.JLabel item_price_1;
    private javax.swing.JLabel item_price_2;
    private javax.swing.JLabel item_price_3;
    private javax.swing.JLabel item_price_4;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel photo_label_1;
    private javax.swing.JLabel photo_label_2;
    private javax.swing.JLabel photo_label_3;
    private javax.swing.JLabel photo_label_4;
    private javax.swing.JTextField search_name;
    private javax.swing.JButton view_item_1;
    private javax.swing.JButton view_item_2;
    private javax.swing.JButton view_item_3;
    private javax.swing.JButton view_item_4;
    // End of variables declaration//GEN-END:variables
}
