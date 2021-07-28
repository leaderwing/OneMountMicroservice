DROP TABLE IF EXISTS user_activity;

CREATE TABLE `user_activity` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `action` varchar(80) NOT NULL,
  `user_id` BIGINT(20) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `login_time` timestamp  NULL
);

