package pt.unl.fct.di.novalincs.nohr.plugin.rdf_converter;

import layout.SpringUtilities;
import org.protege.editor.owl.ui.preferences.OWLPreferencesPanel;
import pt.unl.fct.di.novalincs.nohr.model.ODBCDriver;
import pt.unl.fct.di.novalincs.nohr.plugin.NoHRPreferencesPanel;
import pt.unl.fct.di.novalincs.nohr.plugin.odbc.ODBCPreferences;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * The class is used to define the panel for the RDF Converter. It represents a new tab in the preferences
 *
 * @author Bruno Castelo
 */
public class RDFConverterPreferencesPanel extends OWLPreferencesPanel {

    private static final Dimension MAX_HEIGHT_DIMENSION = new Dimension(Integer.MAX_VALUE,1);

    private File toconvertFile;
    private JTextField toconvertFileTextField;


    public RDFConverterPreferencesPanel(){
        toconvertFileTextField = new JTextField(10);
        toconvertFileTextField.setEditable(false);


    }
    @Override
    public void applyChanges() {

    }

    @Override
    public void initialise() throws Exception {

        setPreferredSize(new Dimension(620,300));
        setLayout(new GridBagLayout());
        GridBagConstraints listConstraints = new GridBagConstraints();
        listConstraints.fill = GridBagConstraints.BOTH;
        listConstraints.gridx = 0;
        listConstraints.gridy = 0;
        listConstraints.gridwidth = 3;
        listConstraints.gridheight = 3;
        listConstraints.weightx = 1;
        listConstraints.weighty = 1;
        GridBagConstraints buttonsConstraints = new GridBagConstraints();
        buttonsConstraints.gridx = 2;
        buttonsConstraints.gridy = 4;
        add(createTable(), listConstraints);
        add(createConvertButton(), buttonsConstraints); // TODO, criar um unico botao
        // TODO ter a certeza que ele so funciona quando estiver um ficheiro selecionado e uma base de dados escolhida.


    }



    private JComponent createConvertButton() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JButton convert = new JButton("Convert");
        Boolean show = toconvertFile != null ;
        convert.setEnabled(show);
        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Done");
            }
        });

        panel.add(convert);
        return panel;
    }

    private JComponent createTable() {

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JComboBox<ODBCDriver> drivers = new JComboBox(ODBCPreferences.getDrivers().toArray());

        panel.add(new JLabel("Choose RDF File"));
        panel.add(toconvertFileTextField);
        panel.add(createChooseRDFFileButton());

        panel.add(new JLabel("Choose Database"));
        panel.add(drivers);
        // TODO ver como meter o botao de convert a aparecer e mandar mail ao knorr a marcar reunião
        return panel;
    }



    private JButton createChooseRDFFileButton() {
        final JButton result = new JButton("Open...");

        result.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fc = new JFileChooser();

                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("RDF files", "rdf");

                fc.setFileFilter(filter);

                final int returnVal = fc.showOpenDialog(RDFConverterPreferencesPanel.this);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    setFileLocation(fc.getSelectedFile());
                }
            }
        });
        return result;
    }

    private void setFileLocation(File value){
        toconvertFile = value;
        toconvertFileTextField.setText(toconvertFile.getPath());
    }


    @Override
    public void dispose() throws Exception {

    }
}
