# language: pt

Funcionalidade: Criação de cota

    @essa
    Cenario: Não deve criar uma conta pois senha é invalida
        Dado que um usuario está na tela de criação de conta
        Quando preenche os campos nome flavio, sobrenome jose, e-mail a15a4@dn.vd, senha 12345
        E clica em salvar
        Então a conta deve ser notificado que a senha é invalida

    Cenario: Deve criar uma conta com sucesso
        Dado que um usuario está na tela de criação de conta
        Quando preenche os campos nome joao, sobrenome sousa, e-mail a15a4@dn.vd, senha hdu>;dgt56Q
        E clica em salvar
        Então a conta deve ser criada com sucesso