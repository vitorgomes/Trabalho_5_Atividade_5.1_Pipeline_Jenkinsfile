import beans.AnuncioBean;
import beans.AnuncianteBean;
import beans.ProdutoBean;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnuncianteBeanTest {

    private static AnuncianteBean anunciante;
    private static AnuncioBean anuncio1;
    private static AnuncioBean anuncio2;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        List<URL> fotosUrl1 = new ArrayList<>(Arrays.asList(
                new URL("http://www.foto1.com.br"),
                new URL("http://www.foto2.com.br")
        ));
        ProdutoBean produto1 = new ProdutoBean("001", "Produto A", "Descricao do Produto A", 10.0, "Novo");
        anuncio1 = new AnuncioBean(produto1, (ArrayList<URL>) fotosUrl1, 0.10);

        List<URL> fotosUrl2 = new ArrayList<>(Arrays.asList(
                new URL("http://www.foto3.com.br"),
                new URL("http://www.foto4.com.br")
        ));
        ProdutoBean produto2 = new ProdutoBean("002", "Produto B", "Descricao do Produto B", 20.0, "Usado");
        anuncio2 = new AnuncioBean(produto2, (ArrayList<URL>) fotosUrl2, 0.20);

        ArrayList<AnuncioBean> anuncios = new ArrayList<>(Arrays.asList(anuncio1, anuncio2));
        anunciante = new AnuncianteBean("João", "123.456.789-00", anuncios);
    }

    @AfterEach
    public void tearDown() {
        anunciante = null;
        anuncio1 = null;
        anuncio2 = null;
    }

    @Test
    public void testGetNome() {
        Assertions.assertEquals("João", anunciante.getNome());
    }

    @Test
    public void testSetNome() {
        anunciante.setNome("Maria");
        Assertions.assertEquals("Maria", anunciante.getNome());
    }

    @Test
    public void testGetCPF() {
        Assertions.assertEquals("123.456.789-00", anunciante.getCPF());
    }

    @Test
    public void testSetCPF() {
        anunciante.setCPF("987.654.321-00");
        Assertions.assertEquals("987.654.321-00", anunciante.getCPF());
    }

    @Test
    public void testGetAnuncios() {
        ArrayList<AnuncioBean> expectedAnuncios = new ArrayList<>(Arrays.asList(anuncio1, anuncio2));
        Assertions.assertEquals(expectedAnuncios, anunciante.getAnuncios());
    }

    @Test
    public void testSetAnuncios() {
        ArrayList<AnuncioBean> novosAnuncios = new ArrayList<>(Arrays.asList(anuncio1));
        anunciante.setAnuncios(novosAnuncios);
        Assertions.assertEquals(novosAnuncios, anunciante.getAnuncios());
    }

    @Test
    public void testAddAnuncio() throws MalformedURLException {
        ArrayList<URL> fotosUrl3 = new ArrayList<>(Arrays.asList(
                new URL("http://www.foto5.com.br"),
                new URL("http://www.foto6.com.br")
        ));
        ProdutoBean produto3 = new ProdutoBean("003", "Produto C", "Descricao do Produto C", 30.0, "Novo");
        AnuncioBean novoAnuncio = new AnuncioBean(produto3, fotosUrl3, 0.15);

        anunciante.addAnuncio(novoAnuncio);
        Assertions.assertTrue(anunciante.getAnuncios().contains(novoAnuncio));
    }

    @Test
    public void testRemoveAnuncio() {
        anunciante.removeAnuncio(0);
        Assertions.assertFalse(anunciante.getAnuncios().contains(anuncio1));
    }

    @Test
    public void testValorMedioAnuncios() {
        double expectedValue = (anuncio1.getValor() + anuncio2.getValor()) / 2;
        Assertions.assertEquals(expectedValue, anunciante.valorMedioAnuncios());
    }
}
