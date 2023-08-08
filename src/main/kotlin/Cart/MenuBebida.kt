package Cart

import Product.Drink
import Produtos.TipoEnum

class MenuBebida(private val carrinho: OrderManager) : Compra {
    val inputUser = InputUser()

    override fun exibirOpcoes() {
        println("======================== Bebidas ========================")
        println("1. Refrigerantes - R$ 8,00 | 2. Sucos - R$ 6,00 | 3. Nenhuma")
        val option = inputUser.lerInteiroDoUsuario("Qual opção você deseja:")
        when (option) {
            1 -> realizarCompra("Refrigerante", 8.00, TipoEnum.BEBIDA)
            2 -> realizarCompra("Suco", 6.00, TipoEnum.BEBIDA)
            3 -> println("Nenhuma bebida selecionada!")
            else -> {
                println("Opção inválida, tente novamente!")
                exibirOpcoes()
            }
        }
    }

    override fun realizarCompra(nome: String, valor: Double, tipoEnum: TipoEnum) {
        var code = 1
        val quantidade = inputUser.lerInteiroDoUsuario("Qual quantidade você deseja:")
        for (i in 0 until quantidade) {
            code++
            carrinho.adicionarProduto(Item(code, Drink(nome,valor,), 1))
        }
        println("Produto adicionado ao carrinho!")
    }
}