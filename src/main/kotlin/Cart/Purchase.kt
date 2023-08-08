package Cart

import Produtos.TipoEnum

interface Purchase {
    fun exibirOpcoes()
    fun realizarCompra(nome: String, valor: Double, tipoEnum: TipoEnum)
}