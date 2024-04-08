package br.ufc.erc.questions;

import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtType;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.filter.TypeFilter;

import java.util.*;

public class QuestionTwo {
    public static void main(String[] args) {

        SpoonAPI spoon = new Launcher();
        spoon.addInputResource("./res/banksys/src/main/java/");
        spoon.buildModel();

        HashMap<String, Set<String>> adjacencyList = new HashMap<>();

        CtModel model = spoon.getModel();
        HashMap<String, Set<String>> adjacenceList = new HashMap<>();


        Collection<CtType<?>> allTypes = model.getAllTypes();
        for (CtType<?> typeAnalised : allTypes) {
            if (!typeAnalised.isShadow()) {
                Set<String> typeHeritage = new HashSet<>();
                for (CtType<?> typeSearch : allTypes) {
                    if (!typeAnalised.getQualifiedName().equals(typeSearch.getQualifiedName())) {
                        herda(typeAnalised.getQualifiedName(), typeSearch.getQualifiedName(),
                                typeSearch.getSuperclass(), typeHeritage);
                    }
                }
                adjacenceList.put(typeAnalised.getQualifiedName(), typeHeritage);
            }

        }

            for (Map.Entry<String, Set<String>> entry : adjacencyList.entrySet()) {
                System.out.println("Tipo: " + entry.getKey());
                System.out.println("Herança: " + entry.getValue());
                System.out.println();
            }
        }

    static void herda(String typeQualified, String typeSearch, CtTypeReference<?> typeParent,
                         Set<String> typeHeritage) {
        if (typeParent == null)
            return;
        if (typeQualified.equals(typeParent.getQualifiedName())) {
            typeHeritage.add(typeSearch);
            return;
        }

        herda(typeQualified, typeSearch, typeParent.getSuperclass(), typeHeritage);}

    }

