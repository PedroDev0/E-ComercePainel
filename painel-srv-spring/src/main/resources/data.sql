INSERT INTO produto (id, descricao, preco_compra, preco_venda, data_cadastro) VALUES
(1, 'Bicicleta', 20.00, 20.00, CURRENT_TIMESTAMP ),
(2, 'tablet', 20.00, 20.00, CURRENT_TIMESTAMP ),
(3, 'carroça', 20.00, 20.00, CURRENT_TIMESTAMP),
(4, 'carro', 20.00, 20.00, CURRENT_TIMESTAMP);

INSERT INTO produto_imagem (id, produto_id, principal, uri_imagem) VALUES
(1, 1, true, 'bicicleta1.jpg'),  
(2, 1, false, 'bicicleta2.jpg'), 
(3, 2, true, 'tablet1.jpg'),     -- Imagem principal para o Tablet
(4, 3, true, 'carroca1.jpg'),    -- Imagem principal para a Carroça
(5, 4, true, 'carro1.jpg'),      -- Imagem principal para o Carro
(6, 4, false, 'carro2.jpg'); 