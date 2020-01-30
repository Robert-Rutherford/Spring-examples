drop database if exists springBlog_db;

show databases;
use springBlog_db;

# CREATE TABLE `dogs` (
#                         `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
#                         `age` tinyint(3) unsigned NOT NULL,
#                         `name` varchar(200) NOT NULL,
#                         `reside_state` char(2) DEFAULT 'XX',
#                         PRIMARY KEY (`id`),
#                         UNIQUE KEY `UK_?????????????????` (`age`)
# ) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO dogs (age, name, reside_state)
VALUES
(2, 'Chuck', 'TX'),
(5, 'Fred', 'OH'),
(3, 'Bud', 'TN'),
(10, 'Bailey', 'AL'),
(11, 'Lexie', 'TX'),
(1, 'Snickers', 'TX'),
(6, 'Red', 'FL'),
(8, 'Barney', 'CA'),
(12, 'Bowser', 'TX');

SHOW CREATE TABLE dogs;

INSERT INTO posts_details (history_of_post, is_awesome, topic_description) VALUES
('5 updates',true,'first post to site'),
('10 updates',true,'second post to site'),
('3 updates',false,'third post to site'),
('1 updates',true,'fourth post to site'),
('30 updates',false,'fifth post to site');

INSERT INTO users (email, password, username) VALUES
('codeup@email.com','pass','deimos'),
('admin@email.com','password','admin');

INSERT INTO posts (body, title, post_details_id, user_id) VALUES
('post 1','this is the first post',1,1),
('post 2','this is the second post',2,1),
('post 3','this is the third post',3,1),
('post 4','this is the fourth post',4,2),
('post 5','this is the fifth post',5,2);




