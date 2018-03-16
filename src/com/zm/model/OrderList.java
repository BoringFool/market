package com.zm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_orderlist")
public class OrderList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = false, nullable = false)
	private int id;
	@ManyToMany//　ManyToMany指定多对多的关联关系
    //因为多对多之间会通过一张中间表来维护两表直接的关系，所以通过 JoinTable 这个注解来声明，name就是
    //指定了中间表的名字，JoinColumns是一个 @JoinColumn类型的数组，表示的是我这方在对方中的外键名称，我
    //方是Course，所以在对方外键的名称就是 rid，inverseJoinColumns也是一个 @JoinColumn类型的数组，表示的
    //是对方在我这放中的外键名称，对方是Teacher，所以在我方外键的名称就是 tid
    @JoinTable(name="t_good_orderlist", joinColumns={ @JoinColumn(name="oid")}, 
    inverseJoinColumns={ @JoinColumn(name = "gid") })
	private Set<Goods> goods;

	public OrderList() {
		goods = new HashSet<Goods>();
	}

	public void addTeacher(Goods good) {
		goods.add(good);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Goods> getGoods() {
		return goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}

}
