package com.dolap.backend.ecommercesite.application.controller;

import com.dolap.backend.ecommercesite.domain.product.command.AddProductCommand;
import com.dolap.backend.ecommercesite.domain.product.presentation.AddProductResponse;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final CommandGateway commandGateway;

    private final QueryGateway queryGateway;

    public ProductController(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity> add(@RequestBody AddProductCommand command) {
        CompletableFuture<AddProductResponse> task = commandGateway.send(command);

        return task.thenApply(ResponseEntity::ok);
    }

}
