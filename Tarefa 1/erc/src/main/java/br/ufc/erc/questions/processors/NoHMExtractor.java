package br.ufc.erc.questions.processors;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtType;
import spoon.reflect.reference.CtTypeReference;

public class NoHMExtractor extends AbstractProcessor<CtType<?>> {
    @Override
    public void process(CtType<?> element) {
        CtTypeReference<?> classe = element.getSuperclass();
        if(classe != null){
            int t = getNumberMethods(classe);
            System.out.printf("Tipo em analise: %s; Numero de métodos herdados: %d \n ", element.getQualifiedName(), t );
        }
    }
    public int getNumberMethods(CtTypeReference<?> element){
        if(element != null){
            return element.getTypeDeclaration().getMethods().size()+getNumberMethods(element.getSuperclass());
        }
        return 0;
    }
}
