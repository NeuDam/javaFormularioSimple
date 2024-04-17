import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class FormPersonas extends JFrame {

    DefaultListModel mod = new DefaultListModel();
    List<Dictionary> personsList = new ArrayList<>();
    private JPanel panel;
    private JTextField telefonoText;
    private JTextField nombreText;
    private JTextField documentoText;
    private JTextField apellidoText;
    private JTextField ciudadText;
    private JList lista;
    private JButton AGREGARButton;
    private JButton CONSULTARTODOButton;

    public FormPersonas() {
        AGREGARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nuevoUsuario();
            }
        });
        CONSULTARTODOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sizePersons = personsList.size();
                int iterator = 0;
                System.out.println(sizePersons);
                if (sizePersons == 0){return;}

                lista.setModel(mod);
                mod.removeAllElements();

                while (iterator < sizePersons){
                    Dictionary dataTemp = personsList.get(iterator);
                    System.out.println(dataTemp.get("name"));
                    mod.addElement(dataTemp.get("name"));
                    iterator++;
                }

            }
        });
    }

    public void nuevoUsuario(){
        Dictionary diccionarioDataTemp = new Hashtable();
        diccionarioDataTemp.put("name", nombreText.getText());
        diccionarioDataTemp.put("surname", apellidoText.getText());
        diccionarioDataTemp.put("ciudad", ciudadText.getText());
        diccionarioDataTemp.put("document", documentoText.getText());
        diccionarioDataTemp.put("phone", telefonoText.getText());
        personsList.add(diccionarioDataTemp);

        nombreText.setText("");
        apellidoText.setText("");
        ciudadText.setText("");
        documentoText.setText("");
        telefonoText.setText("");

        lista.setModel(mod);
        mod.removeAllElements();
        mod.addElement("PERSONA REGISTRADA!");

    }

    public static void main(String[] args) {

        FormPersonas f = new FormPersonas();
        f.setContentPane(f.panel);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.pack();

    }


}
