import beans.ProdutoBean;
import org.junit.jupiter.api.*;


class ProdutoBeanTest {

    private static ProdutoBean produto;

    @BeforeEach
    public void setUp() {
        produto = new ProdutoBean("001", "Produto A", "Descricao do Produto A", 10.0, "Novo");
    }

    @AfterEach
    public void tearDown() {
        produto = null;
    }

    @Test
    public void testGetCodigo() {
        Assertions.assertEquals("001", produto.getCodigo());
    }

    @Test
    public void testSetCodigo() {
        produto.setCodigo("002");
        Assertions.assertEquals("002", produto.getCodigo());
    }

    @Test
    public void testGetName(){
        Assertions.assertEquals("Produto A", produto.getNome());
    }

    @Test
    public void testSetName(){
        produto.setNome("Produto B");
        Assertions.assertEquals("Produto B", produto.getNome());
    }

    @Test
    public void testGetDescricao() {
        Assertions.assertEquals("Descricao do Produto A", produto.getDescricao());
    }

    @Test
    public void testSetDescricao() {
        produto.setDescricao("Descricao do Produto B");
        Assertions.assertEquals("Descricao do Produto B", produto.getDescricao());
    }

    @Test
    public void testGetValor(){
        Assertions.assertEquals(10.0, produto.getValor());
    }

    @Test
    public void testSetValor(){
        produto.setValor(13.0);
        Assertions.assertEquals(13.0, produto.getValor());
    }

    @Test
    public void testGetSerialversionuid() {
        Assertions.assertEquals(1L, ProdutoBean.getSerialversionuid());
    }

    @Test
    @DisplayName("Test compareTo equal")
    public void testCompareToEqual() {
        ProdutoBean outroProduto = new ProdutoBean("002", "Produto B", "Descricao do Produto B", 10.0, "Novo");
        Assertions.assertEquals(0, produto.compareTo(outroProduto));
    }

    @Test
    @DisplayName("Test compareTo greater than")
    public void testCompareToGreaterThan() {
        ProdutoBean outroProduto = new ProdutoBean("002", "Produto B", "Descricao do Produto B", 5.0, "Novo");
        Assertions.assertTrue(produto.compareTo(outroProduto) > 0);
    }

    @Test
    @DisplayName("Test compareTo less than")
    public void testCompareToLessThan() {
        ProdutoBean outroProduto = new ProdutoBean("002", "Produto B", "Descricao do Produto B", 15.0, "Novo");
        Assertions.assertTrue(produto.compareTo(outroProduto) < 0);
    }
}