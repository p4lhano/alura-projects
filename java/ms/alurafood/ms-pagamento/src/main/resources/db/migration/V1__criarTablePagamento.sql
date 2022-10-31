CREATE TABLE pagamento (
 id bigint GENERATED ALWAYS AS IDENTITY,
 valor NUMERIC(10, 5) NOT NULL,
 nome varchar(100) ,
 numero varchar(19) ,
 expiracao varchar(7) ,
 codigo varchar(3) ,
 status varchar(50) NOT NULL,
 forma_de_pagamento_id bigint NOT NULL,
 pedido_id bigint NOT NULL,
PRIMARY KEY (id)
);