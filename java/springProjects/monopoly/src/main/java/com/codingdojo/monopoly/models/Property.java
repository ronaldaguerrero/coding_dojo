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
@Table(name="properties")
public class Property {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer price;
	private Integer rent;
	private Integer houses;
	private String mortgaged;
	private Integer mortgagedValue;
	private String color;
	private Integer position;
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "purchases", 
        joinColumns = @JoinColumn(name = "property_id"), 
        inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private List<Player> players;
    
    public Property() {
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getRent() {
		return rent;
	}

	public void setRent(Integer rent) {
		this.rent = rent;
	}

	public Integer getHouses() {
		return houses;
	}

	public void setHouses(Integer houses) {
		this.houses = houses;
	}

	public String getMortgaged() {
		return mortgaged;
	}

	public void setMortgaged(String mortgaged) {
		this.mortgaged = mortgaged;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getMortgagedValue() {
		return mortgagedValue;
	}

	public void setMortgagedValue(Integer mortgagedValue) {
		this.mortgagedValue = mortgagedValue;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
