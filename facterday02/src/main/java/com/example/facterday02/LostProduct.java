package com.example.facterday02;

public interface LostProduct {
<T extends Product> T createProduct(Class<T> cls);
}
