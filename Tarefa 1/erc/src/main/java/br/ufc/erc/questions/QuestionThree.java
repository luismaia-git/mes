package br.ufc.erc.questions;

import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.TypeFilter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class QuestionThree {
    public static void main(String[] args) {
        SpoonAPI spoon = new Launcher();
        spoon.addInputResource("./res/banksys/src/main/java/");
        spoon.buildModel();

        HashMap<String, Set<String>> adjacencyList = new HashMap<>();

        CtModel model = spoon.getModel();

        for (CtClass<?> ctClass : model.getElements(new TypeFilter<>(CtClass.class))) {
            Set<String> methods = adjacencyList.computeIfAbsent(ctClass.getSimpleName(), k -> new HashSet<>());

            for (CtMethod<?> ctMethod : ctClass.getMethods()) {

                methods.add(ctMethod.getSimpleName());
            }
        }


        for (Map.Entry<String, Set<String>> entry : adjacencyList.entrySet()) {
            System.out.println("Class: " + entry.getKey());
            System.out.println("Methods: " + entry.getValue());
        }
    }

}
