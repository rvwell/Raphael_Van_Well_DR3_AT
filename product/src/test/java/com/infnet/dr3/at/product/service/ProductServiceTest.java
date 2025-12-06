package com.infnet.dr3.at.product.service;

import com.infnet.dr3.at.product.domain.model.Product;
import com.infnet.dr3.at.product.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product(1L, "Notebook Gamer", 5000.0);
    }

    @Test
    void testFindAll() {
        List<Product> products = Arrays.asList(
                product,
                new Product(2L, "Mouse Wireless", 100.0)
        );
        when(repository.findAll()).thenReturn(products);

        List<Product> result = service.findAll();

        assertEquals(2, result.size());
    }

    @Test
    void testFindById() {
        when(repository.findById(1L)).thenReturn(Optional.of(product));

        Product result = service.findById(1L);

        assertEquals(1L, result.getId());
    }

    @Test
    void testFindByIdNotFound() {
        when(repository.findById(999L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.findById(999L);
        });

        assertEquals("Produto não encontrado", exception.getMessage());
    }

    @Test
    void testSave() {
        Product newProduct = new Product(null, "Teclado Mecânico", 300.0);
        Product savedProduct = new Product(3L, "Teclado Mecânico", 300.0);
        when(repository.save(any(Product.class))).thenReturn(savedProduct);

        Product result = service.save(newProduct);

        assertEquals(3L, result.getId());
    }

    @Test
    void testUpdate() {
        Product existingProduct = new Product(1L, "Notebook Gamer", 5000.0);
        Product updatedData = new Product(null, "Notebook Gamer Pro", 5500.0);
        Product updatedProduct = new Product(1L, "Notebook Gamer Pro", 5500.0);

        when(repository.findById(1L)).thenReturn(Optional.of(existingProduct));
        when(repository.save(any(Product.class))).thenReturn(updatedProduct);

        Product result = service.update(1L, updatedData);

        assertEquals("Notebook Gamer Pro", result.getName());
    }

    @Test
    void testDelete() {
        when(repository.findById(1L)).thenReturn(Optional.of(product));
        doNothing().when(repository).delete(any(Product.class));

        service.delete(1L);

        verify(repository, times(1)).delete(any(Product.class));
    }

    @Test
    void testDeleteNotFound() {
        when(repository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            service.delete(999L);
        });

        verify(repository, never()).delete(any(Product.class));
    }

    @Test
    void testInitDataWhenRepositoryIsEmpty() {
        when(repository.count()).thenReturn(0L);
        when(repository.saveAll(anyList())).thenReturn(Arrays.asList(
                new Product(1L, "Notebook Gamer", 5000.0),
                new Product(2L, "Mouse Wireless", 100.0)
        ));

        service.initData();

        verify(repository, times(1)).saveAll(anyList());
    }

    @Test
    void testInitDataWhenRepositoryIsNotEmpty() {
        when(repository.count()).thenReturn(2L);

        service.initData();

        verify(repository, never()).saveAll(anyList());
    }
}

