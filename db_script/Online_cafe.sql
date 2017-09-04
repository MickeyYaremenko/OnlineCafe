
CREATE DATABASE IF NOT EXISTS `cafe`
USE `cafe`;

CREATE TABLE IF NOT EXISTS `bill` (
  `id_order` int(11) DEFAULT NULL,
  `order_sum` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT IGNORE INTO `bill` (`id_order`, `order_sum`) VALUES

CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `balance` decimal(10,2) DEFAULT '0.00',
  `role` enum('client','admin') DEFAULT 'client',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT IGNORE INTO `client` (`id`, `login`, `password`, `first_name`, `last_name`, `email`, `balance`, `role`) VALUES
	(1, 'user', 'user', 'Mike', 'Yaremenko', 'x@mail.com', 100.00, 'admin'),
	(2, 'qwe', 'qW1', 'Awe', 'qwe', 'qwe@qwe.com', 1517.80, 'client');

CREATE TABLE IF NOT EXISTS `items_menu` (
  `menu_id` int(11) DEFAULT NULL,
  `menu_item_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT IGNORE INTO `items_menu` (`menu_id`, `menu_item_id`) VALUES
	(1, 35),
	(1, 37),
	(1, 39),
	(1, 41),
	(1, 43),
	(1, 44),
	(1, 1),
	(1, 2),
	(1, 4),
	(1, 5),
	(1, 6),
	(1, 27),
	(1, 29),
	(1, 30),
	(2, 34),
	(2, 36),
	(2, 38),
	(2, 40),
	(2, 42),
	(2, 45),
	(2, 7),
	(2, 9),
	(2, 31),
	(2, 32),
	(2, 33),
	(2, 25),
	(2, 26),
	(2, 28);

CREATE TABLE IF NOT EXISTS `menu` (
  `menu_id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `creation_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` enum('ACTIVE','IDLE') NOT NULL DEFAULT 'IDLE',
  `language` enum('RU_RU','EN_EN') NOT NULL DEFAULT 'EN_EN',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT IGNORE INTO `menu` (`menu_id`, `creation_time`, `status`, `language`) VALUES
	(00000000001, '2017-07-19 03:21:20', 'ACTIVE', 'EN_EN'),
	(00000000002, '2017-07-25 03:03:50', 'ACTIVE', 'RU_RU');

CREATE TABLE IF NOT EXISTS `menu_item` (
  `id_menu_item` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `title` varchar(60) NOT NULL DEFAULT '0',
  `weight` varchar(50) NOT NULL DEFAULT '0',
  `price` decimal(10,2) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `description` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id_menu_item`),
  UNIQUE KEY `title_UNIQUE` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

INSERT IGNORE INTO `menu_item` (`id_menu_item`, `title`, `weight`, `price`, `category`, `description`) VALUES
	(00000000001, 'Pancakes', '225/50g', 18.50, 'hot', 'Sweet panckakes with honey and jam'),
	(00000000002, 'Chicken breast with cheese and bacon', '175/25/25/25g', 19.00, 'hot', 'Chicken fingers, Ricotta cheese, blue cheese, bacon, cherry tomato, cauliflower au gratin'),
	(00000000004, 'Beef with rice and vegetables', '225/150/150g', 25.50, 'hot', 'Grilled beef with risotto rice, braised tomatoes, cucumbers, pepper'),
	(00000000005, 'Salmon steak', '200/150g', 35.50, 'hot', 'Salmon steak baked with white mushrooms, eggplant, tomatoes and pesto sauce'),
	(00000000006, 'Jack Daniels chicken', '160/170/120/30g', 12.90, 'hot', 'Two glazed chicken slices with potato puree and vegetables'),
	(00000000007, 'Блинчики', '225/50г', 18.50, 'hot', 'Вкусные блинчики с мёдом и джемом'),
	(00000000009, 'Стейк из лосося', '200/150г', 35.50, 'hot', 'Стейк из лосося, с грибами, баклажанами, томатами, соусом песто'),
	(00000000025, 'Латте с сиропом', '250г', 3.00, 'drink', 'Латте с сиропом в ассортименте'),
	(00000000026, 'Молочный улун', '200г', 2.00, 'drink', 'Молочный улун'),
	(00000000027, 'Juice Rich', '200g', 1.50, 'drink', 'Juices Rich in assortment'),
	(00000000028, 'Сок Rich', '200г', 1.50, 'drink', 'Соки Rich в ассортименте'),
	(00000000029, 'Latte with syrup', '250g', 3.00, 'drink', 'Latte with syrup in assortment'),
	(00000000030, 'Milky oolong tea', '200g', 2.00, 'drink', 'Milky oolong tea'),
	(00000000031, 'Куриная грудка с беконом и сыром', '175/25/25/25г', 19.00, 'hot', 'Куриное филе, сыр Рикотто, бекон, томаты черри, цветная капуста в кляре'),
	(00000000032, 'Говядина с рисом и овощами', '225/150/150г', 25.50, 'hot', 'Запеченная говядина с рисом ризотто, тушеными томатами, огурцами и перцем'),
	(00000000033, 'Курица "Jack Daniels"', '160/170/120/30г', 12.90, 'hot', 'Два кусочка крицы в глазури с картофельным пюре и овощами'),
	(00000000034, 'Салат цезарь', '230г', 6.00, 'salad', 'Зеленый салат с сыром пармезан, гренками и соусом "Цезарь"'),
	(00000000035, 'Caesar salad', '230g', 6.00, 'salad', 'Green salad with parmezan cheese toasts and "Caesar" souce'),
	(00000000036, 'Греческий салат', '275г', 7.00, 'salad', 'Салат из свежих огурцов, помидоров, перца, маслин, сыра фета, яйца с оливковым маслом'),
	(00000000037, 'Greek salad', '275g', 7.00, 'salad', 'Fresh salad, cucmbers, tomatoes, pepper, black olives, Feta cheese, egg with olive oil '),
	(00000000038, 'Томатный суп', '300г', 5.00, 'soup', 'Тотмантый крем-суп с базиликом и овозами'),
	(00000000039, 'Tomatto soup', '300g', 5.00, 'soup', 'Tomatto cream soup with basil and vegetables'),
	(00000000040, 'Грибной суп', '300г', 5.50, 'soup', 'Суп с белыми грибами и ломтиками говядины'),
	(00000000041, 'Mushroom soup', '300g', 5.50, 'soup', 'Soup with porcini mushrooms and beef slices'),
	(00000000042, 'Суп с морепродуктами', '250г', 6.00, 'soup', 'Суп с креветками, осьминожками, филе семги, свежим перцем и укропом'),
	(00000000043, 'Seafood soup', '250g', 6.00, 'soup', 'Soup with shrimps, octopuses, salmon fillet, fresh pepper and fennel'),
	(00000000044, 'Focaccia', '280g', 1.50, 'appetizier', 'Journey-cake with basil pesto'),
	(00000000045, 'Фокачча', '280г', 1.50, 'appetizier', 'Лепешка с базиликовым песто');

CREATE TABLE IF NOT EXISTS `order` (
  `id_order` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `id_client` int(11) DEFAULT NULL,
  `order_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `order_status` enum('ON_APPROVAL','COOKING','READY','SERVED') NOT NULL DEFAULT 'ON_APPROVAL',
  PRIMARY KEY (`id_order`),
  UNIQUE KEY `id_order_UNIQUE` (`id_order`),
  KEY `id_client_idx` (`id_client`),
  CONSTRAINT `id_client` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

INSERT IGNORE INTO `order` (`id_order`, `id_client`, `order_date`, `order_status`) VALUES
	(00000000026, 2, '2017-07-17 23:24:39', 'ON_APPROVAL'),
	(00000000027, 2, '2017-07-18 19:54:54', 'COOKING'),
	(00000000028, 2, '2017-07-18 19:58:56', 'ON_APPROVAL'),
	(00000000029, 2, '2017-07-21 03:32:16', 'SERVED'),
	(00000000038, 2, '2017-08-24 18:52:16', 'ON_APPROVAL'),
	(00000000039, 2, '2017-08-24 21:53:34', 'ON_APPROVAL'),
	(00000000040, 2, '2017-09-02 03:00:10', 'ON_APPROVAL'),
	(00000000041, 2, '2017-09-04 03:54:46', 'ON_APPROVAL');

CREATE TABLE IF NOT EXISTS `order_menu_item` (
  `id_menu_item` int(11) DEFAULT NULL,
  `id_order` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT IGNORE INTO `order_menu_item` (`id_menu_item`, `id_order`, `quantity`) VALUES
	(2, 7, 7),
	(1, 7, 1),
	(1, 8, 5),
	(2, 9, 6),
	(2, 10, 7),
	(2, 11, 7),
	(2, 12, 7),
	(2, 13, 4),
	(2, 14, 6),
	(2, 15, 1),
	(2, 16, 2),
	(1, 16, 2),
	(2, 17, 3),
	(1, 17, 2),
	(2, 18, 1),
	(1, 18, 4),
	(2, 19, 3),
	(1, 19, 5),
	(2, 20, 5),
	(1, 20, 14),
	(2, 22, 2),
	(1, 22, 6),
	(1, 23, 9),
	(1, 24, 4),
	(4, 24, 8),
	(2, 25, 5),
	(1, 25, 3),
	(2, 26, 10),
	(1, 26, 3),
	(5, 26, 2),
	(4, 26, 2),
	(1, 27, 3),
	(5, 28, 2),
	(2, 29, 2),
	(1, 30, 4),
	(2, 31, 2),
	(1, 32, 1),
	(1, 33, 1),
	(1, 34, 1),
	(1, 35, 1),
	(1, 36, 1),
	(1, 37, 1),
	(1, 38, 1),
	(2, 39, 1),
	(26, 40, 2),
	(7, 41, 2);