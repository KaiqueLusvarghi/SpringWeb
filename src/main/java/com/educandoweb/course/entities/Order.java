package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.educandoweb.course.entities.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "tb_order")  //dando o nome da tabela
public class Order implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //anotações do JPA para dizer que essa classe vai ser uma tabela
    private Long id;

    
    private Instant moment;

    private Integer orderStatus; // para dizer explicitamente que está gravando no banco de dados um numero inteiro 

    @ManyToOne  // assosiação de MUITOS para UM   Muitos = ordem  Um = usuario
    @JoinColumn(name = "client_id")  // nome da chave estrangeira 
    private User client; // fazendo a assosiação (um pedido tem um usuario)

    
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)// no caso 1 para 1 tem o mesmo id, é obritgatorio colocar cascade = CascadeType.ALL
    private Payment payment;

    public Order (){

    }

    public Order(Long id, Instant moment,OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Instant getMoment() {
        return moment;
    }


    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus); // Usando o metodo que foi implementado na classe OrderStatus
    }


    public void setOrderStatus(OrderStatus orderStatus) { // aqui eu tenho que pegar o numero correspondente ao Enum que é um integer
        if(orderStatus != null){
        this.orderStatus = orderStatus.getCode();
        }
    }


    public User getClient() {
        return client;
    }


    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<OrderItem> getItems(){
        return items;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
