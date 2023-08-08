package Cart

import Product.Lanche
import Produtos.TipoEnum
import kotlin.random.Random

class EditarProduto(private val carrinho: OrderManager) {
    private val inputUser = InputUser()

    fun editarItem() {
        if (carrinho.listaProdutos.isEmpty()) {
            println("O carrinho está vazio, adicione um produto para editar.")
            carrinho.continuarComprando()
            return
        }

        println("Produtos disponíveis para editar:")
        for ((codigo, item) in carrinho.listaProdutos) {
            if (item.tipoEnum == TipoEnum.COMIDA) {
                println("Código - $codigo | Nome - ${item.nome}")
            }
        }

        val code = inputUser.lerInteiroDoUsuario("Digite o código do produto que você deseja editar:")
        if (carrinho.listaProdutos.containsKey(code)) {
            editarQuantidade(code)
        } else {
            println("Nenhum produto com o código $code encontrado, tente novamente!")
            editarItem()
        }
    }

    private fun editarQuantidade(code: Int) {
        val item = carrinho.listaProdutos[code] ?: return
        val novaQuantidade = inputUser.lerInteiroDoUsuario("Digite a nova quantidade de itens para o produto ${item.nome}:")

        if (novaQuantidade <= 0) {
            println("Quantidade inválida. A quantidade deve ser maior que zero.")
            editarQuantidade(code)
            return
        }
        var newcode: Int
        for (i in 0 until novaQuantidade) {
            newcode = Random.nextInt(1, 100)
            carrinho.adicionarProduto(Lanche(item.nome,item.valor,1, newcode, item.tipoEnum))
        }

        val newValue = carrinho.calcularValorTotalPedido()
        println("Quantidade atualizada para ${carrinho.listaProdutos.size} itens. Valor total atualizado: R$$newValue")

        carrinho.exibirProdutos()
    }
}





