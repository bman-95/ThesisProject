package pt.unl.fct.di.novalincs.nohr.plugin.rdf_converter;

import org.semanticweb.owlapi.model.AxiomType;

public final class RDFConverterPreferences {

    private final AxiomType<?>[] ignorableAxioms;

    private static RDFConverterPreferences instance;

    private RDFConverterPreferences(){
        ignorableAxioms = new AxiomType<?>[]{
                AxiomType.DATA_PROPERTY_RANGE,
                AxiomType.FUNCTIONAL_OBJECT_PROPERTY,
                AxiomType.OBJECT_PROPERTY_RANGE
        };
    }
    public static synchronized RDFConverterPreferences getInstance() {
        if (instance == null) {
            instance = new RDFConverterPreferences();
        }

        return instance;
    }
}
