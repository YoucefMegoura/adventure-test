package com.example.adventure.service;

import com.example.adventure.model.Product;
import com.example.adventure.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Inventory getProductsData() {
        Inventory inventory = new Inventory();
        for(Product p: productRepository.findAll()) {
            if (inventory.containsKey(p.getNom())) {
                InventoryItem productItem = inventory.get(p.getNom());
                if (!p.getState().equals("broken")) {
                    productItem.setQty(productItem.getQty() + 1);
                    productItem.setTotalPrice(productItem.getTotalPrice() + p.getPrice());
                    productItem.productBarcodes += "," + p.getBarcode();
                }
            }
            else {
                inventory.put(p.getNom(), new InventoryItem(p.getNom().toLowerCase(), p.getPrice(), 1));
            }
        }
        return inventory;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean deleteById(int id) {
        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public static class Inventory extends HashMap<String, InventoryItem> { }

    public static class InventoryItem {
        private final String pName;
        private int qty;
        private float totalPrice;
        private String productBarcodes;

        public InventoryItem(String pName, float totalPrice, int qty) {
            this.pName = pName;
            this.totalPrice = totalPrice;
            this.qty = qty;
        }

        public String getpName() {
            return pName;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public float getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(float totalPrice) {
            this.totalPrice = totalPrice;
        }

        public String getProductBarcodes() {
            return productBarcodes;
        }

        public void setProductBarcodes(String productBarcodes) {
            this.productBarcodes = productBarcodes;
        }
// tous les getters and setters sont implémentés
    }
}