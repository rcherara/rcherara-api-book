package ca.rcherara.api.book.domain;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 
 */
/**
 * @author rcherara
 *
 */
@Entity
@ApiModel(description = "Class representing all details about the book managed by the API.")

public class Book {

    @Id
    @NotNull
    @Column(name = "id", nullable = false, updatable = false)
    @ApiModelProperty(notes = "Unique identifier of the book. No two books can have the same id.", example = "1", required = true, position = 0)
    
    private Long id;

    @NotNull
    @Size(max = 64)
    @Column(name = "author", nullable = false)
    @ApiModelProperty(notes = "The author of the book.", example = "Jez Humble", required = true, position = 1)  
    private String author;

    @NotNull
    @Size(max = 64)
    @Column(name = "title", nullable = false)
    @ApiModelProperty(notes = "The title of the book.", example = "Continuous Delivery", required = true, position = 2)    
    private String title;
    
    @NotNull
    @Column(name = "year", nullable = true)
    @ApiModelProperty(notes = "The year of the book edition.", example = "2011", required = false, position = 3)      
    public int year;
    
    @NotNull
    @Size(max = 64)
    @Column(name = "publisher", nullable = true) 
    @ApiModelProperty(notes = "The publisher of the book.", example = "Kindle Edition", required = false, position = 4)        
    public String publisher;   
     
    @ApiModelProperty(notes = "The cost of the book.", example = "19.80", required = false, position = 5,access = "hidden")        
    @JsonIgnore
    @Column(name = "cost", nullable = true) 

    public double cost;
    
    @ApiModelProperty(notes = "The price of the book.", example = "28.12", required = false, position = 6)        
    @Column(name = "price", nullable = true) 
   
    double price;
    
    /**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	int option;
    

    public Book() {
    }

    public Book(final Long id, final String author, final String title) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.option=ThreadLocalRandom.current().nextInt(1, 7);
        this.cost=this.price-10;
        this.publisher="publisher";
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public double getPrice(){
        return price;
    }
    public int getOption(){
        return option;
    }
    public void setPrice(int option, double price, double newPrice){
        if (option == 1){
            price = 20.00;
            newPrice = price;
        }
        else if (option == 2){
            price = 15.00;
            newPrice = price;
        }
        else if (option == 3){
            price = 23.90;
            newPrice = price;
        }
        else if (option == 4){
            price = 27.30;
            newPrice = price;
        }
        else if (option == 5){
            price = 50.00;
            newPrice = price;
        }
        else if (option == 6){
            price = 13.50;
            newPrice = price;
        }
    }
    public void setOption(int newOption){
        option = newOption;
    }

    @Override
    public String toString() {
    	
    	return "The details of the book are: {" + "id="+ id+ title + ", " + author + ", " + year + ", " + publisher + ", " + cost+" }";

 
    }
}
