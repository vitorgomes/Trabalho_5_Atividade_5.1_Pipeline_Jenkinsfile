import beans.AnuncioBean;
import beans.ProdutoBean;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnuncioBeanTest {

    private static ProdutoBean produto;
    private static AnuncioBean anuncio;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        ArrayList<URL> fotosUrl = new ArrayList<>(Arrays.asList(
                new URL("http://www.foto1.com.br"),
                new URL("http://www.foto2.com.br")
        ));
        produto = new ProdutoBean("001", "Produto A", "Descricao do Produto A", 10.0, "Novo");
        anuncio = new AnuncioBean(produto, fotosUrl, 0.10);
    }

    @AfterEach
    public void tearDown() {
        produto = null;
        anuncio = null;
    }

    @Test
    public void testGetProduto() {
        Assertions.assertEquals(produto, anuncio.getProduto());
    }

    @Test
    public void testSetProduto() {
        ProdutoBean novoProduto = new ProdutoBean("002", "Produto B", "Descricao do Produto B", 20.0, "Usado");
        anuncio.setProduto(novoProduto);
        Assertions.assertEquals(novoProduto, anuncio.getProduto());
    }

    @Test
    public void testGetFotosUrl() throws MalformedURLException {
        List<URL> expectedUrls = new ArrayList<>(Arrays.asList(
                new URL("http://www.foto1.com.br"),
                new URL("http://www.foto2.com.br")
        ));
        Assertions.assertEquals(expectedUrls, anuncio.getFotosUrl());
    }

    @Test
    public void testSetFotosUrl() throws MalformedURLException {
        ArrayList<URL> novasFotosUrl = new ArrayList<>(Arrays.asList(
                new URL("http://www.foto3.com.br"),
                new URL("http://www.foto4.com.br")
        ));
        anuncio.setFotosUrl(novasFotosUrl);
        Assertions.assertEquals(novasFotosUrl, anuncio.getFotosUrl());
    }

    @Test
    public void testGetDesconto() {
        Assertions.assertEquals(0.10, anuncio.getDesconto());
    }

    @Test
    public void testSetDesconto() {
        anuncio.setDesconto(0.20);
        Assertions.assertEquals(0.20, anuncio.getDesconto());
    }

    @Test
    @DisplayName("Test 10% off")
    public void testGetValor10() {
        double expectedValue = 9.00;
        Assertions.assertEquals(expectedValue, anuncio.getValor());
    }

    @Test
    @DisplayName("Test 90% off")
    public void testGetValor90() {
        anuncio.setDesconto(0.9);
        double expectedValue = 1.00;
        Assertions.assertEquals(expectedValue, anuncio.getValor());
    }

    @Test
    public void testGetSerialversionuid() {
        Assertions.assertEquals(1L, AnuncioBean.getSerialversionuid());
    }
}
