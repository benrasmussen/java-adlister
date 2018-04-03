USE adlister_db;

INSERT INTO users (username, email, password) VALUES
('benr', 'benrasmussen11@gmail.com', 123456),
('chrisa', 'chrisa@gmail.com', 654321);

INSERT INTO ads (user_id, title, description) VALUES
(1, 'new car for sale', 'drives great 110k miles'),
(2, 'nice oak desk', '145lbs super nice desk');