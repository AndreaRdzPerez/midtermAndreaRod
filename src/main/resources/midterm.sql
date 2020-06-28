create schema midterm_test;
use midterm_test;

create schema midterm;
use midterm;

INSERT INTO address (id, city, postal_code, street) VALUES
	(21, "Ourense", "33009", "Avenida de Buenos Aires"),
    (22, "Vigo", "45009", "Rúa de Compostela"),
    (23, "Lugo", "67999", "Rúa Real"),
    (24, "Santiago", "32500", "Rúa Rosalía de Castro"),
    (25, "A Coruña", "23008", "Avenida de Galicia"),
    (26, "Tarragona", "37998", "Carrer de les Coques"); 
    
     INSERT INTO user (id, password, username) VALUES
    (31, "$2a$10$QjUQjou2cyWTkeLJD2biB..jMr0rukHcupQm2CK7/lDTiJ/K5F9rm", "user1"),
    (32, "$2a$10$dSTn7k11eUO42F.8xXcLh.gDTtWygF50qJR06/8qFRGVDqLI4pdZS", "user2"),
    (33, "$2a$10$dSTn7k11eUO42F.8xXcLh.gDTtWygF50qJR06/8qFRGVDqLI4pdZS", "user3"),
    (34, "$2a$10$dSTn7k11eUO42F.8xXcLh.gDTtWygF50qJR06/8qFRGVDqLI4pdZS", "user4"),
    (35, "$2a$10$c7WFJ70iS6f0/6LRbIxEQ.TyJRE/Dzp6N3r8XNnr0Om3oso1citDC", "admin"),
    (36, "$2a$10$qyGrjSK2lgmbB1wgtmoQxuPVr3S21mjf0wH2JRs1TwFkDfRytEx7u", "thirdParty");
    
    INSERT INTO account_holder (date_of_birth, name, user_id, mailing_address_id, primary_address_id) VALUES
	("2000-09-16", "Juan Cuesta", 31, 24, 21 ),
    ("2015-06-16", "Alexia Rodríguez", 32, 21, 21 ),
    ("2018-09-16", "Pau Gasol", 33, 26, 25 ),
    ("1985-07-03", "Patricia García", 34, 22, 22 );
    
    INSERT INTO admin (name, user_id) VALUES
	("George Brown", 35);
    
    INSERT INTO third_party (hashed_key, user_id) VALUES
	("h2sh3dK3yt3st", 36);
    
    INSERT INTO account (id, amount, currency, last_accessed_date, penalty_fee, status, primary_owner_user_id, secondary_owner_user_id) VALUES
	(41, 300, "USD", "2019-06-16", 40, 1, 31, null),
	(42, 400, "USD", "2019-11-16", 40, 1, 32, null),
	(43, 3000, "USD", "2019-06-16", 40, 1, 31, 33),
	(44, 4500, "USD", "2019-11-16", 40, 1, 34, null),
	(45, 5000, "USD", "2019-06-16", 40, 1, 31, null),
	(46, 6000, "USD", "2019-11-16", 40, 1, 34, null);
    
	INSERT INTO checking (minimum_balance, monthly_maintenance_fee, secret_key, account_id, primary_owner_user_id, secondary_owner_user_id) VALUES
	(250, 12, "checking1234", 41, 31, null);

    


    
    

