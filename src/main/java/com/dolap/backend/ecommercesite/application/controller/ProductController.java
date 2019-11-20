package com.dolap.backend.ecommercesite.application.controller;

import com.dolap.backend.ecommercesite.domain.constants.ResponseModel;
import com.dolap.backend.ecommercesite.domain.product.commands.AddProductCommand;
import com.dolap.backend.ecommercesite.domain.product.commands.DeleteProductCommand;
import com.dolap.backend.ecommercesite.domain.product.commands.UpdateProductCommand;
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
        CompletableFuture<ResponseModel> task = commandGateway.send(command);

        return task.thenApply(ResponseEntity::ok);
    }

    @PutMapping("/{productId}")
    public CompletableFuture<ResponseEntity> updateProduct(@RequestBody UpdateProductCommand command, @PathVariable String productId) {
        command.setId(productId);

        CompletableFuture<Void> task = commandGateway.send(command);

        return task.thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{productId}")
    public CompletableFuture<ResponseEntity> deleteProduct(@PathVariable String productId) {
        CompletableFuture<Void> task = commandGateway.send(new DeleteProductCommand(productId));

        return task.thenApply(ResponseEntity::ok);
    }

    @GetMapping("/{productId}")
    public CompletableFuture<ResponseEntity> findByProductId(@PathVariable String productId) {
        FindByProductIdQuery query = new FindByProductIdQuery(productId);

        CompletableFuture<ResponseModel> task = queryGateway.query(query, ResponseModel.class);

        return task.thenApply(ResponseEntity::ok);
    }

}
