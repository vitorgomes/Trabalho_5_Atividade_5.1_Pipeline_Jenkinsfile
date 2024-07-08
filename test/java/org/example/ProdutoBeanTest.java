package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProdutoBeanTest {
    private static ProdutoBean produto;

    ProdutoBeanTest() {
    }

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
}
