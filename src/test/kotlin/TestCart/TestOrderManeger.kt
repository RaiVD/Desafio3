package TestCart

import Cart.OrderManager
import Product.Drink
import Product.Lanche
import Produtos.TipoEnum
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestOrderManeger {

    private lateinit var orderManager: OrderManager

    @BeforeEach
    fun setUp() {
        orderManager = OrderManager()
    }

    @Test
    fun testAddProduct() {
        val product = Lanche("X-Burger", 10.0, 1, 1, TipoEnum.COMIDA)
        orderManager.addProduct(product)
        assertEquals(1, orderManager.listaProdutos.size)
    }

    @Test
    fun testCalculateTotalOrderValue() {
        val snack = Lanche("X-Burger", 10.0, 2, 1, TipoEnum.COMIDA)
        val drink = Drink("Refrigerante", 8.0, 3, 2, TipoEnum.BEBIDA)
        orderManager.addProduct(snack)
        orderManager.addProduct(drink)

        val totalValue = orderManager.calculateTotalOrderValue()
        assertEquals(44.0, totalValue)
    }


}