package Product

import Produtos.TipoEnum

class Drink(override val nome: String, override val valor: Double, override var quantidade: Int, override val code: Int, override val tipoEnum: TipoEnum): Product {
    override fun valorTotal(): Double {
        return (this.valor * this.quantidade)
    }
}