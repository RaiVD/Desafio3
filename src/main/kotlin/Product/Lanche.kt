package Product

import Produtos.TipoEnum

class Lanche(override val name: String, override val value: Double, override var quantity: Int, override val code: Int, override val enumType: TipoEnum): Product {
    override fun amount(): Double {
        return (this.value * this.quantity)
    }
}