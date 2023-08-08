package Cart

import Produtos.TipoEnum

interface Purchase {
    fun displayOptions()
    fun makePurchase(nome: String, valor: Double, tipoEnum: TipoEnum)
}