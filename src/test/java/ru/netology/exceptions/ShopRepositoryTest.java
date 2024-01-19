package ru.netology.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveExistingProductById() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "spoon", 10);
        Product product2 = new Product(57, "fork", 12);
        Product product3 = new Product(19, "knife", 78);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(11);

        Product[] expected = {product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNullProductById() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "spoon", 10);
        Product product2 = new Product(57, "fork", 12);
        Product product3 = new Product(19, "knife", 78);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(12);
        });
    }
}