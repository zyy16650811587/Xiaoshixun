package com.example.facterday02;

public class TrueFacttory implements LostProduct{
    @Override
    public <T extends Product> T createProduct(Class<T> cls) {
        Product product=null;
        try {
            product= (Product) Class.forName(cls.getName()).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
