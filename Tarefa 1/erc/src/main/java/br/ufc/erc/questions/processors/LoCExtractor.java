package br.ufc.erc.questions.processors;

import spoon.processing.AbstractProcessor;

import spoon.reflect.declaration.CtType;

public class LoCExtractor extends AbstractProcessor<CtType<?>> {
    @Override
    public void process(CtType<?> element) {
        String qualifiedName = element.getQualifiedName();
        int startLine = element.getPosition().getLine();
        int endLine = element.getPosition().getEndLine();

        double totalLoC = ((endLine - startLine) == 0) ? (1) : ((endLine - startLine) - 1);
        System.out.printf("Tipo em análise: %s ; Numeros de linhas:  %f \n", qualifiedName, totalLoC);
    }
}
