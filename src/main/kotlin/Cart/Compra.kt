package Cart

import Produtos.TipoEnum

interface Compra {
    fun exibirOpcoes()
    fun realizarCompra(nome: String, valor: Double, tipoEnum: TipoEnum)
}