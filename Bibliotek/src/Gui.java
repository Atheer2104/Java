import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
/** här är GUI den klassen som kontroller gränssnitet samt att spara obejkten i
 * en annan fil. Den
 */
public class Gui implements Serializable , TableModelListener {
    private JFrame frame;
    private JPanel background;
    private JLabel l_id, l_name, l_author, l_count, l_year;
    private JTextField tf_id, tf_name, tf_author, tf_count, tf_year;
    private JButton b_add, b_find, b_remove;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scrollPane;
    private boolean isUpdatingUI = false;

    private Bokregister reg;

    private void init() {
        try {
            FileInputStream fis = new FileInputStream("book.srz");
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream in = new ObjectInputStream(bis);
            reg = (Bokregister) in.readObject();
            if (reg == null) {
                reg = new Bokregister();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        frame = new JFrame("Bibliotek");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        background = new JPanel();
        background.setBackground(Color.ORANGE);

        l_id = new JLabel("Id:");
        background.add(l_id);
        tf_id = new JTextField(12);
        background.add(tf_id);

        l_name = new JLabel("Name:");
        background.add(l_name);
        tf_name = new JTextField(12);
        background.add(tf_name);

        l_author = new JLabel("Author:");
        background.add(l_author);
        tf_author = new JTextField(12);
        background.add(tf_author);

        l_count = new JLabel("Count:");
        background.add(l_count);
        tf_count = new JTextField(12);
        background.add(tf_count);

        l_year = new JLabel("Year:");
        background.add(l_year);
        tf_year = new JTextField(12);
        background.add(tf_year);

        b_add = new JButton("Add book");
        AddListner add = new AddListner();
        b_add.addActionListener(add);
        background.add(b_add);

        b_find = new JButton("Find book");
        Findlistener find = new Findlistener();
        b_find.addActionListener(find);
        background.add(b_find);

        b_remove = new JButton("Remove book");
        Removelistener remove = new Removelistener();
        b_remove.addActionListener(remove);
        background.add(b_remove);


        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Author");
        model.addColumn("Count");
        model.addColumn("Year");
        table = new JTable(model);

        for (int i = 1; i < 10000; i++) {
            Bok b = reg.findBok(String.valueOf(i));
            if (b != null) {
                addRow(b.getId(), b.getName(), b.getAuthor(),b.getCount(), b.getYear());
            }
        }

        // disable user edits
        //table.setDefaultEditor(Object.class, null);
        //table.getTableHeader().setReorderingAllowed(false);
        table.getModel().addTableModelListener(this);

        scrollPane = new JScrollPane(table);
        background.add(scrollPane, BorderLayout.CENTER);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.width/1.78);
        int height = ((width/12) * 9);
        frame.setSize(width, height);
        frame.setContentPane(background);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void tableChanged(TableModelEvent e) {
        if (!isUpdatingUI) {
            int row = e.getFirstRow();
            int column = e.getColumn();
            TableModel model = (TableModel) e.getSource();
            String columnName = model.getColumnName(column);

            String data = String.valueOf(model.getValueAt(row, column));
            String id = String.valueOf(model.getValueAt(row, 0));
            String name = String.valueOf(model.getValueAt(row, 1));
            String author = String.valueOf(model.getValueAt(row, 2));
            String count = String.valueOf(model.getValueAt(row, 3));
            String year = String.valueOf(model.getValueAt(row, 4));

            System.out.println(columnName);
            System.out.println(data);

            Bok updatedBok = new Bok(id, name, author, count, year);

            if (column == 0) {
                updatedBok = new Bok(data, name, author, count, year);
            } else if (column == 1) {
                updatedBok = new Bok(id, data, author, count, year);
            } else if (column == 2) {
                updatedBok = new Bok(id, name, data, count, year);
            } else if (column == 3) {
                updatedBok = new Bok(id, name, author, data, year);
            } else if (column == 4) {
                updatedBok = new Bok(id, name, author, count, data);
            }

            reg.updateBok(updatedBok);

            try {
                FileOutputStream fos = new FileOutputStream("book.srz");
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream out = new ObjectOutputStream(bos);
                out.writeObject(reg);
                out.close();
            } catch (Exception error) {
                error.printStackTrace();
            }
        }

    }

    private class AddListner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            isUpdatingUI = true;
            String id = tf_id.getText();
            String name = tf_name.getText();
            String author = tf_author.getText();
            String count = tf_count.getText();
            String year = tf_year.getText();

            Bok tmp = reg.findBok(id);

            if (tmp != null) {
                // there is a book here
                int newCount = updateCount(tmp, 1);

                Vector rows = model.getDataVector();
                int index = 0;

                for (int i = 0; i < rows.capacity(); i++) {
                    String rowId = (String) ((Vector) rows.get(i)).get(0);
                    if (rowId.equals(id)) {
                        index = i;
                    }
                }

                model.setValueAt(""+newCount,index,3 );
            } else {
                // new book
                Bok b = new Bok(id, name, author, count, year);
                reg.addBok(b);
                addRow(id, name, author, count, year);
            }

            try {
                FileOutputStream fos = new FileOutputStream("book.srz");
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream out = new ObjectOutputStream(bos);
                out.writeObject(reg);
                out.close();
            }catch(Exception error) {
                error.printStackTrace();
            }

            isUpdatingUI = false;
        }
    }

    private class Findlistener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String id = tf_id.getText();
            Bok searchBook = reg.findBok(id);
            if (searchBook != null) {
                tf_name.setText(searchBook.getName());
                tf_author.setText(searchBook.getAuthor());
                tf_count.setText(searchBook.getCount());
                tf_year.setText(searchBook.getYear());
            }else {
                JOptionPane.showMessageDialog(background,"The book doesn't exist");
            }
        }
    }

    private class Removelistener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            isUpdatingUI = true;
            String id = tf_id.getText();

            Bok searchBook = reg.findBok(id);

            if (searchBook != null) {
                int newCount = updateCount(searchBook, -1);

                if (newCount == 0) {

                    Vector rows = model.getDataVector();
                    int index = 0;

                    for (int i = 0; i < rows.capacity(); i++) {
                        String rowId = (String) ((Vector) rows.get(i)).get(0);
                        if (rowId.equals(id)) {
                            index = i;
                        }
                    }


                    reg.removeBok(id);
                    model.removeRow(index);


                } else {
                    Vector rows = model.getDataVector();
                    int index = 0;

                    for (int i = 0; i < rows.capacity(); i++) {
                        String rowId = (String) ((Vector) rows.get(i)).get(0);
                        if (rowId.equals(id)) {
                            index = i;
                        }
                    }

                    model.setValueAt(""+newCount,index,3 );
                }

                try {
                    FileOutputStream fos = new FileOutputStream("book.srz");
                    BufferedOutputStream bos = new BufferedOutputStream(fos);
                    ObjectOutputStream out = new ObjectOutputStream(bos);
                    out.writeObject(reg);
                    out.close();
                }catch(Exception error) {
                    error.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(background,"The book doesn't exist");
            }
            isUpdatingUI = false;
        }
    }

    private int updateCount(Bok tmp, int upOrDown) {
        int totalAmountOfBooks = Integer.parseInt(tmp.getCount())+upOrDown;
        tmp.setCount(""+totalAmountOfBooks);

        return totalAmountOfBooks;
    }

    private void addRow(String id, String name, String author, String count, String year) {
        model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{id, name, author, count, year});
    }


    public static void main(String[] args){
        Gui g = new Gui();
        g.init();

    }

}
