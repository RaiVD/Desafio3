package Payment

class CreditEndDebitEndMealVoucherCardProcessor: PaymentProcessor {
    override fun processPayment(valueReceivedFromUser: Double, totalPurchaseValue: Double): String {
        return "Compra finalizada com sucesso!\nObrigada pela preferência, quando bater a fome, já sabe onde procurar!"
    }
}