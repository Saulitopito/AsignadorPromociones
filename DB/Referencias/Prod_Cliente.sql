ALTER TABLE PROD_CLIENTE ADD CONSTRAINT FK_PROD_CLIENTE FOREIGN KEY (producto_id) REFERENCES PRODUCTOS(id);
ALTER TABLE PROD_CLIENTE ADD CONSTRAINT FK_CLIENTE_PROD FOREIGN KEY (cliente_id) REFERENCES CLIENTES(id);