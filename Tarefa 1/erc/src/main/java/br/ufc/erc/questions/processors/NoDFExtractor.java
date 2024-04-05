package br.ufc.erc.questions.processors;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtType;

public class NoDFExtractor extends AbstractProcessor<CtType<?>> {
    @Override
    public void process(CtType<?> element) {
        int count = 0;
        for (CtField<?> attr : element.getFields()) {
            count = count + 1;
        }
        System.out.printf("Tipo em analise: %s ; Numero de atributos: %d \n", element.getQualifiedName(), count);
    }
}
