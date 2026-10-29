-- Table order follows foreign-key dependencies:
-- category (no FKs)
-- products (FK -> category)
-- orders (no FKs)
-- order_products (FK -> products, orders)

CREATE TABLE category (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    created_at DATETIME(6) NOT NULL,
    updated_at DATETIME(6),
    deleted_at DATETIME(6),
    PRIMARY KEY (id),
    CONSTRAINT uk_category_name UNIQUE (name)
);

CREATE TABLE products (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    category_id BIGINT NOT NULL,
    ratings VARCHAR(255),
    image VARCHAR(255),
    created_at DATETIME(6) NOT NULL,
    updated_at DATETIME(6),
    deleted_at DATETIME(6),
    PRIMARY KEY (id),
    CONSTRAINT fk_products_category
        FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE orders (
    id BIGINT NOT NULL AUTO_INCREMENT,
    -- OrderStatus is persisted as an ordinal (PENDING=0, ACCEPTED=1, REJECTED=2)
    status TINYINT NOT NULL,
    created_at DATETIME(6) NOT NULL,
    updated_at DATETIME(6),
    deleted_at DATETIME(6),
    PRIMARY KEY (id)
);

CREATE TABLE order_products (
    id BIGINT NOT NULL AUTO_INCREMENT,
    product_id BIGINT NOT NULL,
    order_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    created_at DATETIME(6) NOT NULL,
    updated_at DATETIME(6),
    deleted_at DATETIME(6),
    PRIMARY KEY (id),
    CONSTRAINT fk_order_products_product
        FOREIGN KEY (product_id) REFERENCES products (id),
    CONSTRAINT fk_order_products_order
        FOREIGN KEY (order_id) REFERENCES orders (id)
);
