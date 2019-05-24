create table question
(
	id int AUTO_INCREMENT,
	title varchar(50) null,
	description TEXT null,
	gmt_create BIGINT null,
	gmt_modified BIGINT null,
	creator int null,
	comment_count int default 0 null,
	view_count int default 0 null,
	like_count int default 0 null,
	tag varchar(255) null,
	constraint question_pk
		primary key (id)
);

