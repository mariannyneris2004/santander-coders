package model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Annotations
 *
 * @Before // Junit 4 - Roda uma vez antes de cada teste
 * @BeforeEach // Junit 5
 *
 * @BeforeClass // Junit 4 - Roda uma vez antes de TODOS os tests
 * @BeforeAll // Junit 5
 *
 * @After // Junit 4 - Roda uma vez após cada teste
 * @AfterEach // Junit 5
 *
 * @AfterClass // Junit 4 - Roda uma vez após TODOS os testes
 * @AfterAll // Junit 5
 *
 *
 * @Ignore // Junit 4 - Ignora um teste
 * @Disabled
 *
 * Novo:
 * @DisplayName // Junit 5
 *
 * Assert // Junit 4
 * Assertion // Junit 5
 *
 * fail - fail
 * assertTrue - assertTrue
 * assertSame - assertSame
 * assertNull - assertNull
 * assertNotSame - assertNotSame
 * assertNotNull - assertNotNull
 * assertFalse - assertFalse
 * assertEquals - assertEquals
 * assertArrayEquals - assertArrayEquals
 * assertThat - N/A
 * assertThrows (4.13) - assertThrows
 *
 * Nova:
 * assertAll
 * assertThrows
 *
 */

public class CarroTest {
    // F.I.R.S.T - Principios
    // F - Fast
    // I - Isolado/Independente
    // R - Repetable
    // S - Self-validating
    // T - Oportuno (TDD)

    @Test
    @DisplayName("Todos os campos são iniciados corretamente")
    public void deveCriarUmCarroComTodosOsCampos() {
        // public Carro(String cor, String marca, String modelo, Integer velocidadeMaxima)
        Carro carro = new Carro("Preto", "BMW", "X1", 350);

        assertAll("Testando atributos do carro",
                () -> assertEquals("Preto", carro.getCor()),
                () -> assertEquals("BMW", carro.getMarca()),
                () -> assertEquals("X1", carro.getModelo()),
                () -> assertEquals(350, carro.getVelocidadeMaxima()),
                () -> assertEquals(0, carro.getVelocidadeAtual()),
                () -> assertFalse(carro.getLigado()),
                () -> assertTrue(carro.getTrancado())
        );
    }

    @Test
    @DisplayName("Método Ligar iniciado corretamente")
    public void deveLigarCorretamente() throws Exception {
        // Teste #3 - Deve ligar corretamente
        // Given (Dado)
        Carro carro = new Carro("Preto", "BMW", "X1", 350);

        // When (Quando)
        carro.ligar();

        // Then (Então)
        assertTrue(carro.getLigado());
    }

    @Test
    @DisplayName("Método Ligar carro já ligado")
    public void ligarCarroLigado() throws Exception {
        // Teste #3 - Deve ligar corretamente
        // Given (Dado)
        Carro carro = new Carro("Preto", "BMW", "X1", 350);

        // When (Quando)
        carro.ligar();

        Throwable throwable = Assertions.assertThrows(Exception.class, () -> carro.ligar());

        // Then (Então)
        Assertions.assertEquals("O carro já está ligado!", throwable.getMessage());
    }

    @Test
    @DisplayName("Método Desligar iniciado corretamente")
    public void deveDesligarCorretamente() throws Exception {
        // Teste #3 - Deve ligar corretamente
        // Given (Dado)
        Carro carro = new Carro("Preto", "BMW", "X1", 350);

        // When (Quando)
        carro.ligar();
        carro.desligar();

        // Then (Então)
        assertFalse(carro.getLigado());
    }

    @Test
    @DisplayName("Método Ligar carro já ligado")
    public void desligarCarroDesligado() throws Exception {
        // Teste #3 - Deve ligar corretamente
        // Given (Dado)
        Carro carro = new Carro("Preto", "BMW", "X1", 350);

        // When (Quando)
        Throwable throwable = Assertions.assertThrows(Exception.class, () -> carro.desligar());

        // Then (Então)
        Assertions.assertEquals("O carro já está desligado!", throwable.getMessage());
    }

    @Test
    @DisplayName("Método Ligar carro já ligado")
    public void desligarCarroEmMovimento() throws Exception {
        // Teste #3 - Deve ligar corretamente
        // Given (Dado)
        Carro carro = new Carro("Preto", "BMW", "X1", 350);

        // When (Quando)
        carro.ligar();
        carro.acelerar(20);

        Throwable throwable = Assertions.assertThrows(Exception.class, () -> carro.desligar());

        // Then (Então)
        Assertions.assertEquals("O carro está em movimento!", throwable.getMessage());
    }

    @Test
    @DisplayName("Método Acelerar corretamente")
    public void deveAcelerarCorretamente() throws Exception {
        // Teste #5 - Deve acelerar corretamente um carro ligado
        // Given (Dado)
        Carro carro = new Carro("Preto", "BMW", "X1", 350);

        // When (Quando)
        carro.ligar();
        carro.acelerar(10);

        // Then (Então)
        assertEquals((Integer) 10, carro.getVelocidadeAtual());
    }

    @Test
    @DisplayName("Método Acelerar ultrapassa velocidade máxima")
    public void naoDeveUltrapassarAVelocidadeMaxima() throws Exception {
        // Teste #6 - Não pode ultrapassar a velocidade maxima
        // Given
        Carro carro = new Carro("Preto", "BMW", "X1", 350);

        // When
        carro.ligar();
        carro.acelerar(100);
        carro.acelerar(100);
        carro.acelerar(100);

        Throwable throwable = Assertions.assertThrows(Exception.class, () -> carro.acelerar(100));

        // Then (Então)
        Assertions.assertEquals("A velocidade atual não pode ultrapassar a velocidade máxima!", throwable.getMessage());
    }

    @Test
    @DisplayName("Método Acelerar negativamente")
    public void naoDeveAcelerarVelocidadeNegativa() throws Exception {
        // Teste #6 - Não pode ultrapassar a velocidade maxima
        // Given
        Carro carro = new Carro("Preto", "BMW", "X1", 350);

        // When
        carro.ligar();

        Throwable throwable = Assertions.assertThrows(Exception.class, () -> carro.acelerar(-100));

        // Then (Então)
        Assertions.assertEquals("A aceleracao não pode ser menor que zero!", throwable.getMessage());
    }

    @Test
    @DisplayName("Método Acelerar carro desligado")
    public void naoDeveAcelerarCarroDesligado() throws Exception {
        // Teste #6 - Não pode ultrapassar a velocidade maxima
        // Given
        Carro carro = new Carro("Preto", "BMW", "X1", 350);

        // When
        Throwable throwable = Assertions.assertThrows(Exception.class, () -> carro.acelerar(100));

        // Then (Então)
        Assertions.assertEquals("O carro está desligado!", throwable.getMessage());
    }

    @Test
    @DisplayName("Método Frear corretamente")
    public void deveFrearCorretamente() throws Exception {
        // Teste #6 - Não pode ultrapassar a velocidade maxima
        // Given
        Carro carro = new Carro("Preto", "BMW", "X1", 350);

        // When
        carro.ligar();
        carro.acelerar(20);
        carro.frear(10);

        // Then (Então)
        Assertions.assertEquals(10, carro.getVelocidadeAtual());
    }

    @Test
    @DisplayName("Método Frear negativamente")
    public void naoDeveTerVelocidadeInferiorAZero() throws Exception {
        // Given
        Carro carro = new Carro("Preto", "BMW", "X1", 350);
        carro.ligar();
        carro.acelerar(100);

        // When
        carro.frear(50);

        Throwable throwable = Assertions.assertThrows(Exception.class, () -> carro.frear(51));

        // Then (Então)
        Assertions.assertEquals("Você não pode frear uma velocidade menor que zero!", throwable.getMessage());
    }

    @Test
    @DisplayName("Método Frear carro desligado")
    public void naoDeveFrearCarroDesligado() throws Exception {
        // Teste #6 - Não pode ultrapassar a velocidade maxima
        // Given
        Carro carro = new Carro("Preto", "BMW", "X1", 350);

        // When
        Throwable throwable = Assertions.assertThrows(Exception.class, () -> carro.frear(10));

        // Then (Então)
        Assertions.assertEquals("O carro está desligado!", throwable.getMessage());
    }

    @Test
    @DisplayName("Método Trancar carro trancado")
    public void aoTrancarUmCarroJaTrancadoNaoDeveFazerNada() throws Exception {
        // Given
        Carro carro = new Carro("Preto", "BMW", "X1", 350);
        carro.ligar();

        // When
        carro.trancar();
        carro.trancar();

        // Then
        assertEquals(true, carro.getTrancado());
    }

    @Test
    public void aoDestrancarUmCarroJaDestrancadoNaoDeveFazerNada() throws Exception {
        // Given
        Carro carro = new Carro("Preto", "BMW", "X1", 350);
        carro.ligar();

        // When
        carro.destrancar();
        carro.destrancar();

        // Then
        assertFalse(carro.getTrancado());
    }
}
