package org.example.box;

public interface SweetBox {
    void add(int id, Sweets sweet);
    void delete(int id);
    void infoAboutWeightOfBox();
    void infoAboutPriceOfBox();
    void infoAboutAllItems();
    void SmartRemoveSmallestWight(float wight);
    void SmartRemoveSmallestPrice(float wight);
}
