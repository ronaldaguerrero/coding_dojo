package com.codingdojo.monopoly.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="players")
public class Player {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	// fix validations
    @Size(min=1, message="Name must be present")
    private String name;
    private Integer money;
    private Integer token;
    private Integer position;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "purchases", 
        joinColumns = @JoinColumn(name = "player_id"), 
        inverseJoinColumns = @JoinColumn(name = "property_id")
    )
    private List<Property> properties; 

	public Player() {
    }
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public Integer getToken() {
		return token;
	}

	public void setToken(Integer token) {
		this.token = token;
	}
	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
        this.money = 1500;
        this.position = 1;
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
