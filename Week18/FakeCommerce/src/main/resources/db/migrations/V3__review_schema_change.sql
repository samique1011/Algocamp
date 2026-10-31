ALTER TABLE reviews
ADD COLUMN order_id BIGINT,
ADD CONSTRAINT fk_constraint_name 
FOREIGN KEY (order_id) 
REFERENCES orders(id);