package com.dolap.backend.ecommercesite.application.controller;

import com.dolap.backend.ecommercesite.contracts.models.ResponseModel;
import com.dolap.backend.ecommercesite.domain.product.command.AddProductCommand;
import com.dolap.backend.ecommercesite.domain.product.command.DeleteProductCommand;
import com.dolap.backend.ecommercesite.domain.product.command.UpdateProductCommand;
import com.dolap.backend.ecommercesite.domain.product.constants.ProductCategoryEnum;
import com.dolap.backend.ecommercesite.domain.product.query.FindByCategoryQuery;
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
        CompletableFuture<ResponseModel> task = queryGateway.query(new FindByProductIdQuery(productId), ResponseModel.class);

        return task.thenApply(ResponseEntity::ok);
    }

    @GetMapping("cagetory/{category}")
    public CompletableFuture<ResponseEntity> findByCategory(@PathVariable ProductCategoryEnum category,
                                                            @RequestParam(defaultValue = "1", required = false) int pageNo,
                                                            @RequestParam(defaultValue = "100", required = false) int pageSize) {
        FindByCategoryQuery query = new FindByCategoryQuery(category, pageNo, pageSize);

        CompletableFuture<ResponseModel> task = queryGateway.query(query, ResponseModel.class);

        return task.thenApply(ResponseEntity::ok);
    }

}
