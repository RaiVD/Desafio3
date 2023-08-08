package Cart

import Product.Drink
import Produtos.TipoEnum
import kotlin.random.Random

class BuyBeverage(private val carrinho: OrderManager) : Purchase {

    val inputUser = InputUser()

    override fun displayOptions() {
        println("======================== Bebidas ========================")
        println("1. Refrigerantes - R$ 8,00 | 2. Sucos - R$ 6,00 | 3. Nenhuma")
        val option = inputUser.lerInteiroDoUsuario("Qual opção você deseja:")
        when (option) {
            1 -> makePurchase("Refrigerante", 8.00, TipoEnum.BEBIDA)
            2 -> makePurchase("Suco", 6.00, TipoEnum.BEBIDA)
            3 -> println("Nenhuma bebida selecionada!")
            else -> {
                println("Opção inválida, tente novamente!")
                displayOptions()
            }
        }
    }

    override fun makePurchase(nome: String, valor: Double, tipoEnum: TipoEnum) {
        var code: Int
        val quantidade = inputUser.lerInteiroDoUsuario("Qual quantidade você deseja:")
        for (i in 0 until quantidade) {
            code = Random.nextInt(1, 100)
            carrinho.addProduct(Drink(nome,valor,1,code, tipoEnum))
        }
        println("Produto adicionado ao carrinho!")
    }
}