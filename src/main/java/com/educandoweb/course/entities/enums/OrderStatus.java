package com.educandoweb.course.entities.enums;



public enum OrderStatus {

    //fazendo dessa maneira paara que no futuro precise acrescentar mais algum enum, não de erro no banco quebrando a orderm dos enums

    WAITING_PAYMENT (1), //aguardando pagamento
    PAID (2),            //pago
    SHIPPED (3),         //enviado   
    DELIVERED (4),       //entregue
    CANCELED (5);        //cancelado

    private int code; // codigo do tipo do Enum

    // é preciso fazer o construtor para o tipo do tipo Enum. ai ele é Private
    private OrderStatus (int code){
        this.code = code;
    }
    
    //para o codigo ficar acessivel 
    public int getCode(){
        return code;
    }
    
    //metodo estatico para  converter um valor numerico para um tipo enumerado (ENUM)
    public static OrderStatus valueOf (int code) {

            for(OrderStatus value : OrderStatus.values()){
                if (value.getCode() == code) {
                    return value;
                }
            }
                throw new IllegalArgumentException("Invalid  OrdersStatus code !");

        
    }
}
