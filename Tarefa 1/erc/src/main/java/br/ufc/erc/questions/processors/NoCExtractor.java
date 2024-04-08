package br.ufc.erc.questions.processors;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtType;
import spoon.reflect.reference.CtTypeReference;

import java.util.Collection;

public class NoCExtractor extends AbstractProcessor<CtType<?>> {
    @Override
    public void process(CtType<?> element) {
        Collection<CtType<?>> types = this.getFactory().getModel().getAllTypes();

        int count = 0;
        for (CtType<?> typeSearch : types) {
            if (!element.getQualifiedName().equals(typeSearch.getQualifiedName())) {
                count = count + heritageProc(element.getQualifiedName(), typeSearch.getQualifiedName(), typeSearch.getSuperclass());
            }
        }

        System.out.printf("Tipo em análise: %s; Número de tipos que herdam: %d \n", element.getQualifiedName(), count);
    }

    private int heritageProc(String typeQualified, String typeSearch, CtTypeReference<?> typeParent) {
        if (typeParent == null)
            return 0;
        if (typeQualified.equals(typeParent.getQualifiedName())) {
            return 1;
        }

        return heritageProc(typeQualified, typeSearch, typeParent.getSuperclass());
    }
}
