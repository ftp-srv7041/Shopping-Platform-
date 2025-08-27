// entity/Order.java
package com.ecom.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.List;
@Data
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    @DBRef
    private User user;
    private List<Product> products;
    private Double totalAmount;
    private String status;
    private LocalDate orderDate = LocalDate.now();
    private String shippingAddress;
}