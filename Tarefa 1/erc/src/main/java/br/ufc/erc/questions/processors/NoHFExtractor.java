package br.ufc.erc.questions.processors;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtType;
import spoon.reflect.reference.CtTypeReference;

public class NoHFExtractor extends AbstractProcessor<CtType<?>> {
    @Override
    public void process(CtType<?> element) {
        CtTypeReference<?> classe = element.getSuperclass();
        if(classe != null){
            int t = getNumberFields(classe);
            System.out.printf("Tipo em análise: %s; Numero de atributos herdados: %d \n ", element.getQualifiedName(), t );
        }
    }
    public int getNumberFields(CtTypeReference<?> element){
        if(element != null){
            return element.getTypeDeclaration().getFields().size()+getNumberFields(element.getSuperclass());
        }
        return 0;
    }
}
