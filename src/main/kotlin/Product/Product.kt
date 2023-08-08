package Product

import Produtos.TipoEnum

interface Product {
    val code: Int
    val nome: String
    val valor: Double
    var quantidade: Int
    val tipoEnum: TipoEnum
    fun valorTotal(): Double
}