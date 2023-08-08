package Cart

import Product.ProductSelect

data class Item(val codigo: Int, val produto: ProductSelect, val quantidade: Int)

class OrderManager() {

    private val listaProdutos = mutableMapOf<Int, Item>()

    fun adicionarProduto(item: Item) {
        listaProdutos[item.codigo] = item
    }

    fun exibirProdutos() {
        // Implementação para exibir produtos
    }

//    fun calcularValorTotalPedido(): Double {
// //       return listaProdutos.values.sumByDouble { it.valorTotal() }
//    }
}