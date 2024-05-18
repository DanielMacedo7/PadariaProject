package com.example.padariaproject.Util;

import com.example.padariaproject.Models.Perfil;


// classe para gente carregar o perfil já logado na aba de perfil.
public class PerfilSession {

    private static Perfil perfil;

    public static void setPerfil(Perfil obj){
        perfil = obj;

    }

    public static Perfil getPerfil(){
        return perfil;
    }

}
