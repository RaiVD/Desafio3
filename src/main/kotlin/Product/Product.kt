package Product

import Produtos.TipoEnum

interface Product {
    val code: Int
    val name: String
    val value: Double
    var quantity: Int
    val enumType: TipoEnum
    fun amount(): Double
}