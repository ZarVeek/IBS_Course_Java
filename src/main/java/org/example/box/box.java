package org.example.box;

import java.util.*;

public class box {
    public static void main(String[] args) {
        Map<Integer, Sweets> boxWithSweets = new HashMap<>();
        SweetBox sweetBox = new SweetBox() {
            @Override
            public void add(int id, Sweets sweet) {
                boxWithSweets.put(id, sweet);
            }

            @Override
            public void delete(int id) {
                boxWithSweets.remove(id);
            }

            @Override
            public void infoAboutWeightOfBox() {
                float Weight = 0;
                for (int key : boxWithSweets.keySet()) {
                    Weight += boxWithSweets.get(key).getWeight();
                }
                System.out.println("Box weight: " + Weight);
            }

            @Override
            public void infoAboutPriceOfBox() {
                float price = 0;
                for (int key : boxWithSweets.keySet()) {
                    try {
                        price += boxWithSweets.get(key).getPrice();
                    } catch (NullPointerException e) {
                        System.out.println(e);
                    }
                }
                System.out.println("Box price: " + price);
            }

            @Override
            public void infoAboutAllItems() {
                System.out.println("infoAboutAllItems: ");
                for (int key : boxWithSweets.keySet()) {
                    try {
                        System.out.println("Name: " + boxWithSweets.get(key).getName());
                        System.out.println("Id: " + boxWithSweets.get(key).getId());
                        System.out.println("Weight: " + boxWithSweets.get(key).getPrice());
                        System.out.println("Price: " + boxWithSweets.get(key).getPrice() + "\n");
                    } catch (NullPointerException e) {
                        System.out.println(e);
                    }


                }
            }

            @Override
            public void SmartRemoveSmallestWight(float firstWight) {
                float newWight = 0;
                for (int key : boxWithSweets.keySet()) {
                    newWight += boxWithSweets.get(key).getPrice();
                }
                Map<Integer, Float> wightMap = new HashMap<>();
                for (int key : boxWithSweets.keySet()) {
                    wightMap.put(key, (boxWithSweets.get(key).getPrice()));
                }
                while (newWight > firstWight) {
                    for (int keys : wightMap.keySet()) {
                        float min = Collections.min(wightMap.values());
                        if (wightMap.get(keys).equals(min)) {
                            boxWithSweets.remove(keys);
                            wightMap.remove(keys);
                            newWight -= min;
                            break;
                        }
                    }
                }
            }

            @Override
            public void SmartRemoveSmallestPrice(float firstWight) {
                float newWight = 0;
                for (int key : boxWithSweets.keySet()) {
                    newWight += boxWithSweets.get(key).getPrice();
                }
                Map<Integer, Float> priceMap = new HashMap<>();
                for (int key : boxWithSweets.keySet()) {
                    priceMap.put(key, (boxWithSweets.get(key).getPrice()));
                }
                while (newWight > firstWight) {
                    for (int keys : priceMap.keySet()) {
                        float min = Collections.min(priceMap.values());
                        if (priceMap.get(keys).equals(min)) {
                            boxWithSweets.remove(keys);
                            priceMap.remove(keys);
                            newWight -= min;
                            break;
                        }
                    }
                }

            }
        };
        sweetBox.add(1, new Candy("candy", 20, 100, 1));
        sweetBox.add(2, new ChocolateBar("chocolateBar", 120, 80, 2));
        sweetBox.add(3, new Marmalade("marmalade", 50, 40, 3));
        sweetBox.add(4, new Cake("cake", 35, 50, 4));
        sweetBox.infoAboutAllItems();
        sweetBox.delete(1);
        sweetBox.infoAboutPriceOfBox();
        sweetBox.infoAboutPriceOfBox();
        sweetBox.infoAboutWeightOfBox();
        sweetBox.SmartRemoveSmallestPrice(200);
        sweetBox.SmartRemoveSmallestWight(200);
        sweetBox.infoAboutPriceOfBox();
    }
}
