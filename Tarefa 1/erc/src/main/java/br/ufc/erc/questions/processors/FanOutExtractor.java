package br.ufc.erc.questions.processors;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtType;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.List;

public class FanOutExtractor extends AbstractProcessor<CtType<?>> {
    @Override
    public void process(CtType<?> element) {
        int count = 0;

        String typeName = element.getQualifiedName();
        if (!element.isShadow()) {
            for (CtTypeReference<?> referredType : element.getReferencedTypes()) {
                if (!referredType.isShadow()) {

                    if (!referredType.getQualifiedName().equals(typeName)) {
                        count = count + 1;
                    }

                }
            }
        }
        System.out.printf("Tipo em analise: %s . Numero de tipos referenciados: %d \n", typeName, count);

    }
}
