
/* Drop Tables */

DROP TABLE work_product;




/* Create Tables */

CREATE TABLE work_product
(
	id varchar2(64) NOT NULL,
	name nvarchar2(255) NOT NULL,
	price number(10,2),
	create_by varchar2(64) NOT NULL,
	create_date date NOT NULL,
	update_by varchar2(64) NOT NULL,
	update_date date NOT NULL,
	remarks nvarchar2(255),
	del_flag char(1) DEFAULT '0' NOT NULL,
	saler varchar2(64),
	PRIMARY KEY (id)
);



/* Comments */

COMMENT ON TABLE work_product IS '产品表';
COMMENT ON COLUMN work_product.id IS '编号';
COMMENT ON COLUMN work_product.name IS '名称';
COMMENT ON COLUMN work_product.price IS '价格';
COMMENT ON COLUMN work_product.create_by IS '创建者';
COMMENT ON COLUMN work_product.create_date IS '创建时间';
COMMENT ON COLUMN work_product.update_by IS '更新者';
COMMENT ON COLUMN work_product.update_date IS '更新时间';
COMMENT ON COLUMN work_product.remarks IS '备注信息';
COMMENT ON COLUMN work_product.del_flag IS '删除标记';
COMMENT ON COLUMN work_product.saler IS '销售员';



