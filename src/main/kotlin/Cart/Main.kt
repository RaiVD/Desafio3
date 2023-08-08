package Cart

import java.util.concurrent.TimeUnit

fun main() {
    val carrinho = OrderManager()
    val entrada = false
    while (!entrada) {
        try {
            println()
            println("======================== Bem-vindo ao SimCity FastFood ========================")
            println("\t\t\t\t\t=========== Menu ===========")
            println("\t\t\t\t\t\t1. Lanche | 2. Bebida")
            val option = readlnOrNull()?.toIntOrNull() ?: 0

            when (option) {
                1 -> {
                    BuySnack(carrinho).displayOptions()
                    BuyBeverage(carrinho).displayOptions()
                    carrinho.keepBuying()
                }
                2 -> {
                    BuyBeverage(carrinho).displayOptions()
                    carrinho.keepBuying()
                }
                else -> println("Opção inválida, tente novamente!")
            }
            TimeUnit.SECONDS.sleep(5)
        } catch (exception: NumberFormatException) {
            println("Formato inválido, para escolher o item, você deve informar o número dele!")
        }
    }
}
