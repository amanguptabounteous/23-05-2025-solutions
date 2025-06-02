package Handling;

import java.util.*;

class Product{
    private
    int prodID;
    String prodName;
    String catg;
    int price;
    static HashMap<Integer, Product> mp = new HashMap<>();

    public Product(int prodID, String prodName, String catg, int price) {
        this.prodID = prodID;
        this.prodName = prodName;
        this.catg = catg;
        this.price = price;
    }

    public int getProdID() {
        return prodID;
    }

    public String getProdName() {
        return prodName;
    }

    public String getCatg() {
        return catg;
    }

    public int getPrice() {
        return price;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public void setCatg(String catg) {
        this.catg = catg;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static boolean addProd(Product P){
        if(mp.containsKey(P.getProdID())) return false;
        mp.put(P.getProdID(), P);
        return true;
    }

    public static Product getProd(int id){
        return mp.get(id);
    }

    public static boolean updateProd(int id, String name, String catg, int price){
        Product P = mp.get(id);
        if(P==null) return false;
        P.setProdName(name);
        P.setCatg(catg);
        P.setPrice(price);
        return true;
    }

    public static boolean deleteProd(int id){
        return mp.remove(id) != null;
    }

    public static List<Product> getSortedById() {
        List<Product> list = new ArrayList<>(mp.values());
        list.sort(Comparator.comparingInt(Product::getProdID));
        return list;
    }

    public static List<Product> getSortedByName() {
        List<Product> list = new ArrayList<>(mp.values());
        list.sort(Comparator.comparing(Product::getProdName));
        return list;
    }
    public static void display(List<Product> list) {
        for (Product p : list) {
            System.out.println(p.getProdID() + " " + p.getProdName() + " " + p.getCatg() + " " + p.getPrice());
        }
        System.out.println();
    }

}

public class productques {
    public static void main(String[] args) {
        Product.addProd(new Product(1, "Monitor", "Electronics", 7000));
        Product.addProd(new Product(2, "Table", "Furniture", 5000));
        Product.addProd(new Product(3, "Notebook", "Stationery", 50));

        System.out.println("All Products Sorted by ID:");
        Product.display(Product.getSortedById());


        if(Product.updateProd(2, "Office Table", "Furniture", 8000)){
            System.out.println("Product updated");
            System.out.println();
        }

        System.out.println("All Products (Sorted by Name):");
        Product.display(Product.getSortedByName());

        if(Product.deleteProd(1)){
            System.out.println("Product Deleted");
            System.out.println();
        }

        System.out.println("Final Product List:");
        Product.display(Product.getSortedById());
    }
}
