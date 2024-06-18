package com.example.padariaproject.Util;

import com.example.padariaproject.Models.Produtos;
import javafx.util.StringConverter;

// classe para formatar string dentro da listview
public class ProdutoStringConverter extends StringConverter<Produtos> {
    @Override
    public String toString(Produtos produto) {
        if (produto != null) {
            return String.format("%s | %s | R$ %.2f | Quantidade: %d",
                    produto.getNome(), produto.getCategoria(), produto.getValor(), produto.getQuantidade());
        }
        return "";
    }

    @Override
    public Produtos fromString(String string) {
        return null; // Não é necessário para ListView com TextFieldListCell
    }
}