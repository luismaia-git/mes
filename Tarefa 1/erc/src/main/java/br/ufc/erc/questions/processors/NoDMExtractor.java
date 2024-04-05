package br.ufc.erc.questions.processors;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtType;

public class NoDMExtractor extends AbstractProcessor<CtType<?>> {
    @Override
    public void process(CtType<?> element) {
        int count = 0;
        for (CtMethod<?> method : element.getMethods()) {
            count = count + 1;
        }
        System.out.printf("Tipo em analise: %s . Numero de metodos: %d \n", element.getQualifiedName(), count);
    }
}
