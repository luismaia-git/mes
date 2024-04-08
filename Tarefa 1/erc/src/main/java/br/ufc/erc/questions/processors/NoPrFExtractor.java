package br.ufc.erc.questions.processors;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtType;

public class NoPrFExtractor extends AbstractProcessor<CtType<?>> {
    @Override
    public void process(CtType<?> element) {
        int count = 0;
        for (CtField<?> attr : element.getFields()) {
            if(attr.isPrivate()){
                count = count + 1;
            }
        }
        System.out.printf("Tipo em análise: %s ; Numero de atributos privados: %d \n", element.getQualifiedName(), count);
    }
}