package Cart

import Product.Lanche
import Produtos.TipoEnum
import kotlin.random.Random

class BuySnack(private val carrinho: OrderManager): Purchase {

    val inputUser = InputUser()

    override fun exibirOpcoes() {
        println("======================== Lanches ========================")
        println("1. X-burger - R$10,00 | 2. X-salada - R$12,00 | 3. Nenhum")
        val option = inputUser.lerInteiroDoUsuario("Qual opção você deseja:")
        when (option) {
            1 -> realizarCompra("X-Burger", 10.00, TipoEnum.COMIDA)
            2 -> realizarCompra("X-Salada", 12.00, TipoEnum.COMIDA)
            3 -> println("Nenhum lanche selecionado!")
            else -> {
                println("Opção inválida, tente novamente!")
                exibirOpcoes()
            }
        }
    }

    override fun realizarCompra(nome: String, valor: Double, tipoEnum: TipoEnum) {
        var code: Int
        val quantidade = inputUser.lerInteiroDoUsuario("Qual quantidade você deseja:")
        for (i in 0 until quantidade) {
            code = Random.nextInt(1, 100)
            carrinho.adicionarProduto(Lanche(nome,valor,1,code, tipoEnum))
        }
        println("Produto adicionado ao carrinho!")
    }
}