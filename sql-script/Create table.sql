
CREATE TABLE UserDetail(
	id int PRIMARY KEY NOT NULL auto_increment,
    first_name VARCHAR(25) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    dob date NOT NULL,
    email varchar(255) NOT NULL,
    profile_imageURL varchar(255) default NULL
)ENGINE=InnoDB AUTO_INCREMENT=1000;

CREATE TABLE `User` (
	User_Id CHAR(36) PRIMARY KEY NOT NULL,
    user_detail_id int unique,
    username varchar(50) UNIQUE NOT NULL,
    `password` varchar(255) NOT NULL,
    `status` ENUM('enabled', 'disabled') DEFAULT 'enabled',
    create_at timestamp default current_timestamp,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (user_detail_id) references UserDetail(id)
);

CREATE TABLE `Role` (
	role_id int primary key not null auto_increment,
    role_name ENUM('USER','ADMIN','MANAGER') not null default 'USER',
	User_Id CHAR(36) NOT NULL,
    foreign key (User_Id) REFERENCES User (User_Id)
)ENGINE=InnoDB AUTO_INCREMENT=100;

CREATE TABLE Category (
	category_id int primary key not null auto_increment, 
    name varchar(50) not null
)ENGINE=InnoDB AUTO_INCREMENT=200;

CREATE TABLE Subcategory (
	id int primary key not null auto_increment,
    category_id int not null,
    name varchar(50) not null,
    foreign key (category_id) references Category(category_id)
)ENGINE=InnoDB AUTO_INCREMENT=300;

CREATE TABLE Post (
	Post_Id BIGINT PRIMARY KEY NOT NULL,
    author_id CHAR(36) NOT NULL,
    category_id int NOT NULL,
    subcategory_id int NOT NULL,
    title varchar(50) NOT NULL,
    description TEXT NOT NULL,
    poster_image varchar(255) default NULL,
    `status` ENUM('pending', 'published') default 'pending',
    likes int, 
    dislike int,
    create_at timestamp default current_timestamp,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	foreign key (author_id) references User(User_Id),
    foreign key (category_id) references Category(category_id),
    foreign key (subcategory_id) references Subcategory(id)
);

CREATE TABLE PostSection(
	section_id int primary key not null auto_increment,
    post_id BIGINT NOT NULL, 
    `type` ENUM('H1', 'H2', 'H3','P','CODE','li','img','A','TABLE','TR','TD','TH','DIV','SPAN','HR','BR','EMBED','VIDEO','QUOTE','OL','UL') NOT NULL,
    content TEXT NOT NULL,
    position int NOT NULL,
    foreign key (post_id) references Post(Post_Id)
)ENGINE=InnoDB AUTO_INCREMENT=2000;

CREATE TABLE `Comment` (
	comment_id BIGINT primary key not null, 
    post_id BIGINT NOT NULL, 
    user_id CHAR(36) NOT NULL, 
    content TEXT NOT NULL,
    comment_at timestamp default current_timestamp,
    foreign key (post_id) references Post(Post_Id),
    foreign key (user_id) references User(User_Id)
);

CREATE TABLE Friend (
	id BIGINT PRIMARY KEY NOT NULL,
    user_id CHAR(36) NOT NULL, 
    friend_id CHAR(36) NOT NULL,
    `status` ENUM('pending','accepted','declined') default 'pending',
    request_at timestamp default current_timestamp,
    foreign key (user_id) references User(User_Id),
    foreign key (friend_id) references User(User_Id)
);

CREATE TABLE Notification (
	notification_id CHAR(36) PRIMARY KEY NOT NULL, 
    sender_id CHAR(36) NOT NULL,
    receiver_id CHAR(36) NOT NULL,
    content TEXT NOT NULL,
    `status` ENUM('READ', 'UNREAD') default 'UNREAD',
    create_at timestamp default current_timestamp,
    foreign key (sender_id) references User(User_Id),
    foreign key (receiver_id) references User(User_Id)
)ENGINE=InnoDB AUTO_INCREMENT=3000;





