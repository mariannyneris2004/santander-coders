package model;

import model.Modificadores;
import org.junit.Test;

public class ModificadoresTest {

    @Test
    public void testandoModificadores() {
        Modificadores modificadores = new Modificadores();
        modificadores.publicTest();
        modificadores.protectedTest();
        modificadores.defaultTest();
    }

}
