/*
 * Created by JFormDesigner on Sat Nov 18 00:26:00 HKT 2017
 */

package Queuing;

import java.awt.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.table.*;
import com.jgoodies.forms.factories.*;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class TableGUI extends JPanel {
    public TableGUI() {
        initComponents();
    }

    private void waitToSeat(PropertyChangeEvent e) {
        // TODO add your code here
    }

    private void checkOut(PropertyChangeEvent e) {
        // TODO add your code here
    }

    private void displayLogInfo(PropertyChangeEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Shiying Li
        frame1 = new JFrame();
        tabbedPane1 = new JTabbedPane();
        panel2 = new JPanel();
        scrollPane4 = new JScrollPane();
        table3 = new JTable();
        panel3 = new JPanel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        panel4 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        scrollPane3 = new JScrollPane();
        textPane1 = new JTextPane();

        //======== frame1 ========
        {
            frame1.setTitle("Restaurant Queuing System");
            Container frame1ContentPane = frame1.getContentPane();
            frame1ContentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[414,fill]" +
                "[fill]",
                // rows
                "[438]" +
                "[160]"));

            //======== tabbedPane1 ========
            {
                tabbedPane1.setMinimumSize(new Dimension(800, 400));
                tabbedPane1.setPreferredSize(new Dimension(857, 400));
                tabbedPane1.setOpaque(true);
                tabbedPane1.setAlignmentX(0.0F);
                tabbedPane1.setAlignmentY(0.0F);

                //======== panel2 ========
                {

                    // JFormDesigner evaluation mark
                    panel2.setBorder(new javax.swing.border.CompoundBorder(
                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), panel2.getBorder())); panel2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                    panel2.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[fill]",
                        // rows
                        "[]"));

                    //======== scrollPane4 ========
                    {

                        //---- table3 ----
                        table3.setModel(new DefaultTableModel(
                            new Object[][] {
                                {"Successful Trans", 0, null, null, null, null, null, null, null},
                                {"Failed Trans (Waiting for a ticket)", 0, null, null, null, null, null, null, null},
                                {"Failed Trans (Waiting for a table)", 0, null, null, null, null, null, null, null},
                                {"Failed Trans (Waiting for table Assignment)", 0, null, null, null, null, null, null, null},
                                {"Failed Trans (Queue too long)", 0, null, null, null, null, null, null, null},
                                {"Early Leave Trans", 0, null, null, null, null, null, null, null},
                                {"Overall Trans", 0, null, null, null, null, null, null, null},
                            },
                            new String[] {
                                "Name", "Count", "Percent", "NPers", "Waiting T", "Eating T", "Transaction T", "Spending", "Spending/Pers"
                            }
                        ) {
                            Class<?>[] columnTypes = new Class<?>[] {
                                String.class, Integer.class, Float.class, Float.class, Float.class, Float.class, Float.class, Float.class, Float.class
                            };
                            @Override
                            public Class<?> getColumnClass(int columnIndex) {
                                return columnTypes[columnIndex];
                            }
                        });
                        {
                            TableColumnModel cm = table3.getColumnModel();
                            cm.getColumn(0).setPreferredWidth(160);
                            cm.getColumn(0).setCellEditor(new DefaultCellEditor(
                                new JComboBox(new DefaultComboBoxModel(new String[] {
                                    "Successful Trans",
                                    "Failed Trans (Waiting for a ticket)",
                                    "Failed Trans (Waiting for a table)",
                                    "Failed Trans (Waiting for table Assignment)",
                                    "Failed Trans (Queue too long)",
                                    "Early Leave Trans",
                                    "Overall Trans"
                                }))));
                        }
                        table3.setRowHeight(30);
                        table3.setPreferredSize(new Dimension(675, 212));
                        table3.setFont(new Font(".SF NS Text", Font.PLAIN, 10));
                        scrollPane4.setViewportView(table3);
                    }
                    panel2.add(scrollPane4, "cell 0 0,width 700:800:800");
                }
                tabbedPane1.addTab("Statistics", panel2);

                //======== panel3 ========
                {
                    panel3.setPreferredSize(new Dimension(836, 380));
                    panel3.setMinimumSize(new Dimension(54, 380));
                    panel3.setBackground(Color.white);
                    panel3.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[fill]",
                        // rows
                        "[]"));

                    //======== scrollPane2 ========
                    {

                        //---- table2 ----
                        table2.setFocusTraversalPolicyProvider(true);
                        table2.setModel(new DefaultTableModel(
                            new Object[][] {
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                            },
                            new String[] {
                                "Table Size: 1-2", "Table Size: 3-4", "Table Size: 5-6", "Table Size: 7-8", "Table Size: 9-10"
                            }
                        ) {
                            Class<?>[] columnTypes = new Class<?>[] {
                                String.class, String.class, String.class, String.class, String.class
                            };
                            @Override
                            public Class<?> getColumnClass(int columnIndex) {
                                return columnTypes[columnIndex];
                            }
                        });
                        table2.setPreferredScrollableViewportSize(new Dimension(800, 352));
                        table2.setPreferredSize(new Dimension(375, 330));
                        table2.setFont(table2.getFont().deriveFont(table2.getFont().getStyle() | Font.BOLD));
                        table2.setMinimumSize(new Dimension(75, 100));
                        table2.setRowHeight(30);
                        table2.setEnabled(false);
                        table2.setRowMargin(0);
                        table2.setIntercellSpacing(new Dimension(0, 0));
                        table2.setBorder(null);
                        table2.addPropertyChangeListener(e -> waitToSeat(e));
                        scrollPane2.setViewportView(table2);
                    }
                    panel3.add(scrollPane2, "cell 0 0,height 352:352:352");
                }
                tabbedPane1.addTab("Table Occupants", panel3);

                //======== panel4 ========
                {
                    panel4.setBackground(Color.white);
                    panel4.setPreferredSize(new Dimension(836, 380));
                    panel4.setMinimumSize(new Dimension(836, 380));
                    panel4.setMaximumSize(new Dimension(2147483647, 350));
                    panel4.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[fill]",
                        // rows
                        "[350]"));

                    //======== scrollPane1 ========
                    {

                        //---- table1 ----
                        table1.setFocusTraversalPolicyProvider(true);
                        table1.setModel(new DefaultTableModel(
                            new Object[][] {
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                            },
                            new String[] {
                                "Table Size: 1-2", "Table Size: 3-4", "Table Size: 5-6", "Table Size: 7-8", "Table Size: 9-10"
                            }
                        ) {
                            Class<?>[] columnTypes = new Class<?>[] {
                                String.class, String.class, String.class, String.class, String.class
                            };
                            @Override
                            public Class<?> getColumnClass(int columnIndex) {
                                return columnTypes[columnIndex];
                            }
                        });
                        table1.setPreferredScrollableViewportSize(new Dimension(800, 352));
                        table1.setPreferredSize(new Dimension(375, 330));
                        table1.setFont(table1.getFont().deriveFont(table1.getFont().getStyle() | Font.BOLD));
                        table1.setMinimumSize(new Dimension(75, 100));
                        table1.setRowHeight(30);
                        table1.setEnabled(false);
                        table1.setAutoCreateColumnsFromModel(false);
                        table1.setGridColor(new Color(225, 225, 225));
                        table1.setAlignmentX(0.0F);
                        table1.setAlignmentY(0.0F);
                        table1.setForeground(Color.white);
                        table1.setBorder(null);
                        scrollPane1.setViewportView(table1);
                    }
                    panel4.add(scrollPane1, "cell 0 0,height 352:352:352");
                }
                tabbedPane1.addTab("Table Wait Queue", panel4);
            }
            frame1ContentPane.add(tabbedPane1, "cell 0 0,dock center");

            //======== scrollPane3 ========
            {

                //---- textPane1 ----
                textPane1.setEditable(false);
                textPane1.setText("Display Log Info...");
                scrollPane3.setViewportView(textPane1);
            }
            frame1ContentPane.add(scrollPane3, "cell 0 1,height 150:150:150");
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Shiying Li
    private JFrame frame1;
    private JTabbedPane tabbedPane1;
    private JPanel panel2;
    private JScrollPane scrollPane4;
    private JTable table3;
    private JPanel panel3;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JPanel panel4;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JScrollPane scrollPane3;
    private JTextPane textPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
