package br.ufc.erc.questions;

import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtType;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.filter.TypeFilter;

import java.util.*;

public class QuestionOne {
    public static void main(String[] args) {

        SpoonAPI spoon = new Launcher();
        spoon.addInputResource("./res/banksys/src/main/java/");
        spoon.buildModel();

        HashMap<String, Set<String>> adjacencyList = new HashMap<>();

        CtModel model = spoon.getModel();

        //obtendo todos os tipos
        Collection<CtType<?>> types = model.getAllTypes();
        for(CtType<?> type : types) {
            String typeName = type.getQualifiedName();
            Set<String> referencedTypes = new HashSet<>();
            if (!type.isShadow()) {
                for (CtTypeReference<?> referredType : type.getReferencedTypes()) {
                    if (!referredType.isShadow()) {
                        if (!referredType.getQualifiedName().equals(typeName)) {
                            referencedTypes.add(referredType.getQualifiedName());
                        }
                    }
                }
                adjacencyList.put(typeName, referencedTypes);
            }
        }

        for (Map.Entry<String, Set<String>> entry : adjacencyList.entrySet()) {

            System.out.println("Tipos: " + entry.getKey());
            System.out.println("Tipos referenciados : " + entry.getValue());
            System.out.println();
        }
    }
}
