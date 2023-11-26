use groceryApp;

CREATE TABLE productDetails(
    productId BIGINT not null,
    productName VARCHAR(255),
    productDescription VARCHAR(5000),
    productPrice DOUBLE,
    productQuantity INT,
    productImage VARCHAR(255),
    PRIMARY KEY (productId)
);