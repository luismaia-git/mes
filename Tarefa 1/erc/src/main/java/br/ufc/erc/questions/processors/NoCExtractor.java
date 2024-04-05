package br.ufc.erc.questions.processors;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtType;

import java.util.Collection;

public class NoCExtractor extends AbstractProcessor<CtType<?>> {
    @Override
    public void process(CtType<?> element) {
        Collection<CtType<?>> types = this.getFactory().getModel().getAllTypes();

    }
}
