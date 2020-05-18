package pt.unl.fct.di.novalincs.nohr.plugin.rdf_converter;

import org.protege.editor.owl.ui.preferences.OWLPreferencesPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The class is used to define the panel for the RDF Converter. It represents a new tab in the preferences
 *
 * @author Bruno Castelo
 */
public class RDFConverterPreferencesPanel extends OWLPreferencesPanel {

    private static final Dimension MAX_HEIGHT_DIMENSION = new Dimension(Integer.MAX_VALUE,1);


    public RDFConverterPreferencesPanel(){

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
        add(createButton(), buttonsConstraints); // TODO, criar um unico botao
        // TODO ter a certeza que ele so funciona quando estiver um ficheiro selecionado e uma base de dados escolhida

        System.out.println("This was created");

    }

    private JComponent createButton() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JButton convert = new JButton("Convert");
        Boolean show = false;
        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Done");
            }
        });

        return panel;
    }

    private JComponent createTable() {
        return null;
    }

    @Override
    public void dispose() throws Exception {

    }
}
