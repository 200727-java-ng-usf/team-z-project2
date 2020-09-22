create  table mall_users_roles(

role_id			serial			primary key,
role_name		varchar(10)  	not null

)

create table hat_genres(

genre_id 		serial 			primary key,
genre_name		varchar(20)		unique not null

)

create table mall_users(

user_id 		serial 			primary key,
username     	varchar(25) 	unique not null,
password        varchar(256)	not null,
firstname		varchar(25)		not null,	
lastname		varchar(25)		not null,
email			varchar(256)	not null,
role_id			int				not null	references mall_users_roles(role_id)

)


create table item_hats(

item_id				serial 			 primary key,
item_name			varchar(25)		 not null,
item_price			numeric(6,2)	 not null,
item_stock			int				 not null,
description			text,
item_image_url		varchar(256),	 
genre_id 			int				 not null		references hat_genres(genre_id)

)





create table mall_user_orders(

user_order_id		serial 		 	 primary key,
time_created		timestamp		 not null,
user_id				int				 not null		references mall_users(user_id),
item_id	            int              not null       references item_hats(item_id),
item_count			int				 not null
)

commit;
