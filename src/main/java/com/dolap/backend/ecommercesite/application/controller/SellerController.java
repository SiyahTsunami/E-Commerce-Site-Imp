package com.dolap.backend.ecommercesite.application.controller;

import com.dolap.backend.ecommercesite.domain.constants.ResponseModel;
import com.dolap.backend.ecommercesite.domain.seller.command.AddSellerCommand;
import com.dolap.backend.ecommercesite.domain.seller.query.FindBySellerIdQuery;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/seller")
public class SellerController {

    private final CommandGateway commandGateway;

    private final QueryGateway queryGateway;

    @Autowired
    public SellerController(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity> addSeller(@Valid @RequestBody AddSellerCommand command) {
        CompletableFuture<ResponseModel> task = commandGateway.send(command);

        return task.thenApply(ResponseEntity::ok);
    }

    @GetMapping("/{sellerId}")
    public CompletableFuture<ResponseEntity> findByProductId(@PathVariable String sellerId) {
        CompletableFuture<ResponseModel> task = queryGateway.query(new FindBySellerIdQuery(sellerId), ResponseModel.class);

        return task.thenApply(ResponseEntity::ok);
    }

}
