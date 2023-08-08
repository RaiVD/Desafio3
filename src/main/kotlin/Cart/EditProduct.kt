package Cart

import Product.Lanche
import Produtos.TipoEnum
import kotlin.random.Random

class EditProduct(private val carrinho: OrderManager) {
    private val inputUser = InputUser()

    fun editItem() {
        if (carrinho.listaProdutos.isEmpty()) {
            println("O carrinho está vazio, adicione um produto para editar.")
            carrinho.keepBuying()
            return
        }
        println("Produtos disponíveis para editar:")
        for ((codigo, item) in carrinho.listaProdutos) {
            if (item.enumType == TipoEnum.COMIDA) {
                println("Código - $codigo | Nome - ${item.name}")
            }
        }
        val code = inputUser.lerInteiroDoUsuario("Digite o código do produto que você deseja editar:")
        if (carrinho.listaProdutos.containsKey(code)) {
            editQuantity(code)
        } else {
            println("Nenhum produto com o código $code encontrado, tente novamente!")
            editItem()
        }
    }

    private fun editQuantity(code: Int) {
        val item = carrinho.listaProdutos[code] ?: return
        val newQuantity = inputUser.lerInteiroDoUsuario("Digite a nova quantidade de itens para o produto ${item.name}:")

        if (newQuantity <= 0) {
            println("Quantidade inválida. A quantidade deve ser maior que zero.")
            editQuantity(code)
            return
        }
        var newcode: Int
        for (i in 0 until newQuantity) {
            newcode = Random.nextInt(1, 100)
            carrinho.addProduct(Lanche(item.name,item.value,1, newcode, item.enumType))
        }
        val newValue = carrinho.calculateTotalOrderValue()
        println("Quantidade atualizada para ${carrinho.listaProdutos.size} itens. Valor total atualizado: R$$newValue")

        carrinho.displayProducts()
    }
}





