package home.petshop.entity.order;

import home.petshop.entity.AbstractSeoEntity;

/**
 * ListProduct — класс для представления списка продуктов. Это могут быть рецепты
 * пользователя, списки избранного или произвольные наборы товаров по какому-либо
 * поводу
 */
public class ListProduct extends AbstractSeoEntity {
    public ListProduct(String name) {
        super(name);
    }
}
