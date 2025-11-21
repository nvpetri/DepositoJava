package app;

public class Product {
    public String name;
    public String type;
    public int quantity;
    public double cost;
    public double price;

    public Product(){}
    public Product(String n,String t,int q,double c,double p){
        name=n; type=t; quantity=q; cost=c; price=p;
    }
}
