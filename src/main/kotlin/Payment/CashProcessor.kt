package Payment

class CashProcessor: PaymentProcessor {
    override fun processPayment(valueReceivedFromUser: Double, totalPurchaseValue: Double): String {
        return if (valueReceivedFromUser >= totalPurchaseValue) {
            val troco = valueReceivedFromUser - totalPurchaseValue
            "Compra finalizada com sucesso! Troco: R$$troco.\nObrigada pela preferência, quando bater a fome, já sabe onde procurar!"
        } else {
            "Valor em dinheiro insuficiente, tente novamente!"
        }
    }
}