
DROP TABLE IF EXISTS order_item;

CREATE TABLE order_item (
	id bigserial NOT NULL,
	order_id int8 NOT NULL,
	product_code varchar(200) NULL,
	product_name varchar(200) NULL,
	quantity numeric NULL,
	CONSTRAINT order_item_pkey PRIMARY KEY (id)
);
