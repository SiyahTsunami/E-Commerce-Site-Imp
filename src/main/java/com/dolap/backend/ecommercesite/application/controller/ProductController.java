package com.dolap.backend.ecommercesite.application.controller;

import com.dolap.backend.ecommercesite.domain.product.Product;
import com.dolap.backend.ecommercesite.domain.product.commands.AddProductCommand;
import com.dolap.backend.ecommercesite.domain.product.commands.DeleteProductCommand;
import com.dolap.backend.ecommercesite.domain.product.commands.UpdateProductCommand;
import com.dolap.backend.ecommercesite.domain.product.presentation.AddProductResponse;
import com.dolap.backend.ecommercesite.domain.product.query.FindByProductIdQuery;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final CommandGateway commandGateway;

    private final QueryGateway queryGateway;

    @Autowired
    public ProductController(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity> addProduct(@Valid @RequestBody AddProductCommand command) {
        CompletableFuture<AddProductResponse> task = commandGateway.send(command);

        return task.thenApply(ResponseEntity::ok);
    }

    @PutMapping("/{productId}")
    public CompletableFuture<ResponseEntity> updateProduct(@RequestBody UpdateProductCommand command, @PathVariable long productId) {
        command.setId(productId);

        CompletableFuture<Void> task = commandGateway.send(command);

        return task.thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{productId}")
    public CompletableFuture<ResponseEntity> deleteProduct(@RequestBody DeleteProductCommand command, @PathVariable long productId) {
        command.setId(productId);

        CompletableFuture<Void> task = commandGateway.send(command);

        return task.thenApply(ResponseEntity::ok);
    }

    @GetMapping("/{productId}")
    public CompletableFuture<ResponseEntity<Product>> findByProductId(@PathVariable long productId) {
        FindByProductIdQuery query = new FindByProductIdQuery(productId);

        CompletableFuture<Product> parcel = queryGateway.query(query, Product.class);

        return parcel.thenApply(ResponseEntity::ok);
    }

}
