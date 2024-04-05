package br.ufc.erc.questions.processors;

import spoon.processing.AbstractProcessor;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtType;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class FanInExtractor extends AbstractProcessor<CtType<?>> {
    @Override
    public void process(CtType<?> element) {

        String elementTypeName = element.getQualifiedName();

        CtModel model = this.getFactory().getModel();
        Collection<CtType<?>> types = model.getAllTypes();

        int count = 0;
        for(CtType<?> type : types) {

            if(type.getQualifiedName().equals(elementTypeName)){
                continue;
            }

            for (CtTypeReference<?> referredType : type.getReferencedTypes()) {
                if (!referredType.isShadow()) {
                    if (referredType.getQualifiedName().equals(elementTypeName)) {
                        count = count  + 1;
                    }
                }
            }
        }
        System.out.printf("Tipo em analise: %s . Numero de tipos que o referenciam: %d \n", elementTypeName, count);

    }
}

