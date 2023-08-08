package Cart

import Payment.CashProcessor
import Payment.CreditEndDebitEndMealVoucherCardProcessor
import Product.Product

class OrderManager() {

    val listaProdutos = mutableMapOf<Int, Product>()
    val inputUser = InputUser()
    fun addProduct(item: Product) {
        listaProdutos[item.code] = item
    }

    fun displayProducts() {
        println("======================== Carrinho de Compras ========================")
        if (listaProdutos.isEmpty()) {
            println("O carrinho está vazio.")
        } else {
            for ((codigo, item) in listaProdutos) {
                println("Código - $codigo | Nome - ${item.name} | Valor - R$${item.value}")
            }
        }
        println()
    }
    fun calculateTotalOrderValue(): Double {
        return listaProdutos.values.sumByDouble { it.amount() }
    }
    fun keepBuying() {
        println()
        println("1. Adicionar item  |  2. Editar | 3. remover item | 4. Finalizar")
        val option = inputUser.lerInteiroDoUsuario("Qual opção você deseja:")
        when (option) {
            1 ->{
                BuySnack(this).displayOptions()
                BuyBeverage(this).displayOptions()
                keepBuying()
            }
            2 -> {
                EditProduct(this).editItem()
                keepBuying()
            }
            3 ->{
                removeProduct()
                keepBuying()
            }
            4 -> checkout()
            else -> {
                println("Opção inválida, tente novamente!")
                keepBuying()
            }
        }
    }
    fun removeProduct() {
        displayProducts()
        println()
        while (true) {
            val codigo = inputUser.lerInteiroDoUsuario("Digite o código do produto que deseja remover:")
            if (listaProdutos.containsKey(codigo)) {
                listaProdutos.remove(codigo)
                println("Produto removido com sucesso!")
                break
            } else {
                println("Código de produto inválido.")
            }
        }
    }
    fun checkout(){
        if (listaProdutos.isEmpty()) {
            println("O carrinho está vazio. Para finalizar o pedido é necessario adicionar um produto!")
            main()
        }else{
            displayProducts()
            println("Valor total do pedido: R$${calculateTotalOrderValue()}")
            println("1. Cartão de crédito | 2. Cartão de débito | 3. Vale refeição | 4. Dinheiro")
            val formaPagamento = inputUser.lerInteiroDoUsuario("Selecione a forma de pagamento:")
            when(formaPagamento){
                1,2,3 -> println(CreditEndDebitEndMealVoucherCardProcessor().processPayment(0.0,0.0))
                4 -> {
                    val valueReceivedFromUser = inputUser.lerDecimalDoUsuario("Informe o valor em dinheiro: ")
                    println(CashProcessor().processPayment(valueReceivedFromUser,calculateTotalOrderValue()))
                }
            }
        }
    }
}