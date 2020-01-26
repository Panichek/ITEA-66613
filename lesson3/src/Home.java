import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Date;
import java.util.Vector;

public class Home {
    public static JTable table;
    public static int doudleclick = 0;
    public static String folder;
    static File dir;

    public static void main(String[] args) {
        if (args.length > 0) dir = new File(args[0]);
        else dir = new File("D:\\");
        FileTableModel model = new FileTableModel(dir);
        FileTableModel.addWay(dir.toString());
        table = new JTable(model);
        JFrame frame = new JFrame("Home2");
        JMenuBar ob = new JMenuBar();
        JMenu ob1 = new JMenu("Менеджер");
        class TableStyle {
            public void setBackgroud(JTable table, Color black) {
            }
        }
        frame.getContentPane().add(new JScrollPane(table), "Center");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(ob);
        ob.add(ob1);

        TableStyle obb = new TableStyle();
        obb.setBackgroud(table, Color.black);
        table.setForeground(Color.black);
        table.addMouseListener(new MouseListener() {
            protected String way = null;
            protected String way1 = null;
            protected String filename = null;
            public void mouseReleased(MouseEvent arg0) {
            }
            public void mousePressed(MouseEvent arg0) {
            }
            public void mouseExited(MouseEvent arg0) {
            }
            public void mouseEntered(MouseEvent arg0) {
            }
            public void mouseClicked(MouseEvent arg0) {
                doudleclick++;
                if (doudleclick == 1) {
                    int r = table.getSelectedRow();
                    way = (String) table.getValueAt(r, 0);
                }
                if (doudleclick == 2) {
                    int r1 = table.getSelectedRow();
                    way1 = (String) table.getValueAt(r1, 0);
                    if (way.equals(way1) && doudleclick == 2) {

                        String type = (String) table.getValueAt(r1, 3);
                        if (type.equals("Generic File")) {
                            Launcher lnch = new Launcher();
                            Launcher.getLauncher();
                            lnch.Open(FileTableModel.getDirName() + "/" + way);
                            lnch.Destroy();
                            doudleclick = 0;
                        } else {
                            if (type.equals("Папка с файлами")) {

                                FileTableModel.navigation(FileTableModel.getDirName() + "/" + way, table);
                                System.out.println(FileTableModel.getDirName());
                                doudleclick = 0;
                            }
                        }

                    } else if (!way.equals(way1)) {

                        doudleclick = 0;
                    }
                }
            }
        });
        frame.setVisible(true);
    }
}
class Launcher {
    public static void getLauncher() {
    }
    public void Open(String s) {
    }
    public void Destroy() {
    }
}

class FileTableModel extends AbstractTableModel {

    private static String lastFolder = null;          //Остання папка
    private static final Component JFrame = null;      //Фрейм (Вікно)
    protected static File dir;                         //Робоча директорія
    protected String[] filenames;                      //Список файлів дир.
    protected JFileChooser jfc;
    protected static int r = 0;
    protected static Vector<String> back = new Vector<>();  //Вектор для зберігання шляху повернення назад
    protected static Vector<String> last = new Vector<>();  //Вектор зберігання шляху  останньої дир.

    protected String[] columnNames = new String[]{    //Назви колонок таблиці
            "назва","розмір","дата","тип"
    };

    protected Class[] columnClasses = new Class[]{    //Типи колонок таблиці
            String.class, Long.class, Date.class, String.class
    };

    public FileTableModel(File dir) {
        this.dir = dir;
        this.filenames = dir.list();
    }
    public int getColumnCount() {
        return 4;
    }
    public int getRowCount() {
        return filenames.length;
    }
    public String getColumnName(int col) {
        return columnNames[col];
    }
    public Class getColumnClass(int col) {
        return columnClasses[col];
    }
    public Object getValueAt(int row, int col) {
        File f = new File(dir, filenames[row]);

        jfc = new JFileChooser();

        switch (col) {
            case 0:
                return filenames[row];
            case 1:
                return f.length() / 1024;
            case 2:
                return new Date(f.lastModified());
            case 3:
                return new String(jfc.getTypeDescription(f));
            default:
                return null;
        }
    }
    public static String getDirName() {
        return dir.toString();
    }

    public static void addWay(String BackWay) {
        back.add(BackWay);
    }

    public static String getBackWay() {
        String s = null;
        lastFolder = back.lastElement().substring(back.lastElement().lastIndexOf("/"), back.lastElement().length());
        System.out.println("<---" + lastFolder + "--->");
        last.add(lastFolder);
        back.remove(back.lastElement());
        s = back.get(back.size() - 1);
        System.err.println(back.lastElement());
        return s;
    }

    public static String getNextWay() {
        back.add(back.lastElement() + last.lastElement());
        last.remove(last.lastElement());
        System.out.println("last--->>" + back.lastElement());
        return back.lastElement();
    }

    public static JTable navigation(String way, JTable table) {
        File ss = new File(way);
        FileTableModel.addWay(ss.toString());
        FileTableModel model = new FileTableModel(ss);
        table.setModel(model);
        table.repaint();
        return table;
    }
}
