package com.donatus.implementation;

import com.donatus.models.ProductProperties;
import com.donatus.services.CATEGORY;
import com.donatus.services.ProductManagement;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Products implements ProductManagement {
    private static Map<String, ProductProperties> foods = new HashMap<>();
    private static Map<String, ProductProperties> drinks = new HashMap<>();

    public Products() {

    }

    public Map<String, ProductProperties> getFoods() {
        return foods;
    }

    public Map<String, ProductProperties> getDrinks() {
        return drinks;
    }

    @Override
    public boolean addProductsToRestaurant() {
        File file = new File("./src/main/resources/productList.csv");
        String line = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                //System.out.println(Arrays.toString(row));
                if (!row[0].equalsIgnoreCase("name")) {
                    if (row[1].equalsIgnoreCase("drinks")) {
                        ProductProperties newProduct = new ProductProperties();
                        newProduct.setName(row[0]);
                        newProduct.setCAT(CATEGORY.DRINKS);
                        newProduct.setPrice(Integer.parseInt(row[2]));
                        newProduct.setQuantity(Integer.parseInt(row[3]));
                        // Adding created product to drinks Map
                        drinks.put(row[0], newProduct);
                    }
                    if (row[1].equalsIgnoreCase("food")) {
                        ProductProperties newProduct = new ProductProperties();
                        newProduct.setName(row[0]);
                        newProduct.setCAT(CATEGORY.FOOD);
                        newProduct.setPrice(Integer.parseInt(row[2]));
                        newProduct.setQuantity(Integer.parseInt(row[3]));
                        // Adding created product to drinks Map
                        foods.put(row[0], newProduct);
                    }
                }
            }
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File not Found" + e);
        } catch (IOException e) {
            System.out.println("Input or Ouput error" + e);
        }
        return false;
    }

    @Override
    public boolean updateRestaurantRecord() {
        return false;
    }

//    public void viewItems(Map<String, ProductProperties> productPropertiesMap) {
//        System.out.println("Name" + "              " + "Price" + "           " + "Quantity");
//        for (var item : productPropertiesMap.values()) {
//            System.out.printf("%-18s %-18s %-18s", item.getName(), item.getPrice(), item.getQuantity());
//            System.out.println();
//        }
//    }

    public static Consumer<Map<String, ProductProperties>> viewItemsFunc = store ->{
        System.out.println("Name" + "              " + "Price" + "           " + "Quantity");
        store.forEach((key, value)-> System.out.printf("%-18s %-18s %-18s \n", key, value.getPrice(), value.getQuantity()));
    };
}
