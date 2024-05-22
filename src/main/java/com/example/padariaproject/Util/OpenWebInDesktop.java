package com.example.padariaproject.Util;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class OpenWebInDesktop {

    // Implementação do redirecionamento dos Hyperlinks para páginas Web.
    public static void OpenWebPage(URI uri){

        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();

            try{
                desktop.browse(uri);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{
            System.out.println("Erro ao abrir url");
        }

    }
}
