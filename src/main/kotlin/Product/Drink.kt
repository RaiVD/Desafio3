package Product

import Produtos.TipoEnum
class Drink(nome: String, valor: Double) :
    ProductSelect(nome, valor, TipoEnum.BEBIDA) {
}