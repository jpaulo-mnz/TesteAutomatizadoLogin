# language: pt

Funcionalidade: Criação de cota

    Cenario: Não deve criar uma conta pois senha é invalida
        Dado que um usuario está na tela de criação de conta
        Quando preenche os campos nome flavio, sobrenome jose, e-mail a15a4@dn.vd, senha 12345
        E clica em salvar
        Então a conta deve ser notificado que a senha é invalida
    @essa
    Cenario: Deve criar uma conta com sucesso
        Dado que um usuario está na tela de criação de conta
        Quando preenche os campos nome vaderley, sobrenome wichosoff, e-mail vaderley@gmail.com, senha hdu>dgt56Q
        E clica em salvar
        Então a conta deve ser criada com sucesso
    @essa
    Cenario: Deve fazer login na conta criada
        Dado que o usuario está na tela de login
        Quando preenche as informações requeridas de e-mail a15a4@dn.vd, e senha hdu>;dgt56Q
        Então a conta deve ser acessada com sucesso