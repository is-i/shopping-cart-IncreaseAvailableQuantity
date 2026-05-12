package isi.shoppingCart.usecases.services;

import isi.shoppingCart.entities.*;
import isi.shoppingCart.usecases.dto.OperationResult;
import isi.shoppingCart.usecases.ports.CartRepository;
import isi.shoppingCart.usecases.ports.CustomerRepository;
import isi.shoppingCart.usecases.ports.ProductRepository;
import isi.shoppingCart.usecases.ports.PurchaseRepository;

import java.util.List;

public class IncreaseAvailableQuantityUseCase {
    private ProductRepository productRepository;

    public IncreaseAvailableQuantityUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public OperationResult execute(int productId) {
        Product product = productRepository.findById(productId);

        if (product == null ) {
            return OperationResult.fail("El producto no existe");
        }

        product.increaseAvailableQuantity(1);
        productRepository.save(product);

        return OperationResult.ok("El producto " + product.getName()  + " tiene ahora disponible(s) " + product.getAvailableQuantity() + " unidad(es) " );
    }
}
