package com.dolap.backend.ecommercesite.application.controller;

import com.dolap.backend.ecommercesite.domain.constants.ResponseModel;
import com.dolap.backend.ecommercesite.domain.seller.command.AddSellerCommand;
import com.dolap.backend.ecommercesite.domain.seller.query.FindByUsernameQuery;
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

    @GetMapping("/{username}")
    public CompletableFuture<ResponseEntity> findByUsername(@PathVariable String username) {
        CompletableFuture<ResponseModel> task = queryGateway.query(new FindByUsernameQuery(username), ResponseModel.class);

        return task.thenApply(ResponseEntity::ok);
    }

}
