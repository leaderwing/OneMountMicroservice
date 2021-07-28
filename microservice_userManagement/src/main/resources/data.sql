
DELETE FROM permissions_roles;
DELETE FROM permissions;
DELETE FROM users_roles;
DELETE FROM roles;

DELETE FROM contacts;
DELETE FROM addresses;
DELETE FROM users;

INSERT INTO permissions(id, permission, note) VALUES (1, 'LOGIN', 'User Login');
INSERT INTO permissions(id, permission, note) VALUES (2, 'VIEW_PROFILE', 'View user profile');
INSERT INTO permissions(id, permission, note) VALUES (3, 'ADMIN_USER_DATA', 'Manage user data');

INSERT INTO permissions(id, permission, note, enabled) VALUES (4, 'SUPER_ADMIN', 'Admin with highest permission', false);

INSERT INTO roles(id, role) VALUES (1, 'USER');
INSERT INTO roles(id, role) VALUES (2, 'ADMINISTRATOR');

INSERT INTO permissions_roles(permission_id, role_id) VALUES (1, 1);
INSERT INTO permissions_roles(permission_id, role_id) VALUES (2, 1);

INSERT INTO permissions_roles(permission_id, role_id) VALUES (1, 2);
INSERT INTO permissions_roles(permission_id, role_id) VALUES (2, 2);
INSERT INTO permissions_roles(permission_id, role_id) VALUES (3, 2);


INSERT INTO users(id, username, password, name, surname, gender) VALUES (1, 'Quynx', '1d/NZaEqNgtEomytAPrwm/+QjmbudLg33oeEk77Xh88=', 'Quynx', 'ngo', 0);
INSERT INTO users(id, username, password, name, surname, gender) VALUES (2, 'Quynx1', '1d/NZaEqNgtEomytAPrwm/+QjmbudLg33oeEk77Xh88=', 'Quynx1', 'xuan', 0);

INSERT INTO users_roles(user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles(user_id, role_id) VALUES (1, 2);
INSERT INTO users_roles(user_id, role_id) VALUES (2, 1);

INSERT INTO contacts(user_id, email, phone, note) VALUES (1, 'quyict.hut@gmail.com', NULL, NULL);
INSERT INTO contacts(user_id, email, phone, note) VALUES (2, 'quynx@gmail.com', NULL, 'test contact');

insert into addresses(user_id, address, address2, city, country, zip_code) values (2, 'P 2515 ', 'Thạch bàn', 'Hà Nội', 'Việt Nam', '10000');

