package unitTeste;

import br.com.iterasys.Calculadora;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalcularQuadrado {
    @Test
    public void testeCalcularAreaQuadrado() { //inicio do teste calcular area do quadrado
        // Confugura
        // Valores de entrada
        double Aresta = 10;

        // Valores de saida
        double resultadoEsperado = 100;

        //Executa
        double resultadoAtual = Calculadora.areaQuadrado(Aresta);

        //Valida
        assertEquals(resultadoEsperado, resultadoAtual);
    } //fim do teste calcular area do quadrado




    @ParameterizedTest
    @CsvSource(value = {
            "12,144.0",
            "36,1296.0",
            "-90,8100.0",
            "45,2025.0",
            "95,9025.0",
            "162,26244.0",
            "-27,729.0",
            "1,1.0",
            "3,9.0"
    },delimiter = ',')
    public void testeCalcularAreaQuadradoLista(String txtAresta,
                                               String resultadoEsperado) { //inicio do teste calcular area do quadrado em lista
        // Configura
        // Os dados de entrada e o resultado esperado vem da lista
        // Valores de saida

        //Executa
        double resultadoAtual = Calculadora.areaQuadrado(Integer.valueOf(txtAresta));

        //valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);

    } //fim do teste calcular area do quadrado em lista


    @ParameterizedTest //teste lendo arquivos.
    @CsvFileSource(resources = "/csv/MassaCalcularQuadrado.csv", numLinesToSkip = 1, delimiter = ',')
    public void testeCalcularAreaQuadradoLendoArquivo(String txtAresta,
                                                      String resultadoEsperado) {//inicio do teste calcular area do quadrado lendo arquivos
        // Configura
        // Os dados de entrada e o resultado esperado vem da lista em arquivo

        //Executa
        double resultadoAtual = Calculadora.areaQuadrado(Integer.valueOf(txtAresta));

        //Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    } //fim do teste calcular area do quadrado lendo arquivos

}


