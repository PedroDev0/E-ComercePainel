INSERT INTO produto (id, descricao, preco_compra, preco_venda, data_cadastro) VALUES
(1, 'Bicicleta', 20.00, 20.00, CURRENT_TIMESTAMP ),
(2, 'tablet', 20.00, 20.00, CURRENT_TIMESTAMP ),
(3, 'carroça', 20.00, 20.00, CURRENT_TIMESTAMP),
(4, 'carro', 20.00, 20.00, CURRENT_TIMESTAMP);

INSERT INTO produto_imagem (id, produto_id, principal, uri_imagem) VALUES
(1, 1, true, 'https://media.istockphoto.com/id/1947380208/pt/foto/new-bicycle-isolated.jpg?s=2048x2048&w=is&k=20&c=5GO_GQIdXze_MIbyLNTxEVZvaEhdqErGAjfnNt-_mMA='),  
(2, 1, false, 'https://media.istockphoto.com/id/1344641295/pt/foto/new-mountain-bicycle-with-29-inches-wheels-and-blue-frame-isolated-on-white-background.jpg?s=2048x2048&w=is&k=20&c=ycEpwFrpVBQl-EFBrkBilQri9LNQEeH9c9Bv91XK_rY='), 
(3, 2, true, 'https://media.istockphoto.com/id/1349192951/pt/foto/black-and-white-tablets-on-white.jpg?s=2048x2048&w=is&k=20&c=lwFAK0a0nqNKj-RWSViaoeY_6hTg_0GxobvwGqgwXSc='),     -- Imagem principal para o Tablet
(4, 3, true, 'https://media.istockphoto.com/id/178729911/pt/foto/carro.jpg?s=612x612&w=0&k=20&c=7dCgF2XY6wrjLh5xeK8MQ2Elb_C-3p0g6g5FO5cn2hQ='),    -- Imagem principal para a Carroça
(5, 4, true, 'https://media.istockphoto.com/id/1348050852/pt/foto/honda-city.jpg?s=2048x2048&w=is&k=20&c=JI-dhOW_H-bO_xnxEDzA13EYd2CcWd6w0FaW6dKmTqY='),      -- Imagem principal para o Carro
(6, 4, false, 'https://media.istockphoto.com/id/1443466199/pt/foto/home-residential-building-complex-with-street-car-parking.jpg?s=2048x2048&w=is&k=20&c=ejQc8GOBQZgYIZiXt2rtaFrCdNlD-wrdGnCxvPKLiMU=');

ALTER TABLE produto ALTER COLUMN ID RESTART WITH 5;

ALTER TABLE produto_imagem ALTER COLUMN ID RESTART WITH 7;