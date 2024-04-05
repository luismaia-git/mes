package br.ufc.erc.questions;

import spoon.Launcher;
import spoon.SpoonAPI;

public class QuestionFour {

    public static void main(String[] args) {
        SpoonAPI spoon = new Launcher();
        spoon.addInputResource("./res/banksys/src/main/java/");
        spoon.buildModel();
        //spoon.addProcessor("br.ufc.erc.questions.processors.LoCExtractor");
        //spoon.addProcessor("br.ufc.erc.questions.processors.FanInExtractor");
        //spoon.addProcessor("br.ufc.erc.questions.processors.FanOutExtractor");
        //spoon.addProcessor("br.ufc.erc.questions.processors.NoDMExtractor");
        //spoon.addProcessor("br.ufc.erc.questions.processors.NoHMExtractor");
        //spoon.addProcessor("br.ufc.erc.questions.processors.NoPrMExtractor");
        //spoon.addProcessor("br.ufc.erc.questions.processors.NoPuMExtractor");
        //spoon.addProcessor("br.ufc.erc.questions.processors.NoDFExtractor");
        //spoon.addProcessor("br.ufc.erc.questions.processors.NoHFExtractor");
        //spoon.addProcessor("br.ufc.erc.questions.processors.NoPrFExtractor");
        //spoon.addProcessor("br.ufc.erc.questions.processors.NoPuFExtractor");
        spoon.addProcessor("br.ufc.erc.questions.processors.NoCExtractor");
        spoon.process();

        /*
1. LoC (LoCExtractor): número de linhas de código do tipo em análise;
2. Fan-In (FanInExtractor): número de tipos que referenciam o tipo em análise;
3. Fan-Out (FanOutExtractor): número de tipos que o tipo em análise referência;
4. NoDM (NoDMExtractor): número de métodos declarados no tipo em análise;
5. NoHM (NoHMExtractor): número de métodos herdados pelo tipo em análise;
6. NoPrM (NoPrMExtractor): número de métodos privados do tipo em análise;
7. NoPuM (NoPuMExtractor): número de métodos públicos do tipo em análise;
8. NoDF (NoDFExtractor): número de atributos declarados no tipo em análise;
9. NoFH (NoHFExtractor): número de atributos herdados pelo tipo em análise;
10. NoPrF (NoPrFExtractor): número de atributos privados do tipo em análise;
11. NoPuF (NoPuFExtractor): número de atributos públicos do tipo em análise;
12. NoC (NoCExtractor): número de tipos que herdam do tipo em análise
        * */
    }
}
