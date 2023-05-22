package MIktea;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


    public class MikTeaShop extends JFrame {
        private JPanel mainPanel;
        private JTable tbMiktea;
        private JTextField txtName;

        private JTextField txtQuantity;
        private JTextField txtPrice;
        private JTextField txtID;
        private JButton update;
        private JButton delete;
        private JButton add;

        private JButton LogButton;

        String filePath = "Customer.dat";
        int row = 0;

        DefaultTableModel modelTbl;
        List<Customer> listcan = new ArrayList<>();

        public MikTeaShop(String title) {
            super(title);
            this.setContentPane(mainPanel);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(800, 400);
            this.setLocationRelativeTo(null);

            //        modelTbl=new DefaultTableModel();
            tbMiktea.setModel(new DefaultTableModel(
                    new Object[][]{},
                    new String[]{
                            "ID", "Name", "Quantity", "Price",
                    }
            ));

            modelTbl = (DefaultTableModel) tbMiktea.getModel();

            listcan = (List<Customer>) XFile.readObject(filePath);
            if (listcan == null || listcan.size() == 0) {
                listcan = new ArrayList<>();
                listcan.add(new Customer("SP01", "T-Shirt", 113, 5));
            }
            fillTotable();
            showDetail(row);

            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    save();
                }


            });
            tbMiktea.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    tb_ManagementClick();
                }

                private void tb_ManagementClick() {
                    row = tbMiktea.getSelectedRow();
                    showDetail(row);
                }
            });
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Delete();
                }


            });

            update.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    UpDateCan();
                }
            });
        }

        private void Delete() {
            //confirm
            //remove can
            //fill to table
            //save table
            int result = JOptionPane.showConfirmDialog(this,
                    "Do you wanna remove it?", "Remove",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (result == JOptionPane.YES_NO_OPTION) {
                listcan.remove(row);
                fillTotable();
                XFile.writeObject(filePath, listcan);
            }
        }


        private void fillToTable() {
            modelTbl.setRowCount(0);
            for (Customer c : listcan) {
                //            "ID","Name","Amount","Price"
                Object[] row = new Object[]{
                        c.getID(), c.getProductName(), c.getQuanity(), c.getPrice()
                };
                modelTbl.addRow(row);
            }
        }

        private void UpDateCan() {
            //edit list
            editCan();
            fillToTable();
            XFile.writeObject(filePath, listcan);
            tbMiktea.setRowSelectionInterval(row, row);
        }

        private void editCan() {
            Customer c = listcan.get(row);
            c.setID(txtID.getText());
            c.setProductName(txtName.getText());
            c.setQuanity(Integer.parseInt(txtQuantity.getText()));
            c.setPrice(Integer.parseInt(txtPrice.getText()));

        }


        private void save() {
//        add new candidate from form
            Addcan();
//        fill to table
            fillTotable();
//        save file
            XFile.writeObject(filePath, listcan);
        }

        private void Addcan() {
            Customer c = new Customer(
                    txtID.getText(),
                    txtName.getText(),
                    Integer.parseInt(txtQuantity.getText()),
                    Integer.parseInt(txtPrice.getText()
                    ));

            listcan.add(c);
        }

        private void fillTotable() {
            modelTbl.setRowCount(0);
            for (Customer i : listcan) {
                Object[] row = new Object[]{
                        i.getID(), i.getProductName(), i.getQuanity(), i.getPrice()
                };
                modelTbl.addRow(row);
            }
        }


        private void showDetail(int row) {
            String ID = (String) tbMiktea.getValueAt(row, 0);
            txtID.setText(ID);
            String ProductName = (String) tbMiktea.getValueAt(row, 1);
            txtName.setText(ProductName);
            Integer quantity = (Integer) tbMiktea.getValueAt(row, 2);
            txtQuantity.setText(quantity.toString());
            Integer price = (Integer) tbMiktea.getValueAt(row, 3);
            txtPrice.setText(price.toString());


        }
    }

